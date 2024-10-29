package com.page.playwright;

import com.microsoft.playwright.Page;

public class HomePage {
	
	Page page;
	// add locator and action method 
	//locator
	private String search ="input[name='search']";
	private String searchButton ="div#search button";
	private String searchPageHeader ="div#content h1";
	private String myAccountLink ="a[title='My Account']";
	public static  String loginLink ="//a[text()='Login']";
	private String registrationLink ="//a[text()='Register']";
	
	//create page constructor
	
	public HomePage(Page page) {
		this.page=page;
		
	}
	
	//action method for test scenario 
	//action 1
	public String getTitle() {
		String title =page.title();
		return title;
	}
	//action 2
	public String appURL() {
	String url=	page.url();
	return url;
	}
	//action 3
	public String doSearchProduct(String name) {
		page.fill(search, name);
		page.click(searchButton);
	String prodSearch=	page.textContent(searchPageHeader);
	return prodSearch;
		
	}
	
	public LoginPage NavigatetoLoginLink() {
		page.click(myAccountLink);
		page.locator(loginLink).click();
		return new LoginPage(page);
	}
	
	public RegistrationPage NavigateToregistrationLink() {
		page.click(myAccountLink);
		page.click(registrationLink);
		return new RegistrationPage(page);
		
	}
	
	

}
