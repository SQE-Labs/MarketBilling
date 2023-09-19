package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;

public class TokenTest extends BaseTest {

    @Test(priority = 1,enabled = true)
    public  void valid_Token_Details() throws InterruptedException {
        extentTest = extent.startTest("valid_Token_Details");
        extentTest.setDescription("Verify payment status on entering valid token details");
        Login.ValidLogin();
        Admin.navigateToAdmin();
        Payments.validToken("aOrD6n7L4Ys791lmtaXVmfSe");
        Payments.verify_Token_Success_MSG("Group Payment Gateway has been successfully updated.");

    }

    @Test(priority = 2,enabled = true)
    public  void invalid_Token_Details() throws InterruptedException {
        extentTest = extent.startTest("invalid_Token_Details");
        extentTest.setDescription("Verify payment status on entering invalid token details");
        Admin.navigateToAdmin();
        Payments.invalidToken("aOrD6n7L4Ys791lmtaX");
        Payments.verify_Token_Validation_MSG("Invalid Payment Gateway configuration details.");
    }
}
