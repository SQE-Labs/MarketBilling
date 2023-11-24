package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.PropertiesUtil;
import POM.Customer;

import POM.Login;
import org.apache.hc.core5.util.Asserts;
import org.asynchttpclient.util.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCustomers extends BaseTest {

	@Test(priority = 1)
	public  void residentialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Residential Customer ");
		extentTest.setDescription(" Verify that User is able to add Residential customer. ");
//		Login.validLogin();

		String customerIdRes=Customer.createResidentialCustomer("Tenant","Residential","Madirma R-Town","Mills NY","Australia","1265","WA","Mr.","gamler123@yopmail.com", "10","Active");
		System.out.println(customerIdRes);
		Assert.assertNotNull(customerIdRes);


	}

	@Test(priority = 2)
	public  void businessCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Business Customer ");
		extentTest.setDescription(" Verify that User is able to add Business SecondCustomer. ");
//		Login.validLogin();


		String customerIdBus=   Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","Australia","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","10","Active");
		System.out.println(customerIdBus);
		Assert.assertNotNull(customerIdBus);


	}

	@Test(priority = 3)
	public  void CommercialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Add Commercial Customer ");
		extentTest.setDescription(" Verify that User is able to add  Commercial ThirdCustomer. ");
//		Login.validLogin();

	  String customerIdCom =Customer.createCommercialCustomer("Tenant","Commercial","Madirma R-Town","Mills NY","Australia","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","10","Active");
		System.out.println(customerIdCom);
		Assert.assertNotNull(customerIdCom);

	}
}
