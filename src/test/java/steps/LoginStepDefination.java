package steps;




import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.BankAndCashPage;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefination extends TestBase {
	
	LoginPage loginPage;
	BankAndCashPage bankAndCashPage;
	
	
	/*@Test
	 * public void loginTest() throws Throwable{
	 * loginPageObj.enterUserName("demo@techfios.com");
	 * loginPageObj.enterPassword("abc123");
	 * loginPageObj.clickSignInButton();
	 * takeScreenshot(driver);
	 * }
	 */

	@Before
	public void setup() {
		initdriver();
		loginPage= PageFactory.initElements(driver, LoginPage.class);
		
	}
	
	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		driver.get("https://techfios.com/billing/?ng=admin/");
	}
	
	@When("User enters the {string} in the {string} field")
	public void user_enters_the_in_the_field(String LoginData, String LoginField) {
	   switch(LoginField) {
	   case "username":
		   loginPage.enterUserName(LoginData);
		   break;
	   }
	   switch(LoginField) {
	   case "password":
		   loginPage.enterPassword(LoginData);
		   break;
	   }
	}
	
	@When("User clicks on {string}")
	public void user_clicks_on(String buttontype) {
		switch(buttontype) {
		case"login":
			loginPage.clickSignInButton();
			break;
		case"bankCash":
			bankAndCashPage=PageFactory.initElements(driver, BankAndCashPage.class);
			bankAndCashPage.clickOnBankAndCashOption();
			break;
		case"newAccount":
			bankAndCashPage.clickNewAccountOption();
			break;
		case"submit":
			bankAndCashPage.clicksOnSubmitButton();
			break;
		}
		
			
	
	}



	@Then("User should land on Dashboard page")
	public void user_should_land_on_Dashboard_page() {
	    String expectedTitle="Dashboard- iBilling";
	    String actualTitle= loginPage.getPageTitle();
	   
	  
	  Assert.assertEquals(expectedTitle, actualTitle);
	}
	

	
}
