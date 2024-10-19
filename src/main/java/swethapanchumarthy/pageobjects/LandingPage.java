package swethapanchumarthy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swethapanchumarthy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;
	
	// Constructor is the first method to execute in a class
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail = driver.findElement(By.id("userEmail"));

	// PageFactory
	@FindBy(id = "userEmail") // At run Time , it will weill be constructed as above and assigned to the variable specified below
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(css="#login")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email,String pwd) {
		
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		return new ProductCatalogue(driver);
		
				
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return(errorMessage.getText());
		
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client/");
	}

	
}
