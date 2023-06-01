package day11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01(){
        // go to amazon webpage
        driver.get("https://www.amazon.com");
        // check there are 10 rows on web table on the bottom of the page
        List<WebElement> rowsList = driver.findElements(By.xpath("//table//tr"));
        Assert.assertEquals(10, rowsList.size());
        // check there are 14 columns on first row
        List<WebElement> firstRowsColumnList = driver.findElements(By.xpath("//table//tr[1]/td"));
        //System.out.println(columnList.size());
        Assert.assertEquals(14,firstRowsColumnList.size());
        // print the third column
        List<WebElement> thirdColumnList = driver.findElements(By.xpath("//table//tr/td[3]"));
        for (WebElement eachElement:thirdColumnList
             ) {
            System.out.println(eachElement.getText());
        }
        System.out.println("---------------");
        // print the fifth row
        List<WebElement> fifthRowList = driver.findElements(By.xpath("//table//tr[5]"));
        for (WebElement eachRow:fifthRowList
             ) {
            System.out.println(eachRow.getText());
        }
        // check 3rd row on 3rd column is 'Home Services'
        WebElement thirdRowThirdColumnElement = driver.findElement(By.xpath("//table//tr[3]/td[3]"));
        String expectedText = "Home Services";
        String actualText = thirdRowThirdColumnElement.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        // create a method that will print specific section on the table when we give the row and column values
        System.out.println("---------------------------------");
        printDataMethod(5,5);

        wait(3);
    }

    public void printDataMethod(int row, int column){
        WebElement rowAndColumn = driver.findElement(By.xpath("//table//tr["+row+"]/td["+column+"]"));
        System.out.println("The data on "+row+".row and "+column+".column is :\n"+rowAndColumn.getText());
    }
}
