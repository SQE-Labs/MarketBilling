package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.Metering;
import POM.Services;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestAddMeter extends BaseTest {

	String 	registerId;
	@Test(priority = 1)
	public void add_Metering() throws InterruptedException {
		extentTest = extent.startTest("Add  Metering for Residential Customer ");
		extentTest.setDescription(" Verify that User is able to add Metering ");
		Login.validLogin();
		Customer.searchAndNavigateToRecentCustomer();
		Services.navigateToEditServices();
		Metering.AddMeter();
		Metering.verify_Metering_SuccessMSG("Successfully registered meter");
	}
	@Test(priority = 2)
	public  void add_MeterRegister() throws InterruptedException {
		extentTest = extent.startTest(" Add Meter Register ");
		extentTest.setDescription(" Verify that User is able to register meter ");
		registerId = Metering.createRegister();
	//	Metering.verify_MeterRegister_SuccessMSG("Successfully registered meter");

	}
	@Test(priority = 3)
	public  void add_InitialMeterReads() throws InterruptedException {
		extentTest = extent.startTest("Add Initial Meter Reads");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads ");
		Metering.addMeterReads("Initial","150","200","300");
	//	Metering.verify_InitialMeterReads_SuccessMSG("Successfully registered meter");
	}
	@Test(priority = 4)
	public  void add_ConsumptionMeterReads() throws InterruptedException {
		extentTest = extent.startTest("Add Consumption Meter Reads");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads consumption data ");
		Metering.addMeterReads("Actual Read","200","400","650");
	//	Metering.verify_InitialMeterReads_SuccessMSG("Successfully registered meter");

	}

}
