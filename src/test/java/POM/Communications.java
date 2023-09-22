package POM;

import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class Communications {

    public static By newCorrespondence = By.xpath("//*[@class='btn btn-large btn-primary']");
    public static By correspondenceType = By.id("corrTypeSelect");
    public static By sendEmailBtn = By.id("corrSendEmailBtn");
    public static By id = By.xpath("//tbody/tr[1]//td[1]");
    public static By service = By.xpath("//tbody/tr[1]//td[2]");
    public static By status = By.xpath("//tbody/tr[1]//td[5]");
    public static By email = By.xpath("//tbody/tr[1]//td[4]");
    public static By type = By.xpath("//tbody/tr[1]//td[3]");
    public static By dateandTime = By.xpath("//tbody/tr[1]//td[7]");
    public static By communicationsTab = By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div/ul/li[13]/a");

    public static SoftAssert softAssert = new SoftAssert();

    public static void clickNewCorrespondence() throws InterruptedException {
        WebDriverWaits.ClickOn(newCorrespondence);
    }

    public static void clickCommunicationTab() throws InterruptedException {
        WebDriverWaits.WaitUntilVisible(communicationsTab);
        WebDriverWaits.ClickOn(communicationsTab);
    }

    public static void enter_CorrespondenceDetails(String correspondenceTxt) throws InterruptedException {
        clickCommunicationTab();
        clickNewCorrespondence();
        selectCorrespondenceType(correspondenceTxt);
        validateID();
        clickSendEmail();
        validateService();

//        comm.validateStatus("Success");
//        comm.validateEmail("residential123@yopmail.com");
//        comm.validateType("Welcome Pack");
//        comm.validateDateTime();
//        comm.validateAddedBy("testreport+226@sqelabs.com");

    }

    public static void selectCorrespondenceType(String correspondenceTypeText) {
        WebDriverWaits.selectByVisibleText(correspondenceType, correspondenceTypeText);
    }

    public static void clickSendEmail() {
        WebDriverWaits.ClickOn(sendEmailBtn);
    }

    public void validateStatus(String statusText) {
        String actual = WebDriverWaits.GetText(status);
        System.out.println(actual);
        softAssert.assertEquals(actual, statusText);
        softAssert.assertAll();
    }

    public void validateType(String typeText) {
        String actual = WebDriverWaits.GetText(type);
        System.out.println(actual);
        softAssert.assertEquals(actual, typeText);
        softAssert.assertAll();
    }

    public void validateDateTime() {
        String actual = WebDriverWaits.GetText(dateandTime);
        System.out.println(actual);

    }

    public static void validateID() {
        String actual = WebDriverWaits.GetText(id);
        System.out.println(actual);
    }

    public static void validateService() {
        String actual = WebDriverWaits.GetText(service);
        System.out.println(actual);
    }

    public void validateAddedBy(String addedByText) {
        String actual = WebDriverWaits.GetText(type);
        softAssert.assertEquals(actual, addedByText);
    }
}
