package stepdefs;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    WebDriver driver = DriverFactory.getDriver();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        @Given("I open {string}")
        public void i_open_url(String url){
         DriverFactory.getDriver().get(url);
         driver.findElement(By.id("divLogintextMain")).click();
      }

         @When("I enter username {} and password{}")
         public void i_enter_credentials(String username, String password){
            // username
             WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtUserName")));
             usernameField.clear();
             usernameField.sendKeys(username);

               //password
             WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtPassword")));
             passwordField.clear();
             passwordField.sendKeys(password);

             // Select Role
             WebElement userTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("drpUserType")));
             Select role = new Select(userTypeDropdown);
             role.selectByVisibleText(" Netsurf Direct Seller"); // or "Consumer"


             // Click Login Button (handle <a> inside <div>)
             WebElement loginDiv = wait.until(ExpectedConditions.elementToBeClickable(By.id("a_login")));
             loginDiv.click();  // this should work unless JS click is required
         }
         @Then("I should see dashboard")
            public void i_should_see_dashboard(){
            String s = driver.getTitle();
         }
    }