package day07_handleDropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_HandleDropdownMenu {

    // go to webpage https://the-internet.herokuapp.com/dropdown
    // use index, choose option 1 and print
    // use value, choose option 2 and print
    // use visible text, choose option 1 and print
    // print all values of dropdown
    // find the size of the dropdown, print True on console if dropdown has 4 object, else False

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
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropdownMenuElement = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(dropdownMenuElement);
        select.selectByIndex(1);
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
