package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.ManageServiceNumber;
import POM.Transactions;
import org.testng.annotations.Test;

public class PaymentViaCashTest extends BaseTest {
    @Test(priority = 1,enabled = true)
    public  void valid_Cash_PaymentType() throws InterruptedException {
        extentTest = extent.startTest("valid_Cash_PaymentType");
        extentTest.setDescription("Verify 'Transactions' successfully done via 'Cash' from the Payment Method drop-down.");
        //Login.validLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.make_Payment_Cash("Payment","Cash");
        Transactions.verify_CashPaySuccess_MSG("Cash");

    }
    @Test(priority = 2,enabled = true)
    public  void validate_Blank_AmountDetails() throws InterruptedException {
        extentTest = extent.startTest(" validate_Blank_AmountDetails ");
        extentTest.setDescription("Validation message appears when 'Amount' field is left blank after clicking on 'Make Payment' button for 'Cash' Payment Method.");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.make_Payment_Cash("Payment","Cash");
        Transactions.verify_Amount_Validation_MSG("Please enter an amount.");

    }

    @Test(priority = 3,enabled = true)
    public static void validate_DuplicateTxn_Allowed() throws InterruptedException {
        extentTest = extent.startTest("validate_DuplicateTxn_Allowed");
        extentTest.setDescription("Verify validation message appears without selecting the 'Allow duplicate transactions");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.make_Payment_Cash_Allowed("Payment","Cash","100");
        Transactions.verify_Allow_DuplicateTXN("-$1000000");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.make_Payment_Cash_Allowed("Payment","Cash","100");
        Transactions.verify_Allow_DuplicateTXN("-$1000000");

    }

    @Test(priority = 4,enabled = true)
    public static void validate_DuplicateTxn_NotAllowed() throws InterruptedException {
        extentTest = extent.startTest(" validate_DuplicateTxn_NotAllowed ");
        extentTest.setDescription("Verify validation message appears with selecting the 'Allow duplicate transactions");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.make_Payment_Cash_NotAllowed("Payment","Cash","100");
        Transactions.verify_NotAllowed_DuplicateTXN("Transaction can not be processed as it is a duplicate transaction.");

    }

}
