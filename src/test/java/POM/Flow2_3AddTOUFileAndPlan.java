package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;
//import junit.framework.Assert;

public class Flow2_3AddTOUFileAndPlan extends TestLogin {

//	public static String RandomRate1;
//	public static String RandomRate2;
//	public static String RandomRate3;
//	public static String RandomRate4;
//	public static String RandomRate5;
//	public static String RandomRate6;
	public static String RandomName1;
	public static String RandomName2;
	public static String RandomName3;
	public static String RandomName4;
	public static String RandomRateField1;
	public static JavascriptExecutor jse = (JavascriptExecutor) driver;
	public static Select select;

	public static class TouImport {
		public static By AdminIcon = By.xpath("//a[@title='Administration']/i");
		public static By TOUDefinitionsIcon = By.xpath("//p[text()='TOU Definitions']");
		public static By BrowseFileIcon = By.xpath("//button[@id='btnbrowseFile']");
		public static By DescriptionField = By.xpath("//input[@id='attDesc']");
		public static By UploadFileButton = By.xpath("//span[text()='Upload File']");
		public static By ImportDataIcon = By.xpath("//a[@title='Import data']");
		public static By OKBtnConfirmationPopup = By.xpath("//div[@class='bootstrap-dialog-footer-buttons']/button[1]");
		public static By ImportSuccessMessage = By.xpath("//div[@class='alert alert-success']/strong");
		

		public static void TOUImportFile() throws InterruptedException {
			WebDriverWaits.ClickOn(AdminIcon);
			Thread.sleep(2000);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(TOUDefinitionsIcon);
			Thread.sleep(2000);
			WebElement BrowseFile = driver.findElement(By.xpath("//input[@id='attFile']"));
			BrowseFile.sendKeys(System.getProperty("user.dir") + "/TestData/TOU Definition Import Template.csv");
			Thread.sleep(2000);
			WebDriverWaits.SendKeys(DescriptionField, "TOU Definition");
			WebDriverWaits.ClickOn(UploadFileButton);
			jse.executeScript("window.scrollBy(0,400)", "");
			WebDriverWaits.ClickOn(ImportDataIcon);
			WebDriverWaits.ClickOn(OKBtnConfirmationPopup);
			jse.executeScript("window.scrollBy(0,300)", "");
			String SuccessMsg = WebDriverWaits.GetText(ImportSuccessMessage);
			Assert.assertEquals(SuccessMsg, "Import Successful!");
		}
	}

	public static class Plans {
		public static By PlanTab = By.xpath("//*[@class='icon-lightbulb']");
		public static By CreateNewPlan = By.xpath("//*[@id='addBtn']");
		public static By UsageTypeDropdown = By.xpath("//*[@id='usageTypes']");
		public static By NameField = By.xpath("//*[@id='name']");
		public static By Usage_TOU_Definition_Dropdown = By.xpath("//*[@id='usageTOU']");
		public static By Demand_TOU_Definition_Dropdown = By.xpath("//*[@id='demandTOU']");
		public static By DateValidFrom_Datepicker = By.xpath("//*[@id='dateValidFrom']");
		public static By Select_Current_ValidDate_From = By.xpath("//*[@class='active day']");
		public static By DateValidTo_Datepicker = By.xpath("//*[@id='dateValidTo']");
		public static By Select_Current_ValidDate_To = By.xpath("//*[@class='active day']");
		public static By Add_Tariff_Button = By.xpath("//*[@id='addTrfBtn']");
		public static By ChargeDescription_Field = By.xpath("//*[@id='charge-desc']");
		public static By ChargeDescription_Opn = By.xpath("//div[@class='tt-dataset-states']");
		public static By RollupDescription_Field = By.xpath("//*[@id='rollup-desc']");
		public static By RollupDescription_Opn = By.xpath("(//div[@class='tt-dataset-states'])[2]");
		public static By ChargeType_Dropdown = By.xpath("//*[@id='charge-type']");
		public static By RatingMethod_Dropdown = By.xpath("//*[@id='method-type']");
		public static By RatingMethod_Dropdown_Opn = By.xpath("//option[text()='Network Volume']");
		public static By RatingMethod_Dropdown_Opn_OtherPlan = By.xpath("(//*[@id='method-type']/option)[2]");
		public static By Unit_Dropdown = By.xpath("//*[@id='unit-type']");
		public static By Unit_Dropdown_Opn = By.xpath("(//*[@id='unit-type']/option)[2]");
		public static By Rate_Field = By.xpath("//*[@id='rate']");
		public static By AddTrf_Button = By.xpath("//*[@id='addTrf']");
		public static By Trf_SearchField = By.xpath("(//label[text()='Search:'])[2]/input");
		// public static By Trf_SearchField =
		// By.xpath("//*[@id='datatablePreview_wrapper']/div[1]/label/input");
		
		public static By Publish_Button = By.xpath("//*[@id='publishBtn']");
		public static By Cross_icon = By.xpath("//*[@class='icon-remove']");
		public static By Plan_Search_Field = By.xpath("(//label[text()='Search:'])[1]/input");
		public static By SearchResultForPlanName = By.xpath("//tbody[@id='plnListBody']/tr/td[2]");
		public static By PlanSuccessMsg = By.xpath("(//div[@class='alert alert-success']/center)[2]");
		public static By EditIconTarrif = By.xpath("//i[@class='fa fa-pencil']");
		public static By InfoMsgTarrifCount = By.xpath("//div[@id='datatablePreview_info']");
		public static By PlanSearchField = By.xpath(".//*[@class='dataTables_filter']/label/input");
		public static By EditPlan = By.xpath("//*[@class='fa fa-pencil ']");
		public static By TrfCalendarIcon = By.xpath("//*[@class='icon-calendar']");
		public static By Prorata_ToggleButton = By.xpath("(//*[@class='switch-label'])[2]");
		public static By Prorata_RangeFrom_Datepicker = By.xpath("//*[@id='rangeFrom']");
		public static By SelectTodayProrataDate_RangeFrom = By.xpath("//*[@class='active selected day']");
		public static By Prorata_RangeTo_Datepicker = By.xpath("//*[@id='rangeTo']");
		public static By SelectTodayProrataDate_RangeTo = By.xpath("//*[@class='active selected day']");
		public static By ProrataRateField = By.xpath("//*[@id='rateR']");
		public static By ProrataPlus_Button = By.xpath("//*[@id='addProrataBtn']");
		public static By ProrataClose_Button = By.xpath("//*[@id='prorataClose']");
		public static By PorataPlan = By.xpath("(//*[@class='fa fa-pencil '])[1]");
		public static By PlanCrossIcon = By.xpath("//*[@class='icon-remove']");
		public static By AssertionProrataPlus_Button = By.xpath("//*[@id='datatableProrata_info']");
		
		
		
		public static void AddPlanwithoutTOUDefinition() throws InterruptedException {
			
			SoftAssert softAssert = new SoftAssert();
			WebDriverWaits.ClickOn(PlanTab);
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(CreateNewPlan);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(UsageTypeDropdown);
			WebElement UsageOption = WebDriverWaits.WaitUntilVisibleWE(UsageTypeDropdown);
			select = new Select(UsageOption);
			select.selectByVisibleText("Retail Electricity");
			WebDriverWaits.ClickOn(NameField);
			 RandomName1 = "Market_Plan" + RandomStrings.RequiredCharacters(4);
			WebDriverWaits.SendKeys(NameField, RandomName1);
			System.out.println(RandomName1);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(DateValidFrom_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_From);
			WebDriverWaits.ClickOn(DateValidTo_Datepicker);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_To);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Flat Rate Usage");
			WebDriverWaits.ClickOn(ChargeDescription_Opn);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Account Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption);
			// select.selectByVisibleText("Ausgrid kVA Capacity Charge");
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			// WebElement UnitOption =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(UnitOption);
			// select.selectByIndex(1);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate1 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate1);
			Thread.sleep(4000);
			WebDriverWaits.ClickOn(AddTrf_Button);
			Thread.sleep(4000);
			
			
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate1);
			Thread.sleep(2000);
			List<WebElement> countEditIcon1 = driver.findElements(EditIconTarrif);
			int sizeOfList1 = countEditIcon1.size();
			boolean compareList1 = sizeOfList1 == 1;
			softAssert.assertEquals(compareList1, true);
			String TarrifMsg1 = WebDriverWaits.GetText(InfoMsgTarrifCount);
			String ExpectedTMsg1 = "Showing 1 to 1 of 1 entries";
			softAssert.assertEquals(ExpectedTMsg1, TarrifMsg1);
			System.out.println("Tarrif for Plan without TOUDefinition has been searched successfully.");
			driver.findElement(Trf_SearchField).clear();
			Thread.sleep(4000);
			WebDriverWaits.ClickOn(Publish_Button);
			// Assertion "Market has been successfully created."
			String ActualPlanSucessMsg1 = WebDriverWaits.GetText(PlanSuccessMsg);
			String ExpectedMsg1 = RandomName1 +" has been successfully created.";
			softAssert.assertEquals(ExpectedMsg1, ActualPlanSucessMsg1);
			System.out.println("Market having Plan without TOUDefinition has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);
			Thread.sleep(4000);
			// Search the same created plan.
			WebDriverWaits.ClickOn(Plan_Search_Field);
			WebDriverWaits.SendKeys(Plan_Search_Field, RandomName1);
			// Assertion that the plan is added.
            String SearchResultPlanName = WebDriverWaits.GetText(SearchResultForPlanName);
            softAssert.assertEquals(SearchResultPlanName, RandomName1);
			System.out.println("Market having Plan without TOUDefinition has been successfully searched.");
			softAssert.assertAll();
		}

		public static void PlanwithTOUDefinition_Network_and_Retail_Trf() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			WebDriverWaits.ClickOn(PlanTab);
			WebDriverWaits.ClickOn(CreateNewPlan);
			WebDriverWaits.ClickOn(UsageTypeDropdown);
			WebElement UsageOption = WebDriverWaits.WaitUntilVisibleWE(UsageTypeDropdown);
			select = new Select(UsageOption);
			select.selectByVisibleText("Retail Electricity");
			// select.selectByIndex(2);
			WebDriverWaits.ClickOn(NameField);
			String RandomName2 = "MktPlan_NetworkRate" + RandomStrings.RequiredCharacters(4);
			WebDriverWaits.SendKeys(NameField, RandomName2);
			System.out.println(RandomName2);
			WebDriverWaits.ClickOn(Usage_TOU_Definition_Dropdown);
			
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(DateValidFrom_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_From);
			WebDriverWaits.ClickOn(DateValidTo_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_To);

			// Add Trf with Rating Method as Network Volume
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Flat Usage");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Account Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption =WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption);
			// select.selectByVisibleText("Network Volume") // Need to scroll the dropdown
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate2 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate2);
			WebDriverWaits.ClickOn(AddTrf_Button);

			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate2);
			Thread.sleep(2000);
			// Assertion on Showing 1 to 1 of 1 entries
			List<WebElement> countEditIcon2 = driver.findElements(EditIconTarrif);
			int sizeOfList2 = countEditIcon2.size();
			boolean compareList2 = sizeOfList2 == 1;
			softAssert.assertEquals(compareList2, true);
			String TarrifMsg2 = WebDriverWaits.GetText(InfoMsgTarrifCount);
			String ExpectedTMsg2 = "Showing 1 to 1 of 1 entries";
			softAssert.assertEquals(ExpectedTMsg2, TarrifMsg2);
			System.out.println("Plan with TOU Definition having Network rating method is successfully added");
			driver.findElement(Trf_SearchField).clear();

			// Add Trf with Rating Method as Retail Volume
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Retail Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Electricity Usages");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption1 = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption1);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption1 = WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption1);
			// select.selectByVisibleText("Retail Volume") // Need to scroll the dropdown
			WebDriverWaits.ClickOn(Unit_Dropdown);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate3 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate3);
			WebDriverWaits.ClickOn(AddTrf_Button);
			driver.findElement(Trf_SearchField).clear();
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate3);
			Thread.sleep(2000);
			// Assertion on Showing 1 to 1 of 1 entries
			List<WebElement> countEditIcon3 = driver.findElements(EditIconTarrif);
			int sizeOfList3 = countEditIcon3.size();
			boolean compareList3 = sizeOfList3 == 1;
			softAssert.assertEquals(compareList3, true);
//			String TarrifMsg3[] = WebDriverWaits.GetText(InfoMsgTarrifCount).split("(");
//			String ExpectedTMsg3 = "Showing 1 to 1 of 1 entries ";
//			softAssert.assertEquals(ExpectedTMsg3, TarrifMsg3[0]);
			
			System.out.println("Search completed for Market having Plan with TOUDefinition");
			driver.findElement(Trf_SearchField).clear();
			Thread.sleep(4000);
			
			WebDriverWaits.ClickOn(Publish_Button);
			// Assertion "Market has been successfully created."
			String ActualPlanSucessMsg2 = WebDriverWaits.GetText(PlanSuccessMsg);
			String ExpectedMsg2 = RandomName2 +" has been successfully created.";
			softAssert.assertEquals(ExpectedMsg2, ActualPlanSucessMsg2);
			System.out.println("Market having Plan with TOUDefinition Market has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);
			WebDriverWaits.ClickOn(Plan_Search_Field);
			WebDriverWaits.SendKeys(Plan_Search_Field, RandomName2);
			String SearchResultPlanName = WebDriverWaits.GetText(SearchResultForPlanName);
			softAssert.assertEquals(SearchResultPlanName, RandomName2);
			jse.executeScript("window.scrollBy(0,-400)", "");
			softAssert.assertAll();
			Thread.sleep(2000);

			// Search the same created plan.
			// Assertion that the plan is added.

		}

		public static void PlanwithDemandTOUdefinition_Network_and_Retail_Trf() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			WebDriverWaits.ClickOn(PlanTab);
			WebDriverWaits.ClickOn(CreateNewPlan);
			WebDriverWaits.ClickOn(UsageTypeDropdown);
			WebElement UsageOption = WebDriverWaits.WaitUntilVisibleWE(UsageTypeDropdown);
			select = new Select(UsageOption);
			select.selectByVisibleText("Retail Electricity");
			// select.selectByIndex(2);
			WebDriverWaits.ClickOn(NameField);
			String RandomName3 = "MktPlan_NetworkRate" + RandomStrings.RequiredCharacters(4);
			WebDriverWaits.SendKeys(NameField, RandomName3);
			System.out.println(RandomName3);
			WebDriverWaits.ClickOn(Demand_TOU_Definition_Dropdown);

			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(DateValidFrom_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_From);
			WebDriverWaits.ClickOn(DateValidTo_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_To);

			// Add Trf with Rating Method as Network Volume
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Flat Usage");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Account Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption);
			// select.selectByVisibleText("Network Volume") ;// Need to scroll the dropdown
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate4 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate4);
			WebDriverWaits.ClickOn(AddTrf_Button);
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate4);

			// Assertion on Showing 1 to 1 of 1 entries
			// Assertion that the Trf is added.
			// Add Trf with Rating Method as Retail Volume
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Retail Electricity Charges");
			WebDriverWaits.ClickOn(ChargeDescription_Opn);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Electricity Usages");
			WebDriverWaits.ClickOn(RollupDescription_Opn);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption1 = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption1);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption1 =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption1);
			// select.selectByVisibleText("Retail Volume")
			// select.selectByValue("GV");
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			// WebElement UnitOption1 =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(UnitOption1);
			// select.selectByVisibleText("$/kW/year");
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate5 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate5);
			WebDriverWaits.ClickOn(AddTrf_Button);
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate5);

			// Assertion on Showing 1 to 1 of 1 entries
			
			
			
			WebDriverWaits.ClickOn(Publish_Button);
			// Assertion "Market has been successfully created."
			String ActualPlanSucessMsg3 = WebDriverWaits.GetText(PlanSuccessMsg);
			String ExpectedMsg3 = RandomName3 +" has been successfully created.";
			softAssert.assertEquals(ExpectedMsg3, ActualPlanSucessMsg3);
			System.out.println("Market having Plan with DemandTOUdefinition Market has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);
			WebDriverWaits.ClickOn(Plan_Search_Field);
			WebDriverWaits.SendKeys(Plan_Search_Field, RandomName3);
			String SearchResultPlanName = WebDriverWaits.GetText(SearchResultForPlanName);
			softAssert.assertEquals(SearchResultPlanName, RandomName3);
			Thread.sleep(2000);
			softAssert.assertAll();
//			//Just an alternate because other plan and prorata modules are not executing
//			jse.executeScript("window.scrollBy(0,-400)", "");
//			Thread.sleep(2000);

			
		}

		public static void OtherPlan() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();

			WebDriverWaits.ClickOn(PlanTab);
			WebDriverWaits.ClickOn(CreateNewPlan);
			WebDriverWaits.ClickOn(UsageTypeDropdown);
			WebElement UsageOption = WebDriverWaits.WaitUntilVisibleWE(UsageTypeDropdown);
			select = new Select(UsageOption);
			select.selectByVisibleText("Retail Electricity");
			WebDriverWaits.ClickOn(NameField);
			RandomName4 = "OtherPlan" + "random" + RandomStrings.RequiredCharacters(6);
			WebDriverWaits.SendKeys(NameField, RandomName4);
			System.out.println(RandomName4);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(DateValidFrom_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_From);
			WebDriverWaits.ClickOn(DateValidTo_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_To);
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			// Assertion_obj.AssertTariffButton
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Other Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "All USages rates");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption);
			select.selectByVisibleText("Account Level Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn_OtherPlan);
			// WebElement RatingOption =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption);
			// select.selectByIndex(1);
			// select.selectByVisibleText("Ausgrid kVA Capacity Charge");
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate6 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate6);
			
			WebDriverWaits.ClickOn(AddTrf_Button);
			System.out.println("OtherPlan Market Tarrif has been successfully created.");
//			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//			WebDriverWaits.ClickOn(Trf_SearchField);
//			WebDriverWaits.SendKeys(Rate_Field, RandomRate6);
//			Thread.sleep(2000);
//			List<WebElement> countEditIcon4 = driver.findElements(EditIconTarrif);
//			int sizeOfList4 = countEditIcon4.size();
//			boolean compareList4 = sizeOfList4 == 1;
//			softAssert.assertEquals(compareList4, true);
//			String TarrifMsg = WebDriverWaits.GetText(InfoMsgTarrifCount);
//			String ExpectedMsg = "Showing 1 to 1 of 1 entries";
//			softAssert.assertEquals(ExpectedMsg, TarrifMsg);
//			System.out.println("Search completed for Market having OtherPlan.");
			WebDriverWaits.ClickOn(Publish_Button);
			// Assertion "Market has been successfully created."
			String ActualPlanSucessMsg4 = WebDriverWaits.GetText(PlanSuccessMsg);
			String ExpectedMsg4 = RandomName4 +" has been successfully created.";
			softAssert.assertEquals(ExpectedMsg4, ActualPlanSucessMsg4);
			System.out.println("Market having OtherPlan Market has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);
			WebDriverWaits.ClickOn(Plan_Search_Field);
			WebDriverWaits.SendKeys(Plan_Search_Field, RandomName4);
			String SearchResultPlanName = WebDriverWaits.GetText(SearchResultForPlanName);
			softAssert.assertEquals(SearchResultPlanName, RandomName4);
			softAssert.assertAll();
			jse.executeScript("window.scrollBy(0,-400)", "");

		}

		public static void Add_ProRated_Rates() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.navigate().refresh();
			
//			WebDriverWaits.ClickOn(PlanCrossIcon);
			Thread.sleep(2000);
			jse.executeScript("window.scrollBy(0,-1000)", "");

			WebDriverWaits.ClickOn(PorataPlan);
			WebDriverWaits.ClickOn(NameField);
			String NameValue = driver.findElement(NameField).getAttribute("value");
			System.out.println(NameValue);
			Thread.sleep(2000);
			//WebDriverWaits.ClickOn(PlanSearchField);
		//	WebDriverWaits.SendKeys(PlanSearchField, RandomName1); // search tou network plan
	//		WebDriverWaits.ClickOn(EditPlan);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(TrfCalendarIcon);
			WebDriverWaits.ClickOn(Prorata_ToggleButton);
			WebDriverWaits.ClickOn(Prorata_RangeFrom_Datepicker);
			WebDriverWaits.ClickOn(SelectTodayProrataDate_RangeFrom);
			WebDriverWaits.ClickOn(Prorata_RangeTo_Datepicker);
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(SelectTodayProrataDate_RangeTo);
			WebDriverWaits.ClickOn(ProrataRateField);
			String RandomRateField1 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(ProrataRateField, RandomRateField1);
			
			WebDriverWaits.ClickOn(ProrataPlus_Button);
			Thread.sleep(6000);
			List<WebElement> countEditIcon4 = driver.findElements(By.xpath("//tbody[@id='prorataTableContent']//td[@class='sorting_1']"));
			int sizeOfList4 = countEditIcon4.size();
			System.out.println(sizeOfList4);
			boolean compareList4 = sizeOfList4 == 1;
			softAssert.assertEquals(compareList4, true);
			softAssert.assertAll();
			
			
			
			
			
			WebDriverWaits.ClickOn(ProrataClose_Button);
			Thread.sleep(2000);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(Publish_Button);
			Thread.sleep(6000);
//			// MktPlan_NetworkRateQJog has been successfully updated.
//			String ActualPlanSucessMsg5 = WebDriverWaits.GetText(PlanSuccessMsg);
//			String ExpectedMsg5 =RandomName4 + " has been successfully created.";
//			softAssert.assertEquals(ExpectedMsg5, ActualPlanSucessMsg5);
//			System.out.println(RandomName4 + " has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);
			
		}

	}
}