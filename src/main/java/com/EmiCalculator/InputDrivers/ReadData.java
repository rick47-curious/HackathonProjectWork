package com.EmiCalculator.InputDrivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {


	String inputData [] = new String[4];
	String inputfData [] = new String[4];
	public String[] readData()  {


		FileInputStream fis;
		try {
			fis = new FileInputStream("src\\main\\resources\\InputData.xlsx");



			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheetAt(0);

			Row row = sheet.getRow(1);

			for (int i=0; i<3 ; i++) {


				inputData[i] = row.getCell(i).toString();

			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the directory");
		} catch (IOException e) {

			System.out.println("Input cannot be taken from the File");
		}	


		return inputData;
	}
	public String[] readFailedData() {

		try {
			FileInputStream fis = new FileInputStream("src\\main\\resources\\InputData.xlsx");

			XSSFWorkbook wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheetAt(0);

			Row row = sheet.getRow(2);

			for (int i=0; i<3 ; i++) {


				inputfData[i] = row.getCell(i).toString();
			}

		}catch (FileNotFoundException e) {

			System.out.println("File not Found at the Directory");
		} catch (IOException e) {

			System.out.println("Input cannot be taken from the File");
		}
		return inputfData;
	}
}
