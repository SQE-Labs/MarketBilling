package POM;

import CommonMethods.BaseTest;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class Templates extends BaseTest {

    public static SoftAssert softAssert = new SoftAssert();

    public static By template = By.xpath("(//*[@class='quick-button-small'])[16]");

    public static By messageType = By.id("email_message_type");

    public static By emailFrom = By.id("email_rem_from");

    public static By emailSubject = By.id("email_rem_subject");

    public static By save = By.xpath("//button/span[text()='Save']");

    public static By fileAttachments = By.xpath("(//*[@class='filter-option pull-left'])[2]");

    public static By attachCorrespondenceLetter = By.xpath("//*[@id='corr_attachment_letter']/td[2]/div/button/span[1]");

    public static By emailMessage = By.xpath("//*[@id='email_rem_message-wysiwyg-iframe']");

    public static By successMessage = By.xpath("(//*[@class='message'])[2]");

    public static By demoFileAttachments = By.xpath("(//*[@class='message'])[2]");

    public static By demoFttachCorrespondenceLetter = By.xpath("(//*[@class='message'])[2]");

    public static By preview = By.xpath("//button/span[text()='Preview' ]");

    public static By validate = By.xpath("//button/span[text()='Validate' ]");
    public static By crossValidate = By.xpath("(//*[@class='close'])[2]");

    public static By crossPreview = By.xpath("(//*[@class='close'])[1]");
    public static By email = By.xpath("//*[@id='myTab']/li[1]/a");

    //*[@id="corr_attachment_letter"]/td[1]
    public void navigateToTemplate() {
        WebDriverWaits.ClickOn(template);
    }

    public void clickSaveButton() {
        WebDriverWaits.ClickOn(save);
    }

    public void clickEmail() {
        WebDriverWaits.ClickOn(email);
    }

    public void clickPreviewButton() {
        WebDriverWaits.ClickOn(preview);
    }

    public void clickValidateButton() {
        WebDriverWaits.ClickOn(validate);
    }

    public void clickCrossValidate() {
        WebDriverWaits.ClickOn(crossValidate);
    }

    public void clickCrossPreview() {
        WebDriverWaits.ClickOn(crossPreview);
    }

    public void selectMessageType(String mesgType) {
        WebDriverWaits.selectByVisibleText(messageType,mesgType);
    }

    public void selectEmailFrom(String emailText){
        WebDriverWaits.SendKeys(emailFrom, emailText);
    }

    public void enterEmailMessage(String emailMessageText) throws InterruptedException {
         Thread.sleep(1000);
        WebDriverWaits.SendKeys(emailMessage, emailMessageText);
        //WebDriverWaits.scrollIntoView(validate);
    }

    public void enterSubject(String subjectText) {
        WebDriverWaits.SendKeys(emailSubject, subjectText);
        WebDriverWaits.scrollIntoView(validate);
    }

    public void selectAttachLetter(String selectLetterText) throws InterruptedException {
        WebDriverWaits.ClickOn(attachCorrespondenceLetter);
        WebDriverWaits.ClickOn(By.xpath("//ul/li/a/span[contains(text(),'"+selectLetterText+"')]"));
    }

    public void selectFileAttachments(String selectValueText) {
        WebDriverWaits.ClickOn(fileAttachments);
        WebDriverWaits.ClickOn(By.xpath("//ul/li/a/span[contains(text(),'"+selectValueText+"')]"));

    }

    public  static  void validateSuccessTxt(String expected ) {
        String actual =WebDriverWaits.GetText(successMessage);
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

}
