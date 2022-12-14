package POM;

import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;

public class LandingPage {

	public static By userDropdown = By.xpath("//a[@title='User']");
	public static By logout = By.xpath("/html/body/header/div/div[2]/ul/li[5]/ul/li[5]/a");
	public static void clickUserDropdown() {
		WebDriverWaits.ClickOn(userDropdown);
	}
	public static void clickLogout() {
		WebDriverWaits.ClickOn(logout);
	}

}
