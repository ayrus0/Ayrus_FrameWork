package com.lexicata.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lexicata.genericlib.BaseClass;

public class Organisation {
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganisation;
	@FindBy(name="accountname")
	private WebElement orgName;
	@FindBy(xpath="//textarea[@name='bill_street']")
	private WebElement billStreet;
	@FindBy(xpath="//b[text()='Copy Billing address']/preceding-sibling::input")
	private WebElement copyBillAddress;
	@FindBy(name="button")
	private WebElement save;
	
	public void createOrganisationIcon() {
		createOrganisation.click();
	}
	public void orgName(String name) {
		orgName.sendKeys(name);
	}
	public void billStreet(String streetname) {
		billStreet.sendKeys(streetname);
	}
	public void copyBillAddress() {
		copyBillAddress.click();
	}
	public void save() {
		save.click();
	}
	public void createOrganisation(String organisationName,String bill_address) {
		Home home =PageFactory.initElements(BaseClass.driver, Home.class);
		home.getOrganisation().click();
		createOrganisationIcon();
		orgName(organisationName);
		billStreet(bill_address);
		copyBillAddress();
		save();
	}

}
