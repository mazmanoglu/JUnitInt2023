package day09_actionClass;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_UsingFakerClass extends TestBase {

    @Test
    public void test01(){
        // This class is totally same with C06_FacebookRegistration
        // but here, you have to create and use random values for name, surname, email and password.
        // that's why we use Faker class from maven repos

        driver.get("https://www.facebook.com");
        WebElement cookieAcceptButton = driver.findElement(By.xpath("//button[@title='Decline optional cookies']"));
        cookieAcceptButton.click();
        WebElement createNewAccountButtonElement = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createNewAccountButtonElement.click();
        WebElement firsNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions = new Actions(driver);

        Faker faker = new Faker();

        String email = faker.internet().emailAddress();
        String year = Integer.toString(faker.number().numberBetween(1950, 2000));

        actions.click(firsNameElement)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password(8,10))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(year)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();
        wait(3);
    }
}
