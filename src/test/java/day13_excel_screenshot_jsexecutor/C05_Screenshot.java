package day13_excel_screenshot_jsexecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C05_Screenshot extends TestBase {

    @Test
    public void test01() throws IOException {
        // go to amazon webpage
        driver.get("https://www.amazon.com");

        // take the screenshot of full page
        fullPageScreenshotMethod();

        // write Nutella on searchbox and take screenshot of the element
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("Nutella");
        webElementScreenshot(searchBoxElement);

        // do the search, test the result contains Nutella
        searchBoxElement.submit();
        WebElement resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedText = "Nutella";
        String actualText = resultTextElement.getText();

        Assert.assertTrue(actualText.contains(expectedText));

        // take the screenshot of result text
        webElementScreenshot(resultTextElement);
    }
}