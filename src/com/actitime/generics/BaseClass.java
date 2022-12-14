package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.EnterTimeTrackPage;
import com.actitime.pom.LoginPage;

public class BaseClass {

static {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser() {
	Reporter.log("openBrowser", true);	
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.manage().window().maximize(); 
	}
	@BeforeTest
	public void openBrowse1r() {
	Reporter.log("openBrowser1", true);	
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.manage().window().maximize(); 
	}
	@AfterTest
	public void closeBrowser() {
		Reporter.log("closeBrowser", true);	
		driver.close();
	}
	@AfterTest
	public void closeBrowser1() {
		Reporter.log("closeBrowser1", true);	
		driver.close();
	}
	@BeforeMethod
	public void login() throws IOException {
		Reporter.log("login", true);	
		FileLib f=new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
	}
	@AfterMethod
	public void logout() {
		Reporter.log("logout", true);	
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.setLogout();
	    System.out.println("thank you");
	    System.out.println("have a nice day");
	    //sundeep
	    System.out.println("additional work by X guy");
	}
	
}
