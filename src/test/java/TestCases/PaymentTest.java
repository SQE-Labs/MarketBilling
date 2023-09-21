package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.Transactions;
import org.testng.annotations.Test;

public class PaymentTest extends BaseTest {

    public static String RandomName1;

    @Test(priority = 1,enabled = true)
    public void paymentVia_CreditCard() throws InterruptedException {
        extentTest = extent.startTest("Payment via Credit Card");
        extentTest.setDescription(" Verify that User is able to pay via credit card");
        Login.validLogin();
        Customer.searchAndNavigateToRecentCustomer();
   //     Transactions.payment_CreditCard("Payment","Credit Card");

    }

    @Test(priority = 1,enabled = true)
    public void paymentVia_BankAccount() throws InterruptedException {
        Login.validLogin();
        Customer.searchAndNavigateToRecentCustomer();
    //    Transactions.payment_BankAccount("Payment","Bank Account");

    }
}
