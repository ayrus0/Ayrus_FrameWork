package com.lexicata.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.lexicata.genericlib.BaseClass;
import com.lexicata.genericlib.Filelib;
import com.lexicata.genericlib.WebDriverCommonLib;

public class CrmSettings {
	Filelib flib = new Filelib();
	@FindBy(xpath="//a[contains(text(),'Currencies')]")
	private WebElement currenciesSetting;
	@FindBy(xpath="//input[contains(@value,'Save')]")
	private WebElement save;
	@FindBy(xpath="//a[contains(text(),'Users')]")
	private WebElement usersSetting;
	@FindBy(xpath="//input[@value='New User']")
	private WebElement newUserBtn;
	@FindBy(name="user_name")
	private WebElement newUserEdt;
	@FindBy(name="user_password")
	private WebElement newUSerPWedt;
	@FindBy(name="confirm_password")
	private WebElement confirmPasswordEdt;
	@FindBy(id="email1")
	private WebElement emailEdt;
	@FindBy(id="first_name")
	private WebElement firstNameEdt;
	@FindBy(name="last_name")
	private WebElement lastNameEdt;
	@FindBy(xpath="//input[@id='role_name']/..//img")
	private WebElement userRoleLookupIcon;
	
	public void navigateToCurrencies() {
		currenciesSetting.click();
	}
	public void save() {
		save.click();
	}
	public void navigateToUsers() {
		usersSetting.click();
	}
	public void newUSerBtn() {
		newUserBtn.click();
	}
	public void newUSerEdt(String name) {
		newUserEdt.sendKeys(name);
	}
	public void newUerPWedt(String password) {
		newUSerPWedt.sendKeys(password);
	}
	public void confirmPassword(String password) {
		confirmPasswordEdt.sendKeys(password);
	}
	public void emailEdt(String email) {
		emailEdt.sendKeys(email);
	}
	public void firstNameEdt(String firstName) {
		firstNameEdt.sendKeys(firstName);
	}
	public void lastNameEdt(String lastName) {
		lastNameEdt.sendKeys(lastName);
	}
	public void userRoleLookup() {
		userRoleLookupIcon.click();
	}
public void createCurrency(String currencyv) {
		
		//Create Currency
		Home home =PageFactory.initElements(BaseClass.driver, Home.class);
		home.goToMainSettings();
		home.goToCrmSettings();
		BaseClass.driver.findElement(By.xpath("//a[contains(text(),'Currencies')]")).click();
		BaseClass.driver.findElement(By.xpath("//input[@value='New Currency']")).click();
		Select sel =new Select(BaseClass.driver.findElement(By.id("currency_name")));
		sel.selectByValue(currencyv);
		BaseClass.driver.findElement(By.name("conversion_rate")).sendKeys("3");
		BaseClass.driver.findElement(By.xpath("(//input[@value='Save'])[1]")).click();
	}
	public void deleteCurrency(String currencyv) {
		
		Home home = PageFactory.initElements(BaseClass.driver, Home.class);
		home.goToMainSettings();
		home.goToCrmSettings();
		CrmSettings settings= PageFactory.initElements(BaseClass.driver, CrmSettings.class);
		settings.navigateToCurrencies();
		BaseClass.driver.findElement(By.xpath("//a[text()='"+currencyv+"']/../../..//img[@alt='Delete']")).click();
		settings.save();
	}
	public void createUser(String firstName,String lastName) throws Throwable {
		String user_role = flib.getExcelData("Sheet1", 6,1);
		Home home = PageFactory.initElements(BaseClass.driver, Home.class);
		home.goToMainSettings();
		home.goToCrmSettings();
		CrmSettings setting = PageFactory.initElements(BaseClass.driver, CrmSettings.class);
		setting.navigateToUsers();
		setting.newUSerBtn();
		setting.newUSerEdt(firstName);
		setting.newUerPWedt(flib.getExcelData("Sheet1", 27, 1));
		setting.confirmPassword(flib.getExcelData("Sheet1", 27, 1));
		setting.emailEdt(flib.getExcelData("Sheet1", 4,1));
		setting.firstNameEdt(firstName);
		setting.lastNameEdt(lastName);
		setting.userRoleLookup();
		WebDriverCommonLib wLib = PageFactory.initElements(BaseClass.driver, WebDriverCommonLib.class);
		wLib.switchToChildWindow();
		BaseClass.driver.findElement(By.xpath("//a[text()='"+user_role+"']")).click();
		wLib.switchToParentWindow();
		setting.save();
		Thread.sleep(3000);
	}

}
