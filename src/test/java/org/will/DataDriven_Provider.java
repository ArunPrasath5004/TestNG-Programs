package org.will;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven_Provider {
	
	public static Object[][] getvalue() throws IOException {
		
		File f=new File("C:\\Users\\Arun\\Maven_TestNG\\src\\test\\resources\\Excel\\login.xlsx");
		
		FileInputStream st=new FileInputStream(f);
		Workbook wk=new XSSFWorkbook(st);
		Sheet sheet = wk.getSheet("Sheet1");
		Row r = sheet.getRow(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		int cellCount = r.getPhysicalNumberOfCells();
		
		
		Object obj[][]=new Object[rowCount-1][cellCount];		
		
		for (int i = 0; i < rowCount-1; i++) {
			Row row = sheet.getRow(i+1);
			for (int j = 0; j < cellCount; j++) {
				Cell cell = row.getCell(j);
				
				String value=null;
				
				int type = cell.getCellType();
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
				obj[i][j]=value;
				
			}
			
		}
		return obj;
	}
	
	
	@DataProvider(name="datas")
	private Object[][] data() throws IOException {
		Object obj[][]=getvalue();
		return obj;
		
	}
	
	
	@Test(dataProvider="datas")
	private void test(String user,String pass) {
		
		System.out.println(user);
		System.out.println(pass);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
