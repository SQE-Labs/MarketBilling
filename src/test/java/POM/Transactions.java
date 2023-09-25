package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.testng.Assert;

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
    public static By ok = By.xpath("//*[contains(text(),'OK')]");
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
    public static By requestTimeout = By.xpath("//p[@class='errorTransMsg']");
    public static By paymentTypeText = By.xpath("//tbody/tr[1]//td[5]");
    public static By amountInformationText = By.xpath("//div[@class='bootstrap-dialog-message']");
    public static By amountTxt = By.xpath("//tbody/tr[1]//td[6]");
    public static By duplicateErrorText = By.xpath("(//p[@class='error'])[1]");


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

    public static void make_Payment_Cash(String trxnType, String payMethod) throws InterruptedException {
        WebDriverWaits.ClickOn(transactionTab);
        WebDriverWaits.selectByVisibleText(transactionType, trxnType);
        WebDriverWaits.selectByVisibleText(paymentMethod, payMethod);
        WebDriverWaits.ClickOn(transactionDate);
        WebDriverWaits.ClickOn(activeDate);
        WebDriverWaits.ClickOn(allowDupes);
        WebDriverWaits.scrollIntoView(comments);
        WebDriverWaits.SendKeys(comments, trxnType + " " + payMethod);
        WebDriverWaits.scrollIntoView(makePayment);
        WebDriverWaits.ClickOn(makePayment);

    }

    public static void make_Payment_Cash_Allowed(String trxnType, String payMethod,String amountText) throws InterruptedException {
        WebDriverWaits.ClickOn(transactionTab);
        WebDriverWaits.selectByVisibleText(transactionType, trxnType);
        WebDriverWaits.selectByVisibleText(paymentMethod, payMethod);
        WebDriverWaits.SendKeys(amount,amountText);
        WebDriverWaits.ClickOn(transactionDate);
        WebDriverWaits.ClickOn(activeDate);
        WebDriverWaits.ClickOn(allowDupes);
        WebDriverWaits.scrollIntoView(comments);
        WebDriverWaits.SendKeys(comments, trxnType + " " + payMethod);
        WebDriverWaits.scrollIntoView(makePayment);
        WebDriverWaits.ClickOn(makePayment);
        WebDriverWaits.ClickOn(ok);

    }

    public static void make_Payment_Cash_NotAllowed(String trxnType, String payMethod,String amountText) throws InterruptedException {
        WebDriverWaits.ClickOn(transactionTab);
        WebDriverWaits.selectByVisibleText(transactionType, trxnType);
        WebDriverWaits.selectByVisibleText(paymentMethod, payMethod);
        WebDriverWaits.SendKeys(amount,amountText);
        WebDriverWaits.ClickOn(transactionDate);
        WebDriverWaits.ClickOn(activeDate);
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
        WebDriverWaits.WaitUntilVisible(expiryDate);
        WebDriverWaits.SendKeys(expiryDate, expirtDateTxt);
    }

    public static void enterCardNumber(String cardNumberTxt) throws InterruptedException {
        WebDriverWaits.WaitUntilVisibleWE20(creditCardNumber);
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

    public static void clickPayNowBtn() {
        WebDriverWaits.scrollIntoView(payNow);
        WebDriverWaits.ClickOn(payNow);
    }

    public static void verify_CardNumberValidation_MSG(String expected) throws InterruptedException {
        String actual = WebDriverWaits.GetText(invalidCardNumberTxt);
        Assert.assertEquals(actual, expected);
        switchToWindow();
    }

    public static void verify_ExpiryDateValidation_MSG(String expected) throws InterruptedException {
        String actual = WebDriverWaits.GetText(invalidExpiryDateTxt);
        Assert.assertEquals(actual, expected);
        switchToWindow();
    }

    public static void verify_CvvValidation_MSG(String expected) throws InterruptedException {
        String actual = WebDriverWaits.GetText(invalidCvvTxt);
        Assert.assertEquals(actual, expected);
        switchToWindow();
    }
    public static void verify_PaymentSuccess_MSG(String expected) throws InterruptedException {
        Thread.sleep(5000);
        String actual = WebDriverWaits.GetText(transactionTypeText);
        Assert.assertEquals(actual, expected);
        switchToWindow();
    }

    public static void verify_CashPaySuccess_MSG(String expected) throws InterruptedException {
        Thread.sleep(1000);
        String actual = WebDriverWaits.GetText(paymentTypeText);
        Assert.assertEquals(actual, expected);
    }

    public static void verify_Amount_Validation_MSG(String expected) throws InterruptedException {
        Thread.sleep(1000);
        String actual = WebDriverWaits.GetText(amountInformationText);
        Assert.assertEquals(actual, expected);

    }

    public static void verify_Allow_DuplicateTXN(String expected) throws InterruptedException {
        Thread.sleep(1000);
        String actual = WebDriverWaits.GetText(amountTxt);
        Assert.assertEquals(actual, expected);

    }

    public static void verify_NotAllowed_DuplicateTXN(String expected) throws InterruptedException {
        Thread.sleep(1000);
        String actual = WebDriverWaits.GetText(duplicateErrorText);
        Assert.assertEquals(actual, expected);

    }

    public static void verify_TimeoutValidation_MSG(String expected) throws InterruptedException {
        switchToWindow();
        WebDriverWaits.WaitUntilVisibleWE80(requestTimeout);
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

    public static void verify_AccountNumber_Validation_MSG(String trxnType, String payMethod,String routingNumber, String accountNumber) throws InterruptedException {
        make_Payment(trxnType,payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterRoutingNumber(routingNumber);
        enterAccountNumber(accountNumber);

    }

    public static void verify_StateCode_Validation_MSG(String trxnType, String payMethod,String routingNumber, String accountType, String accountNumber,String state) throws InterruptedException {
        make_Payment(trxnType,payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterRoutingNumber(routingNumber);
        selctAccountType(accountType);
        enterAccountNumber(accountNumber);
        enterStateDetails(state);
    }

    public static void verify_ZipCode_Validation_MSG(String trxnType, String payMethod,String routingNumber, String accountType, String accountNumber,String zipCode) throws InterruptedException {
        make_Payment(trxnType,payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterRoutingNumber(routingNumber);
        selctAccountType(accountType);
        enterAccountNumber(accountNumber);
        enterZipCodeDetails(zipCode);
    }

    public static void verify_CityDetails_Validation_MSG(String trxnType, String payMethod,String routingNumber, String accountType, String accountNumber,String city) throws InterruptedException {
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
    }

    public static void verify_AddressDetails_Validation_MSG(String trxnType, String payMethod,String routingNumber, String accountType, String accountNumber) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterRoutingNumber(routingNumber);
        selctAccountType(accountType);
        enterAccountNumber(accountNumber);
        enterName();
        enterAddressDetails();
    }

    public static void verify_RoutingNumber_Validation_MSG(String trxnType, String payMethod,String routingNumber, String accountType, String accountNumber) throws InterruptedException {
        make_Payment(trxnType,payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        enterRoutingNumber(routingNumber);
        selctAccountType(accountType);
        enterAccountNumber(accountNumber);

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
        switchToWindow();
    }


    public static void payment_CCNumberLessThan_Allowed(String trxnType, String payMethod,String cardNumber ,String expiryDate) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
        Thread.sleep(3000);
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
        Thread.sleep(3000);
       // clickPayNowBtn();
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

    public static void payment_Timeout_CC(String trxnType, String payMethod) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
    }
    public static void payment_Timeout_BA(String trxnType, String payMethod) throws InterruptedException {
        make_Payment(trxnType, payMethod);
        switchToWindow();
        maximizePage();
        switchToFrame();
    }

}
