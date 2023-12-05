package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.Transactions;
import org.testng.annotations.Test;

public class PaymentViaBankAccountTest extends BaseTest {

    // Failing due to pop up does not appear
    @Test(priority = 1,enabled = true)
    public void valid_BankAccountDetails() throws InterruptedException {
        extentTest = extent.startTest("valid_BankAccountDetails");
        extentTest.setDescription("Verify payment status on entering valid bank account details");
        //Login.validLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_ViaBankAccount("Payment","Bank Account","021000021","Personal Savings","1368513884","Victoria","CA","91001");

    }
//Partialy Done
    @Test(priority = 2,enabled = false)
    public void validate_Blank_AccountNumber() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_AccountNumber");
        extentTest.setDescription("Verify validation message appears when 'Account Number' field is left blank");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_AccountNumber_Validation_MSG("Payment","Bank Account","","");

    }
    //Partialy Done
    @Test(priority = 3,enabled = false)
    public void validate_InvalidAccountNumber() throws InterruptedException {
        extentTest = extent.startTest("validate_InvalidAccountNumber");
        extentTest.setDescription("Verify payment status on entering invalid 'Account Number' in bank account details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_AccountNumber_Validation_MSG("Payment","Bank Account","","");

    }
    //Partialy Done
    @Test(priority = 4,enabled = false)
    public void validate_Blank_RoutingNumber() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_RoutingNumber");
        extentTest.setDescription("Verify validation message appears when 'Routing Number' field is left blank");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_RoutingNumber_Validation_MSG("Payment","Bank Account","","","");

    }
    //Partialy Done
    @Test(priority = 5,enabled = false)
    public void validate_InvalidRoutingNumber() throws InterruptedException {
        extentTest = extent.startTest("validate_InvalidRoutingNumber");
        extentTest.setDescription("Verify payment status on entering invalid 'Routing Number' in bank account details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_RoutingNumber_Validation_MSG("Payment","Bank Account","","","");

    }

    @Test(priority = 6,enabled = false)
    public void validate_Blank_StateCode() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_StateCode");
        extentTest.setDescription("Verify validation message appears when 'State Code' field is left blank");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_StateCode_Validation_MSG("Payment","Bank Account","","","","");

    }
    //Partialy Done
    @Test(priority = 7,enabled = false)
    public void validate_Incorrect_StateCodeDetails() throws InterruptedException {
        extentTest = extent.startTest("validate_Incorrect_StateCodeDetails");
        extentTest.setDescription("Verify validation message appears when incorrect 'State Code' is entered in bank account detail");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_StateCode_Validation_MSG("Payment","Bank Account","","","","");

    }
    //Partialy Done
    @Test(priority = 8,enabled = false)
    public void validate_Blank_ZipCode() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_ZipCode");
        extentTest.setDescription("Verify validation message appears when 'Zip Code' field is left blank");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_ZipCode_Validation_MSG("Payment","Bank Account","","","","");

    }
    //Partialy Done
    @Test(priority = 9,enabled = false)
    public void validate_Incorrect_ZipCodeDetails() throws InterruptedException {
        extentTest = extent.startTest("validate_Incorrect_ZipCodeDetails");
        extentTest.setDescription("Verify validation message appears on entering incorrect 'Zip Code' in bank account details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_ZipCode_Validation_MSG("Payment","Bank Account","","","","");

    }
    //Partialy Done
    @Test(priority = 10,enabled = false)
    public void validate_Blank_Address() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_Address");
        extentTest.setDescription("Verify validation message appears when 'Address' field is left blank");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_AddressDetails_Validation_MSG("Payment","Bank Account","","","");

    }
    //Partialy Done
    @Test(priority = 11,enabled = false)
    public void validate_Incorrect_AddressDetails() throws InterruptedException {
        extentTest = extent.startTest("validate_Incorrect_AddressDetails");
        extentTest.setDescription("Verify validation message appears on entering incorrect 'Address' in bank account details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_AddressDetails_Validation_MSG("Payment","Bank Account","","","");

    }
    //Partialy Done
    @Test(priority = 12,enabled = false)
    public void validate_Blank_CityDetails() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_City");
        extentTest.setDescription("Verify validation message appears when 'City' field is left blank");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_CityDetails_Validation_MSG("Payment","Bank Account","","","","");

    }
    //Partialy Done
    @Test(priority = 13,enabled = false)
    public void validate_Incorrect_CityDetails() throws InterruptedException {
        extentTest = extent.startTest("validate_Incorrect_CityDetails");
        extentTest.setDescription("Verify validation message appears on entering incorrect 'City' in bank account details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.verify_CityDetails_Validation_MSG("Payment","Bank Account","","","","");

    }
    //Partialy Done
    @Test(priority = 14,enabled = false)
    public void validatePayment_Timeout() throws InterruptedException {
        extentTest = extent.startTest("validatePayment_Timeout");
        extentTest.setDescription("Information message should appear when payment timeout occurs");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_Timeout_BA("Payment","Bank Account");

    }
}
