package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;
import java.awt.*;

import static POM.BillRun.BillCycleName;
import static POM.Customer.CustomerID01R;


public class TestNewBillRun extends BaseTest {

    public static String customerID;
    public static String serviceId;
    public static String meterId;
    public static String meterReg;
    public static String billRunCycle;
    public static String  billCycleName;




    @Test(priority = 0, enabled = true, description = "Creating Customer")
    public void createCustomer() throws InterruptedException {
        extentTest = extent.startTest(" Create Customer ");
        extentTest.setDescription(" Verify that User is able to Create Customer or not ");
        Login.validLogin();
        customerID=Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","Australia","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","10","Active");
        System.out.println("Texts match. Assertion passed.");
        serviceId=Services.M_AddService("Off Market","New South Wales","Australian Capital Territory");
        Services.editService("Connected");
        meterId =Metering.AddMeter() ;
        meterReg = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
        Metering.add_MeterReads("Initial","150","200","300");
        Metering.add_MeterReads("Actual Read","200","400","650");
    }

    @Test(priority = 1, enabled = true, description = "Create BillRun Cycles")
    public void createBillRunCycle() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" Create BillRun Cycle ");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");
         billRunCycle = BillRun.BillRunCycle(customerID);

    }


    @Test(priority = 2, enabled = true)
    public void billRun() throws AWTException, InterruptedException {
        extentTest = extent.startTest(" Generate Bill Run ");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");
        BillRun.SmallBillRunWithSingleCustomer(BillCycleName);
    }

    @Test(priority = 3, enabled = true, description = "RollBack Created BillRun")
    public void commitBillRun() throws InterruptedException {
        extentTest = extent.startTest("Commit Created BillRun");
        extentTest.setDescription("Verify that user is able to Create BillRun Cycles or Not");
        BillRun.commitBillRun(billRunCycle);
    }

    @Test(priority =4, enabled = true, description = "RollBack BillRun")
    public void rollBackCreatedBillRun() throws InterruptedException, AWTException {
        extentTest = extent.startTest("RollBack Created BillRun");
        extentTest.setDescription("Verify that user is able to RollBack the Created BillRun or not");
        BillRun.Rollback_SmallBillRunWithSingleCustomer(billRunCycle);
    }

    @Test(priority = 5, enabled = true, description = "Edit BillRunCycle")
    public void editBillRunCycle() throws InterruptedException, AWTException {
        extentTest = extent.startTest("Edit BillRun Cycle");
        extentTest.setDescription("Verify that user is able to Update the BillRunCycle or not");
        billCycleName = BillRun.editBillCycle(billRunCycle);
    }

    @Test(priority = 6, enabled = true)
    public void reBill() throws AWTException, InterruptedException {
        extentTest = extent.startTest("Re BillRun");
        extentTest.setDescription("Verify that user is able to ReBill or Not");

        BillRun.rebillSingleCustomer(billRunCycle);
    }

    @Test(priority = 7, enabled = true, description = "Download Zip")
    public void downloadZip() throws InterruptedException, AWTException {
        extentTest = extent.startTest("Download Zip");
        extentTest.setDescription("Verify that user is able to DownloadZip file or not");

        BillRun.downloadZip();
    }

    @Test(priority = 8 , enabled=true, description="Email BillRun ")
    public void emailBillRun() throws InterruptedException {
        extentTest = extent.startTest("Email BillRun to customer");
        extentTest.setDescription("Verify that user is able to Email the BillRun or Not");
        BillRun.emailBillRun();
   }
}