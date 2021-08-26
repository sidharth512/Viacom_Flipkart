package readconfit_viacom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readconfit {
	Properties pro;
public Readconfit()  {
	try {
	FileInputStream file=new FileInputStream(".\\configt");
	pro=new Properties();
	
		pro.load(file);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
public  String Readurl() {
	
String	Filpkart=pro.getProperty("url");
return Filpkart;
}
public String ReadChrome() {
	String chrome=pro.getProperty("Chromedriver");
	return chrome;
}

public String ReadEdge() {
	String Edge=pro.getProperty("Edgedriver");
	return Edge;
}

}
