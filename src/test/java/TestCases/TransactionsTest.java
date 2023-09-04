package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.ManageServiceNumber;
import POM.Transactions;
import org.testng.annotations.Test;

public class TransactionsTest  extends BaseTest {
    @Test(priority = 1,enabled = true)
    public  void cashPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Cash ");
        extentTest.setDescription(" Verify that User is able to pay usinhg Card pay method");
        Customer.searchAndNavigateToRecentCustomer();
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Cash","1201");
    }
    @Test(priority = 2,enabled = true)
    public  void bankAccountPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Credit card ");
        extentTest.setDescription(" Verify that User is able to pay using credit pay method");
        Customer.searchAndNavigateToRecentCustomer();
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Bank Account","12199.06");

    }

}
