package day06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C09_YouTubeTest {

    // go to "https://www.youtube.com"
    // titleTest ==> check the title is "YouTube"
    // imageTest ==> check the YouTube picture is displayed
    // searchBoxTest ==> check search box is enabled (erisilebilir/accessible)
    // negativeTitleTest ==> check the title is NOT "youtube"

    static WebDriver driver;


    @BeforeClass
    public static void setup(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void titleTest(){
        driver.get("https://www.youtube.com");
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void imageTest(){
        driver.get("https://www.youtube.com");
        WebElement acceptCookiesElement = driver.findElement(By.xpath("(//yt-touch-feedback-shape/div/div[@class='yt-spec-touch-feedback-shape__fill'])[12]"));
        if (acceptCookiesElement.isDisplayed())
            acceptCookiesElement.click();

        WebElement youtubeLogoElement = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

        Assert.assertTrue(youtubeLogoElement.isDisplayed());
    }

    @Test
    public void searchBoxTest(){
        driver.get("https://www.youtube.com");
        WebElement acceptCookiesElement = driver.findElement(By.xpath("(//yt-touch-feedback-shape/div/div[@class='yt-spec-touch-feedback-shape__fill'])[12]"));
        if (acceptCookiesElement.isDisplayed())
            acceptCookiesElement.click();

        WebElement searchBoxElement = driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searchBoxElement.isEnabled());
    }

    @Test
    public void negativeTitleTest(){
        driver.get("https://www.youtube.com");
        WebElement acceptCookiesElement = driver.findElement(By.xpath("(//yt-touch-feedback-shape/div/div[@class='yt-spec-touch-feedback-shape__fill'])[12]"));
        if (acceptCookiesElement.isDisplayed())
            acceptCookiesElement.click();

        String expectedWrongTitle = "youtube";
        String actualTitle = driver.getTitle();

        Assert.assertNotEquals(expectedWrongTitle,actualTitle);
    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
