package day09_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    @Test
    public void test01(){
        /*
            - go to webpage https://the-internet.herokuapp.com/context_menu
            - right click on stripped area
            - test the alert text is equal to "You selected a context menu"
            - click Ok and close the alert
            - click 'Elemental Selenium' link
            - test the "Elemental Selenium" is written on h1 tag
         */
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement strippedAreaElement = driver.findElement(By.id("hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(strippedAreaElement).perform();

        String expectedAlertText = "You selected a context menu";
        String actualAlertText = driver.switchTo()
                                        .alert()
                                        .getText();
        Assert.assertEquals(expectedAlertText,actualAlertText);

        driver.switchTo().alert().accept();

        String firstPageWindowHandleValue = driver.getWindowHandle();
        WebElement elementalSeleniumTextElement = driver.findElement(By.linkText("Elemental Selenium"));
        elementalSeleniumTextElement.click();
        Set<String> windowHandlesSet = driver.getWindowHandles();
        String secondPageWindowHandleValue ="";
        for (String eachHandleValue:windowHandlesSet
        ) {
            if (!eachHandleValue.equals(firstPageWindowHandleValue)){
                secondPageWindowHandleValue=eachHandleValue;
            }
        }
        driver.switchTo().window(secondPageWindowHandleValue);

        String expectedHeadLine = "Elemental Selenium";
        String actualHeadLine = driver.findElement(By.tagName("h1")).getText();

       // Assert.assertTrue(actualHeadLine.contains(expectedHeadLine));
        Assert.assertEquals(expectedHeadLine,actualHeadLine);
    }
}
