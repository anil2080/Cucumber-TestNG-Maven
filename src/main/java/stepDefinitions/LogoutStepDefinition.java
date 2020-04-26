package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogoutStepDefinition {
	
	WebDriver driver;

	@Given("^user is on home Page$")
	public void user_already_on_home_page() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://ui.freecrm.com/");
		driver.findElement(By.name("email")).sendKeys("anil.kumar2080@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Test@1234");
		WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", loginBtn);
	}

	@When("^title of home page is Free CRM$")
	public void title_of_home_page_is_free_CRM() {
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cogmento CRM", title);
	}

	@Then("^logout & Close the browser$")
	public void close_the_browser() {
		driver.quit();
	}

}
