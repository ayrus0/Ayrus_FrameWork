package com.lexicata.genericlib;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.lexicata.genericlib.Filelib;
import com.lexicata.objectrepositorylib.Home;
import com.lexicata.objectrepositorylib.Login;

public class BaseClass {
	public static WebDriver driver;
	public Filelib flib = new Filelib();
	public Actions act;
	public static Random random=new Random();
	//WebDriverCommonLib wLib =PageFactory.initElements(driver, WebDriverCommonLib.class);
	WebDriverCommonLib wLib = new WebDriverCommonLib();	
	@BeforeClass
	public void configBC() throws Throwable {
		String BROWSER = flib.getPropertyFileData("browser");
		System.out.println("========LAUNCH THE BROWSER========");
		if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if(BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}
		act = new Actions(driver);
	}
	@BeforeMethod
	public void configBM() throws Throwable {
		String URL = flib.getPropertyFileData("url");
		String USER = flib.getPropertyFileData("username");
		String PASSWORD = flib.getPropertyFileData("password");
		wLib.waitForPageToLoad();
		wLib.maximizeWindow();
		wLib.openURL(URL);
		Login l =PageFactory.initElements(driver, Login.class);
		l.loginToAPP(USER, PASSWORD);
	}
	@AfterMethod
	public void configAM() {
		System.out.println("========LOGOUT========");
		Home hm =PageFactory.initElements(driver, Home.class);
		hm.logout();
		
	}
	@AfterClass
	public void configAC() {
		driver.close();
	}

}
