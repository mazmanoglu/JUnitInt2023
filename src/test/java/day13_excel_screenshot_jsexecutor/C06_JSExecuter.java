package day13_excel_screenshot_jsexecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSExecuter extends TestBase {

    @Test
    public void test01(){

        // go to amazon webpage
        driver.get("https://www.amazon.com");

        // click "sell" button with Javascript executor
        WebElement sellButtonElement = driver.findElement(By.xpath("//a[text()='Sell']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver; //(JavascriptExecutor) --> casting
        jse.executeScript("arguments[0].click();",sellButtonElement);
        wait(2);

        // create an alert and write "congrats"

        jse.executeScript("alert('Congrats');");
        wait(3);

        driver.switchTo().alert().accept();

        wait(2);
    }
}
