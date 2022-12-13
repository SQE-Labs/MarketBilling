package TestCases;

import CommonMethods.DateAndTime;
import ExtentReport.ExtentReportClass;
import POM.Flow6_7AddingServiceAndMeter;
import com.opencsv.CSVWriter;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import POM.Flow2_3AddTOUFileAndPlan;

public class Imports extends ExtentReportClass {


	public static List<String[]> createCsvDataSpecial() {

		System.out.println("ServiceIDLater3");

		String[] header = {"*Service ID", "*Meter Serial Number", "*Status", "*Consumption Type", "*Configuration", "Multiplier", "Constant", "Hazard", "Location", "Additional Site Info", "Meter Point ID", "Next Scheduled Read Date", "Manufacturer", "Model", "Meter Read Type", "Route", "Walk Order", "*Meter Installation Type", "*Date Connected", "Date Removed"};
		String[] record1 = {Flow6_7AddingServiceAndMeter.ServiceIDLater3, "Z013434", "Current", "Cumulative", "Flat", "", "", "", "", "", "", "", "", "", "", "", "", "BASIC", DateAndTime.DateTimeGenerator().toString()};
		List<String[]> list = new ArrayList<>();
		list.add(header);
		list.add(record1);

		return list;

	}
	@Test(priority = 1)
	public static void CustomerPrerequiste() throws InterruptedException {

		List<String[]> csvData = createCsvDataSpecial();
		try {
			String filePath=
					System.getProperty("user.dir") + "/TestData/Electricity - Meter Import Template New.csv";
			CSVWriter writer =
					new CSVWriter(new FileWriter(filePath));
			;
//				CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)
			writer.writeAll(csvData);
		} catch (Exception e) {
			throw new RuntimeException(e);

		}



//		extentTest = extent.startTest(" Bill Run With No Cycle ");
//		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
//		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.CustomerPrerequiste();
//
	}
	
	@Test(priority = 2)
	public static void MeterNumberImport() throws InterruptedException, IOException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.MeterNumberImport.MeterNumberImportFile();
		
	}
	
	
	

}
 