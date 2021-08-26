package readconfit_viacom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	String path=null;
public 	XLUtility(String path) {
	this.path=path;
}
public int getrowcount(String sheetName) throws IOException {
	 FileInputStream src=new FileInputStream(path);
	 XSSFWorkbook wb=new XSSFWorkbook(src);
	 XSSFSheet sheet=wb.getSheet(sheetName);
	 int rowcount=sheet.getLastRowNum();
	 return rowcount;
	 
}
public int getcellcount(String sheetName,int rownum ) throws IOException {
	FileInputStream src=new FileInputStream(path);
	XSSFWorkbook wb= new XSSFWorkbook(src);
	XSSFSheet sheet=wb.getSheet(sheetName);
	XSSFRow row=sheet.getRow(rownum );
	int cellcount=row.getLastCellNum();
	return cellcount;
	
}
public String getCellData(String sheetName,int rownum,int colunm ) throws IOException {
	FileInputStream src=new FileInputStream(path);
	XSSFWorkbook wb= new XSSFWorkbook(src);
	XSSFSheet sheet=wb.getSheet(sheetName);
	XSSFRow row=sheet.getRow(rownum );
	XSSFCell cell=row.getCell(colunm);
	DataFormatter formattor=new DataFormatter();
	String data;try {
	  data=formattor.formatCellValue(cell);
	}
	catch(Exception e) {
		data="";
	}
	return data;
}

}
