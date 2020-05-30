package com.student.TestData;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UtilClass {

	public static int new_entityState = 0;

	public static int edit_entityState = 2;

	public static int delete_entityState = 3;

	static XSSFWorkbook book;

	static XSSFSheet sheet;

	public static Object[][] setData(String sheetname, String file_path) {

		try {

			FileInputStream file = new FileInputStream(file_path);

			book = new XSSFWorkbook(file);

		} catch (Throwable e) {

			System.out.println(e.getMessage());
		}

		sheet = book.getSheetAt((int) Math.round(Double.parseDouble(sheetname)));

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {

			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();

			}

		}

		return data;
	}

}
