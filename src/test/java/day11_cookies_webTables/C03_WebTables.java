package day11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {

    @Test
    public void amazonTest(){
        // go to amazon webpage
        // click "home services" on the web table at the bottom of the page.
        // check the browser goes to the related page

        driver.get("https://www.amazon.com");
        WebElement homeServiceElement = driver.findElement(By.xpath("//table/tbody/tr[3]/td[3]")); //If you don't write tbody / if you don't write all child classes, then you should put double slash(//)
        homeServiceElement.click();

        String expectedPageTitle = "Home & Business Services";
        WebElement actualPageTitleElement = driver.findElement(By.xpath("//span[text()='Home & Business Services']"));
        Assert.assertTrue(actualPageTitleElement.getText().contains(expectedPageTitle));
        //or
        Assert.assertTrue(actualPageTitleElement.isDisplayed());

        // write all table body
        WebElement tableBody = driver.findElement(By.xpath("//table/tbody"));
        System.out.println(tableBody.getText());
        wait(5);
    }
}
