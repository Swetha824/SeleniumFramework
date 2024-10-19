package swethapanchumarthy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swethapanchumarthy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	// Constructor is the first method to execute in a class
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	// PageFactory
	

	
	@FindBy(css = ".cartSection h3") 
	List<WebElement> cartProducts;
	

	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}
	@FindBy(css=".totalRow button")
	WebElement checkOutButton;

	public CheckOutPage CheckOutPage() {
		
		checkOutButton.click();
		return new CheckOutPage(driver);
		
	}
	
	

	
}
