package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	Select select;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void launchUrl() {
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}

	public static void sendKeys(WebElement element, String text) {
		element.sendKeys(text);
	}

	public static String readExcel(String path, String sheetName, int rowNo, int cellNo) throws IOException {
		File file = new File(path);
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Cell cell = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo);
		int cellType = cell.getCellType();
		String value;
		if (cellType == 1)
			value = cell.getStringCellValue();
		else if (DateUtil.isCellDateFormatted(cell)) {
			value = new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());

		} else {
			value = String.valueOf((long) cell.getNumericCellValue());
		}
		return value;
	}

	public static void writeExcel(String path, String sheetName, int rowNo, int cellNo, String value)
			throws IOException {
		File file = new File(path);
		FileInputStream fileInputStream=new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Cell createCell = workbook.getSheet(sheetName).getRow(rowNo).createCell(cellNo);
		createCell.setCellValue(value);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);

	}
	
	public static void selectByVisibleText(WebElement element,String text) {
		new Select(element).selectByVisibleText(text);
	}
	
	public static String getAttribute(WebElement element,String attribute) {
		return element.getAttribute(attribute);
	}

}
