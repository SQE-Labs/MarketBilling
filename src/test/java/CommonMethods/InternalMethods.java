package CommonMethods;

import java.util.ArrayList;
import java.util.List;

import POM.Services;
import org.openqa.selenium.WebElement;

import static BrowsersBase.BrowsersInvoked.driver;


public class InternalMethods extends Services {

	public static void SwitchToCustomerpage() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> OverViewTab = driver.findElements(overviewTab);
		if (OverViewTab.size() == 0) {
			WebDriverWaits.ClickOn( selectBusinessCustomer_Record1);
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			Thread.sleep(3000);
			driver.switchTo().window((String) tabs.get(1));
		}
		}
	public static void SwitchToCustomerpage(int windowIndex) throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> OverViewTab = driver.findElements( overviewTab);
		if (OverViewTab.size() == 0) {
			WebDriverWaits.ClickOn( selectBusinessCustomer_Record1);
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			Thread.sleep(3000);
			driver.switchTo().window((String) tabs.get(windowIndex));
		}



	}
		public static void searchResults() throws InterruptedException {
			Thread.sleep(2000);
			List<WebElement> EditIcon = driver.findElements( Edit_icon);
			if (EditIcon.size() == 2) {
				WebDriverWaits.ClickOn(TwosearchResults);


			}



	}

}

 
//*[@class='icon-edit ']  TwosearchResults