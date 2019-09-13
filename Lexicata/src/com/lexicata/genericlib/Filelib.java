package com.lexicata.genericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.tools.FileObject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

/**
 * 
 * @author Ayrus
 *
 */
public class Filelib {
	String pPath = "./commonData.properties";
	String ePath = "./testScriptData.xlsx";
	/**
	 * get the property file by key value based on argument
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyFileData(String key) throws Throwable{
		FileInputStream fis = new FileInputStream(pPath);
		Properties pObj= new Properties();
		pObj.load(fis);
		String data = pObj.getProperty(key);
		return data;
	}
	/**
	 * it is used to read from excelsheet (testScriptData.xlsx) based on your arguments
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName,int rowNum,int celNum) throws Throwable {
		FileInputStream fis=new FileInputStream(ePath);
		//String data = WorkbookFactory.create(fis).getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.getCell(celNum);
		String data = cel.getStringCellValue();
		return data;
	}
		public void setExcelData(String sheetName,int rowNum,int celNum,String data) throws Throwable {
			FileInputStream fis = new FileInputStream(ePath);
			Workbook wb =WorkbookFactory.create(fis);
			wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).setCellValue(data);
			FileOutputStream fos = new FileOutputStream(ePath);
			wb.write(fos);
			wb.close();
			
			}
	}
