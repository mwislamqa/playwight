package com.test.playwright;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.basePlaywright.BaseTest;

public class HomPageTest extends BaseTest {

	// test1
	@Test(priority = 1)
	public void titleTestforHomePage() {
		String actual_Title = homePage.getTitle();
		Assert.assertEquals(actual_Title, "Your Store");
	}

	// test2
	@Test(priority = 2)
	public void appURL_test() {
		String appURL = homePage.appURL();
		Assert.assertEquals(appURL,prop.getProperty("url"));
	}

	// test3
	@Test(dataProvider = "getProductData", priority = 3)
	public void searchProductTest(String productName) {
		String product = homePage.doSearchProduct(productName);
		Assert.assertEquals(product, "Search - " + productName);
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {

				{ "macbook" },

				{ "Imac" },

				{ "samsung" }

		};

	}

}
