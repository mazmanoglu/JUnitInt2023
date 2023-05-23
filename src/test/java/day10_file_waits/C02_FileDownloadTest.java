package day10_file_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {

    @Test
    public void downloadTest(){
        // go to webpage https://the-internet.herokuapp.com/download
        // download any file from the page
        // check the file is successfully downloaded.

        driver.get("https://the-internet.herokuapp.com/download");
        WebElement downloadElement = driver.findElement(By.xpath("//a[@href='download/some-file.txt']"));
        downloadElement.click();
        wait(5);
        String downloadedFilePath = System.getProperty("user.home")+"\\Downloads\\some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(downloadedFilePath)));
        wait(3);
    }
}
