package kr.spring.sample.excel.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
// A 원본
public class ExcelUploadAYE {

	public static void main(String[] args) {
		
		File file = new File("D:\\excelTest/통합SMS_대상자엑셀업로드양식.xlsx");
		
		try {

			FileInputStream fis = new FileInputStream(file);
			Workbook wb = WorkbookFactory.create(fis);
			
			Sheet st = wb.getSheetAt(0);
			Iterator<Row> iterator = st.iterator();
			
			while(iterator.hasNext()) {
				
				Row crRow = iterator.next();
				Iterator<Cell> cellterator = crRow.iterator();
				
				while(cellterator.hasNext()) {
					
					Cell crCell = cellterator.next();
					
					System.out.println(crCell.getStringCellValue());
					
				}
				
			}
			
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
