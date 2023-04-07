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

public class C04_CheckBoxTest {
    // go to webpage https://the-internet.herokuapp.com/checkboxes
    // locate the checkbox1 and checkbox2
    // test
    //      checkbox1 is clicked
    //      checkbox2 is NOT clicked

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

        if (checkbox1Element.isSelected())
            System.out.println("checkbox 1 is selected. Test FAILED");
        else
            System.out.println("checkbox 1 is NOT selected. Test PASSED");

        if (checkbox2Element.isSelected())
            System.out.println("checkbox 2 is selected. Test PASSED");
        else
            System.out.println("checkbox 2 is NOT selected. Test FAILED");
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
