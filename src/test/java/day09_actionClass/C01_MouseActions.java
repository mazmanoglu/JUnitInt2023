package day09_actionClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_MouseActions extends TestBase {
    @Test
    public void test01(){
        // go to amazon webpage
        // choose "create a list" from "Account&List" menu
        // click the "USD" button at the bottom of the page

        driver.get("https://www.amazon.com");


        /*
            While performing a test, it may be necessary to perform extra operations with the mouse or keyboard.
            For example, in order to click on the "create a list" link, it is necessary to wait on the account&list menu.

            Driver mostly use web elements that he sees (it depends on argument that web developer used)

            That's why Selenium created Action Class to perform all the functions, that we can do with the mouse and keyboard, with driver.

            To use the properties of the Action Class, we have to create instance (object).

            All actions should end perform method --> actions.moveToElement(accountListElement).perform();
         */

        Actions actions = new Actions(driver); //action class needs a parameter(a Driver object)
        WebElement accountListElement = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountListElement).perform();
        driver.findElement(By.xpath("//span[text()='Create a List']")).click();

    }
}
