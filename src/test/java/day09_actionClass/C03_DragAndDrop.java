package day09_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_DragAndDrop extends TestBase {

    @Test
    public void test01(){
        /*
            - go to webpage https://demoqa.com/droppable
            - hold "Drag me" button and put "Drop here" box
            - Test "Drop here" is written "Dropped!"
         */

        driver.get("https://demoqa.com/droppable");
        WebElement dragElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropTargetElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragElement,dropTargetElement).perform();

        WebElement droppedTextElement = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expectedDroppedText = "Dropped!";
        String actualDroppedText = droppedTextElement.getText();

        Assert.assertEquals(expectedDroppedText, actualDroppedText);
    }
}
