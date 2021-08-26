package TastCase_pakage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import POM_Filpkart.Login_Page;
import readconfit_viacom.XLUtility;



public class TC_001_viacom extends BaseTest_viacom{
	@Test(dataProvider="logindata")
	public void startup(String user,String pwd) throws InterruptedException {
		System.out.println(driver.getTitle());
		Login_Page click=new Login_Page(driver);
	 click.username(user);
		click.password(pwd);
		click.loginbutton();
		Thread.sleep(3000);
		if (driver.getPageSource().contains("Your username or password is incorrect")==true) {
			System.out.println(driver.getTitle());
			driver.switchTo().defaultContent();
		}
		else {
			click.login();
			click.logout();
		}
		
		
	}
	/*
	 * public boolean Ismessagepresent() { try {
	 * driver.getPageSource().contains("Your username or password is incorrect");
	 * return true;
	 * 
	 * } catch(Exception e) { return false; } }
	 */
		
@DataProvider(name="logindata")
String[][]getData() throws IOException{
	
	
	String path="C:\\Users\\User 1\\Desktop\\New Microsoft Office Excel Worksheet.xlsx";
	XLUtility Xlutil=new XLUtility(path);
	int totalrows=Xlutil.getrowcount("Sheet1");
	int totalcols=Xlutil.getcellcount("Sheet1",totalrows );
	String loginData[][]=new String [totalrows][totalcols];
	for(int i=1;i<= totalrows;i++) {
		for(int j=0;j<totalcols;j++) {
			loginData[i-1][j]=Xlutil.getCellData("Sheet1", i, j);
		}
	}
	
	/*
	 * String [][] loginData= { {"857451" ,"123455"}, {"papulu.rataer", "sidh1234"},
	 * { "papulu.pattanaik@gmail.com" ,"sidh1234"},
	 * 
	 * 
	 * };
	 */
	
	return loginData;
}
/*
 * public String data() throws IOException { XLUtils load=new XLUtils(); String
 * logdata=load.getdata(1, 0, 0); return logdata;
 * 
 * }
 */
	
	
	
	/*
	String path="C:\\Users\\User 1\\Desktop\\New Microsoft Office Excel Worksheet.xlsx";
	int rownum=readconfit_viacom.XLUtils.getRowCount(path,"Sheet1" );
	int cellcount=readconfit_viacom.XLUtils.getCellcount(path, "Sheet1",rownum );
	String loginData[][]=new String [rownum][cellcount];
	for(int i=1;i<=rownum;i++) {
		for(int j=0;i<cellcount;j++) {
			String logindata=readconfit_viacom.XLUtils.getCellData(path, "Sheet1", i, j);
			
			
		}
	}
	return loginData;
}*/
}

