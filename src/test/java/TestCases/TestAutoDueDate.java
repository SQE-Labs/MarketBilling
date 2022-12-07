package TestCases;

import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan; //

public class TestAutoDueDate extends TestLogin{
	
	@Test(priority = 1) 
	public static void M_EnableDueDate() throws InterruptedException { 
		extentTest = extent.startTest(" Auto Due Date ");
		extentTest.setDescription(" Verify that User is able to Enable due date by Payment terms ");
		pageObjects.Flow9_Auto_Due_Date.X_EnableDueDate.M_EnableDueDate();
		
	}
	
	@Test(priority = 2) 
	public static void AutoDueDate() throws InterruptedException { 
		extentTest = extent.startTest(" Auto Due Date ");
		extentTest.setDescription(" Verify that User is able to run the bill run with 1 customer after updating auto due date ");
		pageObjects.Flow9_Auto_Due_Date.AutoDueDate();
		
	}
	
	@Test(priority = 3)
	public static void BillRunWithSingleCustomer() throws InterruptedException {
		extentTest = extent.startTest(" BillRunWithSingleCustomer ");
		extentTest.setDescription(" Verify that User is able to run the bill with cycle ");
<<<<<<< HEAD:src/test/java/TestCases/TestAutoDueDate.java
		pageObjects.Flow9_Auto_Due_Date.BillRunWithSingleCustomer();
=======
		pageObjects.Flow8_AllBillrunCycles.BillRunWithSingleCustomer();
>>>>>>> 87aa608 ( minor updates):src/main/java/test/TestAutoDueDate.java
		
	}
	

}
 