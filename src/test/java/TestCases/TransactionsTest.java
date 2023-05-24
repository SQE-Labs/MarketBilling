package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.ManageServiceNumber;
import POM.Transactions;
import org.testng.annotations.Test;

import static TestCases.TestLogin.ValidLogin;

public class TransactionsTest  extends BaseTest {
    @Test(priority = 33)
    public  void cashPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Cash ");
        extentTest.setDescription(" Verify that User is able to pay usinhg Card pay method");
        //Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Cash","1201");
    }
    @Test(priority = 34)
    public  void creditCardPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Credit card ");
        extentTest.setDescription(" Verify that User is able to pay usinhg credit pay method");
        Customer.searchAndNavigateToRecentCustomer();
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Credit Card","12199.06");
    }
}
