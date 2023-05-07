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

import java.time.Duration;

public class C04_HandleAlert {

    /*
    --> 2 types of alerts appear during automation
    HTML Alerts
    - these can be located like any other html element. can be used in automation.
    Javascript Alerts
    - It cannot be located with html codes, so methods such as click, getText will not work.

    There is only one solution for javascript alerts. Switching to the alert using the switchTo() method and doing the functions that the alert allows.
     */

    /*
        - go to webpage "https://the-internet.herokuapp.com/javascript_alerts"

        - create 'acceptAlert' method
        - click first button, then OK button on alert message, test the result message equals to "You successfully clicked an alert".

        - create 'dismissAlert' method
        - click second button, then Cancel button on alert message, test the result message does not contain "successfully"

        - create 'sendKeysAlert' method
        - click third button, write your name on alert box, click OK on alert, verify your name is displayed on result.
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

    @Test
    public void acceptAlertTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement firstButton = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        firstButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String expectedResultMessage = "You successfully clicked an alert";
        String actualResultMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertEquals(expectedResultMessage, actualResultMessage);
    }

    @Test
    public void dismissAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement secondButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
        secondButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        String unexpectedWord = "successfully";
        String actualResultMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertFalse(actualResultMessage.contains(unexpectedWord));
    }

    @Test
    public void sendKeysTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement thirdButton = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
        thirdButton.click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Fatih Ozer");
        driver.switchTo().alert().accept();
        String expectedName = "Fatih Ozer";
        String actualResultMessage = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(actualResultMessage.contains(expectedName));
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}