package com.lexicata.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexicata.genericlib.BaseClass;

public class Product {
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProduct;
	@FindBy(name="productname")
	private WebElement productName;
	@FindBy(id="unit_price")
	private WebElement unitPrice;
	@FindBy(name="button")
	private WebElement save;
	
	public void createProductIcon() {
		createProduct.click();
	}
	public void productName(String name) {
		productName.sendKeys(name);
	}
	public void unitPrice(String price) {
		unitPrice.sendKeys(price);
	}
	public void save() {
		save.click();
	}
	public void createProduct(String productName,String unit_price) {
		Home home =PageFactory.initElements(BaseClass.driver, Home.class);
		home.goToProducts();
		createProductIcon();
		productName(productName);
		unitPrice(unit_price);
		save();
	}

}
