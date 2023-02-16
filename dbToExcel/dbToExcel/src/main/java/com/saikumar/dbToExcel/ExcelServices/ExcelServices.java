package com.saikumar.dbToExcel.ExcelServices;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.saikumar.dbToExcel.Entity.Employee;

public class ExcelServices {
	
	public static boolean checkExcelForamt(MultipartFile file) {
		
		String contentType = file.getContentType();
		
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static List<Employee> convertExcelToList(InputStream is) {
		
		List<Employee> empList = new ArrayList<>();
		
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
				Employee emp = new Employee();
				
				while(cells.hasNext()) {
					Cell cell = cells.next();
					
					switch(cellNumber) {
					case 0:
						emp.setEmpid((int)cell.getNumericCellValue());
						break;
					case 1:
						emp.setEmpFirstName(cell.getStringCellValue());
						break;
					case 2:
						emp.setEmpLastName(cell.getStringCellValue());
						break;
					case 3:
						emp.setEmpMail(cell.getStringCellValue());
						break;
					case 4:
						emp.setEmpGovtId((int) cell.getNumericCellValue());
						break;
					default:
						break;
					}
					cellNumber++;
				}
				
				empList.add(emp);
			}
			
			workbook.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return empList;
	}

}
