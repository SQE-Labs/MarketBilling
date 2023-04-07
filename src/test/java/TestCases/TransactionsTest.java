package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.ManageServiceNumber;
import POM.Transactions;
import org.testng.annotations.Test;

import static TestCases.TestLogin.ValidLogin;

public class TransactionsTest  extends BaseTest {
    @Test(priority = 36,enabled = true)
    public  void cashPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Cash ");
        extentTest.setDescription(" Verify that User is able to pay usinhg Card pay method");
       // Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Cash","1201");
    }
    @Test(priority = 37,enabled = true)
    public  void creditCardPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Credit card ");
        extentTest.setDescription(" Verify that User is able to pay usinhg credit pay method");
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Credit Card","12199.06");

    }
}
