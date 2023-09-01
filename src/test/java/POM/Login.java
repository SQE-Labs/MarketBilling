package POM;

import org.openqa.selenium.By;
import BrowsersBase.DataInterface;
import CommonMethods.WebDriverWaits;

public class Login {

	public static By UsernameField = By.xpath("//input[@name='j_username']");
	public static By PasswordField = By.xpath("//input[@name='predigpass']");
	public static By LoginButton = By.xpath("//button[@value='Log In']");
	public static By groupLogiin = By.id("submitrequest");
	public static By selectGroup = By.id("newGroup");


	public static void ValidLogin() {
		WebDriverWaits.SendKeys(UsernameField, DataInterface.Username);
		WebDriverWaits.SendKeys(PasswordField, DataInterface.Password);
		WebDriverWaits.ClickOn(LoginButton);

	}
	public static void loginWithGroupName(String groupName) {
		WebDriverWaits.SendKeys(UsernameField, DataInterface.Username);
		WebDriverWaits.SendKeys(PasswordField, DataInterface.Password);
		WebDriverWaits.ClickOn(LoginButton);
	//	WebDriverWaits.selectByVisibleText(selectGroup,groupName);
	//	WebDriverWaits.ClickOn(groupLogiin);

	}
}
