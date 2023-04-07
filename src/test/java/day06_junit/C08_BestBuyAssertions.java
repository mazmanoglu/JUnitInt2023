package day06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C08_BestBuyAssertions {
    // go to https://www.bestbuy.com
    // URL test ==> check the URL is equal to "https://www.bestbuy.com/
    // TitleTest ==> check the page title does NOT contain "Rest"
    // LogoTest ==> check the logo of BestBuy is displayed
    // FrancaisLinkTest ==> check the French link is displayed

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
    public void urlTest(){
        driver.get("https://www.bestbuy.com/");
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void titleTest(){
        driver.get("https://www.bestbuy.com/");
        String expectedError = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedError));
    }

    @Test
    public void logoTest(){
        driver.get("https://www.bestbuy.com/");
        WebElement logoElement = driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));

        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    public void francaisTest(){
        driver.get("https://www.bestbuy.com/");
        WebElement francaisElement = driver.findElement(By.xpath("//button[text()='Français']"));

        Assert.assertTrue(francaisElement.isDisplayed());
    }

    @AfterClass
    public static void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
