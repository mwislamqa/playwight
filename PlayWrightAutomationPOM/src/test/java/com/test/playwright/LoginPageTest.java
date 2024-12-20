package com.test.playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.basePlaywright.BaseTest;

import Utilities.EncryptedPassword;
public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void ClickAccountTest() throws Exception {
		
		loginPage=homePage.NavigatetoLoginLink();
		loginPage.clickAccountLink();
		//Assert.fail();
		
		
	}
	@Test(priority =2)
	public void loginAccountTitleTest() {
		System.out.println(loginPage.title());
		Assert.assertEquals(loginPage.title(), "Account Login");
	
	}
	//EncryptedPassword.password, EncryptedPassword.secretKey
	@Test(priority =3)
	public void loginAppTest() throws Exception {
		//loginPage.clickAccountLink();
		String enrptpwd= prop.getProperty("password");
		loginPage.logintotheapplicaton(prop.getProperty("userName"),EncryptedPassword.decryptPassword(enrptpwd, EncryptedPassword.secretKey));
		String urlapp="https://naveenautomationlabs.com/opencart/index.php?route=account/account";
		assertThat(page).hasURL(urlapp);
		Thread.sleep(5000);
	}
	
	@Test(priority=4,dependsOnMethods = "loginAppTest", enabled = false)
	public void logoutTest() throws InterruptedException {
		loginPage.logout();
	}
	
//	public void loginAppTest() {
//		loginPage.logintotheapplicaton(prop.getProperty("userName"), prop.getProperty("password"));
//		String urlapp="https://naveenautomationlabs.com/opencart/index.php?route=account/login";
//		assertThat(page).hasURL(urlapp);
//	}

}
