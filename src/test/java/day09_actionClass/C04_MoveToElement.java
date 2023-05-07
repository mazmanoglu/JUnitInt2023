package day09_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MoveToElement extends TestBase {

    @Test
    public void test01(){
        /*
            - go to amazon web page "https://www.amazon.com/"
            - take the mouse on "Account&Lists" menu to open the menu
            - click to "Create a list" button
            - check "Your Lists" is written on new page
         */

        driver.get("https://www.amazon.com/");
        WebElement accountAndListButtonElement = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountAndListButtonElement).perform();
        WebElement createAListButtonElement = driver.findElement(By.xpath("//span[text()='Create a List']"));
        createAListButtonElement.click();
        WebElement yourListButtonElement = driver.findElement(By.xpath("//div[@role='heading']"));

        Assert.assertTrue(yourListButtonElement.isDisplayed());
        wait(3);
    }
}
