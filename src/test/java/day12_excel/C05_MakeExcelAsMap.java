package day12_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class C05_MakeExcelAsMap {

    @Test
    public void excelMapTest() throws IOException {
        // sometimes we want to import all the data in Excel into the code area.

        String filePath = System.getProperty("user.home")+"/Desktop/Java-Selenium/Ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // It is not possible to store all information in a structure like a List, because Excel has more than one column.
        //We can use map which is the closest java structure to real database.

        // english country name = key
        // combination of other 3 information = value

        Map<String,String> countryMap = new TreeMap<>(); // normally we use "new HashMap<>()" but here used TreeMap to put data in order
        int lastRowIndex = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i=0; i<lastRowIndex; i++){
            // english name of the country
            String keyCountry = workbook
                                    .getSheet("Sayfa1")
                                    .getRow(i)
                                    .getCell(0)
                                    .toString();

            // capital name in English + Turkish country name + capital name in Turkish
            String valueCountry = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                                    +", "
                                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                                    +", "
                                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString()
                                    +"\n";


            countryMap.put(keyCountry,valueCountry);
        }
        System.out.println(countryMap);

        // Test that the english capital name of the country whose english name is Barbados, is Bridgetown

        String barbadosValue = countryMap.get("Barbados");
        System.out.println(barbadosValue); //Bridgetown, Barbados, Bridgetown
        String[] barbadosValueArray = barbadosValue.split(", ");

        String actualCapitalName = barbadosValueArray[0]; //[0]capital name in English, [1]country name in Turkish, [2]capital name in Turkish
        String expectedCapitalName = "Bridgetown";

        Assert.assertEquals(expectedCapitalName,actualCapitalName);

    }
}
