package TestCases;

import CommonMethods.BaseTest;
import POM.*;
import org.testng.annotations.Test;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;




public class MultipleCustomerBillRunTest extends BaseTest {
	public String customerId;
	public String customerId2;
	public String billRunCycleName;
	@Test(priority = 0,enabled = false)  // cannot automate because BillRun is not happen without billruncycle.
	public  void BillRunWithNoCycle() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		String customerId = Customer.createCustomer( "Tenant", "Commercial","Tenant Traders", "12345678951","Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com","" ,"10");
		String serviceId=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
		Services.editService("Connected");
		String 	meterId =Metering.add_Metering();
		String registerId = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");
		//	BillRun.BillrunMethod_NoCycle();

	}

	@Test(priority = 1,enabled =false)
	public  void billRunWithUncommittedStatement() throws InterruptedException, AWTException {
		extentTest = extent.startTest(" Bill Run With Uncommitted Statement ");
		extentTest.setDescription(" Verify that User is gets the confirmation popup when user tries to run the bill WitUncommitted Statement ");
		Login.validLogin();
		String customerId = Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","10","Active" );
		String serviceId=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
		Services.editService("Connected");
		String 	meterId =Metering.add_Metering();
		String registerId = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");
		String billRunCycle= BillRun.BillRunCycle(customerId);
		BillRun.SmallBillRunWithSingleCustomer(billRunCycle);
		//	BillRun.BillRunWithUncommittedStatement(billRunCycle,customerId);

	}
	@Test(priority=2,enabled = true)
	public  void testLargeBillRun() throws InterruptedException, AWTException {
		extentTest = extent.startTest(" Large Cycle Bill run with 1 customer ");
		extentTest.setDescription(" Verify that User is able to run the large bill run with 1 customer ");
		Login.validLogin();
		String CustomerID01R = Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","10","Active" );
		String serviceId=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
		Services.editService("Connected");
		String 	meterId =Metering.add_Metering();
		String registerId = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");

		String CustomerID02B = Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","10","Active" );
		String serviceId2=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
		Services.editService("Connected");
		String 	meterId2 =Metering.add_Metering();
		String registerId2 = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");

		String CustomerID03C = Customer.creteBusinessCustomer("Tenant","Business","Madirma R-Town","Mills NY","1265","WA","FranklinCovey","32165485216","Dr.","test_Resdnt2@yopmail.com","","10","Active" );
		String serviceId3=Services.M_AddService("Off Market","New South Wales","Almor Distt 324");
		Services.editService("Connected");
		String 	meterId3 =Metering.add_Metering();
		String registerId3 = Metering.create_Register("Na","KWH","ALLDAY","5","0","0","17");
		Metering.add_MeterReads("Initial","150","200","300");
		Metering.add_MeterReads("Actual Read","200","400","650");
		List<String> customerList = new ArrayList<String>();
		customerList.add(CustomerID01R);
		customerList.add(CustomerID02B);
		customerList.add(CustomerID03C);

		billRunCycleName= BillRun.createBillCycle(customerList);
		BillRun.runBillCycle(billRunCycleName);
		BillRun.commitBillRun(billRunCycleName);
	}

	@Test(priority = 4,enabled = true)
	public  void TwoCustomer_RollBack() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		BillRun.Rollback_SmallBillRunWithSingleCustomer(billRunCycleName);
	}
	@Test(priority = 5,enabled = true)
	public  void TwoCustomer_ReBill() throws InterruptedException, AWTException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		customerList.add(customerId2);
		BillRun.runBillCycle(billRunCycleName);

	}
	@Test(priority = 6,enabled = true)
	public  void TwoCustomer_FullStatementRollBack() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		BillRun.rollback_in_statementTab(customerId2);
	}
	@Test(priority = 7,enabled = true)
	public  void TwoCustomer_RebillStatement() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rebill ");
		extentTest.setDescription(" Verify that User is able to run full statement rebill ");
		BillRun.statementRebill(customerId2);
	}

}