package TestCases;

import CommonMethods.BaseTest;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.Test;

import java.io.IOException;

//import POM.Flow2_3AddTOUFileAndPlan;

public class Imports extends BaseTest {



	@Test(priority = 1)
	public  void MeterNumberImport() throws InterruptedException, IOException, CsvException {
		extentTest = extent.startTest(" Meter Number import ");
		extentTest.setDescription(" Verify that User is able to run meter number import");
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.CustomerPrerequiste();
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.MeterNumberImport.MeterNumberImportFile();

	}
	@Test(priority = 1,enabled = false)
	public  void MeterRegisterImport() throws InterruptedException, IOException, CsvException {
		extentTest = extent.startTest(" Meter Register ");
		extentTest.setDescription(" Verify that User is able to run meter register");
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.CustomerPrerequiste();
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.MeterNumberImport.MeterNumberImportFile();
	}

	@Test(priority = 1,enabled = false)
	public  void Invoicesetup() throws InterruptedException, IOException, CsvException {
		extentTest = extent.startTest("Invoice Setup ");
		extentTest.setDescription(" Verify that User is able to run  invoice setup");
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.CustomerPrerequiste();
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.MeterNumberImport.MeterNumberImportFile();
	}

}
