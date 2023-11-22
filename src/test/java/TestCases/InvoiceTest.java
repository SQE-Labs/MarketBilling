package TestCases;

import CommonMethods.BaseTest;
import POM.Admin;
import POM.GroupEdit;
import POM.Invoice;
import POM.Login;
import org.testng.annotations.Test;
import static POM.Invoice.invoiceName;

public class InvoiceTest extends BaseTest {

    Admin admin = new Admin();
    Invoice invoice = new Invoice();
    GroupEdit groupEdit = new GroupEdit();


    @Test(priority = 1,enabled = true)
    public  void createInvoice_template() throws InterruptedException {
        extentTest = extent.startTest("Create Invoice Template ");
        extentTest.setDescription(" Verify that User is able to create Invoice Template. ");
        //Login.validLogin();
        admin.navigateToInvoiceSetup();
        invoice.create_Invoice("TRANSACTION-SUMMARY","TRANSACTION-SUMMARY-LIST","TRANSACTION-SUMMARY-LIST","Sample template text" );

    }
    @Test(priority = 2,enabled = true)
    public  void editInvoice_template() throws InterruptedException {
        extentTest = extent.startTest("Edit Invoice Template ");
        extentTest.setDescription(" Verify that User is able to edit Invoice Template. ");
        admin.navigateToInvoiceSetup();
        invoice.edit_Invoice("TRANSACTION-SUMMARY","TRANSACTION-SUMMARY-LIST","BILLPAY","TRANSACTION-SUMMARY-LIST","Sample  edited template text");


    }
    @Test(priority = 3,enabled = true)
    public void invoice_Settings() throws Exception {
        extentTest = extent.startTest("Invoice Settings ");
        extentTest.setDescription(" Verify that User is able to edit Invoice settings in Group Edit ");
        invoiceName="Invoice961";
        Admin.navigateToGroupEdit();
        groupEdit.invoice_Settings();
        groupEdit.validate_SuccessTxt("Success! Changes have been updated successfully.\n");
    }

}