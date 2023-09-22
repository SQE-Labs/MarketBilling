package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.awt.*;
import static POM.Customer.*;


public class TestAddService extends BaseTest {

    @AfterMethod
    public void pageRefresh() {
        driver.navigate().refresh();
    }

    @Test(priority = 1)
    public void AddResidentialService( ) throws InterruptedException, AWTException {
        extentTest = extent.startTest("Retail Electricity Service for  Residential Customer ");
        extentTest.setDescription(" Verify that User is able to add Residential Service. ");
       // Login.validLogin();
        Customer.searchCustomer(CustomerID01R);
        Services.addService();
    }

    @Test(priority = 2)
    public void EditResidentialService() throws InterruptedException {
        extentTest = extent.startTest(" Edit Retail Electricity Service for  Residential Customer ");
        extentTest.setDescription(" Verify that User is able to edit Retail Electricity Service for  Residential Customer. ");
       // Login.validLogin();
        Services.editService();
    }

    @Test(priority = 3)
    public void AddMeter_MeterRegisterR() throws InterruptedException {
        extentTest = extent.startTest(" AddMeter and MRegister  for  service ");
        extentTest.setDescription(" Verify that User is able to add Service. ");
        Metering metering = new Metering();
        metering.AddMeter();
        metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");


    }

    @Test(priority = 4)
    public void AddBusinessService() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" Add and edit Retail Electricity Service for  Business Customer  ");
        extentTest.setDescription(" Verify that User is able to add SecondService. ");
      //Login.validLogin();
      //String CustomerID02B="36896";
        Customer.searchCustomer(CustomerID02B);
        Services.addService();
        Services.editService();
        Metering metering = new Metering();
        metering.AddMeter();
        metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");

    }


    @Test(priority = 5)
    public void AddCommercialService( ) throws InterruptedException, AWTException {
        extentTest = extent.startTest(" Add and edit Retail Electricity Service for  Commercial Customer  ");
        extentTest.setDescription(" Verify that User is able to add ThirdService ");
        Customer.searchCustomer(CustomerID03C);
        Services.addService();
        Services.editService();
        Metering metering = new Metering();
        metering.AddMeter();
        metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");

    }
    @Test(priority = 6,enabled=false)
    public void addSitePlans() throws InterruptedException {
        extentTest = extent.startTest(" Add Site Plans ");
        extentTest.setDescription(" Verify that User is able to add  site plans ");
      //  AddSitePlans.addSitePlan();

    }

    @Test(priority = 6)
    public void addSiteParameters() throws InterruptedException {
        extentTest = extent.startTest(" Add Site Parameters ");
        extentTest.setDescription(" Verify that User is able to add  site Paramaters ");
        AddSitePlans.addSiteParameters();

    }






}
