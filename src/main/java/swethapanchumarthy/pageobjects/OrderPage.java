package swethapanchumarthy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swethapanchumarthy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	// Constructor is the first method to execute in a class
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	// PageFactory
	

	
	@FindBy(xpath = "//tr//td[2]") 
	List<WebElement> productNames;
	

	


	public Boolean VerifyOrderDisplay(String productName) {
		// TODO Auto-generated method stub
		Boolean match = productNames.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	

	
}
