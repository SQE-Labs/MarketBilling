package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Transactions extends TestLogin {

    public static By transaction = By.xpath("//*[@id='content']/div[2]/div[1]/div/div/ul/li[7]/a");
    public static By transactionType = By.id("tranType");
    public static By paymentMethod = By.id("tranSubType");
    public static By transactionTab = By.xpath("//*[@class=\"icon-money\"]");
    public static By amount = By.id("amount");
    public static By activeDate = By.cssSelector(".active.day");
    public static By transactionDate = By.id("tranDate");
    public static By comments = By.id("comment");
    public static By makePayment = By.id("acms-submitBtn");
    public static By viewHistory = By.id("historyRow");
    public static By ok = By.xpath("//*[contains(text(),'OK')]");
    public static By cancel = By.xpath("//*[contains(text(),'Cancel')]");
    public static By allowDupes = By.name("allowDupes");
    public static By creditCardNumber = By.xpath("(//*[@name='card.number'])[1]");
    public static By expiryDate = By.xpath("//input[@class='wpwl-control wpwl-control-expiry']");
    public static By cVV = By.xpath("(//*[@name='card.cvv'])[1]");
    public static By billingAddress = By.xpath("//select[@name='billing.country']");
    public static By payNow = By.xpath("//button[@class='wpwl-button wpwl-button-pay']");
    public static By accountType = By.xpath("/html/body/app-root/div/div/div/div/form/div[1]/div[2]/div/div/div/select");
    public static By accountNumber = By.id("account-number");
    public static By name = By.id("account-holder-name");
    public static By address = By.id("account-address-line1");
    public static By city = By.id("account-city");
    public static By state = By.id("account-region-code");
    public static By zip = By.id("account-postal-code");
    public static By routingNumber = By.id("routing-number");
    public static By submit = By.id("card-submit-button");
    public static By invalidCardNumberTxt = By.xpath("//div[@class='wpwl-hint wpwl-hint-cardNumberError']");
    public static By invalidExpiryDateTxt = By.xpath("//div[@class='wpwl-hint wpwl-hint-expiryMonthError']");
    public static By invalidCvvTxt = By.xpath("//div[@class='wpwl-hint wpwl-hint-cvvError']");
    public static By transactionTypeText = By.xpath("//tbody/tr[1]//td[4]");
    public static By requestTimeout = By.xpath("//*[@id=\"errTransactionAlert\"]/div/center/text()");


    public static SoftAssert softAssert = new SoftAssert();
    static String SUCCESS_PAY_CC = "Payment recevied";



    public static void addPaymentDetails(String trxnType, String payMethod, String amt) throws InterruptedException {
        WebDriverWaits.selectByVisibleText(transactionType, trxnType);
        WebDriverWaits.selectByVisibleText(paymentMethod, payMethod);
        WebDriverWaits.SendKeys(amount, amt);
        WebDriverWaits.ClickOn(transactionDate);
        WebDriverWaits.ClickOn(activeDate);
        WebDriverWaits.ClickOn(allowDupes);
        WebDriverWaits.SendKeys(comments, trxnType + " " + payMethod);
        WebDriverWaits.scrollIntoView(makePayment);
        WebDriverWaits.ClickOn(makePayment);
        try {
            WebDriverWaits.ClickOn(ok);

        } catch (Exception e) {

        }

    }

    public static void make_Payment(String trxnType, String payMethod) throws InterruptedException {
        WebDriverWaits.ClickOn(transactionTab);
        WebDriverWaits.selectByVisibleText(transactionType, trxnType);
        WebDriverWaits.selectByVisibleText(paymentMethod, payMethod);
        String RandomAmount = "34" + RandomStrings.RequiredDigits(3);
        WebDriverWaits.SendKeys(amount, RandomAmount);
        WebDriverWaits.ClickOn(transactionDate);
        WebDriverWaits.ClickOn(activeDate);
        WebDriverWaits.ClickOn(allowDupes);
        WebDriverWaits.scrollIntoView(comments);
        WebDriverWaits.SendKeys(comments, trxnType + " " + payMethod);
        WebDriverWaits.scrollIntoView(makePayment);
        WebDriverWaits.ClickOn(makePayment);
        WebDriverWaits.ClickOn(ok);

    }

    public static void enterCvv(String cvvTxt){
        WebDriverWaits.SendKeys(cVV, cvvTxt);
    }

    public static void enterExpiryDate(String expirtDateTxt){
        WebDriverWaits.SendKeys(expiryDate, expirtDateTxt);
    }

    public static void enterCardNumber(String cardNumberTxt){
        WebDriverWaits.WaitUntilVisible(creditCardNumber);
        WebDriverWaits.SendKeys(creditCardNumber,cardNumberTxt);
    }

    public static void switchToWindow() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWaits.SwitchToNewTab();
    }

    public static void switchToFrame() throws InterruptedException {
        WebDriverWaits.SwitchToParentFrame();
    }

    public static void maximizePage() throws InterruptedException {
        driver.manage().window().maximize();
    }

    public static void clickPayNowBtn() throws InterruptedException {
        WebDriverWaits.scrollIntoView(payNow);
        WebDriverWaits.ClickOn(payNow);
    }

    public static void verify_CardNumberValidation_MSG(String expected) throws InterruptedException {
        String actual = WebDriverWaits.GetText(invalidCardNumberTxt);
        Assert.assertEquals(actual, expected);
    }

    public static void verify_ExpiryDateValidation_MSG(String expected) throws InterruptedException {
        String actual = WebDriverWaits.GetText(invalidExpiryDateTxt);
        Assert.assertEquals(actual, expected);
    }

    public static void verify_CvvValidation_MSG(String expected) throws InterruptedException {
        String actual = WebDriverWaits.GetText(invalidCvvTxt);
        Assert.assertEquals(actual, expected);
    }
    public static void verify_PaymentSuccess_MSG(String expected) throws InterruptedException {
        Thread.sleep(5000);
        String actual = WebDriverWaits.GetText(transactionTypeText);
        Assert.assertEquals(actual, expected);
    }

    public static void verify_TimeoutValidation_MSG(String expected) throws InterruptedException {
        switchToWindow();
        Thread.sleep(400000);
        WebDriverWaits.scrollIntoView(transaction);
        String actual = WebDriverWaits.GetText(requestTimeout);
        Assert.assertEquals(actual, expected);
    }


    public static void enterRoutingNumber(String routingNumberTxt){
        WebDriverWaits.WaitUntilVisible(routingNumber);
        WebDriverWaits.SendKeys(routingNumber,routingNumberTxt);
    }

    public static void accountType(){
        WebDriverWaits.ClickOn(accountType);
        WebDriverWaits.selectByVisibleText(accountType,"Personal Savings");
    }

    public static void enterAccountNumber(String accountNumberTxt){
        WebDriverWaits.WaitUntilVisible(accountNumber);
        WebDriverWaits.SendKeys(accountNumber,accountNumberTxt);
    }

    public static void selctAccountType(String accountTypeTxt){
        WebDriverWaits.ClickOn(accountType);
        WebDriverWaits.selectByVisibleText(accountType,accountTypeTxt);
    }

    public static void enterName(){
        String RandomAmount = "Lewis" + RandomStrings.RequiredCharacters(5);
        WebDriverWaits.SendKeys(name, RandomAmount);
           }

    public static void enterAddressDetails(){
        String RandomAmount = "12" + RandomStrings.RequiredDigits(3);
        WebDriverWaits.SendKeys(address, RandomAmount);
    }

    public static void enterCityDetails(String cityTxt){
        WebDriverWaits.SendKeys(city,cityTxt);
    }

    public static void enterStateDetails(String stateTxt){
        WebDriverWaits.SendKeys(state,stateTxt);
    }

    public static void enterZipCodeDetails(String zipCodeTxt){
        WebDriverWaits.SendKeys(zip,zipCodeTxt);
    }
    public static void clickSubmitBtn(){
        WebDriverWaits.WaitUntilVisible(submit);
        WebDriverWaits.ClickOn(submit);
    }

    public static void payment_ViaBankAccount(String trxnType, String payMethod,String routingNumber, String accountType, String accountNumber, String city, String state,String zipCode) throws InterruptedException {
        make_Payment(trxnType,payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterRoutingNumber(routingNumber);
        selctAccountType(accountType);
        enterAccountNumber(accountNumber);
        enterName();
        enterAddressDetails();
        enterCityDetails(city);
        enterStateDetails(state);
        enterZipCodeDetails(zipCode);
        clickSubmitBtn();

    }
    public static void selectBillingAddress(String billingAddressTxt){
        WebDriverWaits.selectByVisibleText(billingAddress, "Australia");
    }

    public static void payment_ViaCreditCard(String trxnType, String payMethod,String cardNumber , String expiryDate,String cVV, String billingAddress) throws InterruptedException {
        make_Payment(trxnType,payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);
        enterCvv(cVV);
        selectBillingAddress(billingAddress);
        clickPayNowBtn();
//        softAssert.assertEquals(transactionTypeText, SUCCESS_PAY_CC);
//        softAssert.assertAll();

    }


    public static void payment_CCNumberLessThan_Allowed(String trxnType, String payMethod,String cardNumber ,String expiryDate) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);
        Thread.sleep(2000);
    }

    public static void payment_CCardNumber_Blank(String trxnType, String payMethod,String cardNumber , String expiryDate,String cVV, String billingAddress) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);
        enterCvv(cVV);
        selectBillingAddress(billingAddress);
        clickPayNowBtn();
    }


    public static void payment_Invalid_CCardNumber(String trxnType, String payMethod,String cardNumber , String expiryDate) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);
    }


    public static void payment_Invalid_ExpiryDate(String trxnType, String payMethod, String expiryDate,String cVV) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterExpiryDate(expiryDate);
        enterCvv(cVV);
    }



    public static void payment_ExpiryDate_Blank(String trxnType, String payMethod,String cardNumber , String expiryDate,String cVV) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);
        enterCvv(cVV);
        clickPayNowBtn();
    }

    public static void payment_BlankCVV(String trxnType, String payMethod,String cardNumber , String expiryDate,String cVV) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);
        enterCvv(cVV);
        clickPayNowBtn();

    }

    public static void payment_InvalidCVV(String trxnType, String payMethod,String cardNumber,String expiryDate,String cVV, String billingAddress) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterCardNumber(cardNumber);
        enterExpiryDate(expiryDate);
        enterCvv(cVV);
        selectBillingAddress(billingAddress);
    }

    public static void payment_Timeout(String trxnType, String payMethod,String cardNumber) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterCardNumber(cardNumber);
        Thread.sleep(100000);
    }
}
