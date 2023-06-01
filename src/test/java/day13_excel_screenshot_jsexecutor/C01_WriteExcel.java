package day13_excel_screenshot_jsexecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void writeExcelTest() throws IOException {

        //Go to the first line by following the steps.
        String filePath = System.getProperty("user.home")+"/Desktop/Java-Selenium/Ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        //Create a new cell for the fourth cell and write "Population" in the cell
        workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .createCell(4)
                .setCellValue("Population");

        //Write 150 in the 2nd row on population column
        workbook
                .getSheet("Sayfa1")
                .getRow(1)
                .createCell(4)
                .setCellValue("150");

        //Write 250 in the 10th row on population column
        workbook
                .getSheet("Sayfa1")
                .getRow(9)
                .createCell(4)
                .setCellValue("250");

        //Write 350 in the 15th row on population column
        workbook
                .getSheet("Sayfa1")
                .getRow(14)
                .createCell(4)
                .setCellValue("350");

        // change population on the 15th row as 1111
        workbook
                .getSheet("Sayfa1")
                .getRow(14)
                .getCell(4)
                .setCellValue("1111");

        //Save the file
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        workbook.write(fileOutputStream);

        //Close the file
        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();
    }
}
