package com.test.playwright;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.basePlaywright.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=2)
	public void ClickAccountTest() throws Exception {
		
		loginPage=homePage.NavigatetoLoginLink();
		loginPage.clickAccountLink();
		
	}
	@Test(priority =1)
	public void loginAccountTitleTest() {
		Assert.assertEquals(loginPage.title(), "Account Login");
	
	}

}
