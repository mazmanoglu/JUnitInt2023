package day07_handleDropdown;

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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_HandleDropdownMenu {

    // go to webpage https://the-internet.herokuapp.com/dropdown
    // use index, choose option 1 and print
    // use value, choose option 2 and print
    // use visible text, choose option 1 and print
    // print all values of dropdown
    // check the size of dropdown is 3

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

    @Test
    public void ddmTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownMenuElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdownMenuElement);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(2000);

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        Thread.sleep(2000);
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement> optionsList = select.getOptions();

        for (WebElement eachWebElement:optionsList
             ) {
            System.out.println(eachWebElement.getText());
        }

        Assert.assertEquals(3, optionsList.size());
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
