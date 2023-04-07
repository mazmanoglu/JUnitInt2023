package day06_junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_BeforeClass {

    /*
    - The methods that we use @BeforeClass and @AfterClass notations must be static (in JUnit)
    - JUnit runs the methods randomly (we cannot predict the order)
    - We have to consider that all test methods could be run independently.
    - If we use @Before/@After, the window would be closed/opened for EACH test. To avoid this and run 1 time, use @BeforeClass/@AfterClass
     */


    // go to amazon webpage
    // make 3 different test methods.
    // make searches for Nutella, Java and Selenium, and print the results

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
    public void testNutella(){
        driver.get("https://www.amazon.com");
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("Nutella" + Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(searchResultElement.getText());
    }

    @Test
    public void testJava(){
        driver.get("https://www.amazon.com");
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("Java" + Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(searchResultElement.getText());
    }

    @Test
    public void testSelenium(){
        driver.get("https://www.amazon.com");
        WebElement searchBoxElement = driver.findElement(By.id("twotabsearchtextbox"));
        searchBoxElement.sendKeys("Selenium" + Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(searchResultElement.getText());
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
