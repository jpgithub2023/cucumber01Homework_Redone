package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BankAndCashPage;
import pages.LoginPage;
import pages.TestBase;

public class BankAndCashDefination extends TestBase {

	LoginPage loginPage;
	BankAndCashPage bankAndCashPage;
	
	
	
	
	@And("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String accountDetails, String accountTitleField) {
		bankAndCashPage=PageFactory.initElements(driver, BankAndCashPage.class);
		switch (accountTitleField) {
		case "accountTitle":
			bankAndCashPage.entersAccountTitle(accountDetails);
			break;
		case "description":
			bankAndCashPage.entersDescription(accountDetails);
			break;
		case "initialBalance":
			bankAndCashPage.entersInitialBalance(accountDetails);
			break;
		case "accountNumber":
			bankAndCashPage.entersAccountNumber(accountDetails);
			break;
		case "contactPerson":
			bankAndCashPage.entersContactPerson(accountDetails);
			break;
		case "Phone":
			bankAndCashPage.enterPhoneNumber(accountDetails);
			break;
		case "internetBankingURL":
			bankAndCashPage.entersUrllink(accountDetails);
			break;
		}
		
	}
	@Then("User should be able to validate account created successfully")
	public void user_should_be_able_to_validate_account_created_successfully() {
		bankAndCashPage.validateInsertedName();
		System.out.println("Account is created successfully");
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
