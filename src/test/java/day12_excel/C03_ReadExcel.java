package day12_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C03_ReadExcel {

    @Test
    public void readExcelTest() throws IOException{

        String filePath = System.getProperty("user.home")+"/Desktop/Java-Selenium/Ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        List<String> listOfCountriesTurkishName = new ArrayList<>();
        int lastRowIndex = workbook
                                .getSheet("Sayfa1")
                                .getLastRowNum();

        for (int i=0; i<lastRowIndex; i++){
            listOfCountriesTurkishName.add(workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString());
        }
        listOfCountriesTurkishName.remove(0);

        /*
        for (String eachCountry:listOfCountriesTurkishName
             ) {
            System.out.println(eachCountry);
        }
         */

        //check "Ulkeler" excel table contains "Senegal"
        Assert.assertTrue(listOfCountriesTurkishName.contains("Senegal"));

        // check there are 190 countries
        Assert.assertEquals(190,listOfCountriesTurkishName.size());

        // check the longest name is "Mikronezya Federal Devletleri"
        String longestCountryName = "Senegal"; // just put a random country name

        for (String eachCountry:listOfCountriesTurkishName
             ) {
            if (eachCountry.length()>longestCountryName.length()){
                longestCountryName=eachCountry;
            }
        }

        System.out.println("Longest country name is = "+longestCountryName);
        Assert.assertEquals("Mikronezya Federal Devletleri",longestCountryName);


    }
}
