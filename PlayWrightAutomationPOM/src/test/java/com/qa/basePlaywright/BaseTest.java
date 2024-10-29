package com.qa.basePlaywright;

import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.baseFactory.playwright.BaseFactory;
import com.microsoft.playwright.Page;
import com.page.playwright.HomePage;
import com.page.playwright.LoginPage;
import com.page.playwright.RegistrationPage;

public class BaseTest {
	
	BaseFactory basefactory;
	Page page;
	protected HomePage homePage;
	protected Properties prop;
	protected LoginPage loginPage;
	protected RegistrationPage registrationPage;
	@BeforeTest
	//@BeforeSuite
	public void setUpBrowser() {
		basefactory = new BaseFactory();
		prop=basefactory.int_prop();
	    page= basefactory.initialBrowser(prop);
	    homePage = new HomePage(page);
	    loginPage = new LoginPage(page);
	    registrationPage = new RegistrationPage(page);
	
	}
	
	@AfterTest
	//@AfterSuite
	public void tearDown() {
		page.context().browser().close();
		
	}

}
