package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadData {
	
	
	@Test
	public void getData() {
		
		try {
			
			File excelPath = new File("D:\\AutoIT\\TestData.xlsx");
			FileInputStream fin = new FileInputStream(excelPath);
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet sh = wb.getSheet("Sheet2");
			
			System.out.println(sh.getRow(14).getCell(7).getStringCellValue());
			System.out.println(sh.getRow(12).getCell(12).getStringCellValue());
			System.out.println(sh.getRow(10).getCell(9).getNumericCellValue());	
			System.out.println(sh.getRow(7).getCell(6).getStringCellValue());
			System.out.println(sh.getRow(5).getCell(10).getStringCellValue());
			
			XSSFSheet sh1 = wb.getSheet("Sheet1");
			
			int rows = sh1.getLastRowNum()-sh1.getFirstRowNum();
			
			System.out.println(rows);
			
			int cols = sh1.getRow(0).getLastCellNum();
			
			System.out.println(cols);
			
			for (int i = 0; i <=rows; i++) {
				
				for (int j = 0; j <cols; j++) {
					
					System.out.println(sh1.getRow(i).getCell(j).getStringCellValue());
					System.out.println();	
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
