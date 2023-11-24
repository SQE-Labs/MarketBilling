package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.PropertiesUtil;
import CommonMethods.WebDriverWaits;
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

        Services.M_AddService("Off Market","New South Wales","Australian Capital Territory");
    }

    @Test(priority = 2)
    public void EditResidentialService() throws InterruptedException {
        extentTest = extent.startTest(" Edit Retail Electricity Service for  Residential Customer ");
        extentTest.setDescription(" Verify that User is able to edit Retail Electricity Service for  Residential Customer. ");
       // Login.validLogin();
        Services.editService("Connected");
    }

    @Test(priority = 3)
    public void AddMeter_MeterRegisterR() throws InterruptedException {
        extentTest = extent.startTest(" AddMeter and MRegister  for  service ");
        extentTest.setDescription(" Verify that User is able to add Service. ");


         Metering.AddMeter() ;
        Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");

        Metering.add_MeterReads("Initial","150","200","300");
        Metering.add_MeterReads("Actual Read","200","400","650");


    }

    @Test(priority = 4)
    public void AddBusinessService() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" Add and edit Retail Electricity Service for  Business Customer  ");
        extentTest.setDescription(" Verify that User is able to add SecondService. ");
      //Login.validLogin();
      //String CustomerID02B="36896";
         Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
        Services.M_AddService("Off Market","NSW", "New South Wales");
        Services.editService("Connected");
        Metering metering = new Metering();
        Metering.AddMeter() ;
      Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");

        Metering.add_MeterReads("Initial","150","200","300");
        Metering.add_MeterReads("Actual Read","200","400","650");

    }


    @Test(priority = 5)
    public void AddCommercialService( ) throws InterruptedException, AWTException {
        extentTest = extent.startTest(" Add and edit Retail Electricity Service for  Commercial Customer  ");
        extentTest.setDescription(" Verify that User is able to add ThirdService ");
        Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
        Services.M_AddService("Off Market","NSW", "New South Wales");
        Services.editService("Connected");
        Metering.AddMeter() ;
        Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
        Metering.add_MeterReads("Initial","150","200","300");
        Metering.add_MeterReads("Actual Read","200","400","650");
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
        driver.navigate().refresh();
    }

}
