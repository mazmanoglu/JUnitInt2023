package day09_actionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_FacebookRegister extends TestBase {
    @Test
    public void test01(){
        // go to https://www.facebook.com
        // accept cookies
        // click "create new account" button
        // fill the name, surname, mail and password
        // click to register button

        driver.get("https://www.facebook.com");
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[@title='Decline optional cookies']"));
        cookieAcceptButton.click();
        WebElement createNewAccountButtonElement = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createNewAccountButtonElement.click();
        WebElement firsNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        firsNameElement.sendKeys("Fatih");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB)
                .sendKeys("ozer")
                .sendKeys(Keys.TAB)
                .sendKeys("fatihozer246@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("fatihozer246@gmail.com")
                .sendKeys(Keys.TAB)
                .keyDown(Keys.SHIFT)
                .sendKeys("x")
                .keyUp(Keys.SHIFT)
                .sendKeys("yt123")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("1986")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        wait(3);
    }
}
