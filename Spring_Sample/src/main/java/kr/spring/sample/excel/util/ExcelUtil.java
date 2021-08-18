package kr.spring.sample.excel.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class ExcelUtil {
	
	public static List<Map<String, Object>> readFile(MultipartHttpServletRequest mRequest) {
		List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
		MultipartFile mf = mRequest.getFile("file");
		String path = "D:\\test\\";
		String originFileName = mf.getOriginalFilename();
		// long fileSize = mf.getSize();
		// System.out.println("=== FileName : "+originFileName+" Size : "+fileSize);
		String safeFile = path + originFileName;
		
		try {
			Workbook workbook = WorkbookFactory.create(new File(safeFile));
			Sheet sheet = workbook.getSheetAt(0);
			int row_cnt = sheet.getPhysicalNumberOfRows();
			int cell_cnt = sheet.getRow(0).getPhysicalNumberOfCells();
			// Cell[] cell = new Cell[cell_cnt];
			
			for(int no=1; no<row_cnt; no++) {
				Row row = sheet.getRow(no);
				if(row != null && row.getCell(0) != null) {
					HashMap<String, Object> data = new HashMap<String, Object>();
					for(int i=0; i<cell_cnt; i++) {
						data.put("cell"+i, row.getCell(i)+"");
					}
					datas.add(data);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return datas;
	}
	
	// Excel 파일 다운로드
	public static void writeExcel(List<Map<String, Object>> datas, ServletOutputStream os) {
		String index = "pno,name,age,gender,phone,email";
		Workbook workbook = new SXSSFWorkbook();
		Sheet sheet = workbook.createSheet();
		
		// Header 만들기
		Row row = sheet.createRow(0);
		String[] headers = index.split(",");
		for(int i=0; i<headers.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(headers[i]);
		}
		
		// Body 만들기
		for(int i=1; i<datas.size(); i++) {
			row = sheet.createRow(i);
			for(int j=0; j<headers.length; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue((String)datas.get(i).get(headers[j]));
			}
		}
		
		// Excel 파일 만들기
		try {
			workbook.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
