package POM;
//Cash Payment Method

import CommonMethods.DateAndTime;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import POM.Flow2_3AddTOUFileAndPlan.TouImport;
import POM.Flow6_7AddingServiceAndMeter.X_AddService;
import TestCases.TestLogin;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static TestCases.Imports.serviceId;

public class Flow11Import_Transactions_Update_Download_And_EmailStatement extends TestLogin {
		public static JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		public static String CustomerPrerequiste() throws InterruptedException {
			Thread.sleep(2000);
			Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
		return 	Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();

		}
		
		
		// Import Meter number and meter register
		
		public static class MeterNumberImport{
			
			public static By MeterNumbersIcon = By.xpath("//p[text()='Meter Numbers']");

			public static void MeterNumberImportFile() throws IOException, InterruptedException, CsvException {
				String filePath = System.getProperty("user.dir") + "/TestData/format.csv";
				WebDriverWaits.ClickOn(Flow2_3AddTOUFileAndPlan.TouImport.AdminIcon);
				WebDriverWaits.ClickOn(MeterNumbersIcon);
				serviceId= "8354427260";
				System.out.println("Service id generated is "+serviceId);
				csvFileReplace(filePath,serviceId,1,0);
				Thread.sleep(2000);
				WebElement BrowseFile = driver.findElement(By.xpath("//input[@id='attFile']"));
				BrowseFile.sendKeys(filePath);
				Thread.sleep(2000);
				WebDriverWaits.SendKeys(TouImport.DescriptionField, "Meter Numbers " +serviceId);
				WebDriverWaits.ClickOn(TouImport.UploadFileButton);
				jse.executeScript("window.scrollBy(0,400)", "");
				WebDriverWaits.ClickOn(TouImport.ImportDataIcon);
				WebDriverWaits.ClickOn(TouImport.OKBtnConfirmationPopup);
				jse.executeScript("window.scrollBy(0,300)", "");
				String SuccessMsg = WebDriverWaits.GetText(TouImport.ImportSuccessMessage);
				Assert.assertEquals(SuccessMsg, "Import Successful!");

			}
		}
		
//		 public void CSVFileHandle() throws IOException {
//		        String CSV_File_Path = (System.getProperty("user.dir") + "/TestData/Electricity - Meter Import Template.csv");
//		        Reader reader = Files.newBufferedReader(Paths.get(CSV_File_Path));
//		        CSVParser CSVParser = new CSVParser(reader, CSVFormat.DEFAULT);
//
//		        for (CSVRecord CSVRecord : CSVParser) {
//		            String name = CSVRecord.get(0);
//		            String product = CSVRecord.get(1);
//		            String description = CSVRecord.get(2);
//		            System.out.println("Record No - " + CSVRecord.getRecordNumber());
//		            System.out.println("---------------");
//		            System.out.println("Name : " + name);
//		            System.out.println("Product : " + product);
//		            System.out.println("Description : " + description);
//		            System.out.println("---------------");
//		        }
//		    }
			 public static void csvFileReplace(String fileToUpdate, String replace, int row, int col) throws IOException, CsvException {

				 File inputFile = new File(fileToUpdate);

// Read existing file
				 CSVReader reader = new CSVReader(new FileReader(inputFile));
				 List<String[]> csvBody = reader.readAll();
// get CSV row column  and replace with by using row and column
				 csvBody.get(row)[col] = replace;
				// csvBody.get(row)[19] = DateAndTime.DateGenerator();

				 reader.close();

// Write to CSV file which is open
				 CSVWriter writer = new CSVWriter(new FileWriter(inputFile), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);
				 writer.writeAll(csvBody);
				 writer.flush();
				 writer.close();
			 }

		 public static void CSVFileOverwrite() throws IOException {

		        List<String[]> csvData = createCsvDataSpecial();
		        try (CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("user.dir") + "/TestData/format.csv"), CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END))  {
		            writer.writeAll(csvData);
		        }
		    }

		    public static List<String[]> createCsvDataSpecial() {


		        String[] header = {"*Service ID", "*Meter Serial Number", "*Status", "*Consumption Type", "*Configuration", "Multiplier", "Constant", "Hazard", "Location", "Additional Site Info", "Meter Point ID", "Next Scheduled Read Date", "Manufacturer", "Model", "Meter Read Type", "Route", "Walk Order", "*Meter Installation Type", "*Date Connected", "Date Removed"};
		        String[] record1 = {serviceId, "Z013430", "Current", "Cumulative", "POS", "", "", "", "", "", "", "", "", "", "", "", "", "BASIC", DateAndTime.DateGenerator(),""};
		        List<String[]> list = new ArrayList<>();
		        list.add(header);
		        list.add(record1);
		        return list;

		    }    
		    
		    
		
	
		public static void BillRunPrerequiste() throws InterruptedException {
		
			Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle();
			Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();
			
		}
		
		public static void SearchCustomer() throws InterruptedException {
			
			WebDriverWaits.ClickOn(X_AddService.SearchIcon);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(X_AddService.SearchField);
			String ThirdRecID = WebDriverWaits.GetText(X_AddService.selectResidentialCustomer_Record);
			WebDriverWaits.SendKeys(X_AddService.SearchField, ThirdRecID);

			WebDriverWaits.ClickOn(X_AddService.SearchIcon);
			Thread.sleep(4000);
		}

		

		
		
		
		public static class X_Transactions_CashPaymentMethod {
			
			public static By Transactions =By.xpath ("(//*[@class='icon-money'])[1]");
			public static By TransactionType_Dropdown = By.xpath("//*[@id='tranType']");
			public static By TransactionType_DropdownOpn = By.xpath("//*[@id='tranType']/option[6]");
			public static By PaymentMethod_Dropdown = By.xpath("Payment Method");
			public static By PaymentMethod_DropdownOpn = By.xpath("//*[@id='tranSubType']/option[6]");
			public static By Amount_Field = By.xpath("//*[@id='amount']");
			public static By MakePayment_Button = By.xpath("//*[@id='submitBtn']");
			public static By Assert_CashPayment_Method = By.xpath("//tr[@id='trans_1']/td[5]");
			
			
			public static void M_Cash_Payment_Method() throws InterruptedException {
				
				 SoftAssert softAssert = new SoftAssert();
				 
				 WebDriverWaits.ClickOn(Transactions);
				 WebDriverWaits.ClickOn(TransactionType_Dropdown);
				 WebDriverWaits.ClickOn(TransactionType_DropdownOpn);
				 WebDriverWaits.ClickOn(PaymentMethod_Dropdown);
				 WebDriverWaits.ClickOn(PaymentMethod_DropdownOpn);
				 WebDriverWaits.ClickOn(Amount_Field);
				 String RandomNumber1 = RandomStrings.RequiredDigits(4);
				 WebDriverWaits.SendKeys(Amount_Field, RandomNumber1);
				 jse.executeScript("window.scrollBy(0,100)", "");
				 WebDriverWaits.ClickOn(MakePayment_Button);
//				 Validate Payment Method name
				 String ActualMsg1 = WebDriverWaits.GetText(Assert_CashPayment_Method);
					String ExpectedMsg1 = "Cash";
					softAssert.assertEquals(ExpectedMsg1, ActualMsg1);
					System.out.println("Payment method is Cash");
				 
				 
		}
		
			public static void Credit_Card_Payment_Method() throws InterruptedException {
				
//				 SoftAssert softAssert = new SoftAssert();
				 
				 WebDriverWaits.ClickOn(Transactions);
				 WebDriverWaits.ClickOn(TransactionType_Dropdown);
				 WebDriverWaits.ClickOn(TransactionType_DropdownOpn);
				 WebDriverWaits.ClickOn(PaymentMethod_Dropdown);
				 WebDriverWaits.ClickOn(PaymentMethod_DropdownOpn);
				 WebDriverWaits.ClickOn(Amount_Field);
				 String RandomNumber1 = RandomStrings.RequiredDigits(4);
				 WebDriverWaits.SendKeys(Amount_Field, RandomNumber1);
				 jse.executeScript("window.scrollBy(0,100)", "");
				 WebDriverWaits.ClickOn(MakePayment_Button);
		//		 Validate Payment Method name
				
					
		}
			
		}
		
		}
		
