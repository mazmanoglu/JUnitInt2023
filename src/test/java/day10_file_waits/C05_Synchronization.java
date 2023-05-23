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

public class C05_Synchronization {
    // crate 2 methods : implicitlyWait(), explicitlyWait()
    // test all steps in both methods
        // visit the page https://the-internet.herokuapp.com/dynamic_controls
        // click remove button
        // Assert "It's gone!" text is displayed
        // click add button
        // Assert "It's back" text is displayed
    // don't extend TestBase

    @Test
    public void implicitlyWaitTest(){

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButtonElement = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButtonElement.click();
        WebElement itsGoneTextElement = driver.findElement(By.id("message"));
        Assert.assertTrue(itsGoneTextElement.isDisplayed());

        WebElement addButtonElement = driver.findElement(By.xpath("//button[text()='Add']"));
        addButtonElement.click();
        WebElement itsBackTextElement = driver.findElement(By.id("message"));
        Assert.assertTrue(itsBackTextElement.isDisplayed());
    }

    @Test
    public void explicitlyWaitTest(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();

        // didn't use implicitly wait

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButtonElement = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButtonElement.click();
        //when we click the button, test couldn't find the text, because we didn't use implicitly wait. That's why test is failed.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30)); //we can put a long range coz it affects just this step, not all
        /*
            Classically, to tell it to wait for a web element, we first need to locate that web element, but as in this question, we cannot locate it because the element we need to wait is not yet. We cannot tell Driver to wait for an element that we cannot locate.
            In such problems, creating a web element, waiting and locating are all done together.
         */
        WebElement itsGoneTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsGoneTextElement.isDisplayed());

        WebElement addButtonElement = driver.findElement(By.xpath("//button[text()='Add']"));
        addButtonElement.click();

        WebElement itsBackTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertTrue(itsBackTextElement.isDisplayed());
    }
}
