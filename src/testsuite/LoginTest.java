package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = " https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on the ‘Sign In’ link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        // Verify the text ‘Welcome Back!’
        String expectedHeadingText = "Welcome Back!";
        WebElement headingText = driver.findElement(By.className("page__heading"));
        String actualHeadingText = headingText.getText();
        Assert.assertEquals("Welcome Back text not displayed", expectedHeadingText, actualHeadingText);

    }

    @Test
    public void verifyTheErrorMessage() {
        //click on the ‘Sign In’ link
        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();
        // Enter invalid username
        WebElement userNameField = driver.findElement(By.id("user[email]"));
        userNameField.sendKeys("hjui");
        //Enter invalid password
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("jlko9");
        //Click on Login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        loginButton.click();
        // Verify the error message ‘Invalid email or password.’
        String expectedErrorMessage = "Invalid email or password.";
        WebElement errorMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualErrorMessage = errorMessage.getText();
        Assert.assertEquals("Inavlid Error Message not same", expectedErrorMessage, actualErrorMessage);

    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
