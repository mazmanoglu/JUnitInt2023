package day12_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void readExcelTest() throws IOException{
        // go to "Ulkeler" excel table
        // check 32nd country's name in english is Canada

        String filePath = System.getProperty("user.home")+ "/Desktop/Java-Selenium/Ulkeler.xlsx";

        FileInputStream fileInputStream = new FileInputStream(filePath);

        Workbook workbook = WorkbookFactory.create(fileInputStream);

        String actualCountryName = workbook
                                        .getSheet("Sayfa1")
                                        .getRow(31)
                                        .getCell(0)
                                        .toString();

        String expectedCountryName = "Canada";

        Assert.assertEquals(expectedCountryName,actualCountryName);
    }
}
