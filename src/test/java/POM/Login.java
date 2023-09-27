package POM;

import CommonMethods.PropertiesUtil;
import org.openqa.selenium.By;
import CommonMethods.WebDriverWaits;

public class Login {

	public static By usernameField = By.xpath("//input[@name='j_username']");
	public static By passwordField = By.xpath("//input[@name='predigpass']");
	public static By loginButton = By.xpath("//button[@value='Log In']");
	public static By groupLogiin = By.xpath("//button[text()='Login']");
	public static By selectGroup = By.id("newGroup");


	public static void validLogin() {
		WebDriverWaits.SendKeys(usernameField, PropertiesUtil.getValue("username") );
		WebDriverWaits.SendKeys(passwordField, PropertiesUtil.getValue("password"));
		if (PropertiesUtil.getValue("loginType").contains("single")) {
			WebDriverWaits.ClickOn(loginButton);}
		else {
			WebDriverWaits.selectByVisibleText(selectGroup,PropertiesUtil.getValue("groupName"));
			WebDriverWaits.ClickOn(groupLogiin);
		}


	}

}