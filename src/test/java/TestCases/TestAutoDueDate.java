package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestAutoDueDate extends BaseTest {

	public String customerId ;
	public String customerId2 ;
	public String customerId3 ;

	public 	String billRunCycle1;
	public 	String billRunCycle2;
	public 	String billRunCycle3;
	public   String BillCycleName;

	@Test(priority = 1, enabled = true)
	public void billRun_after_EnableDueDate_CalendarDays() throws InterruptedException, AWTException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_CalendarDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as Calendar Days ");
		//Login.validLogin();
		AdminGroup.M_EnableDueDate("Calendar days");
		customerId= Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		Services.M_AddService("Off Market","NSW", "New South Wales");
		Services.editService("Connected");
		String meterId = Metering.AddMeter();
		String registerId = Metering.createRegister("Na","KWH","ALLDAY","5.0","0","0","17");
		Metering.addMeterReads("Initial", "150", "200", "300");
		Metering.addMeterReads("Actual Read", "200", "400", "650");

		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		    BillCycleName=BillRun.BillRunCycle(customerId);
		    BillRun.runBillCycle(BillCycleName);
	}


	@Test(priority = 2, enabled = true)
	public void billRun_after_EnableDueDate_BusinessDays() throws InterruptedException, AWTException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_BusinessDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as BusinessDays ");
		AdminGroup.M_EnableDueDate("Business days");
		customerId2= Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		 Services.M_AddService("Off Market","NSW", "New South Wales");
		 Services.editService("Connected");
		 Metering.AddMeter();
		 Metering.createRegister("Na","KWH","ALLDAY","5.0","0","0","17");
		 Metering.addMeterReads("Initial", "150", "200", "300");
		 Metering.addMeterReads("Actual Read", "200", "400", "650");

		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId2);
		BillCycleName= BillRun.BillRunCycle(customerId2);
		BillRun.runBillCycle(BillCycleName);

	}

	@Test(priority = 3)
	public void billRun_after_EnableDueDate_EndOfMonth() throws InterruptedException, AWTException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_EndOfMonth");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as End of Month");
		AdminGroup.M_EnableDueDate("End of month");
		 customerId3=Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		 Services.M_AddService("Off Market","NSW", "New South Wales");
		 Services.editService("Connected");
		 Metering.AddMeter();
		 Metering.createRegister("Na","KWH","ALLDAY","5.0","0","0","17");
		Metering.addMeterReads("Initial", "150", "200", "300");
		Metering.addMeterReads("Actual Read", "200", "400", "650");

		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId3);
		BillCycleName= BillRun.BillRunCycle(customerId3);
			BillRun.runBillCycle(BillCycleName);
	}
	}

