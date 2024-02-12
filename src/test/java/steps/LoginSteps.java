package steps;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	
	WebDriver driver;

    @Given("User navigate to the web Web Katalon-demo-cura")
    public void navigateToWebPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com");
    }

    @And("User click on the make appointment button")
    public void clickMakeAppointmentButton() {
        driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
    }

    @And("User enter the username as John Doe")
    public void enterUsername() {
        driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
    }

    @And("User enter the password as ThisIsNotAPassword")
    public void enterPassword() {
        driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
    }
    
    @And("User enter the password as Test123")
    public void enterInvalidPassword() {
        driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("Test123");
    }

    @When("User click on the login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
    }

    @Then("Login should be success")
    public void verifyLoginSuccess() {
        String expectedResult = "Make Appointment";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/div/h2")).getText();
        assertEquals(expectedResult, actualResult);
        driver.close();
    }
    @But("Login should fail")
    public void verifyLoginFailure() {
        String expectedResult = "Login failed! Please ensure the username and password are valid.";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]")).getText();
        assertEquals(expectedResult, actualResult);
        driver.close();
    }

}
