package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.RandomStrings;
import POM.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSingleCustomerBillRun extends BaseTest {
    String customerId;
    String serviceId;
    String meterId;
    String registerId;
    String billCycleName;
    String invoiceTemplate;

    @Test(priority = 1,enabled = true)
    public  void CreateCustomer_For_BillrunCycle() throws InterruptedException {
        extentTest = extent.startTest(" Create Customer for bill run with 1 customer ");
        extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        Login.ValidLogin();
        customerId =Customer.createCustomer("Tenant", "Residential", "residential123@yopmail.com");
         serviceId=Services.M_AddService(customerId);
         Services.EditService();
         meterId =Metering.AddMeter();
         registerId =Metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");


    }
    @Test(priority = 2)

    public  void create_Customer_invoiceTemplate() throws InterruptedException {
        extentTest = extent.startTest("Customer Invoice Template");
        extentTest.setDescription(" Verify that User is able to create Customer Invoice template");
        Login.ValidLogin();
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
    public  void createAndEditBillCycleName() throws InterruptedException {
        extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
        extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        //String customerId="40893";
        List<String > customer= new ArrayList<String>();
        customer.add(customerId);
        String billCycleOldName = BillRun.createBillCycle(customer);
        billCycleName = BillRun.editBillCycle(billCycleOldName);

    }
    @Test(priority = 5,enabled = true)
    public  void SmallBillRunWithSingleCustomer() throws InterruptedException {
        extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
        extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        BillRun.runBillCycle(billCycleName);
    }

    @Test(priority = 6)

    public  void Rollback_SmallBillRunWithSingleCustomer() throws InterruptedException {
        extentTest = extent.startTest(" Rollback for single customer ");
        extentTest.setDescription(" Verify that User is able to run rollback single customer ");
        BillRun.Rollback_SmallBillRunWithSingleCustomer(customerId);
    }
    @Test(priority = 7)

    public  void rebill_and_Reuse() throws InterruptedException {
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
