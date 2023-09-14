package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.Transactions;
import org.testng.annotations.Test;

public class PaymentViaBankAccountTest extends BaseTest {


    @Test(priority = 1,enabled = true)
    public void paymentVia_BankAccount() throws InterruptedException {
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_BankAccount("Payment","Bank Account");

    }
}
