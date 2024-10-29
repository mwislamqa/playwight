package com.page.playwright;

import com.microsoft.playwright.Page;

public class RegistrationPage {
	Page page;
	//locator
	private String registration = "#content h1";
	//constructor
	public RegistrationPage(Page page) {
		
		this.page=page;
	}
	
	//action method
	
	public String registrationlinkVerify() {
		
	String regVerify=	page.textContent(registration);
	
	return regVerify;
	}
	

}
