package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAutoDueDate extends BaseTest {

	@Test(priority = 1, enabled = true)
	public void BillRun_after_EnableDueDate_CalendarDays() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_CalendarDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as Calendar Days ");
		AdminGroup.M_EnableDueDate("Calendar days");

		String customerId = Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );


		String serviceId = Services.M_AddService("offMarket","NSW", "New South Wales");
		Services.editService("Active");
		String meterId = Metering.AddMeter();
		String registerId = Metering.createRegister("Na","KWH","ALLDAY","5.0","0","0","17");
		Metering.addMeterReads("Initial", "150", "200", "300");
		Metering.addMeterReads("Actual Read", "200", "400", "650");

		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		//	String billRunCycle= BillRunTest.createBillCycle(customerList);
		//	BillRunTest.runBillCycle(billRunCycle);
	}

	@Test(priority = 2, enabled = true)
	public void BillRun_after_EnableDueDate_BusinessDays() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_BusinessDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as BusinessDays ");
		AdminGroup.M_EnableDueDate("Business days");

		String customerId = Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		String serviceId = Services.M_AddService("offMarket","NSW", "New South Wales");
		Services.editService("Active");
		String meterId = Metering.AddMeter();
		String registerId = Metering.createRegister("Na","KWH","ALLDAY","5.0","0","0","17");
		Metering.addMeterReads("Initial", "150", "200", "300");
		Metering.addMeterReads("Actual Read", "200", "400", "650");


		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		//	String billRunCycle= BillRunTest.createBillCycle(customerList);
		//	BillRunTest.runBillCycle(billRunCycle);

	}

	@Test(priority = 3)
	public void BillRun_after_EnableDueDate_EndOfMonth() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_EndOfMonth");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as End of Month");
		AdminGroup.M_EnableDueDate("End of month");

		String customerId = Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		String serviceId = Services.M_AddService("offMarket","NSW", "New South Wales");
		Services.editService("Active");
		String meterId = Metering.AddMeter();
		String registerId = Metering.createRegister("Na","KWH","ALLDAY","5.0","0","0","17");
		Metering.addMeterReads("Initial", "150", "200", "300");
		Metering.addMeterReads("Actual Read", "200", "400", "650");

		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		//	String billRunCycle= BillRunTest.
		//	(customerList);
		//	BillRunTest.runBillCycle(billRunCycle);	}


	}
}
