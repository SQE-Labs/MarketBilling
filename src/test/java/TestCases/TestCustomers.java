package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Flow5_AddCustomer;
import POM.Login;
import org.testng.annotations.Test;

public class TestCustomers extends BaseTest {

	@Test(priority = 1)
	public  void ResidentialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Residential Customer ");
		extentTest.setDescription(" Verify that User is able to add Residential customer. ");
		Login.validLogin();
		Customer.FirstResidentialCustomer();
	}

	@Test(priority = 2)
	public  void BusinessCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Business Customer ");
		extentTest.setDescription(" Verify that User is able to add Business SecondCustomer. ");
	   Customer.SecondBusinessCustomer();
	}

	@Test(priority = 3)
	public  void CommercialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Commercial Customer ");
		extentTest.setDescription(" Verify that User is able to add  Commercial ThirdCustomer. ");
	  Customer.ThirdCommercialCustomer();
	}
}
