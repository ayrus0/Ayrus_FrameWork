package com.lexicata.quote;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.lexicata.genericlib.BaseClass;
import com.lexicata.genericlib.Filelib;
import com.lexicata.genericlib.WebDriverCommonLib;
import com.lexicata.objectrepositorylib.AdvancedSearch;
import com.lexicata.objectrepositorylib.CrmSettings;
import com.lexicata.objectrepositorylib.Filter;
import com.lexicata.objectrepositorylib.Home;
import com.lexicata.objectrepositorylib.Organisation;
import com.lexicata.objectrepositorylib.Product;
import com.lexicata.objectrepositorylib.Quote;
import com.lexicata.objectrepositorylib.Search;
@Listeners(com.lexicata.genericlib.ListImpClass.class)
public class Quotes extends BaseClass {
	String organisationName;
	String productName;
	String quoteName;
	
	@Test(enabled=true)
	public void ValidateCurrencyEnterEqualsWith() throws Throwable {
		//Create Organization
		Thread.sleep(3000);
		organisationName = flib.getExcelData("Sheet1", 0,1)+random.nextInt();
		String bill_address = flib.getExcelData("Sheet1", 1,1);
		Organisation org = PageFactory.initElements(BaseClass.driver, Organisation.class);
		org.createOrganisation(organisationName, bill_address);
		Thread.sleep(3000);
		
		//Create Product
		productName = flib.getExcelData("Sheet1", 11, 1);
		String unit_price = flib.getExcelData("Sheet1",13,1);
		Product pd = PageFactory.initElements(driver, Product.class);
		pd.createProduct(productName, unit_price);
		Thread.sleep(2000);
		
		CrmSettings setting = PageFactory.initElements(driver, CrmSettings.class);
		
		setting.createCurrency(flib.getExcelData("Sheet1", 7, 1));
		
		//Create Quote
		quoteName = flib.getExcelData("Sheet1", 16,1);
		Home home =PageFactory.initElements(driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		Quote qt = PageFactory.initElements(driver, Quote.class);
		qt.createQuote();
		qt.subject(quoteName);
		
		qt.selectOrgByLookup(organisationName);
		
		qt.selectProductByLookup(productName);
		
		qt.quantity1(flib.getExcelData("Sheet1", 12,1));
		
		//Select Currency
		WebDriverCommonLib wLib =PageFactory.initElements(driver, WebDriverCommonLib.class);
		wLib.select(qt.getInventoryCurrency(), flib.getExcelData("Sheet1", 8, 1));
		wLib.acceptAlert();
		qt.saveQuote();
		
		//Create Filter
		Filter filter =PageFactory.initElements(driver, Filter.class);
		filter.createFilter(5);
		AdvancedSearch adv = PageFactory.initElements(driver, AdvancedSearch.class);
		adv.advanceSearchVerify(5,5);
		
		filter.deleteFilter();
		
		setting.deleteCurrency(flib.getExcelData("Sheet1", 7, 1));
	}
	
	@Test(enabled=true)
	public void ValidateDiscountAmountEnterEqualsWith() throws Throwable {
		
		//Create Organization
		Thread.sleep(3000);
		organisationName = flib.getExcelData("Sheet1", 0,1)+random.nextInt();
		String bill_address = flib.getExcelData("Sheet1", 1,1);
		Organisation org = PageFactory.initElements(BaseClass.driver, Organisation.class);
		org.createOrganisation(organisationName, bill_address);
		Thread.sleep(3000);
		
		//Create Product
		productName = flib.getExcelData("Sheet1", 11, 1);
		String unit_price = flib.getExcelData("Sheet1",13,1);
		Product pd = PageFactory.initElements(driver, Product.class);
		pd.createProduct(productName, unit_price);
		Thread.sleep(2000);	
		
		//Create Quote
		quoteName = flib.getExcelData("Sheet1", 16,1);
		Home home =PageFactory.initElements(driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		Quote qt = PageFactory.initElements(driver, Quote.class);
		qt.createQuote();
		qt.subject(quoteName);
			
		qt.selectOrgByLookup(organisationName);
				
		qt.selectProductByLookup(productName);
				
		qt.quantity1(flib.getExcelData("Sheet1", 12,1));
		
		//Select Discount "Direct Price reduction"
		qt.discount2();
		qt.directPriceRed3();
		qt.getDiscountAmountFinal().clear();
		qt.discountAmountFinal(flib.getExcelData("Sheet1", 15,1));
		qt.hideFinalDiscountPopup();
		qt.saveQuote();
		
		//Create Filter
		Filter filter =PageFactory.initElements(driver, Filter.class);
		filter.createFilter(7);
		AdvancedSearch adv = PageFactory.initElements(driver, AdvancedSearch.class);
		adv.advanceSearchVerify(7,1);
				
		filter.deleteFilter();
		
	}
	@Test(enabled=true)
	public void ValidateDiscountPercentEnterEqualsWith() throws Throwable {
		//Create Organization
		Thread.sleep(3000);
		organisationName = flib.getExcelData("Sheet1", 0,1)+random.nextInt();
		String bill_address = flib.getExcelData("Sheet1", 1,1);
		Organisation org = PageFactory.initElements(BaseClass.driver, Organisation.class);
		org.createOrganisation(organisationName, bill_address);
		Thread.sleep(3000);
		
		//Create Product
		productName = flib.getExcelData("Sheet1", 11, 1);
		String unit_price = flib.getExcelData("Sheet1",13,1);
		Product pd = PageFactory.initElements(driver, Product.class);
		pd.createProduct(productName, unit_price);
		Thread.sleep(2000);	
		
		//Create Quote
		quoteName = flib.getExcelData("Sheet1", 16,1);
		Home home =PageFactory.initElements(driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		Quote qt = PageFactory.initElements(driver, Quote.class);
		qt.createQuote();
		qt.subject(quoteName);
					
		qt.selectOrgByLookup(organisationName);
				
		qt.selectProductByLookup(productName);
						
		qt.quantity1(flib.getExcelData("Sheet1", 12,1));
		
		//Select Discount "%"
		
		qt.discount2();
		qt.percentPrice();
		qt.getDiscountPercentFinal().clear();
		qt.discountPercentFinal(flib.getExcelData("Sheet1", 14,1));
		qt.hideFinalDiscountPopup();
		qt.saveQuote();
		
		//Create Filter
		Filter filter =PageFactory.initElements(driver, Filter.class);
		filter.createFilter(6);
		AdvancedSearch adv = PageFactory.initElements(driver, AdvancedSearch.class);
		adv.advanceSearchVerify(6,1);
						
		filter.deleteFilter();
		
	}
	@Test(enabled=true)
	public void ValidateInventoryManagerEnterEqualsWith() throws Throwable {
		
		//Create Organization
		Thread.sleep(3000);
		organisationName = flib.getExcelData("Sheet1", 0,1)+random.nextInt();
		String bill_address = flib.getExcelData("Sheet1", 1,1);
		Organisation org = PageFactory.initElements(BaseClass.driver, Organisation.class);
		org.createOrganisation(organisationName, bill_address);
		Thread.sleep(3000);
				
		//Create Product
		productName = flib.getExcelData("Sheet1", 11, 1);
		String unit_price = flib.getExcelData("Sheet1",13,1);
		Product pd = PageFactory.initElements(driver, Product.class);
		pd.createProduct(productName, unit_price);
		Thread.sleep(2000);
		String newuserFN=flib.getExcelData("Sheet1", 2,1)+BaseClass.random.nextInt();
		String newuserLN=flib.getExcelData("Sheet1", 5,1);
		CrmSettings setting=PageFactory.initElements(driver, CrmSettings.class);
		setting.createUser(newuserFN,newuserLN);
		
		//Create Quote
		quoteName = flib.getExcelData("Sheet1", 16,1);
		Home home =PageFactory.initElements(driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		Quote qt = PageFactory.initElements(driver, Quote.class);
		qt.createQuote();
		qt.subject(quoteName);
		
		//Select inventory manager
		WebDriverCommonLib wLib = PageFactory.initElements(driver, WebDriverCommonLib.class);
		wLib.select(qt.getInventoryManagerEdt(), newuserFN+" "+newuserLN);
		
		qt.selectOrgByLookup(organisationName);
		
		qt.selectProductByLookup(productName);
						
		qt.quantity1(flib.getExcelData("Sheet1", 12,1));
		qt.saveQuote();
		
		//Create Filter
		Filter filter =PageFactory.initElements(driver, Filter.class);
		filter.createFilter(8);
		AdvancedSearch adv = PageFactory.initElements(driver, AdvancedSearch.class);
		adv.advanceSearchVerify(8,1,newuserFN+" "+newuserLN);
								
		filter.deleteFilter();
	}
	@Test(enabled=true)
	public void ValidateAdjustmentEntereEqualsWith() throws Throwable {
		
		//Create Organization
		Thread.sleep(3000);
		organisationName = flib.getExcelData("Sheet1", 0,1)+random.nextInt();
		String bill_address = flib.getExcelData("Sheet1", 1,1);
		Organisation org = PageFactory.initElements(BaseClass.driver, Organisation.class);
		org.createOrganisation(organisationName, bill_address);
		Thread.sleep(3000);
						
		//Create Product
		productName = flib.getExcelData("Sheet1", 11, 1);
		String unit_price = flib.getExcelData("Sheet1",13,1);
		Product pd = PageFactory.initElements(driver, Product.class);
		pd.createProduct(productName, unit_price);
		Thread.sleep(2000);
				
		//Create Quote
		quoteName = flib.getExcelData("Sheet1", 16,1);
		Home home =PageFactory.initElements(driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		Quote qt = PageFactory.initElements(driver, Quote.class);
		qt.createQuote();
		qt.subject(quoteName);
		
		qt.selectOrgByLookup(organisationName);
		
		qt.selectProductByLookup(productName);
				
		qt.quantity1(flib.getExcelData("Sheet1", 12,1));

		//Select adjustment
		WebDriverCommonLib wLib = PageFactory.initElements(driver, WebDriverCommonLib.class);
		wLib.select(qt.getAdjustmentType(), flib.getExcelData("Sheet1", 18,1));
		qt.getAdjustmentEdt().clear();
		qt.adjustmentEdt(flib.getExcelData("Sheet1", 19,1));
		
		qt.saveQuote();
		//Create Filter
		Filter filter =PageFactory.initElements(driver, Filter.class);
		filter.createFilter(9);
		AdvancedSearch adv = PageFactory.initElements(driver, AdvancedSearch.class);
		adv.advanceSearchVerify(9,1);
										
		filter.deleteFilter();
	}
	@Test(enabled=true)
	public void ValidateAssingedToEnterEqualsWith() throws Throwable {
		//Create Organization
		Thread.sleep(3000);
		organisationName = flib.getExcelData("Sheet1", 0,1)+random.nextInt();
		String bill_address = flib.getExcelData("Sheet1", 1,1);
		Organisation org = PageFactory.initElements(BaseClass.driver, Organisation.class);
		org.createOrganisation(organisationName, bill_address);
		Thread.sleep(3000);
						
		//Create Product
		productName = flib.getExcelData("Sheet1", 11, 1);
		String unit_price = flib.getExcelData("Sheet1",13,1);
		Product pd = PageFactory.initElements(driver, Product.class);
		pd.createProduct(productName, unit_price);
		Thread.sleep(2000);
		String newuserFN=flib.getExcelData("Sheet1", 2,1)+BaseClass.random.nextInt();
		String newuserLN=flib.getExcelData("Sheet1", 5,1);
		CrmSettings setting=PageFactory.initElements(driver, CrmSettings.class);
		setting.createUser(newuserFN,newuserLN);
		
		//Create Quote
		quoteName = flib.getExcelData("Sheet1", 16,1);
		Home home =PageFactory.initElements(driver, Home.class);
		home.openMoreMenu();
		home.goToQuotes();
		Quote qt = PageFactory.initElements(driver, Quote.class);
		qt.createQuote();
		qt.subject(quoteName);
		
		//Select user
		WebDriverCommonLib wLib = PageFactory.initElements(driver, WebDriverCommonLib.class);
		wLib.select(qt.getAssignedUserSel(), newuserFN+" "+newuserLN);
		
		qt.selectOrgByLookup(organisationName);
		
		qt.selectProductByLookup(productName);
				
		qt.quantity1(flib.getExcelData("Sheet1", 12,1));
		qt.saveQuote();
		
		AdvancedSearch adv = PageFactory.initElements(driver, AdvancedSearch.class);
		adv.advanceSearchVerify(10,1,newuserFN+" "+newuserLN);
		
	}
	@Test(enabled=false)
	public void ValidateCarrierEnterEqualsWith() throws Throwable {
		createOrganisation();
		
		createProduct();
		
		createQuote();
		
		createFilter(1);
		
		advanceSearchVerify(1,1);
		
		deleteFilter();
	}
	@Test(enabled=false)
	public void ValidateContactNameEnterEqualsWith() throws Throwable {
		createOrganisation();
		
		createProduct();
		
		createQuote();
		
		createFilter(2);
		
		advanceSearchVerify(2,1);
		
		deleteFilter();
	}
	@Test(enabled=false)
	public void ValidateConversionRateEnterEqualsWith() throws Throwable {
		createOrganisation();
		
		createProduct();
		
		createQuote();
		
		createFilter(3);
		
		advanceSearchVerify(3,1);
		
		deleteFilter();
	}
	@Test(enabled=false)
	public void ValidateCreatedTimeEnterEqualsWith() throws Throwable {
		createOrganisation();
		
		createProduct();
		
		createQuote();
		
		createFilter(4);
		
		advanceSearchVerify(4,1);
		
		deleteFilter();
	}
	
}
