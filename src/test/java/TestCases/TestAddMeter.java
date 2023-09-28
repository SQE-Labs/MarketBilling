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

	String     registerId;
	@Test(priority = 1)
	public  void add_Metering() throws InterruptedException {
		extentTest = extent.startTest("Add  Metering");
		extentTest.setDescription(" Verify that User is able to add Metering. ");
		Login.validLogin();
		Customer.searchAndNavigateToRecentCustomer();
		Services.navigateToEditServices();
		Metering.add_Metering();
	}
	@Test(priority = 2)
	public  void add_MeterRegister() throws InterruptedException {
		extentTest = extent.startTest(" Add Meter Register ");
		extentTest.setDescription(" Verify that User is able to register meter ");
		registerId = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");

	}
	@Test(priority = 3)
	public  void MeterReadsInitial() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads Initial ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads ");
		Metering.add_MeterReads("Initial","150","200","300");
	}
	@Test(priority = 4)
	public  void MeterReadsConsumption() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads Consumption Data  ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads consumption data ");
		Metering.add_MeterReads("Actual Read","200","400","650");

	}

}