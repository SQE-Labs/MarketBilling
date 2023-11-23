package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static POM.Customer.*;


public class MultipleCustomerBillRunTest extends BaseTest {
	public String CustomerID01R;
	public String CustomerID02B;
	public String CustomerID03C;
	public String customerId;
	public String billRunCycleName;
	public String billRunCycle;
	@Test(priority = 0,enabled = false)  // cannot automate because BillRun is not happen without billruncycle.
	public  void BillRunWithNoCycle() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");

		String customerId = Customer.createCustomer( "Tenant", "Commercial","Tenant Traders", "12345678951","Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10");
		String serviceId=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
		Services.editService("Connected");
		String 	meterId =Metering.AddMeter();
		String registerId = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");

		//	BillRun.BillrunMethod_NoCycle();

	}

	@Test(priority = 1,enabled =false)//functionality not there
	public  void billRunWithUncommittedStatement() throws InterruptedException, AWTException {
		extentTest = extent.startTest(" Bill Run With Uncommitted Statement ");
		extentTest.setDescription(" Verify that User is gets the confirmation popup when user tries to run the bill WitUncommitted Statement ");
		//Login.validLogin();
		customerId=Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		String serviceId=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
		Services.editService("Connected");
		String 	meterId =Metering.AddMeter();
		String registerId = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");
		 billRunCycle= BillRun.BillRunCycle(customerId);
		BillRun.runBillCycle(billRunCycle);
		BillRun.directRollBack(billRunCycleName);
	//	BillRun.BillRunWithUncommittedStatement(billRunCycle,customerId);

	}
	@Test(priority=2,enabled = true)
	public  void testLargeBillRun() throws InterruptedException, AWTException {
		extentTest = extent.startTest(" Large Cycle Bill run with 1 customer ");
		extentTest.setDescription(" Verify that User is able to run the large bill run with 1 customer ");
	//	Login.validLogin();
		 CustomerID01R = Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		 Services.M_AddService("Off Market","NSW","New South Wales");
		Services.editService("Connected");
		String 	meterId =Metering.AddMeter();
		String registerId = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");

		CustomerID02B = Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		 Services.M_AddService("Off Market","NSW","New South Wales");
		Services.editService("Connected");
		 Metering.AddMeter();
		  Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");

		 CustomerID03C = Customer.createCustomer( "Tenant", "Business","Tenant Traders" ,"12345678951" ,"Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10"  );
		 Services.M_AddService("Off Market","NSW","New South Wales");
		Services.editService("Connected");
		 Metering.AddMeter();
		 Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");

		List<String> customerList = new ArrayList<String>();
		customerList.add(CustomerID01R);
		customerList.add(CustomerID02B);
		customerList.add(CustomerID03C);

		billRunCycleName= BillRun.createBillCycle(customerList);
		BillRun.runBillCycle(billRunCycleName);
	//	BillRun.commitBillRun(billRunCycleName);
	}

	@Test(priority = 4,enabled = true)
	public  void multiCustomer_RollBack() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		BillRun.directRollBack(billRunCycleName);
	}
	@Test(priority = 5,enabled = true)
	public  void multiCustomer_ReBill() throws InterruptedException, AWTException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		List<String> customerList = new ArrayList<String>();
		customerList.add(CustomerID01R);
		customerList.add(CustomerID02B);
		customerList.add(CustomerID03C);
		BillRun.runBillCycle(billRunCycleName);

	}
	@Test(priority = 6,enabled = true)
	public  void multiCustomer_FullStatementRollBack() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		Customer.searchCustomer(CustomerID02B);
		BillRun.rollback_in_statementTab(CustomerID02B);
	}
	@Test(priority = 7,enabled = true)
	public  void multiCustomer_RebillStatement() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rebill ");
		extentTest.setDescription(" Verify that User is able to run full statement rebill ");
		Customer.searchCustomer(CustomerID02B);
		BillRun.statementRebill(CustomerID02B);
	}

}