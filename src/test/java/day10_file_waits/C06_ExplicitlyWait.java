package day10_file_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C06_ExplicitlyWait {

    @Test
    public void explicitlyWaitTest(){
        // go to webpage https://the-internet.herokuapp.com/dynamic_controls
        // assert that Textbox is NOT enabled.
        // click Enable button and wait till Textbox is enabled
        // assert "It's enabled!" message is displayed
        // assert Textbox is enabled

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement textBoxElement = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxElement.isEnabled());

        WebElement enabledButtonElement = driver.findElement(By.xpath("//button[text()='Enable']"));
        enabledButtonElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textBoxElement));

        WebElement itsEnabledTextElement = driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabledTextElement.isDisplayed());

        Assert.assertTrue(textBoxElement.isEnabled());

        driver.quit();
    }
}
