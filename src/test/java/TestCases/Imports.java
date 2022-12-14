package TestCases;

import ExtentReport.ExtentReportClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

//import POM.Flow2_3AddTOUFileAndPlan;

public class Imports extends ExtentReportClass {

	public static String  serviceId;
	@BeforeClass
	public static void CustomerPrerequiste() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		 serviceId = POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.CustomerPrerequiste();

	}
	
	@Test(priority = 2)
	public static void MeterNumberImport() throws InterruptedException, IOException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.MeterNumberImport.MeterNumberImportFile();
		
	}
	
	
	

}
 