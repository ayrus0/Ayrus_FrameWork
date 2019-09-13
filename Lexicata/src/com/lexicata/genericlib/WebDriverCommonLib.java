package com.lexicata.genericlib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	String parentid;
	public void openURL(String URL) {
		BaseClass.driver.get(URL);
	}
	public void waitForPageToLoad() {
		BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void waitForExpElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void maximizeWindow() {
		BaseClass.driver.manage().window().maximize();
	}
	public void select(WebElement element,String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public void select(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	public void moveMouse(WebElement element) {
		Actions act = new Actions(BaseClass.driver);
		act.moveToElement(element).perform();
	}
	public void rightClick(WebElement element) {
		Actions act = new Actions(BaseClass.driver);
		act.contextClick(element).perform();
	}
	public void doubleClick(WebElement element) {
		Actions act = new Actions(BaseClass.driver);
		act.doubleClick(element).perform();
	}
	public void acceptAlert() {
		BaseClass.driver.switchTo().alert().accept();
	}
	public void cancelAlert() {
		BaseClass.driver.switchTo().alert().dismiss();
	}
	public void switchToChildWindow() throws Throwable {
		Set<String> set = BaseClass.driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		parentid = it.next();
		String childid = it.next();
		BaseClass.driver.switchTo().window(childid);
	}
	public void switchToParentWindow() {
		BaseClass.driver.switchTo().window(parentid);
	}

}
