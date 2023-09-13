package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;

public class Transactions extends TestLogin {


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
    public static By nameOnAccount = By.id("account-holder-name");
    public static By address = By.id("account-address-line1");
    public static By city = By.id("account-city");
    public static By state = By.id("account-region-code");
    public static By zip = By.id("account-postal-code");
    public static By routingNumber = By.id("routing-number");
    public static By submit = By.id("card-submit-button");



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

    public static void payment_CreditCard(String trxnType, String payMethod) throws InterruptedException {
        WebDriverWaits.ClickOn(transactionTab);
        WebDriverWaits.selectByVisibleText(transactionType, trxnType);
        WebDriverWaits.selectByVisibleText(paymentMethod, payMethod);
        String RandomAmount = "20" + RandomStrings.RequiredCharacters(2);
        WebDriverWaits.SendKeys(amount, RandomAmount);
        WebDriverWaits.ClickOn(transactionDate);
        WebDriverWaits.ClickOn(activeDate);
        WebDriverWaits.ClickOn(allowDupes);
        WebDriverWaits.scrollIntoView(comments);
        WebDriverWaits.SendKeys(comments, trxnType + " " + payMethod);
        WebDriverWaits.scrollIntoView(makePayment);
        WebDriverWaits.ClickOn(makePayment);
        WebDriverWaits.ClickOn(ok);
        Thread.sleep(5000);
        WebDriverWaits.SwitchToNewTab();
        driver.manage().window().maximize();
        WebDriverWaits.SwitchToParentFrame();
        WebDriverWaits.SendKeys(creditCardNumber, "4200000000000000");
        WebDriverWaits.SendKeys(expiryDate, "03/24");
        WebDriverWaits.SendKeys(cVV, "142");
        WebDriverWaits.selectByVisibleText(billingAddress, "Australia");
        WebDriverWaits.scrollIntoView(payNow);
        WebDriverWaits.ClickOn(payNow);


    }

    public static void payment_BankAccount(String trxnType, String payMethod) throws InterruptedException {
        WebDriverWaits.ClickOn(transactionTab);
        WebDriverWaits.selectByVisibleText(transactionType, trxnType);
        WebDriverWaits.selectByVisibleText(paymentMethod, payMethod);
        String RandomAmount = "10" + RandomStrings.RequiredCharacters(2);
        WebDriverWaits.SendKeys(amount, RandomAmount);
        WebDriverWaits.ClickOn(transactionDate);
        WebDriverWaits.ClickOn(activeDate);
        WebDriverWaits.ClickOn(allowDupes);
        WebDriverWaits.scrollIntoView(comments);
        WebDriverWaits.SendKeys(comments, trxnType + " " + payMethod);
        WebDriverWaits.scrollIntoView(makePayment);
        WebDriverWaits.ClickOn(makePayment);
        WebDriverWaits.ClickOn(ok);
        Thread.sleep(5000);
        WebDriverWaits.SwitchToNewTab();
        driver.manage().window().maximize();
        WebDriverWaits.SwitchToParentFrame();
        WebDriverWaits.SendKeys(routingNumber,"021000021");
        WebDriverWaits.ClickOn(accountType);
        WebDriverWaits.selectByVisibleText(accountType,"Personal Savings");
        WebDriverWaits.SendKeys(accountNumber,"1368513884");
        WebDriverWaits.SendKeys(nameOnAccount,"Levis");
        WebDriverWaits.SendKeys(address,"66");
        WebDriverWaits.SendKeys(city,"Victoria");
        WebDriverWaits.SendKeys(state,"CA");
        WebDriverWaits.SendKeys(zip,"91001");
        WebDriverWaits.WaitUntilVisible(submit);
        WebDriverWaits.ClickOn(submit);
//      Submit button is not working so we are not able to add assertions.

    }
}
