package POM;

import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static POM.Invoice.invoiceName;

public class GroupEdit extends TestLogin {

    public static By primary_front_id = By.id("primary_front_id");
    public static By primary_back_id = By.id("primary_back_id");
    public static By secondary_front_id = By.id("secondary_front_id");
    public static By secondary_back_id = By.id("secondary_back_id");
    public static By saveChangesBtn = By.id("saveChangesBtn");
    public static By alertSuccess = By.cssSelector(".alert.alert-success");
    public static By save = By.xpath("//button[text()='Save']");
    public static By editGroup = By.xpath("(//*[@class='fa fa-group'])[2]");
    public static By checkBoxCorrespondence = By.id("flag_enableCorrespondenceLetter");
    public static By saveChanges = By.xpath("//*[@class='btn btn-mini btn-primary']");
    public static By saveConfirmation = By.xpath("//*[@class='btn btn-primary']");

    public static SoftAssert softAssert = new SoftAssert();


    public static void selectPrimaryInvoiceTemplate(String invoiceName) {
        WebDriverWaits.scrollIntoView(primary_front_id);
        WebDriverWaits.selectByVisibleText(primary_front_id, invoiceName);
        WebDriverWaits.selectByVisibleText(primary_back_id, invoiceName);

    }

    public static void selectSecondaryInvoiceTemplate(String invoiceName) {
        WebDriverWaits.scrollIntoView(primary_front_id);
        WebDriverWaits.selectByVisibleText(secondary_front_id, invoiceName);
        WebDriverWaits.selectByVisibleText(secondary_back_id, invoiceName);

    }

    public static void clickSaveBtn() {
        WebDriverWaits.scrollIntoView(saveChangesBtn);
        WebDriverWaits.ClickOn(saveChangesBtn);
        WebDriverWaits.WaitUntilVisible(save);
        WebDriverWaits.ClickOn(save);

    }

    public static void invoice_Settings() {
        selectPrimaryInvoiceTemplate(invoiceName);
        selectSecondaryInvoiceTemplate(invoiceName);
        clickSaveBtn();
    }

    public static void validate_SuccessTxt(String expected) {
        WebDriverWaits.scrollIntoView(alertSuccess);
        String actual = WebDriverWaits.GetText(alertSuccess);
        softAssert.assertEquals(actual, expected);
    }

    public static void validate_SuccessTXT(String expected) throws InterruptedException {
        WebDriverWaits.scrollIntoView(alertSuccess);
        String actual = WebDriverWaits.GetText(alertSuccess);
        softAssert.assertEquals(actual, expected);
        softAssert.assertAll();
    }

    public static void navigateToEditGroup() {
        WebDriverWaits.ClickOn(editGroup);
    }


    public static void enable_CorrepondenceToggle() {
        WebDriverWaits.scrollIntoView(checkBoxCorrespondence);
        WebDriverWaits.selectCheckBox(checkBoxCorrespondence);
        click_SaveChangesBtn();
        click_SaveConfirmationBtn();
    }

    public static void click_SaveChangesBtn() {
        WebDriverWaits.scrollIntoView(saveChanges);
        WebDriverWaits.ClickOn(saveChanges);
    }

    public static void click_SaveConfirmationBtn() {
        WebDriverWaits.ClickOn(saveConfirmation);
    }

}
