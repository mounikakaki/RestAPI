package utils;

import org.testng.annotations.Test;

public class ExcelUtilsTest {
	static int i;
	
	@Test
	public void run() {
		
		String excelPath = "./data/TestData.xlsx";
		String sheetName = "Sheet1";
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		excel.getClass();
		excel.getRowCount();
	
		for(i=0;i<=2;i++)
		excel.getCelldata(1,i);
	
		
		
	}

}
