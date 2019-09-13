package com.lexicata.objectrepositorylib;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.lexicata.genericlib.BaseClass;
import com.lexicata.genericlib.Filelib;
import com.lexicata.genericlib.WebDriverCommonLib;

public class AdvancedSearch {
	Filelib flib = new Filelib();
	boolean flag = false;
	
	@FindBy(xpath="//a[text()='Go to Advanced Search']")
	private WebElement navigateToAdvSearch;
	@FindBy(xpath="//select[@class='detailedViewTextBox']")
	private WebElement filterDetail;
	@FindBy(xpath="//select[@class='repBox']")
	private WebElement filterConditions;
	@FindBy(xpath="//input[@class='repBox']")
	private WebElement filterSearchValue;
	@FindBy(xpath="//table[@class='searchUIAdv3 small']//input[@value=' Search Now ']")
	private WebElement advSearchButton;
	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[8]")
	private List<WebElement> advTableCol8;
	
	public void navigateToAdvSearch() {
		navigateToAdvSearch.click();
	}
	public void filterSearchValue(String searchValue) {
		filterSearchValue.sendKeys(searchValue);
	}
	public void AdvancedSearchButton() {
		advSearchButton.click();
	}
	public void advanceSearchVerify(int columnValue, int condition) throws Throwable {
		// go inside advanced search
		Home home = PageFactory.initElements(BaseClass.driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		AdvancedSearch adv = PageFactory.initElements(BaseClass.driver, AdvancedSearch.class);
		adv.navigateToAdvSearch();
		
		//Verification process
		
		WebDriverCommonLib wLib = PageFactory.initElements(BaseClass.driver, WebDriverCommonLib.class);
		wLib.select(adv.getFilterDetail(), flib.getExcelData("Sheet1", 24,columnValue));
		wLib.select(adv.getFilterConditions(), flib.getExcelData("Sheet1", 26,condition));
		adv.getFilterSearchValue().clear();
		adv.filterSearchValue(flib.getExcelData("Sheet2", columnValue,1));
		adv.AdvancedSearchButton();
		Thread.sleep(5000);
		for(int j=1;j<adv.getAdvTableCol8().size();j++)
			{
				String actData = adv.getAdvTableCol8().get(j).getText();
				if(actData.contains(flib.getExcelData("Sheet2", columnValue,1))) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
			
			}
		Assert.assertTrue(flag);
		}
	public void advanceSearchVerify(int column, int condition,String searchValue) throws Throwable {
		Home home = PageFactory.initElements(BaseClass.driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		BaseClass.driver.findElement(By.xpath("//a[text()='Go to Advanced Search']")).click();
		
		//Verification process
		WebDriverCommonLib wLib =PageFactory.initElements(BaseClass.driver, WebDriverCommonLib.class);
		AdvancedSearch advSearch = PageFactory.initElements(BaseClass.driver, AdvancedSearch.class);
		wLib.select(advSearch.getFilterDetail(), flib.getExcelData("Sheet1", 24,column));
		wLib.select(advSearch.getFilterConditions(), flib.getExcelData("Sheet1", 26,condition));
		advSearch.getFilterSearchValue().clear();
		advSearch.filterSearchValue(searchValue);
		advSearch.AdvancedSearchButton();
		Thread.sleep(5000);
		for(int j=1;j<advSearch.getAdvTableCol8().size();j++)
			{
				String actData = advSearch.getAdvTableCol8().get(j).getText();
				if(actData.contains(searchValue)) {
					flag = true;
				}
				else {
					flag = false;
					break;
				}
			
			}
		Assert.assertTrue(flag);
		}
	public WebElement getAdvSearchButton() {
		return advSearchButton;
	}
	public List<WebElement> getAdvTableCol8() {
		return advTableCol8;
	}
	public WebElement getFilterConditions() {
		return filterConditions;
	}
	public WebElement getFilterSearchValue() {
		return filterSearchValue;
	}
	public WebElement getFilterDetail() {
		return filterDetail;
	}

}
