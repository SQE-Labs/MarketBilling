package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class TestNewBillRun extends BaseTest {

    public static String customerID;
    public static String serviceId;
    public static String meterId;
    public static String meterReg;
    public static String billRunCycle;
    public static String  billCycleName;
    Metering meter = new Metering();



    @Test(priority = 0, enabled = true, description = "Creating Customer")
    public void createCustomer() throws InterruptedException {
        extentTest = extent.startTest(" Create Customer ");
        extentTest.setDescription(" Verify that User is able to Create Customer or not ");
    //
        //    Login.validLogin();
        customerID=Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","10","Active");
        System.out.println("Texts match. Assertion passed.");
        serviceId=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
        Services.editService("Connected");
        meterId=Metering.AddMeter();
        meterReg=Metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");


    }

    @Test(priority = 2, enabled = true, description = "Create BillRun Cycles")
    public void createBillRunCycle() throws InterruptedException, AWTException {
        extentTest = extent.startTest("Create BillRun Cycle ");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");
         billRunCycle = BillRun.BillRunCycle(customerID);

    }

    @Test(priority = 3, enabled = true)
    public void billRun() throws AWTException, InterruptedException {
        extentTest = extent.startTest("Create BillRun Cycles ");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");
        BillRun.SmallBillRunWithSingleCustomer(billRunCycle);
    }

    @Test(priority =4, enabled = true, description = "RollBack BillRun")
    public void rollBackCreatedBillRun() throws InterruptedException {
        extentTest = extent.startTest("RollBack Created BillRun");
        extentTest.setDescription("Verify that user is able to RollBack the Created BillRun or not");

       BillRun.Rollback_SmallBillRunWithSingleCustomer();
    }

    @Test(priority = 8, enabled = true, description = "Download Zip")
    public void downloadZip() throws InterruptedException, AWTException {
        extentTest = extent.startTest("Download Zip");
        extentTest.setDescription("Verify that user is able to DownloadZip file or not");

        BillRun.downloadZip();
    }
//TO-DO
    @Test(priority = 5, enabled = false, description = "Edit BillRunCycle")
    public void editBillRunCycle() throws InterruptedException, AWTException {
        extentTest = extent.startTest("Edit BillRun Cycle");
        extentTest.setDescription("Verify that user is able to Update the BillRunCycle or not");
        billCycleName = BillRun.editBillCycle(billRunCycle);
    }

    @Test(priority = 6, enabled = true)
    public void reBill() throws AWTException, InterruptedException {
        extentTest = extent.startTest("Re BillRun   ");
        extentTest.setDescription("Verify that user is able to ReBill or Not");

        BillRun.rebillSingleCustomer(billRunCycle);
    }

    @Test(priority = 7, enabled = true, description = "RollBack Created BillRun")
    public void CommitBillRun() throws InterruptedException {
        extentTest = extent.startTest("Create BillRun Cycles ");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");
        BillRun.commitBillRun();
    }
@Test(priority = 9 , enabled=true, description="Email BillRun ")
    public void emailBillRun() throws InterruptedException {
        extentTest = extent.startTest("Email BillRun to customer ");
        extentTest.setDescription("Verify that user is able to Email the BillRun or Not");
       BillRun.emailBillRun();
    }
}

