package swethapanchumarthy.Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import swethapanchumarthy.AbstractComponents.AbstractComponent;
import swethapanchumarthy.TestComponents.BaseTest;
import swethapanchumarthy.pageobjects.CartPage;
import swethapanchumarthy.pageobjects.CheckOutPage;
import swethapanchumarthy.pageobjects.ConfirmationPage;
import swethapanchumarthy.pageobjects.LandingPage;
import swethapanchumarthy.pageobjects.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test(groups={"ErrorHandling"})
	public void loginErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("pswetha308@gmail.com", "Swetha@39");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());

	}

	@Test
	public void productErrorValidation() throws IOException {

		String productName = "ZARA COAT 3";

		ProductCatalogue productCatalogue = landingPage.loginApplication("panchumarthyswetha@gmail.com", "Password@3");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);

	}
}
