package com.baseFactory.playwright;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.page.playwright.HomePage;

public class BaseFactory {
	
	public static Playwright playwright;
	Browser browser;
	BrowserContext browserContex;
	public static Page page;
	protected Properties prop;
	HomePage homepage;
	
	
	//initialize we driver
	public Page initialBrowser(Properties prop) {
		System.out.println("hello ! Automation Initializing the driver.");
		String browserName= prop.getProperty("browser");
		playwright = Playwright.create();
		
		switch (browserName) {
		case "chromium":
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "firefox":
			browser=playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
		case "safari":
			browser=playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
			break;
			
		case "chrome":
			browser=playwright.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
			break;

		default:
			System.out.println("pass the right bowser name.....!");
			break;
		}
		
		browserContex=	browser.newContext();
		page = browserContex.newPage();
		page.navigate(prop.getProperty("url"));
		return page;
	}
	//calling properties
	public Properties int_prop() {
		try {
			FileInputStream file = new FileInputStream("./src/test/resources/config/config.properties");
			prop= new Properties();
			try {
				prop.load(file);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return prop;
		
	}
	//take screenshots
	public  static String Screenshots() {
		String path = System.getProperty("user.dir") + "/Screenshots/" + System.currentTimeMillis() + ".png";

		//page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		//page.locator(HomePage.loginLink).screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(path)));
		return path;
		 
	}

}
