package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
	
	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	 public String getPropertyFileValue(String key) throws IOException {
			FileInputStream stream = new FileInputStream("C:\\Users\\91790\\eclipse-workspace\\API\\config.properties");
			Properties prop = new Properties();
			prop.load(stream);
			Object name = prop.get(key);
			String value = (String) name;
			return value;	
		}
	 public String getAttribute(WebElement element) {
			String attribute = element.getAttribute("value");
			return attribute;
		}
	 public void getBrowser(String browserType) {
		 switch (browserType) {
		case "chrome":
	WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
					
					driver = new ChromeDriver();
					break;
		case "ie":
			WebDriverManager.iedriver().setup();
					
					driver = new ChromeDriver();
				
					break;
		case "edge":
			WebDriverManager.edgedriver().setup();
					
					driver = new ChromeDriver();
				
					break;
		default:
			break;
		}
	
	 }


	
	public static void loadUrl(String url) {
		driver.get(url);
	}
	
	public static void maximize() {
		driver.manage().window().maximize();
	}
	
	public static void implicitly(int sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}
	
	public WebElement findElementById(String value) {
		WebElement findElement = driver.findElement(By.id(value));
		return findElement;
	}
	public void clear(WebElement element) {
		element.clear();
	}
	public WebElement findElementByXpath(String value) {
		WebElement findElement = driver.findElement(By.xpath(value));
		return findElement;
	}
	
	public void type(WebElement element, String data) {
		element.sendKeys(data);
	}
	
	public void click(WebElement element) {
		element.click();
	}
	
	public String getData(String sheetName, int rowNo, int cellNo) throws IOException {
		String res= null;
		File file = new File("E:\\Core Selenium\\EmployeeR\\Excel1\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wK = new XSSFWorkbook(stream);
		Sheet sheet = wK.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType type = cell.getCellType();
				switch (type) {
				case STRING:
					res = cell.getStringCellValue();
					break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dcv = cell.getDateCellValue();
						SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yy");
						res = dateformat.format(dcv);
					}else {
						double numericCellValue = cell.getNumericCellValue();
						BigDecimal v = BigDecimal.valueOf(numericCellValue);
						System.out.println(v);
						res = v.toString();
						
					}
					break;

				default:
					break;
				}
		return res; 
	}
	
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void dragAndDrop(WebElement element, WebElement element1) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element, element1).perform();
	}
	
	public String getDropDownOptions(String url, String id) throws IOException {
		String res = null;
		File file = new File("E:\\Core Selenium\\EmployeeR\\Excel1\\automation2.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.createSheet("Datas1");
		driver.get(url);
		WebElement element = driver.findElement(By.id(id));
		Select value = new Select(element);
		List<WebElement> options = value.getOptions();
		int size = options.size();
		for (int i = 0; i < size; i++) {
			res = options.get(i).getText();
			Row row = sheet.createRow(i);
			Cell createCell = row.createCell(0);
			createCell.setCellValue(res);
			FileOutputStream team = new FileOutputStream(file);
			workbook.write(team);
		}
		return res;  
	}	
	public String getNum(String sheetName, int rowNo, int cellNo) throws IOException {
		
		File file = new File("E:\\Core Selenium\\EmployeeR\\Excel1\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wK = new XSSFWorkbook(stream);
		Sheet sheet = wK.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		double numericCellValue = cell.getNumericCellValue();
		BigDecimal v = new BigDecimal(numericCellValue);
		String num = v.toString();
		return num;
	}
	public void insertCellValue(String sheetName, int rowNo, int cellNo, String value) throws IOException {
		File file = new File("E:\\Core Selenium\\EmployeeR\\Excel1\\Hotel.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook wK = new XSSFWorkbook(stream);
		Sheet sheet = wK.getSheet(sheetName);
		Row row = sheet.createRow(rowNo);
		Cell cell = row.createCell(cellNo);
		cell.setCellValue(value);
		FileOutputStream out = new FileOutputStream(file);
		wK.write(out);
	}
	public static void close() {
		driver.close();
	}

	public void AssertEquals(WebElement element) {
	
		String text = element.getText();
		boolean contains = text.contains("Hello");
		Assert.assertTrue("Verify login", contains);
	}
	public void alertAccept() {
		Alert alt= driver.switchTo().alert();
		alt.accept();
	}
	
	}
