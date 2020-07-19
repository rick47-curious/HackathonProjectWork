package com.EmiCalculator.OutputDrivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	public boolean getData(String month,String principal,String interest)  {
		try {
		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFSheet sheet = wb.createSheet("OutputPassedData");

		Row row = sheet.createRow(0);

		//Headers
		Cell cell11 = row.createCell(0);
		cell11.setCellValue("Month");

		Cell cell12 = row.createCell(1);
		cell12.setCellValue("Principal");

		Cell cell13 = row.createCell(2);
		cell13.setCellValue("Interest");

		//Values
		Row row2 = sheet.createRow(1);
		Cell cell21 = row2.createCell(0);
		cell21.setCellValue(month);

		Cell cell22 = row2.createCell(1);
		cell22.setCellValue(principal);

		Cell cell23 = row2.createCell(2);
		cell23.setCellValue(interest);

		String timestamp = new SimpleDateFormat("dd-MM-yyyyy.HH.mm.ss").format(new Date());
		File file = new File("src\\test\\resources\\OutputPassedData"+timestamp+".xlsx");
		FileOutputStream fos;
		
			fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			
			System.out.println("Destination folder not found,Please check carefully");
			return false;
		} catch (IOException e) {
			
			System.out.println("There was a problem while writing the data");
			return false;
		}
		
		//wb.close();
		return true;
	}

	public boolean getFailedData(String month,String principal,String interest) {
		try {
		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFSheet sheet = wb.createSheet("OutputFailedData");

		Row row = sheet.createRow(0);

		//Headers
		Cell cell11 = row.createCell(0);
		cell11.setCellValue("Month");

		Cell cell12 = row.createCell(1);
		cell12.setCellValue("Principal");

		Cell cell13 = row.createCell(2);
		cell13.setCellValue("Interest");
		
		//Values
		Row row2 = sheet.createRow(1);
		
		Cell cell21 = row2.createCell(0);
		cell21.setCellValue(month);

		Cell cell22 = row2.createCell(1);
		cell22.setCellValue(principal);

		Cell cell23 = row2.createCell(2);
		cell23.setCellValue(interest);
		
		String timestamp = new SimpleDateFormat("dd-MM-yyyy.HH.mm.ss").format(new Date());
		File file = new File("src\\test\\resources\\OutputFailedData"+timestamp+".xlsx");
		
			FileOutputStream fos = new FileOutputStream(file);
			wb.write(fos);
		} catch (FileNotFoundException e) {
			
			System.out.println("Destination folder not found,Please check carefully");
			return false;
		} catch (IOException e) {
			
			System.out.println("There was a problem while writing the data");
			return false;
		}
		
		return true;
	}
}
