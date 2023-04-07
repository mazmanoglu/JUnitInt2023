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

public class C06_RadioButtonTest {
    /*
    - JUnit automatically returns test results as 'Passed' or 'Failed'.
    - However, JUnit basically reports that the code runs and finishes without any problems.
    - If we run the tests using the Assert class in JUnit then it will give the correct test reports we want.
     */

    // go to "https://www.facebook.com
    // accept cookies
    // click "create new account" button
    // locate the radio button elements
    // test that the gender button that suits you is selected

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
        driver.get("https://www.facebook.com");
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[@title='Only allow essential cookies']"));
        cookieAcceptButton.click();

        WebElement createNewAccountButton = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createNewAccountButton.click();

        WebElement genderRadioButton = driver.findElement(By.xpath("//label[text()='Male']"));
        if (genderRadioButton.isSelected())
            System.out.println("Gender radiobutton is selected. Test PASSED");
        else
            System.out.println("Gender radiobutton is NOT selected. Test FAILED");
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
