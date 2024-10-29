package com.test.playwright;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.basePlaywright.BaseTest;

public class RegistrationPageTest extends BaseTest{
	
	@Test
	public void registrationLinkTest() {
		registrationPage=	homePage.NavigateToregistrationLink();
		String registVeiry=registrationPage.registrationlinkVerify();
		Assert.assertEquals(registVeiry, "Register Account");
	}

}
