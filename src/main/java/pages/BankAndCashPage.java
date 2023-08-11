package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class BankAndCashPage {

	WebDriver driver;

	public BankAndCashPage(WebDriver driver) {
		this.driver = driver;

	}
	
	//Element List
	@FindBy(how= How.XPATH, using="//*[@id=\"side-menu\"]/li[10]/a/span[1]")WebElement BankAndCash;
	@FindBy(how= How.XPATH, using="//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")WebElement NewAccount;
	@FindBy(how= How.XPATH, using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/h5")WebElement AddNewAccountHeaderText;
	@FindBy(how= How.XPATH, using="//*[@id=\"account\"]")WebElement AccountTitle;
	@FindBy(how= How.XPATH, using="//*[@id=\"description\"]")WebElement AccountDescription;
	@FindBy(how= How.XPATH, using="//*[@id=\"balance\"]")WebElement InitialBalance;
	@FindBy(how= How.XPATH, using="//*[@id=\"account_number\"]")WebElement AccountNumber;
	@FindBy(how= How.XPATH, using="//*[@id=\"contact_person\"]")WebElement ContactPerson;
	@FindBy(how= How.XPATH, using="//*[@id=\"contact_phone\"]")WebElement PhoneNumber;
	@FindBy(how= How.XPATH, using="//*[@id=\"ib_url\"]")WebElement Url;
	@FindBy(how= How.XPATH, using="//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")WebElement Submitutton;
	//@FindBy(how= How.XPATH, using="//*[@id=\"page-wrapper\"]/div[3]/div[1]")WebElement AccountSuccess;
	
	
	//Method to interact with above Elements
	
	public void clickOnBankAndCashOption() {
		try {
			Thread.sleep(2000);
			BankAndCash.click();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	public void clickNewAccountOption() {
		try {
			Thread.sleep(5000);
			NewAccount.click();
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
	}
	
	public String getPageTitle() {
		return driver.getTitle();
		
	}
	String insertedTitle;
	public void entersAccountTitle(String accountTitle) {
		insertedTitle = accountTitle + randomNumGenerator(999);
		AccountTitle.sendKeys(insertedTitle);
	} 
	
	public void entersDescription(String account_description) {
		AccountDescription.sendKeys(account_description);
	}
	
	public void entersInitialBalance(String balance) {
		InitialBalance.sendKeys(balance);
	}
	
	public void entersAccountNumber(String Account_Number) {
		AccountNumber.sendKeys(Account_Number +randomNumGenerator(999));
	}
	
	public void entersContactPerson(String contact) {
		ContactPerson.sendKeys(contact);
	}

	public void enterPhoneNumber(String number) {
		PhoneNumber.sendKeys(number);
	}
	public void entersUrllink(String url) {
		Url.sendKeys(url);
	}
	
	public void clicksOnSubmitButton() {
		Submitutton.click();
	}
	public int randomNumGenerator(int bound) {
		Random rnd= new Random();
		int generatedNum= rnd.nextInt(bound);
		return generatedNum;
		}
	
	//tbody/tr[295]/td[1]
		//tbody/tr[i]/td[1]
		String before_xpath="//tbody/tr[";
		String after_xpath="]/td[1]";
		
		
			public void validateInsertedName() {
			List <WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
			int rowSize= rows.size();
			System.out.println("No of rows are : " + rowSize);
			for(int i=rowSize; i<=10; i--) {
			String actualName=driver.findElement(By.xpath(before_xpath+ i+ after_xpath)).getText();
			if(actualName.contains(insertedTitle)) {
				System.out.println("Account is created");
			}else {
				System.out.println("No Account");
			}
		}
		}
	
	
	
}




