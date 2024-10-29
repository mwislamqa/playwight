package com.page.playwright;

import com.microsoft.playwright.Page;

public class LoginPage {
	Page page;
	//locator 
	private String account="//a[text()='Account']";
	
	//constructor 
	
	public LoginPage(Page page) {
		this.page=page;
	}
	
	
	//action method
	
	public void clickAccountLink() throws Exception {
		Thread.sleep(4000);
		page.click(account);
		
	}
	
	public String title() {
	String titleloginpage=	page.title();
	return titleloginpage;
	}
	

}
