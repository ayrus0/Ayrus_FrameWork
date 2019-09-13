package com.lexicata.genericlib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.lexicata.genericlib.BaseClass;

public class ListImpClass implements ITestListener{
	public void onTestFailure(ITestResult result) {
		String ftestName=result.getMethod().getMethodName();
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.driver);
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(".screenshot/"+ftestName+".png"));
		}catch(IOException e) {
			System.out.println("Exception occured");
		}
	}

}
