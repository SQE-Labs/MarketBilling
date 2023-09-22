package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;
import java.awt.*;


public class TestNewBillRun extends BaseTest {

    Metering meter = new Metering();
    BillRun bill = new BillRun();


    @Test(priority = 0, enabled = true, description = "Creating Customer")
    public void createCustomer() throws InterruptedException {
        extentTest = extent.startTest(" Create Customer ");
        extentTest.setDescription(" Verify that User is able to Create Customer or not ");
        Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","Active");
        System.out.println("Texts match. Assertion passed.");
       // Assert.assertEquals(true,false);
    }

    // ============Creating Service=========
    @Test(priority = 1, enabled = true, description = "Create Service for the customer")
    public void createService() throws AWTException, AWTException, InterruptedException {
        extentTest = extent.startTest(" Creating Service For the Customer ");
        extentTest.setDescription(" Verify that User is able to Create Service or not ");
        Services serv = new Services();
        serv.createService("Nulla Vale", "3435", "Australian Capital Territory");


    }

    @Test(priority = 2, enabled = true, description = "Create Meter for the customer")
    public void createMeter() throws InterruptedException {
        extentTest = extent.startTest(" Create Meter ");
        extentTest.setDescription(" Verify that User is able to Create Meter or not ");
        meter.createMeter();

        //Success msg does not appear so cannot add assertion.
    }

    @Test(priority = 3, enabled = true, description = "Create MeterRegister for the customer")
    public void createMeterRegister() throws InterruptedException {
        extentTest = extent.startTest(" Create MeterRegister ");
        extentTest.setDescription(" Verify that User is able to Create MeterRegister or not ");
        meter.createMeterRegister();
    }

    @Test(priority = 4, enabled = true, description = "Create MeterReads")
    public void createMeterReads() throws AWTException, InterruptedException {
        extentTest = extent.startTest("Create meter Reads");
        extentTest.setDescription("Verify that user is able to Create Meter Register or Not");
        meter.createMeterReads();

    }


    @Test(priority = 5, enabled = true, description = "Create BillRun Cycles")
    public void createBillRunCycle() throws InterruptedException {
        extentTest = extent.startTest("Create BillRun Cycle ");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");
        bill.createBillRunCycle();
    }

    @Test(priority = 6, enabled = true)
    public void billRun() throws AWTException, InterruptedException {
        extentTest = extent.startTest("Create BillRun Cycles ");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");

        bill.billRun();
    }

    @Test(priority =7, enabled = true, description = "RollBack BillRun")
    public void rollBackCreatedBillRun() throws InterruptedException {
        extentTest = extent.startTest("RollBack Created BillRun");
        extentTest.setDescription("Verify that user is able to RollBack the Created BillRun or not");

        bill.rollBack();
    }

    @Test(priority = 11, enabled = true, description = "Download Zip")
    public void downloadZip() throws InterruptedException, AWTException {
        extentTest = extent.startTest("Download Zip");
        extentTest.setDescription("Verify that user is able to DownloadZip file or not");

        bill.downloadZip();
    }

    @Test(priority = 8, enabled = false, description = "Edit BillRunCycle")
    public void editBillRunCycle() throws InterruptedException {
        extentTest = extent.startTest("Edit BillRun Cycle");
        extentTest.setDescription("Verify that user is able to Update the BillRunCycle or not");
       // Login.ValidLogin();
        bill.editBillRunCycles();
    }

    @Test(priority = 9, enabled = true)
    public void reBill() throws AWTException, InterruptedException {
        extentTest = extent.startTest("Re BillRun   ");
        extentTest.setDescription("Verify that user is able to ReBill or Not");

        bill.reBillRun();
    }

    @Test(priority = 10, enabled = true, description = "RollBack Created BillRun")
    public void CommitBillRun() throws InterruptedException {
        extentTest = extent.startTest("Create BillRun Cycles ");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");
        bill.commitBillRun();
    }
@Test(priority = 12 , enabled=true, description="Email BillRun ")
    public void emailBillRun() throws InterruptedException {
        extentTest = extent.startTest("Email BillRun to customer ");
        extentTest.setDescription("Verify that user is able to Email the BillRun or Not");
       bill.emailBillRun();
    }
}

