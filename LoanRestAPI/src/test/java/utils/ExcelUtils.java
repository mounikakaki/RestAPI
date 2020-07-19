package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static FileInputStream fis;
	static File file;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
//	static Logger logger = LogManager.getLogger(ExcelUtils.class);
	
	//	static String ExcelPath = "./data/TestData.xlsx";

	public ExcelUtils(String excelPath, String sheetName){

		try {
			file = new File(excelPath);
			 fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet= workbook.getSheet(sheetName);
//			logger.error("This is wrong");
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



	public int getRowCount(){

		int rowCount=sheet.getPhysicalNumberOfRows();
		System.out.println("No.of rows:"+rowCount);
		return rowCount;
	}
	public int getColumnCount(){

		int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("No.of rows:"+columnCount);
		return columnCount;
	}


	public Object getCelldata(int rowNum, int colNum){
		Object value=null;
		try{
			DataFormatter dataformatter = new DataFormatter();
			value= dataformatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println("Value is:"+value);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return value;

	}

}
