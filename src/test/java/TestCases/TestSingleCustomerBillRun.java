package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//import POM.Flow2_3AddTOUFileAndPlan; //TestTwoCustomerBillRun

public class TestSingleCustomerBillRun extends BaseTest {
    String customerId;
    String serviceId;
    String meterId;
    String registerId;
    String billCycleName;

    @Test(priority = 24,enabled = true)
    public  void CreateCustomer_For_BillrunCycle() throws InterruptedException {
        extentTest = extent.startTest(" Create Customer for bill run with 1 customer ");
        Login.ValidLogin();
        extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");

        customerId =Customer.createCustomer("Tenant", "Residential", "residential123@yopmail.com");
         serviceId=Services.M_AddService(customerId);
         Services.EditService();
         meterId =Metering.AddMeter();
         registerId =Metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");


    }

    @Test(priority = 25,enabled = true)
    public  void SmallBillRunWithSingleCustomer() throws InterruptedException {
        extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
        extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        List<String > customer= new ArrayList<String>();
        customer.add(customerId);
        billCycleName =BillRun.createBillCycle(customer);
        BillRun.runBillCycle(billCycleName);
    }

    @Test(priority = 26)

    public  void Rollback_SmallBillRunWithSingleCustomer() throws InterruptedException {
        extentTest = extent.startTest(" Rollback for single customer ");
        extentTest.setDescription(" Verify that User is able to run rollback single customer ");
        //String customerId ="40930";
        BillRun.Rollback_SmallBillRunWithSingleCustomer(customerId);
    }
    @Test(priority = 27)

    public  void rebill_and_Reuse() throws InterruptedException {
        extentTest = extent.startTest(" Rebill and Reuse Statement ");
        extentTest.setDescription(" Verify that User is able to run rebill and reuse and Statement");
        BillRun.rebillSingleCustomer(billCycleName);
    }

}
