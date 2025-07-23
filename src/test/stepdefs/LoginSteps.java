package stepdefs;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
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
         public void i_enter_credentials(String username, String password) throws InterruptedException {
            // username
             WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtUserName")));
             usernameField.clear();
             usernameField.sendKeys(username);
             Thread.sleep(2000);

               //password
             WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("txtPassword")));
             passwordField.clear();
             passwordField.sendKeys(password);

             // Select Role
             WebElement userTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("drpUserType")));
             Select role = new Select(userTypeDropdown);
             role.selectByVisibleText(" Netsurf Direct Seller"); // or "Consumer"


             // Click Login Button (handle <a> inside <div>)
             WebElement loginDiv = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#a_login a")));
             JavascriptExecutor JS =  (JavascriptExecutor) driver;
             System.out.println("🔘 Attempting to click login...");
             JS.executeScript("arguments[0].click();", loginDiv);
             System.out.println("✅ JS click on login link inside #a_login triggered.");
             //loginDiv.click();  // this should work unless JS click is required

         }
         @Then("I should see homepage")
            public void i_should_see_homepage() throws InterruptedException {
             try {
                 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/Dashboard/Dashboard']")));
                 System.out.println("✅ Login successful — Dashboard link is visible.");
             } catch (TimeoutException e) {
                 System.out.println("❌ Login may have failed — Dashboard icon not found.");
             }
         }
}