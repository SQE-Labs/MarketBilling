package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.RandomStrings;
import POM.*;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestSingleCustomerBillRun extends BaseTest {
    static String customerId;
    String serviceId;
    String meterId;
    String registerId;
    static String billCycleName;
    String invoiceTemplate;

    @Test(priority = 1,enabled = true)
    public  void CreateCustomer_For_BillrunCycle() throws InterruptedException {
        extentTest = extent.startTest(" Create Customer for bill run with 1 customer ");
        extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
       // Login.validLogin();
        customerId =Customer.createCustomer( "Tenant", "Commercial","Tenant Traders", "12345678951","Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10");
         serviceId=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
         Services.editService("Connected");
         meterId =Metering.AddMeter();
         registerId = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
        Metering.add_MeterReads("Initial","150","200","300");
        Metering.add_MeterReads("Actual Read","200","400","650");


    }
    @Test(priority = 2)

    public  void create_Customer_invoiceTemplate() throws InterruptedException {
        extentTest = extent.startTest("Customer Invoice Template");
        extentTest.setDescription(" Verify that User is able to create Customer Invoice template");
        //   Login.ValidLogin();
        Admin.navigateToInvoiceSetup();
        invoiceTemplate="Customer_Invoice_"+ RandomStrings.RequiredCharacters(4);
        Invoice.createNewInvoice(invoiceTemplate);
    }
    @Test(priority = 3)

    public  void customer_InvoiceSettings() throws InterruptedException {
        extentTest = extent.startTest("Customer Invoice Settings");
        extentTest.setDescription(" Verify that User is able to update Customer Invoice Settings");
        customerId="41130";
        Settings settings=Customer.navigateTo_CustomerSettings(  customerId);
        settings.invoiceSettings_Customer(invoiceTemplate);
        settings.clickSave();
    }
    @Test(priority = 4,enabled = true)
    public static void createAndEditBillCycleName() throws InterruptedException {
        extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
        extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        //String customerId="40893";
        List<String > customer= new ArrayList<String>();
        customer.add(customerId);
        String billCycleOldName = BillRun.createBillCycle(customer);
        billCycleName = BillRun.editBillCycle(billCycleOldName);

    }
    @Test(priority = 5,enabled = true)
    public  void SmallBillRunWithSingleCustomer() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
        extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        BillRun.runBillCycle(billCycleName);
    }

    @Test(priority = 6)

    public  void Rollback_SmallBillRunWithSingleCustomer() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" Rollback for single customer ");
        extentTest.setDescription(" Verify that User is able to run rollback single customer ");
        BillRun.Rollback_SmallBillRunWithSingleCustomer(billCycleName);
    }
    @Test(priority = 7)

    public  void rebill_and_Reuse() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" Rebill and Reuse Statement ");
        extentTest.setDescription(" Verify that User is able to run rebill and reuse and Statement");
        BillRun.rebillSingleCustomer(  billCycleName);
    }
    @Test(priority = 8)


    public  void emailBills() throws InterruptedException {
        extentTest = extent.startTest(" Send Email ");
        extentTest.setDescription(" Verify that User is able to send emails");

        BillRun.billRunCycleSearch(billCycleName);
        BillRun.viewBillDetails( );
        BillRun.selectCustCheckBox();
        BillRun.clickEmailBills();
        BillRun.clickSelectedCustomers();
        BillRun.clickContinueEmail();
        BillRun.verifyEmailResults();
        BillRun.clickClose();
    }
    @Test(priority = 8)

    public  void downloadPdf() throws InterruptedException {
        extentTest = extent.startTest(" Download Pdf ");
        extentTest.setDescription(" Verify that User is able to download pdf");
        BillRun.billRunCycleSearch(billCycleName);
        BillRun.viewBillDetails( );
        BillRun.selectCustCheckBox();
        BillRun.clickDownloadPdf();
        BillRun.clickSelectedCustomer();
        BillRun.clickDownload_Popup();

    }

}