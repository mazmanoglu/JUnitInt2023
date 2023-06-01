package day12_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {
        // System.out.println(System.getProperty("user.home"));


        // assign the file path to a string variable
        String dynamicFilePath = System.getProperty("user.home")+"\\Desktop\\Java-Selenium\\Ulkeler.xlsx";

        // create a FileInputStream object and enter the file path as a parameter
        FileInputStream fileInputStream = new FileInputStream(dynamicFilePath);

        // create workbook object, enter FileInputStream object as parameter
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // create a worksheet object
        Sheet sheet = workbook.getSheet("Sayfa1");

        // create a row object
        Row row = sheet.getRow(2);

        // create a cell object (row.getCell(index))
        Cell cell = row.getCell(0);

        // System.out.println(cell); //Albania

        // check 3rd row equals "Albania";
        String expectedCountryName = "Albania";
        String actualCountryName = cell.toString();

        Assert.assertEquals(expectedCountryName,actualCountryName);



    }
}