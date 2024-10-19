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
import swethapanchumarthy.pageobjects.OrderPage;
import swethapanchumarthy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest {

	String productName = "ZARA COAT 3";

	@Test
	public void submitOrder() throws IOException {

		ProductCatalogue productCatalogue = landingPage.loginApplication("pswetha308@gmail.com", "Swetha@3239");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutPage = cartPage.CheckOutPage();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmationMessage = confirmationPage.confirmationMessage();

		Assert.assertEquals(confirmationMessage, "THANKYOU FOR THE ORDER.");

	}

	// To Verify ZARA COAT3 is displaying in orders page
	@Test(dependsOnMethods = "submitOrder")
	public void OrderHistoryTest() {

		ProductCatalogue productCatalogue = landingPage.loginApplication("pswetha308@gmail.com", "Swetha@3239");
		OrderPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
		

	}
}
