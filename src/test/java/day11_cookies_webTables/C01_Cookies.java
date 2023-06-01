package day11_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.youtube.com");
        WebElement acceptCookiesElement = driver.findElement(By.xpath("//*[text()='Accept all']"));
        //acceptCookiesElement.click();

        Set<Cookie> cookieSet = driver.manage().getCookies();
        Cookie cookie = new Cookie("The best cookie", "is mine");
        driver.manage().addCookie(cookie);
        cookieSet = driver.manage().getCookies();

        //cookieSet.add(cookie); No matter how but this also works :)

        for (Cookie eachCookie:cookieSet
        ) {
            System.out.println(eachCookie);
        }

        wait(4);

    }
}
