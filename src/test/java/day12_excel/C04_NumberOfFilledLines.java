package day12_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C04_NumberOfFilledLines {

    @Test
    public void test01() throws IOException{
        // Test that the number of physically used lines in Sayfa2 in Ulkeler excel table is 15

        String filePath = System.getProperty("user.home")+"/Desktop/Java-Selenium/Ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        int totalRowNumber = workbook.getSheet("Sayfa2").getLastRowNum();
        // add +1 to the index to find row number
        System.out.println("Total row number = " + (totalRowNumber+1));

        int numberOfFilledLines = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();

        System.out.println("Number of physically used lines = "+numberOfFilledLines);

    }
}
