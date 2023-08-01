package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import POM.*;
import org.testng.annotations.Test;
import java.awt.*;

public class CorrespondenceTest extends BaseTest {
    String fileName;
    Admin admin = new Admin();
    GroupEdit groupEdit = new GroupEdit();
    CorrespondenceSetup correspondence = new CorrespondenceSetup();

    Templates template = new Templates();
    final String SUCCESS = "Successfully saved message.";
    String letterName;

    @Test(priority = 0,enabled = true)
    public void enable_correspondence() throws InterruptedException {
        extentTest = extent.startTest(" Enable Correspondence Toggle");
        extentTest.setDescription(" Verify that User is able to enable correspondence toggle button ");
        Login.loginWithGroupName("Testing1228");
        admin.navigateToAdmin();
        groupEdit.navigateToEditGroup();
        groupEdit.enableCorrepondenceToggle();
        groupEdit.clickSaveChanges();
        groupEdit.clickSaveConfirmation();
        groupEdit.validateSuccessText("Success! Changes have been updated successfully.");
    }

    @Test(priority = 1,enabled = true)
    public void createNewCorrespondenceLetter() throws InterruptedException {
        extentTest = extent.startTest(" Create New Correspondence Letter ");
        extentTest.setDescription(" Verify that User is able to create new correspondence letter ");
        //Login.loginWithGroupName("Testing1228");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickCreateCorrespondence();
        letterName = "Letter" + RandomStrings.RequiredCharacters(4);
        correspondence.enterLetterName(letterName);
        correspondence.selectLetterType("Welcome Pack");
        correspondence.clickSaveCorrespondence();
        correspondence.clickSaveThisCorrespondence();
        correspondence.clickOkMessage();
        correspondence.clickNext();
        //correspondence.clickBackToCorrespondence();
        correspondence.searchCorrespondence(letterName);
    }

    @Test(priority = 2,enabled = true)
    public void editCorrespondenceLetter() {
        extentTest = extent.startTest(" Edit Correspondence Letter ");
        extentTest.setDescription(" Verify that User is able to edit the correspondence letter ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickEditCorrespondence();
        correspondence.enterLetterName(letterName);
        correspondence.clickSaveCorrespondence();
        correspondence.clickNext();
        correspondence.clickNext();

    }

    @Test(priority = 3,enabled = true)
    public void deleteCorrespondenceLetter() throws InterruptedException {
        extentTest = extent.startTest(" Delete Correspondence Letter ");
        extentTest.setDescription(" Verify that User is able to delete correspondence letter ");
       // Login.loginWithGroupName("Testing1228");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickDeleteCorrespondence();
        correspondence.clickConfirmDelete();
        //correspondence.searchCorrespondence(letterName);
        //correspondence.validateDeleteCorrespondence("No data available in table");

    }

    @Test(priority = 4)
    public void UploadFileAttachment() throws AWTException, InterruptedException {
        extentTest = extent.startTest(" Upload File Attachment ");
        extentTest.setDescription(" Verify that User is able to Upload File Attachment ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickUploadIcon();
        Thread.sleep(4000);
        fileName = "LetterSample.pdf";
        //String filepath = "C:\\Users\\Itsqe\\Downloads\\MarketBilling\\TestData\\" + fileName;
        String filepath = "C:\\Users\\Itsqe\\Downloads\\" + fileName;

        WebDriverWaits.uploadFileUsingRobot(filepath);
        Thread.sleep(2000);
        correspondence.enterDescription("DescriptionTest");
        correspondence.clickUploadFile();
        //correspondence.validateUploadedFile("Showing 1 to 1 of 1 entries");

    }

    @Test(priority = 5,enabled = false)
    public void setupWelcomePackEmail() throws InterruptedException {
        extentTest = extent.startTest(" Setup Welcome Pack Email ");
        extentTest.setDescription(" Verify that User is able to setup Welcome Pack Email");
        admin.navigateToAdmin();
        template.navigateToTemplate();
        template.selectMessageType("Welcome Pack");
        template.selectEmailFrom("Reck@yopmail.com");
        template.enterSubject("Test Correspondence");
        template.enterEmailMessage("This Email is for Testing Purpose");
        template.selectAttachLetter(letterName);
        Thread.sleep(2000);
        template.selectFileAttachments(fileName);
        Thread.sleep(2000);
        template.clickPreviewButton();
        template.clickCrossPreview();
        template.clickValidateButton();
        template.clickCrossValidate();
        template.clickSaveButton();
        template.validateSuccessTxt("Successfully saved message.");

    }

    @Test(priority = 6)
    public void DeleteFileAttachment() {
        extentTest = extent.startTest(" Delete File Attachment ");
        extentTest.setDescription(" Verify that User is able to Delete File Attachment ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickDeleteAttachments();
        correspondence.clickOkMessage();
        // correspondence.validateDeleteImportAttachments("No data available in table");
    }

    @Test(priority = 7,enabled = false)
    public void manualSendingLetters() throws InterruptedException {
        extentTest = extent.startTest(" Manual Sending Letters ");
        extentTest.setDescription(" Verify that User is able to send Manual Letters ");
        //Login.loginWithGroupName("Testing1228");
        admin.navigateToAdmin();
        admin.clickSearchIcon();
        Customer customer = admin.clickRecentCustomerId();
        WebDriverWaits.SwitchToNewTab();
        Communications comm = customer.clickCommunications();
        comm.clickNewCorrespondence();
        comm.selectCorrespondenceType("Welcome Pack");
        comm.clickSendEmail();
        comm.validateID();
        comm.validateService();
        comm.validateStatus("Success");
        comm.validateEmail("residential123@yopmail.com");
        comm.validateType("Welcome Pack");
        comm.validateDateTime();
        comm.validateAddedBy("testreport+226@sqelabs.com");

    }
}
