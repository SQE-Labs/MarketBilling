package POM;

import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.testng.Assert;

public class Payments extends TestLogin {

    public static By payments = By.xpath(" (//a[@class='quick-button-small'])[20]");
    public static By accessToken = By.xpath("//input[@id='gateway_connect_key_add']");
    public static By modify = By.xpath("//button[@id='modifyBttn']");
    public static By successMessageText = By.xpath("//p[@class='message']");
    public static By validationMessageText = By.xpath("//*[@id=\"utbFrmDiv\"]/div[2]/div/div/center/strong/p");

    public static void validToken(String tokenText){
        WebDriverWaits.ClickOn(payments);
        WebDriverWaits.SendKeysWithClear(accessToken,tokenText);
        WebDriverWaits.scrollPageEnd();
        WebDriverWaits.ClickOn(modify);

    }

   public static void invalidToken(String tokenText) throws InterruptedException {
        WebDriverWaits.scrollIntoView(payments);
       WebDriverWaits.ClickOn(payments);
       WebDriverWaits.SendKeysWithClear(accessToken,tokenText);
       Thread.sleep(2000);
       WebDriverWaits.scrollIntoView(modify);
       WebDriverWaits.ClickOn(modify);

   }

    public static void verify_Token_Success_MSG(String expected) throws InterruptedException {
        Thread.sleep(1000);
        WebDriverWaits.WaitUntilVisible(successMessageText);
        String actual = WebDriverWaits.GetText(successMessageText);
        Assert.assertEquals(actual,expected);

    }

    public static void verify_Token_Validation_MSG(String expected) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWaits.WaitUntilVisible(validationMessageText);
        String actual = WebDriverWaits.GetText(validationMessageText);
        Assert.assertEquals(actual,expected);

    }
}
