package POM;

import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class CorrespondenceSetup extends TestLogin {

    public static SoftAssert softAssert = new SoftAssert();

    public static String RandomName1;

    public static By correspondence = By.xpath("(//*[@class='col-lg-4 col-md-4 col-xs-4'])[35]");
    public static By createCorrespondence = By.xpath("(//*[@class='btn btn-primary'])[1]");
    public static By letterName = By.id("correspondence_name");

    public static By letterType = By.id("correspondence_type");

    public static By saveCorrespondence = By.id("saveCorrespondence");
    public static By saveThisCorrespondence = By.xpath("(//*[@id='saveTemplateCorrespondence'])[1]");
    public static By okMessage = By.xpath("(//*[@class='btn btn-primary'])[4]");
    public static By mceu_43 = By.id("mceu_43");

    public static By editCorrespondence = By.xpath("(//*[@class='btn btn-info'])[1]");

    public static By next = By.xpath("//*[@class='btn btn-success btn-next']");

    public static By deleteCorrespondence = By.xpath("(//*[@class='btn btn-danger'])[1]");

    public static By confirmDelete = By.xpath("(//*[@class='btn btn-primary'])[4]");

    public static By deleteIcons = By.xpath("//*[@class='btn btn-danger']");
    public static By uploadIcon = By.id("btnbrowseFile");
    public static By tmpAttFile = By.id("tmpAttFile");

    public static By deleteAttachments = By.xpath("//*[@id='importHistoryTable']/tbody/tr[1]/td[7]/a");

    public static By description = By.id("attDesc");

    public static By uploadFile = By.xpath("(//*[@class='btn btn-primary'])[3]");

    public static By validateText = By.xpath("(//*[@class='dataTables_info'])[2]");

    public static By searchBox = By.xpath("//*[@id=\"DataTables_Table_0_filter\"]/label/input");

    public static By validateDelete = By.xpath("(//*[@class='dataTables_empty'])[2]");

    public static By validateDeleteImport = By.xpath("//*[@class='dataTables_empty']");



    public static void navigateToCorrespondenceSetup() {
        WebDriverWaits.ClickOn(correspondence);
    }

    public static void clickCreateCorrespondence() {
        WebDriverWaits.ClickOn(createCorrespondence);
    }

    public static void enterLetterName(String letterNam) {
        WebDriverWaits.SendKeys(letterName,letterNam );
    }


    public static void selectLetterType(String letterText) {
        WebDriverWaits.selectByVisibleText(letterType, letterText);
    }

    public static void clickSaveCorrespondence() {
        WebDriverWaits.ClickOn(saveCorrespondence);

    }

    public static void clickSaveThisCorrespondence() throws InterruptedException {
     //   WebDriverWaits.scrollIntoView(saveThisCorrespondence);
        Thread.sleep(4000);

        WebDriverWaits.scrollIntoView(mceu_43);
        WebDriverWaits.scrollDown();
        WebDriverWaits.scrollDown();

        WebDriverWaits.WaitUntilVisible(saveThisCorrespondence);
        WebDriverWaits.ClickOn(saveThisCorrespondence);
    }

    public static void clickOkMessage() {
        WebDriverWaits.ClickOn(okMessage);
    }

    public static void clickEditCorrespondence() {
        WebDriverWaits.ClickOn(editCorrespondence);
    }

    public static void clickNext() {
        WebDriverWaits.ClickOn(next);

    }

    public static void clickDeleteCorrespondence() {
        WebDriverWaits.scrollIntoView(deleteCorrespondence);
        WebDriverWaits.ClickOn(deleteCorrespondence);

    }

    public static void clickConfirmDelete() {
        WebDriverWaits.ClickOn(confirmDelete);
    }

    public static void deleteIcons() {
        List<WebElement> countEditIcon = driver.findElements(deleteIcons);
        int sizeOfList = countEditIcon.size();
        boolean compareList = sizeOfList == 1;
        System.out.println(deleteIcons);
    }

    public static void clickUploadIcon() {
        WebDriverWaits.scrollIntoView(uploadIcon);
        WebDriverWaits.ClickOn(uploadIcon);
    }

    public static void clickDeleteAttachments() {
        WebDriverWaits.scrollIntoView(deleteAttachments);
        WebDriverWaits.ClickOn(deleteAttachments);
    }

    public static void uploadFile(String filepath) {
        WebDriverWaits.SendKeys(tmpAttFile, filepath);
    }
    public static void enterDescription(String descriptionText){
        WebDriverWaits.SendKeys(description,descriptionText);
    }

    public static void clickUploadFile() {
        WebDriverWaits.scrollIntoView(uploadFile);
        WebDriverWaits.ClickOn(uploadFile);
    }

    public static void searchCorrespondence(String searchText){
        WebDriverWaits.SendKeys(searchBox,searchText);
        System.out.println(searchText);
    }

    public  static  void validateUploadedFile(String expected) {
        WebDriverWaits.scrollIntoView(uploadFile);
        String actual =WebDriverWaits.GetText(validateText);
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    public  static  void validateDeleteImportAttachments(String expected) {
        WebDriverWaits.scrollIntoView(validateDeleteImport);
        String actual =WebDriverWaits.GetText(validateDeleteImport);
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }

    public  static  void validateDeleteCorrespondence(String expected) throws InterruptedException {
        String actual =WebDriverWaits.GetText(validateDelete);
        softAssert.assertEquals(actual,expected);
        softAssert.assertAll();
    }
}