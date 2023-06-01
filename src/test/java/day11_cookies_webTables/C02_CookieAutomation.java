package day11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;
import java.util.Set;


public class C02_CookieAutomation extends TestBase {

    @Test
    public void cookieTest(){
        // go to amazon webpage
        // make a list for all cookies
        // test there are more than 5 cookies in page
        // check the value of "i18n-prefs" cookie is USD
        // create a cookie and add to page, name = "my best cookie", value = "is with chocolate"
        // test your new cookie is being added
        // delete the cookie named 'skin'
        // delete all cookies and test

        driver.get("https://www.amazon.com");
        Set<Cookie> allCookiesList = driver.manage().getCookies();

        int orderNumber=1;

        for (Cookie eachCookie:allCookiesList
             ) {
            System.out.println(orderNumber+" - "+eachCookie);
            orderNumber++;
        }

        Assert.assertTrue(allCookiesList.size()>5);

        Cookie i18nCookie = driver.manage().getCookieNamed("i18n-prefs");
        String i18nActualValue = i18nCookie.getValue();

        Assert.assertEquals("USD",i18nActualValue);

        System.out.println("=== === === == === === ===");

        Cookie addNewCookie = new Cookie("The best cookie", "is with chocolate");
        driver.manage().addCookie(addNewCookie);
        allCookiesList = driver.manage().getCookies();

        int secondOrderNumber=1;

        for (Cookie eachCookie:allCookiesList
        ) {
            System.out.println(secondOrderNumber+" - "+eachCookie);
            secondOrderNumber++;
        }

        Cookie myBestCookie = driver.manage().getCookieNamed("The best cookie");
        String myBestCookieValue = myBestCookie.getValue();

        Assert.assertEquals("is with chocolate",myBestCookieValue);

        System.out.println("=== === === == === === ===");

        allCookiesList = driver.manage().getCookies();
        int numberOfCookiesBeforeDelete = allCookiesList.size();

        driver.manage().deleteCookieNamed("skin");

        allCookiesList = driver.manage().getCookies();
        int numberOfCookiesAfterDelete = allCookiesList.size();

        int thirdOrderNumber=1;

        for (Cookie eachCookie:allCookiesList
        ) {
            System.out.println(thirdOrderNumber+" - "+eachCookie);
            thirdOrderNumber++;
        }

        Assert.assertEquals(numberOfCookiesBeforeDelete,numberOfCookiesAfterDelete+1);

        driver.manage().deleteAllCookies();

        allCookiesList = driver.manage().getCookies();
        System.out.println("=== === === == === === ===");

        for (Cookie eachCookie:allCookiesList
        ) {
            System.out.println(eachCookie);
        }
        Assert.assertEquals(0,allCookiesList.size());
        //Assert.assertTrue(allCookiesList.size()==0);


        wait(4);


    }
}
