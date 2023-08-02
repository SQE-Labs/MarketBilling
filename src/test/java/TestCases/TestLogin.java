package TestCases;

import CommonMethods.BaseTest;
import POM.Login;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {



	@Test(priority = -1,enabled = true)
	public static void ValidLogin() {
		extentTest = extent.startTest(" ValidLogin ");
		extentTest.setDescription(" Verify that User is able to login successfully. ");
		Login.loginWithGroupName("Testing1228");
	}
}
