package com.saikumar.services;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.saikumar.entity.EmployeeQuiry;

public class ExcelServicesForQuiry {

	public static boolean checkExcelForamt(MultipartFile file) {
		
		String contentType = file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static List<Integer> getingEmpId (InputStream is) {
		
		List<Integer> empIdList = new ArrayList<>();
		
		try {
			
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("data1");
			
			int rownumber = 0;
			Iterator<Row> iterator = sheet.iterator();
			
			while(iterator.hasNext()) {
				Row row = iterator.next();
				
				if(rownumber == 0 ) {
					rownumber++;
					continue;
				}
				
				Iterator<Cell> cells = row.iterator();
				
				int cellNumber = 0;
				EmployeeQuiry empQuiry = new EmployeeQuiry();
				
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					switch(cellNumber) {
					case 0:
						empQuiry.setEmpId((int)cell.getNumericCellValue());
						break;
					default:
						break;
					}
					cellNumber++;
				}
				
				empIdList.add(empQuiry.getEmpId());
			}
			
			workbook.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return empIdList;
	}
}
