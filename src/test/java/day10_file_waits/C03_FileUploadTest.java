package day10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTest extends TestBase {

    @Test
    public void uploadTest01(){
        // go to web page https://the-internet.herokuapp.com/upload
        // click choose a file button
        // choose any file you want to upload
        // click upload button
        // check "File uploaded" text is displayed

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButtonElement = driver.findElement(By.id("file-upload"));
        wait(5);

        /*
            -After pressing the select file button, it is not possible to select a file from the computer using selenium.
            Instead, we can select a file by writing --> choosingFileButtonElement.sendKeys("filePath")
         */

        String filePathToUpload = System.getProperty("user.home")+"\\Desktop\\Java-Selenium\\FileTest\\demo.txt";
        chooseFileButtonElement.sendKeys(filePathToUpload);
        wait(2);

        WebElement uploadButtonElement = driver.findElement(By.id("file-submit"));
        uploadButtonElement.click();
        wait(2);

        WebElement fileUploadedTextElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(fileUploadedTextElement.isDisplayed());
    }
}
