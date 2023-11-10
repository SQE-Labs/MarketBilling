package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Login;
import POM.Metering;
import POM.Services;
import org.testng.annotations.Test;

public class TestAddMeter extends BaseTest {
	String 	registerId;
	@Test(priority = 21,enabled = true)
	public  void Metering() throws InterruptedException {
		extentTest = extent.startTest("Add  Meter  for Residential Customer ");
		extentTest.setDescription(" Verify that User is able to add Meter. ");
		//Login.loginWithGroupName("Testing1228");
		Customer.searchAndNavigateToRecentCustomer();
		Services.navigateToEditServices();
		Metering.AddMeter();
	}
	@Test(priority = 22,enabled = true)
	public  void MeterRegister() throws InterruptedException {
		extentTest = extent.startTest(" Meter Register ");
		extentTest.setDescription(" Verify that User is able to register meter ");
		registerId =	Metering.createRegister();

	}
	@Test(priority = 23,enabled = true)
	public  void MeterReadsInitial() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads Initial ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads ");
		Metering.addMeterReads("Initial","150","200","300");
	}
	@Test(priority = 24,enabled = true)
	public  void MeterReadsConsumption() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads Consumption Data  ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads consumption data ");
		Metering.addMeterReads("Actual Read","200","400","650");

	}
}
