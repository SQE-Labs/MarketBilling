package TestCases;

import CommonMethods.BaseTest;
import POM.Flow5_AddCustomer;
import org.testng.annotations.Test;

public class TestCustomers extends BaseTest {

	@Test(priority = 7)
	public  void ResidentialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Residential Customer ");
		extentTest.setDescription(" Verify that User is able to add Residential customer. ");
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
	}

	@Test(priority = 8)
	public  void BusinessCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Business Customer ");
		extentTest.setDescription(" Verify that User is able to add Business SecondCustomer. ");
	   Flow5_AddCustomer.SecondCustomer.SecondBusinessCustomer();
	}

	@Test(priority = 9)
	public  void CommercialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Commercial Customer ");
		extentTest.setDescription(" Verify that User is able to add  Commercial ThirdCustomer. ");
	   Flow5_AddCustomer.ThirdCustomer.ThirdCommercialCustomer();
	}
}
