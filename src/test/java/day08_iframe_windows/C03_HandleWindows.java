package day08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_HandleWindows {

    /*
        - go to amazon webpage
        - assign the window handle value to a String variable
        - check page title contains "Amazon"
        - create a new tab, then go to wisequarter.com
        - check page title contains "Wise Quarter"
        - create a new window, then go to walmart.com
        - check page title contains "Walmart"
        - turn back to first page and check you turn back to amazon webpage.
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
        - When we want to open a new page or tab, we do it with the driver.switchTo().newWindow(WindowType.TAB or WindowType.WINDOW) method and switch it to that page. Since this transition is made through the driver, the driver itself also switches to that new page, so we can continue to operate anything on the new page.

        - There is only one way to switch to any opened window instead of creating a new one,
                - that is to use the window handle value of the page that we want to switch to.
                - If there is a window that you will return during a test, we should save the window handle of that page.
     */
    @Test
    public void windowTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
        String firstPageHandleValue = driver.getWindowHandle();
        String expectedContent = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedContent));

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        String expectedSecondContent = "Wise Quarter";
        String actualSecondTitle = driver.getTitle();
        Assert.assertTrue(actualSecondTitle.contains(expectedSecondContent));

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        String expectedThirdContent = "Walmart";
        String actualThirdTitle = driver.getTitle();
        Assert.assertTrue(actualThirdTitle.contains(expectedThirdContent));

        driver.switchTo().window(firstPageHandleValue);
        expectedContent = "Amazon";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedContent));

    }
    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
