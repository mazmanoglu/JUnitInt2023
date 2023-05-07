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

public class C05_BasicAuthentication {
    /*
        - go to 'https://the-internet.herokuapp.com/basic_auth'
        - fill the authentication with these info
            - html command : https://username:password@URL
            - username : admin
            - password : admin
        - check the page could be entered successfully.
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
    public void basicAuthenticationTest(){
        // driver.get("https://the-internet.herokuapp.com/basic_auth");
        // normally we had to write above link to go to a webpage. But for api using, we have to write username and password
        // inside the url which is given to us by the company. we call this endpoint

        // - html command / endpoint: https://username:password@URL
        //            - username : admin
        //            - password : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement successEntryMessageElement = driver.findElement(By.tagName("p"));

        String expectedWord = "Congratulations";
        String actualSentence = successEntryMessageElement.getText();

        Assert.assertTrue(actualSentence.contains(expectedWord));
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
