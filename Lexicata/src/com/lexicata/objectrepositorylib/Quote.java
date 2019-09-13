package com.lexicata.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexicata.genericlib.BaseClass;
import com.lexicata.genericlib.WebDriverCommonLib;

public class Quote {
	@FindBy(xpath="//img[@title='Create Quote...']")
	private WebElement createQuoteicon;
	@FindBy(name="subject")
	private WebElement subject;
	@FindBy(name="assigned_user_id1")
	private WebElement inventoryManagerEdt;
	@FindBy(name="assigned_user_id")
	private WebElement assignedUserSel;
	public WebElement getAssignedUserSel() {
		return assignedUserSel;
	}
	@FindBy(xpath="//input[@id='single_accountid']/following-sibling::img")
	private WebElement LookupOrg;
	@FindBy(id="searchIcon1")
	private WebElement product1;
	@FindBy(id="qty1")
	private WebElement quantity1;
	@FindBy(id="inventory_currency")
	private WebElement inventoryCurrency;
	@FindBy(xpath="(//a[text()='Discount'])[2]")
	private WebElement discount2;
	@FindBy(xpath="(//td[contains(text(),'Direct Price Reduction')]/..//input)[3]")
	private WebElement directPriceRed3;
	@FindBy(xpath="(//td[contains(text(),'% of Price')]/..//input)[3]")
	private WebElement percentPrice;
	@FindBy(name="discount_amount_final")
	private WebElement discountAmountFinal;
	@FindBy(name="discount_percentage_final")
	private WebElement discountPercentFinal;
	@FindBy(xpath="//img[@onclick=\"fnHidePopDiv('discount_div_final')\"]")
	private WebElement hideFinalDiscountPopup;
	@FindBy(id="adjustmentType")
	private WebElement adjustmentType;
	@FindBy(id="adjustment")
	private WebElement adjustmentEdt;
	@FindBy(xpath="//input[@value='  Save  ']")
	private WebElement saveQuote;
	
	public void createQuote() {
		createQuoteicon.click();
	}
	public void subject(String data) {
		subject.sendKeys(data);
	}
	public WebElement getInventoryManagerEdt() {
		return inventoryManagerEdt;
	}
	public void LookupOrganisation() {
		LookupOrg.click();
	}
	public void selectProduct1() {
		product1.click();
	}
	public void quantity1(String quantity){
		quantity1.sendKeys(quantity);
	}
	public void discount2() {
		discount2.click();
	}
	public void directPriceRed3() {
		directPriceRed3.click();
	}
	public void percentPrice() {
		percentPrice.click();
	}
	public void discountAmountFinal(String price) {
		discountAmountFinal.sendKeys(price);
	}
	public void discountPercentFinal(String percent) {
		discountPercentFinal.sendKeys(percent);
	}
	public WebElement getPercentPrice() {
		return percentPrice;
	}
	public WebElement getDiscountPercentFinal() {
		return discountPercentFinal;
	}
	public WebElement getHideFinalDiscountPopup() {
		return hideFinalDiscountPopup;
	}
	public void hideFinalDiscountPopup() {
		hideFinalDiscountPopup.click();
	}
	public void adjustmentEdt(String adjustmentData) {
		adjustmentEdt.sendKeys(adjustmentData);
	}
	public void saveQuote() {
		saveQuote.click();
	}
	public WebElement getDiscount2() {
		return discount2;
	}
	public WebElement getDirectPriceRed3() {
		return directPriceRed3;
	}
	public WebElement getDiscountAmountFinal() {
		return discountAmountFinal;
	}
	public WebElement getAdjustmentType() {
		return adjustmentType;
	}
	public WebElement getAdjustmentEdt() {
		return adjustmentEdt;
	}
	public WebElement getSaveQuote() {
		return saveQuote;
	}
	public void selectOrgByLookup(String organisationName) throws Throwable {
		Quote qt = PageFactory.initElements(BaseClass.driver, Quote.class);
		qt.LookupOrganisation();
		WebDriverCommonLib wLib =PageFactory.initElements(BaseClass.driver, WebDriverCommonLib.class);
		wLib.switchToChildWindow();
		Search search = PageFactory.initElements(BaseClass.driver, Search.class);
		search.searchBox(organisationName);
		search.searchButton();
		Thread.sleep(2000);
		BaseClass.driver.findElement(By.xpath("//a[text()='"+organisationName+"']")).click();
		wLib.acceptAlert();
		wLib.switchToParentWindow();
	}
	public void selectProductByLookup(String productName) throws Throwable {
		Quote qt = PageFactory.initElements(BaseClass.driver, Quote.class);
		qt.selectProduct1();
		WebDriverCommonLib wLib = PageFactory.initElements(BaseClass.driver, WebDriverCommonLib.class);
		wLib.switchToChildWindow();
		Thread.sleep(2000);
		BaseClass.driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		wLib.switchToParentWindow();
	}
	public WebElement getCreateQuoteicon() {
		return createQuoteicon;
	}
	public WebElement getSubject() {
		return subject;
	}
	public WebElement getLookupOrg() {
		return LookupOrg;
	}
	public WebElement getProduct1() {
		return product1;
	}
	public WebElement getQuantity1() {
		return quantity1;
	}
	public WebElement getInventoryCurrency() {
		return inventoryCurrency;
	}
	
}
