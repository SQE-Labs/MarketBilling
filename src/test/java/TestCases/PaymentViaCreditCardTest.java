package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.Transactions;
import org.testng.annotations.Test;

public class PaymentViaCreditCardTest extends BaseTest {

    @Test(priority = 1, enabled = true)
    public void valid_CreditCardDetails() throws InterruptedException {
        extentTest = extent.startTest("valid_CreditCardDetails");
        extentTest.setDescription("Verify payment status on entering valid credit card details");
        //Login.validLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_ViaCreditCard("Payment", "Credit Card","4200000000000000","03/34","543","");
        Transactions.verify_PaymentSuccess_MSG("Payment received");

    }

    @Test(priority = 2, enabled = true)
    public void validate_Lessthan_Allowed() throws InterruptedException {
        extentTest = extent.startTest("validate_Lessthan_Allowed");
        extentTest.setDescription("Verify validation message appears on entering less than allowed digits in credit card details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_CCNumberLessThan_Allowed("Payment", "Credit Card","42000000000000","03/24");
        Transactions.verify_CardNumberValidation_MSG("Invalid card number or brand");

    }

    @Test(priority = 3, enabled = true)
    public void validate_Blank_CardNumber() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_CardNumber");
        extentTest.setDescription("Verify validation message appears when 'Card Number' field is left blank");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_CCardNumber_Blank("Payment", "Credit Card","","03/24","765","Australia");
        Transactions.verify_CardNumberValidation_MSG("Invalid card number or brand");
    }

    @Test(priority = 4, enabled = true)
    public void validate_Invalid_CardNumber() throws InterruptedException {
        extentTest = extent.startTest("validate_Invalid_CardNumber");
        extentTest.setDescription("Verify validation message appears on entering invalid 'Card Number' in credit card details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_Invalid_CCardNumber("Payment", "Credit Card","42000000000000000","03/45");
        Transactions.verify_CardNumberValidation_MSG("Invalid card number or brand");

    }

    @Test(priority = 5, enabled = true)
    public void validate_Invalid_ExpiryDate() throws InterruptedException {
        extentTest = extent.startTest("validate_Invalid_ExpiryDate");
        extentTest.setDescription("Verify validation message appears on entering invalid 'Expiry Date' in credit card details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_Invalid_ExpiryDate("Payment", "Credit Card","03/20","876");
        Transactions.verify_ExpiryDateValidation_MSG("Invalid expiry date");
    }

    @Test(priority = 6, enabled = true)
    public void validate_Blank_ExpiryDate() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_ExpiryDate");
        extentTest.setDescription("Verify validation message appears when 'Expiry Date' field is left blank");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_ExpiryDate_Blank("Payment", "Credit Card","4200000000000000","03/20","543");
        Transactions.verify_ExpiryDateValidation_MSG("Invalid expiry date");
    }

    @Test(priority = 7, enabled = true)
    public void validate_Invalid_Cvv() throws InterruptedException {
        extentTest = extent.startTest("validate_Invalid_Cvv");
        extentTest.setDescription("Verify validation message appears on entering invalid 'CVV' in credit card details");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_InvalidCVV("Payment", "Credit Card","4200000000000000","03/34","5432","Australia");
        Transactions.verify_CvvValidation_MSG("Invalid CVV");
    }

    @Test(priority = 8, enabled = true)
    public void validate_Blank_Cvv() throws InterruptedException {
        extentTest = extent.startTest("validate_Blank_Cvv");
        extentTest.setDescription("Verify validation message appears when 'CVV' field is left blank after clicking on 'Pay Now' button.");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_BlankCVV("Payment", "Credit Card","4200000000000000","03/34","");
        Transactions.verify_CvvValidation_MSG("Invalid CVV");
    }

    @Test(priority = 9, enabled = true)
    public void validate_Payment_Timeout() throws InterruptedException {
        extentTest = extent.startTest("validate_Payment_Timeout");
        extentTest.setDescription("Verify Information message appears when payment timeout occurs, on the 'Payments' page");
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_Timeout_CC("Payment", "Credit Card");
        Transactions.verify_TimeoutValidation_MSG("Request timeout");


    }

}
