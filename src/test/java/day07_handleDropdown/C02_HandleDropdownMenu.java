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

public class C02_HandleDropdownMenu {
    // go to amazon web page
    // check the number of options on dropdownmenu on the left side of search box is 28

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
    public void ddmTest(){
        driver.get("https://www.amazon.com");

        WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdownElement);

        List<WebElement> optionList = select.getOptions(); //give a list of web elements

        for (WebElement eachElement:optionList
             ) {
            System.out.println(eachElement.getText());
        }

        Assert.assertEquals(28, optionList.size());
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
