package day06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C03_CheckBox {
    // create "CheckBoxTest" class
    // create the necessary structure
    // go to webpage "https://the-internet.herokuapp.com/checkboxes"
    // locate the elements "checkbox1" and "checkbox2"
    // If it is not clicked, click the checkbox1
    // If it is not clicked, click the checkbox2

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
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1Element = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2Element = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if (!checkbox1Element.isSelected())
            checkbox1Element.click();

        if (!checkbox2Element.isSelected())
            checkbox2Element.click();
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}