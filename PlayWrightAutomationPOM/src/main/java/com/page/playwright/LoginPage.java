package com.page.playwright;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
	Page page;
	// locator
	private String account = "//span[text()='My Account']";
	private String loginInput = "[name='email']";
	private String PasswordInput = "[name='password']";
	private String submit = "//input[@type='submit']";

	// constructor

	public LoginPage(Page page) {
		this.page = page;
	}

	// action method

	public void clickAccountLink() throws Exception {
		Thread.sleep(4000);
		page.click(account);

	}

	public String title() {
		String titleloginpage = page.title();
		return titleloginpage;
	}

	public Object logintotheapplicaton(Object userName, Object object) {
		page.locator(loginInput).fill((String) userName);
		page.locator(PasswordInput).fill((String) object);
		page.click(submit);
		return null;

	}

	public void logout() throws InterruptedException {
		page.click(account);
		Thread.sleep(4000);
		Locator dropdown = page.locator("//ul[@class='dropdown-menu dropdown-menu-right']/li");

		for (int i = 0; i < dropdown.count(); i++) {
			String all = dropdown.nth(i).innerText();
			if (all.contains("Logout")) {
				dropdown.nth(i).click();
			}
			break;

		}

	}

}
