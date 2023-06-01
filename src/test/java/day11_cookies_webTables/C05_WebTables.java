package day11_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_WebTables extends TestBase {

    @Test
    public void webTableTest(){
        // go to webpage https://demoqa.com/webtables
        driver.get("https://demoqa.com/webtables");

        // print the titles on header of the table
        List<WebElement> titleElementsList = driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));

        for (WebElement eachElement:titleElementsList
             ) {
            System.out.print(eachElement.getText() + "---");
        }

        // print the title of the 3rd column
        System.out.println();
        System.out.println(titleElementsList.get(2).getText());

        // print all data of the table
        List<WebElement> dataElementsList = driver.findElements(By.xpath("//div[@class='rt-td']"));

        for (WebElement eachData:dataElementsList
             ) {
            System.out.println(eachData.getText());
        }

        // print how many cell (data) on the table are not empty
        int counter=0;
        for (WebElement eachElement:dataElementsList
             ) {
            if (!eachElement.getText().isBlank()){
                counter++;
                // "     " --> is blank, but not empty.
            }
        }
        System.out.println("The number of cell on table that are NOT empty is : "+counter); //6*3=18

        // print the row number of the table
        List<WebElement> rowElementList = driver.findElements(By.xpath("//div[@class='rt-tr-group']"));

        System.out.println("Number of rows on table is : "+rowElementList.size()); //10

        // print the column number of the table
        System.out.println("Number of columns on table is : "+titleElementsList.size()); //7

        // print the 3rd column
        /*
            We could not reach the data information dynamically because the table could not be created with the table tags.
         */
        System.out.println("<--------->");
        for (int i=2; i<dataElementsList.size(); i+=7){
            System.out.println(dataElementsList.get(i).getText()); // 39 45 29
        }

        // print the salary of the person whose First Name is Kierra
        /*
            First Kierra's element and add 4 to it.
         */

        for (int i=0; i<dataElementsList.size(); i++){
            if (dataElementsList.get(i).getText().equalsIgnoreCase("Kierra")){
                System.out.println("Kierra's salary is = "+dataElementsList.get(i + 4).getText()); //2000
            }
        }
        // create a method, this method will give the data when we put the values of column and row

    }
}
