package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.RandomStrings;
import POM.*;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;




public class TestNewBillRun extends BaseTest {

        Metering meter=new Metering();
        BillRun bill=new BillRun() ;

        String CustomerFirstName;
        String CustomersurName;
        String expectedCustomertext="Successfully saved customer.";
        String expectedText = "The Service has been created successfully.";
        String expectedservicetext="The Service has been created successfully.";
        String expectedmeterregisterText = "Successfully created meter register.";
        String expectedBusinessSuccessMessage="Success! Changes have been updated successfully.";
        String expectedBillSuccessMessage = "Successfully added new bill run cycle.";
        String expBillRunSuccessText = "Showing 1 to 1 of 1 entries (filtered from 37 total entries)";

        // String expectedText="Successfully saved customer.";
        // BrowsersInvoked ss =new BrowsersInvoked();
        // String ActualText =
        // BrowsersInvoked.driver.findElement(By.xpath("//center[text()='Successfully
        // saved customer.']")).getText();

        @Test(priority = 0, enabled = true, description = "Creating Customer")
        public void CreateCustomer() {
            extentTest = extent.startTest(" Create Customer ");
            extentTest.setDescription(" Verify that User is able to Create Customer or not ");

            Customer cust =new Customer();

           Login.loginWithGroupName("Test Utilities");


            cust.CreateCustomer("12345678958","456789145", "24 Railway Street","Woondul", "Australia", "NSW","4357");
            System.out.println("Texts match. Assertion passed.");
        }

        // ============Creating Service=========
        @Test(priority = 1, enabled = true, description = "Create Service for the customer")
        public void CreatingService() throws AWTException, AWTException, InterruptedException {
            extentTest = extent.startTest(" Creating Service For the Customer ");
            extentTest.setDescription(" Verify that User is able to Create Service or not ");
        //    Login.loginWithGroupName("Test Utilities");
            Services service=new Services();


             service.CreateService("Nulla Vale", "3435","Australian Capital Territory");


        }

       @Test (priority = 2, enabled = true, description = "Create Meter for the customer")
        public void CreatingMeter() throws InterruptedException {
            extentTest = extent.startTest(" Create Meter ");
            extentTest.setDescription(" Verify that User is able to Create Meter or not ");

            meter.CreateMeter();


            //assertion misisig
        }

        @ Test(priority = 3, enabled = true, description = "Creating MeterRegister for the customer")
        public void CreateMeterRegister() {
            extentTest = extent.startTest(" Create MeterRegister ");
            extentTest.setDescription(" Verify that User is able to Create MeterRegister or not ");

             meter.CreateMeterRegister();



        }

        @ Test(priority = 4, enabled = true, description = "Create MeterReads")
        public void CreateMeterReads() throws AWTException, InterruptedException {
            extentTest = extent.startTest("Create meter Reads");
            extentTest.setDescription("Verify that user is able to Create Meter Register or Not");
             meter.CreateMeterReads();
        }


        @Test(priority = 5, enabled = true, description = "Creating BillRun Cycles")
        public void CreateBillRunCycles() throws InterruptedException {
            extentTest = extent.startTest("Creating BillRun Cycles ");
            extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");

             bill.CreateBillRunCycle();
        }

        @Test(priority = 6,enabled = true)
        public void CreateBillRun() throws AWTException, InterruptedException {
            extentTest = extent.startTest("Creating BillRun Cycles ");
            extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");

             bill.BillRun();
        }

        @Test(priority = 7, enabled = true, description = "Commiting BillRun")
        public void CommitCreatedBillRun() throws AWTException, InterruptedException {
            extentTest = extent.startTest("Committing Created BillRun");
            extentTest.setDescription("Verify that user is able to Commit the Created BillRun or not");

            bill.CommitBillRun();
        }

        @Test(priority = 9, enabled = true, description = "RollBack BillRun")
        public void RollBackCreatedBillRun() throws InterruptedException {
            extentTest = extent.startTest("RollBack Created BillRun");
            extentTest.setDescription("Verify that user is able to RollBack the Created BillRun or not");

            bill. RollBack();
        }

        @Test(priority = 8, enabled = true, description = "Download Zip")
        public void DownloadZip() throws InterruptedException, AWTException {
            extentTest = extent.startTest("Download Zip");
            extentTest.setDescription("Verify that user is able to DownloadZip file or not");

             bill.DownloadZip();
        }
    }

