package day08_iframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_Iframe {
    /*
        - go to webpage "https://the-internet.herokuapp.com/iframe"
        - create a method "iframeTest"
        - Test "An IFrame containing ..." text is enabled(erisilebilir)
        - Write "Hello World" on text box
        - Verify "Elemental Selenium" text is visible and write on console.
     */

    WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    /*
    - If the web element that we want to access is in an iframe, the driver cannot access that element directly.
    - First we need to switch to the iframe that the web element is in.

    - to switch to an iframe, use one of these options with switchto().frame() method
        - index
        - name or id attribute value
        - object located as web element

     - If you want to do something about the main page after entering/switch into an iframe, you must first exit from that iframe with some methods
            - switchTo().defaultContent() ==> turn back to main page
            - switchTo().parentFrame() ==> If there is nested iframe, this could help you to shift one level outside (not main page)
     */

    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iframeTextElement = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframeTextElement.isEnabled());
        System.out.println(iframeTextElement.getText());
        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);
        Thread.sleep(2000);

        WebElement textBoxElement = driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(2000);

        textBoxElement.clear();
        Thread.sleep(2000);

        textBoxElement.sendKeys("Hello World");

        driver.switchTo().defaultContent();

        WebElement elementalSeleniumTextElement = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSeleniumTextElement.isEnabled());

        System.out.println(elementalSeleniumTextElement.getText());
    }

    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
