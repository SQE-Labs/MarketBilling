package POM;

import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class Communications {

    public static SoftAssert softAssert = new SoftAssert();
    //C:\Users\Itsqe\Downloads\LetterSample.pdf
    public static By newCorrespondence = By.xpath("//*[@class='btn btn-large btn-primary']");
   // public static By newCorrespondence = By.xpath("//button[@class='btn btn-large btn-primary']");

    public static By correspondenceType = By.id("corrTypeSelect");

    public static By sendEmailBtn = By.id("corrSendEmailBtn");

    public static By id = By.xpath("//tbody/tr[1]//td[1]");

    public static By service = By.xpath("//tbody/tr[1]//td[2]");

    public static By status = By.xpath("//tbody/tr[1]//td[5]");

    public static By email = By.xpath("//tbody/tr[1]//td[4]");

    public static By type = By.xpath("//tbody/tr[1]//td[3]");

    public static By dateandTime = By.xpath("//tbody/tr[1]//td[7]");

    public static By addedBy = By.xpath("//tbody/tr[1]//td[8]");
    public static void clickNewCorrespondence() throws InterruptedException {
        WebDriverWaits.ClickOn(newCorrespondence);
    }

    public void selectCorrespondenceType(String correspondenceTypeText) {
        WebDriverWaits.selectByVisibleText(correspondenceType,correspondenceTypeText);
    }

    public void clickSendEmail() {
        WebDriverWaits.ClickOn(sendEmailBtn);
    }

    public void validateStatus(String statusText){
        String actual =WebDriverWaits.GetText(status);
        System.out.println(actual);
        softAssert.assertEquals(actual,statusText);
        softAssert.assertAll();
    }

    public void validateEmail(String emailText){
        String actual =WebDriverWaits.GetText(email);
        System.out.println(actual);
        softAssert.assertEquals(actual,emailText);
        softAssert.assertAll();

    }

    public void validateType(String typeText){
        String actual =WebDriverWaits.GetText(type);
        System.out.println(actual);
        softAssert.assertEquals(actual,typeText);
        softAssert.assertAll();
    }

    public void validateDateTime(){
        String actual =WebDriverWaits.GetText(dateandTime);
        System.out.println(actual);

    }
    public void validateID(){
        String actual =WebDriverWaits.GetText(id);
        System.out.println(actual);
    }
    public void validateService(){
        String actual =WebDriverWaits.GetText(service);
        System.out.println(actual);
    }

    public void validateAddedBy(String addedByText){
        String actual =WebDriverWaits.GetText(type);
        softAssert.assertEquals(actual,addedByText);
    }
}
