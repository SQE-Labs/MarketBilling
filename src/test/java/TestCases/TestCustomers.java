package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;

import POM.Login;
import org.testng.annotations.Test;

public class TestCustomers extends BaseTest {

	@Test(priority = 1)
	public  void ResidentialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Residential Customer ");
		extentTest.setDescription(" Verify that User is able to add Residential customer. ");
		Login.validLogin();
		Customer.createResidentialCustomer("Tenant","Residential","Madirma R-Town","Mills NY","1265","WA","Mr.","gamler123@yopmail.com","","Active");
	}

	@Test(priority = 2)
	public  void BusinessCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Business Customer ");
		extentTest.setDescription(" Verify that User is able to add Business SecondCustomer. ");
	   Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","Active");
	}

	@Test(priority = 3)
	public  void CommercialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Commercial Customer ");
		extentTest.setDescription(" Verify that User is able to add  Commercial ThirdCustomer. ");
//		Login.validLogin();
	  Customer.createCommercialCustomer("Tenant","Commercial","Madirma R-Town","Mills NY","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","10","Active");
	}
}
