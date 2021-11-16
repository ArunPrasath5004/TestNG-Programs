package org.add;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void browserLaunch(String browserName) {

		switch (browserName) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		default:
			break;
		}

	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static String getCurrentTitle() {
		String text = driver.getTitle();
		return text;


	}

	public static String getUrl() {
		String url = driver.getCurrentUrl();
		return url;

	}
	
	
	public static void timeWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	
	public static void clickBtn(WebElement a) {
		a.click();
	}
	
	
	public static void sendValues(WebElement a,String value) {
		a.sendKeys(value);

	}
	
	public static String getTheText(WebElement element) {
		String text = element.getText();
		return text;
		
	}
	
	public static String getTheAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
		
	}
	
	public static void browserClose() {
		driver.quit();
	}
	
	
	public static WebElement findElement(String locatename,String locater) {
		WebElement a=null;
		
		if (locatename.equals("id")) {
			a = driver.findElement(By.id(locater));
		}
		else if (locatename.equals("name")) {
			a = driver.findElement(By.name(locater));
		}
		else if (locatename.equals("xpath")) {
			a = driver.findElement(By.xpath(locater));
		}
		
		return a;

	}
	
	public static void mouse(WebElement pick,WebElement drop) {
		
		Actions a=new Actions(driver);
		
		a.dragAndDrop(pick, drop).perform();
		

	}
	
	public static void mousehold(WebElement pick,WebElement drop ) {
		
		Actions a=new Actions(driver);
		
		a.clickAndHold(pick).moveToElement(drop).release().build().perform();

	}
	
	public static void mousedouble(WebElement path) {
		Actions a=new Actions(driver);
		a.doubleClick(path).perform();

	}
	
	public static void keybord() throws Exception {
		Robot r= new Robot();
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
		
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);

	}
	
	public static void popup(String Opt) {
		Alert as=driver.switchTo().alert();
		
		if (Opt.equals("accept")) {
			as.accept();
		}
		else if (Opt.equals("dismiss")) {
			as.dismiss();
		}
		else if (Opt.equals("value")) {
			as.sendKeys("YES");
			as.accept();
		}

	}
	
	public static void screenShot(String filename) throws IOException  {
		TakesScreenshot t=(TakesScreenshot)driver;
		
		File temp = t.getScreenshotAs(OutputType.FILE);
		File perm=new File("./src/test/resources/Snaps/"+filename+".png");
		FileUtils.copyFile(temp, perm);

	}
	
	public static void executeJava(String text,WebElement path) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
				
		js.executeScript("arguments[0].setAttribute('value','"+text+"');",path);

	}
	
	
	public static void frameSwitch(int value) {
			driver.switchTo().frame(value);
	}
	
	public static void frameOut(String txt) {
		if (txt.equals("back")) {
			driver.switchTo().parentFrame();
		}
		else if (txt.equals("out")) {
			driver.switchTo().defaultContent();
		}

	}
	
	public static void windowChange(int index) {
		
		Set<String> window = driver.getWindowHandles();
		
		List<String> l=new ArrayList<String>(window);		
		
		driver.switchTo().window(l.get(index));
		
	}
	
	public static void dropElements(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
		
	}
	
	public static void clearValues(WebElement element) {
		element.clear();
	}

	public static String driven(String filename,String text,int rIndex,int cIndex) throws Exception {
		
		File f=new File("./src/test/resources/Excel/"+filename+".xlsx");
		
		FileInputStream st=new FileInputStream(f);
		
		Workbook w=new XSSFWorkbook(st);
		Sheet sh = w.getSheet(text);
		Row row = sh.getRow(rIndex);
		Cell cell = row.getCell(cIndex);
		
		int type = cell.getCellType();
		
		// type = 1 ==>String
		// type = 0 ==>Numerical values
		String value = null;
		if (type==1) {
			value = cell.getStringCellValue();
		}
		else {
			if (DateUtil.isCellDateFormatted(cell)) {
				value = new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());
			}
			else {
				value = String.valueOf((long)cell.getNumericCellValue());
			}
		}
		return value;
		
	}

	
	
	public static List<String> dataDrivenLoop(String fileName,String text) throws IOException {
		
		File f=new File("./src/test/resources/Excel/"+fileName+".xlsx");
		
		FileInputStream fs=new FileInputStream(f);
		
		Workbook wk= new XSSFWorkbook(fs);
		
		Sheet sheet = wk.getSheet(text);		
		
		List<String> ln=new ArrayList<String>();
	
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row r = sheet.getRow(i);
			
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
				Cell c = r.getCell(j);
				
				int cellType = c.getCellType();
				
				String value=null;
				
				if (cellType==1) {
					value = c.getStringCellValue();
				}
				else {
					if (DateUtil.isCellDateFormatted(c)) {
						Date dt = c.getDateCellValue();
						SimpleDateFormat sm=new SimpleDateFormat("dd-MM-yyyy");
						value = sm.format(dt);
					}
					else {
						double num = c.getNumericCellValue();
						long l=(long)num;
						value = String.valueOf(l);
					}
						
				}
				
				ln.add(value);
				
			}
		}
		return ln;
		
	}
	
	
	public static void dataWrite(String filename,String sheetname,int rowno,int cellno,String value) throws IOException {
		
		File fl=new File("./src/test/resources/Excel/"+filename+".xlsx");
		
		FileInputStream in=new FileInputStream(fl);
		Workbook wk=new XSSFWorkbook(in);
		Sheet sheet = wk.getSheet(sheetname);
		Row row = sheet.createRow(rowno);
		Cell cell = row.createCell(cellno);
		cell.setCellValue(value);
		FileOutputStream op=new FileOutputStream(fl);
		wk.write(op);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
