package TastCase_pakage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import readconfit_viacom.Readconfit;

public class BaseTest_viacom {
	public WebDriver driver;
	Readconfit read=new Readconfit();
	String URL=read.Readurl();
	String driv=read.ReadChrome();
	String driv2=read.ReadEdge();
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", driv);
		driver=new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.edge.driver",driv2 );
			driver=new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		
		
	}
	public void capturescreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\ScreenShots\\"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("screenshorttaken");
		
	}

}
