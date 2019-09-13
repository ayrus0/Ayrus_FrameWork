package com.lexicata.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexicata.genericlib.BaseClass;
import com.lexicata.genericlib.WebDriverCommonLib;

public class Home {
	WebDriverCommonLib wLib =PageFactory.initElements(BaseClass.driver, WebDriverCommonLib.class);
	
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement organisation;
	@FindBy(xpath="//a[text()='More']")
	private WebElement moremenu;
	@FindBy(name="Quotes")
	private WebElement quotes;
	@FindBy(xpath="//a[text()='Products']")
	private WebElement products;
	@FindBy(xpath="//img[@src='themes/softed/images/mainSettings.PNG']")
	private WebElement mainSettings;
	@FindBy(xpath="//a[text()='CRM Settings']")
	private WebElement crmSettings;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement logoutBtn;
	
	public void openMoreMenu() {
		wLib.moveMouse(moremenu);
	}
	public void goToOrganisation() {
		organisation.click();
	}
	public WebDriverCommonLib getwLib() {
		return wLib;
	}
	public WebElement getOrganisation() {
		return organisation;
	}
	public WebElement getMoremenu() {
		return moremenu;
	}
	public WebElement getQuotes() {
		return quotes;
	}
	public WebElement getProducts() {
		return products;
	}
	public WebElement getMainSettings() {
		return mainSettings;
	}
	public WebElement getCrmSettings() {
		return crmSettings;
	}
	public void goToQuotes() {
		quotes.click();
	}
	public void goToProducts() {
		products.click();
	}
	public void goToMainSettings() {
		wLib.moveMouse(mainSettings);
	}
	public void goToCrmSettings() {
		crmSettings.click();
	}	
	public WebElement getAdminIcon() {
		return adminIcon;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	
	public void logout() {
		wLib.moveMouse(adminIcon);
		logoutBtn.click();
	}

}
