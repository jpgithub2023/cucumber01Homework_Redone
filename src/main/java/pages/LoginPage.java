package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver= driver;
	}
		
		//Element List
		@FindBy(how= How.XPATH, using="//*[@id=\"username\"]")WebElement UserName;
		@FindBy(how= How.XPATH, using="//*[@id=\"password\"]")WebElement Password;
		@FindBy(how= How.XPATH, using="/html/body/div/div/div/form/div[3]/button")WebElement SignInButton;
		
		//Method to interact with above Elements
		
		public void enterUserName(String username) {
			UserName.sendKeys(username);
			try {
			Thread.sleep(3000);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			}
		
			public void enterPassword(String password) {
			Password.sendKeys(password);
			try {
			Thread.sleep(3000);
			} catch (InterruptedException e) {
		
			e.printStackTrace();
			}
			}

			public void clickSignInButton() {
				SignInButton.click();
			try {
			Thread.sleep(2000);
			
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			}
			
			public String getPageTitle() {
			return driver.getTitle();
			}
}
