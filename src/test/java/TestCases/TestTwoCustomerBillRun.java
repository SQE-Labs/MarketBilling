package TestCases;

import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan; //

public class TestTwoCustomerBillRun extends TestLogin{
	
	
	@Test(priority = 1) 
	public static void Flow8_AllBillrunCycles() throws InterruptedException { 
		extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
		extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
		pageObjects.Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithTwoCustomer();
		
	}
	
	
	

}
 