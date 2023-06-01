package day13_excel_screenshot_jsexecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenshotWholePage extends TestBase {

    @Test
    public void screenshotTest() throws IOException {

        // go to amazon webpage
        driver.get("https://www.amazon.com");
        wait(2);
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("Nutella"+ Keys.ENTER);

        // test the result contains Nutella
        WebElement resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedText = "Nutella";
        String actualText = resultTextElement.getText();

        Assert.assertTrue(actualText.contains(expectedText));

        //We need 4 steps to take screenshot of the whole page.
        // 1- Instant an object from TakesScreenShot and assign to driver as a value.
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

        // 2- create a file to save the screenshots
        File wholePageScreenShot = new File("target/Screenshot/wholePageScreenshot.png");

        // 3- use screenshot object to get and save into a temporary file
        File temporaryFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // 4- save the temporary file into to main file that we prepared before
        FileUtils.copyFile(temporaryFile,wholePageScreenShot);

    }
}
