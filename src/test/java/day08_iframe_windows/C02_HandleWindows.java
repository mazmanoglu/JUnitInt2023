package day08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Set;

public class C02_HandleWindows {
    /*
        - go to webpage "https://the-internet.herokuapp.com/iframe"
        - click to Elemental Selenium
        - check the headline of the new page is visible and the text is "Elemental Selenium"
     */

    WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    /*
    when we write driver.get ==> this goes to https://the-internet.herokuapp.com/iframe
    But after we clicked Elemental Selenium, this went to a new page/URL

    If it is opened more than 1 page during a test, we have to shift driver between these windows.

    If a new page opens when we click on a link, we cannot switch the driver directly to the newly opened window.
    First of all, we must find the handle value of that page and use that value to switch to the new page.
     */

    @Test
    public void windowTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        String firstPageWindowHandleValue = driver.getWindowHandle();
        WebElement elementalSeleniumTextElement = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSeleniumTextElement.click();
        Set<String> windowHandlesSet = driver.getWindowHandles();

        /*
        To find the Window Handle Value of second page, I tried to remove first page value from the set,
        this is another way of the solution
        windowHandlesSet.remove(firstPageWindowHandleValue);
        System.out.println(windowHandlesSet);

        Result
        First Page Window Handle Value: 3B511291BFF354018DA0A8A50C6933D6
        Window Handle Values of both pages: [3B511291BFF354018DA0A8A50C6933D6, E2092A19EC9D91E59B251D143E162C15]
        Second Page Window Handle Value: [E2092A19EC9D91E59B251D143E162C15]
         */

        // second and main solution

        String secondPageWindowHandleValue ="";
        for (String eachHandleValue:windowHandlesSet
             ) {
            if (!eachHandleValue.equals(firstPageWindowHandleValue)){
                secondPageWindowHandleValue=eachHandleValue;
            }
        }
        driver.switchTo().window(secondPageWindowHandleValue);

        WebElement newHeadLineTextElement = driver.findElement(By.tagName("h1"));
        Assert.assertTrue(newHeadLineTextElement.isDisplayed());

        String expectedText = "Elemental Selenium";
        String actualText = newHeadLineTextElement.getText();

        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
