package day09_actionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test01(){
     /*
        - go to amazon webpage
        - write nutella on searchbox
        - click enter to search
        - clear the searchbox
        - use action class and write SamsungA71 on searchbox
      */

        /*
            - Although there are many keys on the keyboard, there are 2 basic operations for each key
                    1- press it once
                    sendKeys(keys.ENTER)
                    2- long press, then lift our hand from the key when we're done
                        - we use the keyDown() method to press the key, the keyUp() method to release the pressed key
         */

        driver.get("https://www.amazon.com");
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("nutella");
        searchBoxElement.sendKeys(Keys.ENTER);
        wait(2);
       //searchBoxElement.clear();
        driver.navigate().back();
        wait(2);
        searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions = new Actions(driver);
        actions.click(searchBoxElement)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();
        wait(2);
    }
}
