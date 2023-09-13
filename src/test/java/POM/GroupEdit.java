package POM;

import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class GroupEdit  extends TestLogin {
    public static SoftAssert softAssert = new SoftAssert();

    public static By primary_front_id = By.id("primary_front_id");
    public static By primary_back_id = By.id("primary_back_id");
    public static By secondary_front_id = By.id("secondary_front_id");
    public static By secondary_back_id = By.id("secondary_back_id");

    public static By saveChangesBtn = By.id("saveChangesBtn");
    public static By alertSuccess = By.cssSelector(".alert.alert-success");

   // public static By save = By.className("btn btn-primary");
    public static By save = By.xpath("//button[text()='Save']");
    public static By editGroup = By.xpath("(//*[@class='fa fa-group'])[2]");
    public static By checkBoxCorrespondence = By.id("flag_enableCorrespondenceLetter");

    public static By correspondenceToggle = By.xpath("//*[@id='franchisee']/div[10]/div[2]/div[9]/div/label/span[1]");

    public static By saveChanges = By.xpath("//*[@class='btn btn-mini btn-primary']");
    public static By saveConfirmation = By.xpath("//*[@class='btn btn-primary']");
        public  static  void selectPrimaryInvoiceTemplate(String invoiceName) {
        WebDriverWaits.scrollIntoView(primary_front_id);
        WebDriverWaits.selectByVisibleText(primary_front_id,invoiceName);
            WebDriverWaits.selectByVisibleText(primary_back_id,invoiceName);

        }
    public  static  void selectSecondaryInvoiceTemplate(String invoiceName) {
        WebDriverWaits.scrollIntoView(primary_front_id);
        WebDriverWaits.selectByVisibleText(secondary_front_id,invoiceName);
        WebDriverWaits.selectByVisibleText(secondary_back_id,invoiceName);

    }
    public  static  void clickSave() {
        WebDriverWaits.scrollIntoView(saveChangesBtn);
       WebDriverWaits.ClickOn(saveChangesBtn);
       WebDriverWaits.WaitUntilVisible(save);
        WebDriverWaits.ClickOn(save);

    }
    public  static  void validateSuccessTxt() {
        WebDriverWaits.scrollIntoView(alertSuccess);
        String actual =WebDriverWaits.GetText(alertSuccess);
        softAssert.assertEquals(actual,"Success! Changes have been updated successfully.\n");
    }

    public  static  void validateSuccessText(String expected) {
        WebDriverWaits.scrollIntoView(alertSuccess);
        String actual =WebDriverWaits.GetText(alertSuccess);
        softAssert.assertEquals(actual,expected);
     //   softAssert.assertAll();
    }

    public static void navigateToEditGroup(){
        WebDriverWaits.ClickOn(editGroup);
    }

    public static void enableCorrepondenceToggle(){
        WebDriverWaits.scrollIntoView(checkBoxCorrespondence);
        WebDriverWaits.selectCheckBox(checkBoxCorrespondence);
    }
    public static void clickSaveChanges(){
        WebDriverWaits.scrollIntoView(saveChanges);
        WebDriverWaits.ClickOn(saveChanges);
    }

    public static void clickSaveConfirmation(){
        WebDriverWaits.ClickOn(saveConfirmation);
    }


}
