package com.lexicata.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexicata.genericlib.BaseClass;
import com.lexicata.genericlib.Filelib;
import com.lexicata.genericlib.WebDriverCommonLib;

public class Filter {
	Filelib flib = new Filelib();
	
	@FindBy(xpath="//a[text()='Create Filter']")
	private WebElement createFilterlnk;
	@FindBy(name="viewName")
	private WebElement viewName;
	@FindBy(xpath="(//input[@value='Save'])[2]")
	private WebElement save;
	@FindBy(xpath="//font[text()='Filters :']/../../..//a[text()='Delete']")
	private WebElement deleteFilterlnk;
	
	public void createFilterlnk() {
		createFilterlnk.click();
	}
	public void viewName(String filterName) {
		viewName.sendKeys(filterName);
	}
	
	public void save() {
		save.click();
	}
	public void deleteFilterlnk() {
		deleteFilterlnk.click();
	}
	public void createFilter(int columnValue) throws Throwable {
		Home home =PageFactory.initElements(BaseClass.driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		createFilterlnk();
		viewName(flib.getExcelData("Sheet1", 21, 1));
		WebDriverCommonLib wLib = PageFactory.initElements(BaseClass.driver, WebDriverCommonLib.class);
		wLib.select(BaseClass.driver.findElement(By.name(flib.getExcelData("Sheet1", 22,1))), flib.getExcelData("Sheet1", 24,columnValue));
		save();
	}
	public void deleteFilter() {
		deleteFilterlnk();
		WebDriverCommonLib wLib = PageFactory.initElements(BaseClass.driver, WebDriverCommonLib.class);
		wLib.acceptAlert();
	}
	public WebElement getCreateFilterlnk() {
		return createFilterlnk;
	}
	public WebElement getViewName() {
		return viewName;
	}
	public WebElement getSave() {
		return save;
	}

}
