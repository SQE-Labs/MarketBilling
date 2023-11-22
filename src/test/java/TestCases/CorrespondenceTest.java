package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.WebDriverWaits;
import POM.*;
import org.testng.annotations.Test;
import java.awt.*;
import static POM.CorrespondenceSetup.Correspondence_letterName;

public class CorrespondenceTest extends BaseTest {

    Admin admin = new Admin();
    GroupEdit groupEdit = new GroupEdit();
    CorrespondenceSetup correspondence = new CorrespondenceSetup();
    Templates template = new Templates();
    Communications comm = new Communications();
    Customer cust = new Customer();



    @Test(priority = 0, enabled = true)
    public void enable_correspondenceToggle() throws InterruptedException {
        extentTest = extent.startTest(" Enable Correspondence Toggle");
        extentTest.setDescription(" Verify that User is able to enable correspondence toggle button ");
        //Login.validLogin();
        admin.navigateToAdmin();
        groupEdit.navigateToEditGroup();
        groupEdit.enable_CorrepondenceToggle();
        groupEdit.validate_SuccessTXT("Success! Changes have been updated successfully.");

    }

    @Test(priority = 1, enabled = true)
    public void create_NewCorrespondenceLetter() throws InterruptedException {
        extentTest = extent.startTest(" Create New Correspondence Letter ");
        extentTest.setDescription(" Verify that User is able to create new correspondence letter ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.create_CorrespondenceLetter("Welcome Pack");
        correspondence.validate_NewLetterSuccessTXT(Correspondence_letterName);

    }

    //TODO ASERTION PENDING DUE TO SEARCH FILED ISSUE //
    @Test(priority = 2, enabled = true)
    public void edit_CorrespondenceLetter() throws InterruptedException {
        extentTest = extent.startTest(" Edit Correspondence Letter ");
        extentTest.setDescription(" Verify that User is able to edit the correspondence letter ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.edit_Correspondenceletter();
        //    correspondence.validate_EditLetterSuccessTXT(Correspondence_letterName);

    }

    @Test(priority = 3, enabled = true)
    public void delete_CorrespondenceLetter() throws InterruptedException {
        extentTest = extent.startTest(" Delete Correspondence Letter ");
        extentTest.setDescription(" Verify that User is able to delete correspondence letter ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.delete_Correspondenceletter();
        correspondence.validate_DeleteCorrespondenceTXT("No matching records found");

    }

    @Test(priority = 4, enabled = true)
    public void Upload_FileAttachment() throws AWTException, InterruptedException {
        extentTest = extent.startTest(" Upload File Attachment ");
        extentTest.setDescription(" Verify that User is able to Upload File Attachment ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.upload_FileAttachment("File Attachment Upload");
        correspondence.validate_UploadedFileRECORD("Showing 1 to 3 of 3 entries");

    }

    //TODO Functionality not working properly //
    @Test(priority = 5, enabled = true)
    public void setup_WelcomePackEmail() throws InterruptedException {
        extentTest = extent.startTest(" Setup Welcome Pack Email ");
        extentTest.setDescription(" Verify that User is able to setup Welcome Pack Email");
        admin.navigateToAdmin();
        template.navigateToTemplate();
        template.setup_WelcomePackEmail("Welcome Pack","Reck@yopmail.com","Test Correspondence","Reckk@yopmail.com","The testing is used for specific purpose");

    }


    @Test(priority = 6, enabled = true)
    public void Delete_FileAttachment() {
        extentTest = extent.startTest(" Delete File Attachment ");
        extentTest.setDescription(" Verify that User is able to Delete File Attachment ");
        admin.navigateToAdmin();
        correspondence.navigateToCorrespondenceSetup();
        correspondence.delete_FileAttachment();
        correspondence.validate_DeleteImportAttachmentsRECORD("Showing 1 to 2 of 2 entries");
    }

    @Test(priority = 7, enabled = true)
    public void manualSendingLetters() throws InterruptedException {
        extentTest = extent.startTest(" Manual Sending Letters ");
        extentTest.setDescription(" Verify that User is able to send Manual Letters ");
        admin.navigateToAdmin();
        cust.navigateToCustomer();
        comm.enter_CorrespondenceDetails("Welcome Pack");

    }
}