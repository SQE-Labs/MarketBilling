package TestCases;

import org.testng.annotations.Test;
<<<<<<< HEAD:src/test/java/TestCases/TestLogin.java
import ExtentReport.ExtentReportClass;
import pageObjects.Flow1Login;
=======
import commonUtil.ExtentReportClass;
>>>>>>> 87aa608 ( minor updates):src/main/java/test/TestLogin.java

public class TestLogin extends ExtentReportClass {



	@Test(priority = 0)
	public static void ValidLogin() {
		extentTest = extent.startTest(" ValidLogin ");
		extentTest.setDescription(" Verify that User is able to login successfully. ");
		Flow1Login.ValidLogin();
	}
}
