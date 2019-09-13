package com.lexicata.objectrepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Search {
	@FindBy(name="search_text")
	private WebElement searchBox;
	@FindBy(name="search")
	private WebElement searchButton;
	public void searchBox(String data) {
		searchBox.sendKeys(data);
	}
	public void searchButton() {
		searchButton.click();
	}

}
