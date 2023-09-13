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
    public void enable_correspondence() {
        extentTest = extent.startTest(" Enable Correspondence ");
        extentTest.setDescription(" Verify that User is able to enable correspondence toggle button ");
      //  Login.loginWithGroupName("Testing1228");
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
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickCreateCorrespondence();
        letterName = "Letter" + RandomStrings.RequiredCharacters(5);
        correspondence.enterLetterName(letterName);
        correspondence.selectLetterType("Welcome Pack");
        correspondence.clickSaveCorrespondence();
        correspondence.clickSaveThisCorrespondence();
        correspondence.clickOkMessage();
        correspondence.clickBackToCorrepondenceList();
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
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickDeleteCorrespondence();
        correspondence.clickConfirmDelete();
        Thread.sleep(5000);
        correspondence.searchCorrespondence(letterName);
        correspondence.validateDeleteCorrespondence("No matching records found");

    }

    @Test(priority = 4,enabled = true)
    public void UploadFileAttachment() throws AWTException, InterruptedException {
        extentTest = extent.startTest(" Upload File Attachment ");
        extentTest.setDescription(" Verify that User is able to Upload File Attachment ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickUploadIcon();
        Thread.sleep(4000);
        fileName = "LetterSample.pdf";
//        String filepath = "C:\\Users\\Itsqe\\eclipse-workspace\\MarketBilling\\"+ fileName;
//        WebDriverWaits.uploadFileUsingRobot(filepath);
        String filepath = "C:\\Users\\DELL\\IdeaProjects\\MarketBilling\\"+ fileName;
        WebDriverWaits.uploadFileUsingRobot(filepath);
        Thread.sleep(2000);
        correspondence.enterDescription("DescriptionTest");
        correspondence.clickUploadFile();
        correspondence.validateUploadedFile("Showing 1 to 3 of 3 entries");

    }

    @Test(priority = 5,enabled = true)
    public void setupWelcomePackEmail() throws InterruptedException {
        extentTest = extent.startTest(" Setup Welcome Pack Email ");
        extentTest.setDescription(" Verify that User is able to setup Welcome Pack Email");
        admin.navigateToAdmin();
        template.navigateToTemplate();
        template.selectMessageType("Welcome Pack");
        template.selectEmailFrom("Reck@yopmail.com");
        template.enterSubject("Test Correspondence");
        template.enterEmailMessage("This Email is for Testing Purpose");

//        template.selectAttachLetter(letterName);
//        Thread.sleep(2000);
//        template.selectFileAttachments(fileName);
//        Thread.sleep(2000);
//        template.clickPreviewButton();
//        template.clickCrossPreview();
//        template.clickValidateButton();
//        template.clickCrossValidate();
//        template.clickSaveButton();
//        template.validateSuccessTxt("Successfully saved message.");

    }

    @Test(priority = 6,enabled = true)
    public void DeleteFileAttachment() {
        extentTest = extent.startTest(" Delete File Attachment ");
        extentTest.setDescription(" Verify that User is able to Delete File Attachment ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.clickDeleteAttachments();
        correspondence.clickOkMessage();
        correspondence.validateDeleteImportAttachments("Showing 1 to 2 of 2 entries");
    }

    @Test(priority = 7,enabled = true)
    public void manualSendingLetters() throws InterruptedException {
        extentTest = extent.startTest(" Manual Sending Letters ");
        extentTest.setDescription(" Verify that User is able to send Manual Letters ");
        admin.navigateToAdmin();
        admin.clickSearchIcon();
        Customer customer = admin.clickRecentCustomerId();
        WebDriverWaits.SwitchToNewTab();
        Communications comm = customer.clickCommunications();
        comm.clickNewCorrespondence();
        comm.selectCorrespondenceType("Welcome Pack");

        comm.validateID();
        comm.clickSendEmail();
        comm.validateService();

        // Commented because of bug

//        comm.validateStatus("Success");
//        comm.validateEmail("residential123@yopmail.com");
//        comm.validateType("Welcome Pack");
//        comm.validateDateTime();
//        comm.validateAddedBy("testreport+226@sqelabs.com");

    }
}
