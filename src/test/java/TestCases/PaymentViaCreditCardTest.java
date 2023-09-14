package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.Transactions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PaymentViaCreditCardTest extends BaseTest {

    public static String RandomName1;

    @Test(priority = 1, enabled = true)
    public void validCreditCardDetails() throws InterruptedException {
        extentTest = extent.startTest("validCreditCardDetails");
        extentTest.setDescription("Verify that User is able to pay via credit card");
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_CreditCard("Payment", "Credit Card");
        Transactions.verify_PaymentSuccess_MSG("Payment received");

    }

    @Test(priority = 2, enabled = true)
    public void validate_LessthanAllowed() throws InterruptedException {
        extentTest = extent.startTest("validate_LessthanAllowed");
        extentTest.setDescription("Verify that User is not allowed less than 16 digits in Card Number");
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_CCNumberLessThan_Allowed("Payment", "Credit Card");
        Transactions.verify_CardNumberValidation_MSG("Invalid card number or brand");

    }

    @Test(priority = 3, enabled = true)
    public void validateCardNumber_Blank() throws InterruptedException {
        extentTest = extent.startTest("validateCardNumber_Blank");
        extentTest.setDescription("Verify that User is not allowed to pay with blank Card Number");
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_CCardNumber_Blank("Payment", "Credit Card");
        Transactions.verify_CardNumberValidation_MSG("Invalid card number or brand");
    }

    @Test(priority = 4, enabled = true)
    public void validate_InvalidCardNumber() throws InterruptedException {
        extentTest = extent.startTest("validate_InvalidCardNumber");
        extentTest.setDescription(" Verify that User is not allowed to pay with invalid Card Number");
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_Invalid_CCardNumber("Payment", "Credit Card");
        Transactions.verify_CardNumberValidation_MSG("Invalid card number or brand");

    }

    @Test(priority = 5, enabled = true)
    public void validate_InvalidExpiryDate() throws InterruptedException {
        extentTest = extent.startTest("validate_InvalidExpiryDate");
        extentTest.setDescription(" Verify that User is not allowed to pay with expiry date");
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_Invalid_ExpiryDate("Payment", "Credit Card");
        Transactions.verify_ExpiryDateValidation_MSG("Invalid expiry date");
    }

    @Test(priority = 6, enabled = true)
    public void validateExpiryDate_Blank() throws InterruptedException {
        extentTest = extent.startTest("validateExpiryDate_Blank");
        extentTest.setDescription(" Verify that User is not allowed to pay with blank Expiry date");
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_ExpiryDate_Blank("Payment", "Credit Card");
        Transactions.verify_ExpiryDateValidation_MSG("Invalid expiry date");
    }

    @Test(priority = 7, enabled = true)
    public void validate_InvalidCvv() throws InterruptedException {
        extentTest = extent.startTest("validate_InvalidCvv");
        extentTest.setDescription(" Verify that User is not allowed to pay with invalid CVV");
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_InvalidCVV("Payment", "Credit Card");
        Transactions.verify_CvvValidation_MSG("Invalid CVV");
    }

    @Test(priority = 8, enabled = true)
    public void validateCvv_Blank() throws InterruptedException {
        extentTest = extent.startTest("validateCvv_Blank");
        extentTest.setDescription(" Verify that User is able to pay with blank CVV");
        Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_BlankCVV("Payment", "Credit Card");
        Transactions.verify_CvvValidation_MSG("Invalid CVV");
    }
    @Test(priority = 9, enabled = true)
    public void validatePayment_Timeout() throws InterruptedException {
        extentTest = extent.startTest("validatePayment_Timeout");
        extentTest.setDescription("Validate payment timeout");
      //  Login.ValidLogin();
        Customer.searchAndNavigateToRecentCustomer();
        Transactions.payment_Timeout("Payment", "Credit Card");
        Transactions.verify_TimeoutValidation_MSG("Invalid expiry date");

    }

}
