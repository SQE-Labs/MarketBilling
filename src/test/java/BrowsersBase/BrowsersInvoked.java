package BrowsersBase;


import CommonMethods.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowsersInvoked {
	public static WebDriver driver;
	public String browser = PropertiesUtil.getValue("browserMain");
	public String FinalBrowser = browser.toUpperCase();

	@BeforeSuite
	public void SetProp() {
		switch (FinalBrowser) {
		case "CHROME": {
			ChromeOptions chromeOptions = new ChromeOptions();
		//	WebDriverManager.chromedriver().setup();
		//	chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
			break;
		}
		case "FIREFOX": {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			//WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(firefoxOptions);
			break;
		}
		case "EDGE": {
			EdgeOptions edgeOptions = new EdgeOptions();
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(edgeOptions);
			break;
		}
//		case "OPERA": {
//			OperaOptions operaOptions = new OperaOptions();
//			WebDriverManager.operadriver().setup();
//			driver = new OperaDriver(operaOptions);
//			break;
//		}
		default : {
			break;
		}
		}

		driver.manage().window().maximize();
		driver.get(PropertiesUtil.getValue("URL"));
	}

	@AfterSuite
	public void toClose() {
	//	driver.quit();
	}

}
