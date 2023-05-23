package day10_file_waits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C04_Synchronization {
    /*
        - When running tests, there may be delays due to internet, computer speed, or the application we are running.
        That's why, to not our test fail, we need to synchronize our codes with our working environment
        (internet + computer + the application we are working on).

        - There are 1 way in Java and 2 ways in Selenium to solve synchronization problems.
            a) Thread.sleep(DurationOfWait) --> Java
            - not dynamic
            - Holds the codes and not let to pass to the next line as long as we write.
            - not useful, not flexible. It causes tests to take too long then normal

            b) ImplicitlyWait(maxDurationOfWait) --> Selenium
            - dynamic / task oriented
            - Instead of waiting for the maximum time at each step, it waits for the duration of the task.
            - It prevents extra time being spent because it does not wait for the maximum time.
            - ImplicitlyWait() covers the whole class. It means this method provides dynamic waiting time for locating and other operations in the whole class. If the task is not performed even though max time is finished, it gives an error.
            - It is preferable that the maximum wait time for ImplicitlyWait() is neither too long nor too short. An optimum maxWaitingTime should be determined.

            c) ExplicitlyWait() --> Selenium
            - dynamic / task oriented
            - If the time we set with ImplicitlyWait is not enough for any operation we will perform during the test, a special wait (explicitlyWait) can be created for only that test and/or operation instead of increasing the ImplicitlyWait times in all tests.
            - ExplicitlyWait creates a wait time focused on a single task.
            - If the task is completed early, ExplicitlyWait will allow you to pass the rest of the test without further delay.
     */

    @Test
    public void test01(){
        // don't extend testBase class or use implicitly wait
        // go to youtube, accept cookies, click first video

        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(ops);
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com");
        TestBase.wait(5);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN);
        WebElement acceptCookiesButtonElement = driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[12]"));
        //acceptCookiesButtonElement.click(); there are some automation problems on youtube which is normal
        TestBase.wait(5);
        driver.quit();
    }
}
