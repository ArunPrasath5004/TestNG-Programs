package hoteladd;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelRead {
	
	@Test
	private void test() throws IOException {

		File f = new File("./src/test/resources/Excel/data driven.xlsx");
		
		FileInputStream fl=new FileInputStream(f);
		
		Workbook wk=new XSSFWorkbook(fl);
		Sheet sheet = wk.getSheet("Data");
		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				int type = cell.getCellType();
				
				if (type==1) {
					String value = cell.getStringCellValue();
					System.out.println(value);
				}
				else {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date value = cell.getDateCellValue();
						SimpleDateFormat sm=new SimpleDateFormat("dd-MMM-yyyy");
						String format = sm.format(value);
						System.out.println(format);
					}
					else {
						double value = cell.getNumericCellValue();
						long l=(long)value;
						String valueOf = String.valueOf(l);
						System.out.println(valueOf);
					}
				}				
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
