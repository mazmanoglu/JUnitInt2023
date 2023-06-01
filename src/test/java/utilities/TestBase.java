package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {

    public WebDriver driver;
    // protected WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void teardown()  {
        driver.quit();
    }

    public static void wait(int secondsToWait){
        try {
            Thread.sleep(secondsToWait*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void fullPageScreenshotMethod() throws IOException {

        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2- create a file to save the screenshots
        // make filename dynamic and add date
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd-HHmmss");

        File wholePage = new File("target/Screenshot/wholePageScreenshot"+ldt.format(dtf)+".png");

        // 3- use screenshot object to get and save into a temporary file
        File temporaryFile = tss.getScreenshotAs(OutputType.FILE);

        // 4- save the temporary file into to main file that we prepared before
        FileUtils.copyFile(temporaryFile,wholePage);
    }

    public void webElementScreenshot(WebElement target) throws IOException {

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd-HHmmss");
        File webElementScreenshot = new File("target/Screenshot/webElementScreenshot"+ldt.format(dtf)+".png");

        File temporaryPicture = target.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temporaryPicture,webElementScreenshot);

    }
}
