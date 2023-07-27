package excelconcept;

import java.io.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetExcelData {

	public static void main(String[] args) throws Throwable {
		GetExcelData g = new GetExcelData();
		g.getExcelDate();

	}

	public void getExcelDate() throws Throwable

	{
		FileInputStream fis = new FileInputStream(new File(
				"C:\\Users\\Virendra\\eclipse-workspace\\TestExcelData\\src\\main\\java\\com\\qa\\testData\\Users.xlsx"));
		XSSFWorkbook w = new XSSFWorkbook(fis);
		XSSFSheet s = w.getSheet("Sheet1");
		int c = s.getRow(0).getLastCellNum();// To find the column count
		System.out.println(c);
		int r = s.getLastRowNum()-s.getFirstRowNum(); // To find the row count
		System.out.println(r);

		for (int i = 1; i <= r; i++) {
			XSSFRow row = s.getRow(i);
			for (int j = 0; j < c; j++) {
				XSSFCell cell = row.getCell(j);

				System.out.print(cell + " ");
			}
			System.out.println();

		}

	}

}
