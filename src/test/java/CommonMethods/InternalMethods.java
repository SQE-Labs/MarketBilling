package CommonMethods;

import POM.Flow6_7AddingServiceAndMeter;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class InternalMethods extends Flow6_7AddingServiceAndMeter {

	public static void SwitchToCustomerpage() throws InterruptedException {
		Thread.sleep(2000);
		List<WebElement> OverViewTab = driver.findElements(X_AddService.OverviewTab);
		if (OverViewTab.size() == 0) {
			WebDriverWaits.ClickOn(X_AddService.selectBusinessCustomer_Record1);
			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
			Thread.sleep(3000);
			driver.switchTo().window((String) tabs.get(1));

		}
		}
		public static void searchResults() throws InterruptedException {
			Thread.sleep(2000);
			List<WebElement> EditIcon = driver.findElements(X_AddService.Edit_icon);
			if (EditIcon.size() == 2) {
				WebDriverWaits.ClickOn(X_AddService.TwosearchResults);
			

			}

		
		
	}

}

 
//*[@class='icon-edit ']  TwosearchResults