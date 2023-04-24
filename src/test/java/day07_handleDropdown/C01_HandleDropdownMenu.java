package day07_handleDropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_HandleDropdownMenu {
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
    Dropdown menus are special web elements and are created with the 'select' tag.
    In order to select an option from the dropdown menus, we must create an object from the Select class.
    - locate the dropdown menu
    - create object from Select class
    - give the element of dropdown location as a parameter of Select object
    - To select the option from the menu where we locate and create the select object, we can choose the option with
        --index
        --value
        --visibletext
     */


    @Test
    public void dropdownTest(){
        // go to amazon web page
        // choose 'electronics' from search-in menu (left side of the search box)
        // print java on searchbox and search
        // test the result is bigger than 1000

        driver.get("https://www.amazon.com");
        WebElement dropdownWebElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdownWebElement);
        select.selectByVisibleText("Electronics");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String searchResultStr = searchResultElement.getText();
        System.out.println(searchResultStr); //1-24 of 341 results for "Java"

        int indexOfOf = searchResultStr.indexOf("of");
        int indexOfResults = searchResultStr.indexOf("results");
        int searchResultNumberAsInt = Integer.parseInt(searchResultStr.substring(indexOfOf+3, indexOfResults-1)); //begin index included, last index excluded

        System.out.println(searchResultNumberAsInt); //320
        // we print now the results to see, but in real project, don't use SOUT to print your results. Not a good behave.

        Assert.assertTrue(searchResultNumberAsInt>1000); // failed, coz result number is around 300

    }


    @After
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}