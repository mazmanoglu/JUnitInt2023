package day13_excel_screenshot_jsexecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_ScreenshotWebElement extends TestBase {

    @Test
    public void test01() throws IOException {
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

        // just take a shot of the result text element
        // difference from whole page is that you have to locate the web element as first step. 2., 3. and 4. steps are same.

        File webElementScreenshot = new File("target/Screenshot/webElementScreenshot.png");

        File temporaryPicture = resultTextElement.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(temporaryPicture,webElementScreenshot);



    }
}
