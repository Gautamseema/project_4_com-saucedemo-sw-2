package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
        System.out.println("Opening the Browser");
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
     // Enter username on userName field
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
    //  Enter password on password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
    //  click on loginButton
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        String expectedText = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']"));
        String actualText = actualTextElement.getText();
        // Verifying actual and expected text
        Assert.assertEquals(expectedText, actualText);

    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Enter username on userName field
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        //  Enter password on password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        //  click on loginButton
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        //use this method
        int productCount = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals(productCount,6);
    }
    public void closeBrowser() {
        driver.quit();

    }
    }

