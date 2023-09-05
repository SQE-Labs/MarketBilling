package POM;

import BrowsersBase.DataInterface;
import CommonMethods.DateAndTime;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static POM.Flow5_AddCustomer.*;
import static POM.GroupEdit.softAssert;

public class BillRun extends TestLogin {
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static By ConfirmationAssertion = By.xpath("//*[@class='bootstrap-dialog-message']");
    public static By BillRun_Tab = By.xpath("//*[@class='icon-tasks']");
    public static By RunTheBills_Button = By.xpath("//*[@class='btn btn-success']");
    public static By BillRun_StartDate_Datepicker = By.xpath("//*[@id='cycleDate']");
    public static By Select_BillRun_StartDate_Datepicker = By.xpath("//*[@class='active day']");
    public static By BillRun_EndDate_Datepicker = By.xpath("//*[@id='cycleEnd']");
    public static By Select_BillRun_EndDate_Datepicker = By.xpath("//*[@class='active day']");
    public static By BillRun_IssueDate_Datepicker = By.xpath("//*[@id='issueDate']");
    public static By Select_BillRun_IssueDate_Datepicker = By.xpath("//*[@class='active day']");
    public static By BillRun_DueDate_Datepicker = By.xpath("//*[@id='dueDate']");
    public static By Select_BillRun_DueDate_Datepicker = By.xpath("//*[@class='active day']");

    public static By BillRun_Button = By.xpath("//button[contains(text(),'Run Bill')]");
    public static By Continue_Button = By.xpath("//button[contains(text(),'Continue')]");
    public static By OK_Button = By.xpath("//button[contains(text(),'OK')]");
    public static By Spinner_Icon = By.xpath("//div[@class='spinner']");
    public static By View_Button = By.xpath("//button[contains(text(),'View')]");
    public static By Cancel_Button = By.xpath("//*[@class='close']");
    public static By rollbackCancel = By.className("bootstrap-dialog-close-button");

    public static By Yes_Button = By.xpath("//button[contains(text(),'Yes')]");
    public static By Admin_Tab = By.xpath("//a[@title='Administration']/i");
    public static By BillRunCycles_Subtab = By.xpath("//*[contains(text(),'Bill Run Cycles')]");
    public static By AddBillRunCycleButton_CreateNew = By.xpath("//*[@id='addBtn']");
    public static By billSearch = By.xpath("//input[@type='search']");
    public static By editActionBtn = By.xpath("//a[@title='Edit']");

    public static By billRunSearch = By.cssSelector(".box-icon a");

    public static By CycleName_Field = By.xpath("//*[@id='cyclename']");
    public static By CustomerListFilter = By.xpath("//*[@placeholder='Customer List Filter']");
    public static By CustomerListFilterOpn = By.xpath("(//select[@multiple='multiple'])[1]");
    public static By ArrowRight = By.xpath("(//*[@class='glyphicon glyphicon-arrow-right'])[3]");
    public static By SaveButton = By.xpath("//button[contains(text(),'Save')]");
    public static By BillRunCycleSuccessMsg = By.xpath("//div[@class='alert alert-success']/center");
    public static By BillRunCycle_Dropdown = By.xpath("//*[@id='cycleno']");
    public static By BillRunCycle_DropdownOpn = By.xpath("//*[@id='cycleno']/option[2]");
    public static By Rollback_and_Fix_Tab = By.xpath("//*[@id='rollback-and-fix']");
    public static By Continue_rollback_Button = By.xpath("(//*[contains(text(),'Continue rollback')])[2]");
    public static By RollbackCompleteSuccessMsg = By.xpath("(//div[contains(text(),'Rollback complete.')])");
    // public static By Cancel_Button = By.xpath("//*[@class='bootstrap-dialog-close-button']");
    public static By Statement_Subtab = By.xpath("//*[@class='icon-columns']");
    public static By ViewDetails_Icon = By.xpath("//*[@title='View Details']");
    public static By EditDetails_Icon = By.xpath("//i[@class='icon-edit']");
    public static By newIssueDate = By.cssSelector("input#custIssueDate");
    public static By updateBtn = By.xpath("//button[contains(text(),'Update')]");
    public static By textIssueDate = By.xpath("//tr/td[3]");

    public static By Rollback_Button = By.xpath("//*[@class='btn btn-mini btn-danger']");
    public static By RollbackReason_Field = By.xpath("//*[@id='rollbackReason']");
    public static By Ok_Button = By.xpath("//*[contains(text(),'OK')]");
    public static By Successrollback_assertion = By.xpath("//*[@Class='bootstrap-dialog-body']");
    public static By BillRunCycleOption = By.xpath("//select[@id='cycleno']");
    public static By RollbackCross_Icon = By.xpath("//*[@class='bootstrap-dialog-close-button']");
    public static By Bill_Run_Complete_CloseButton = By.xpath("(//*[@class='btn btn-primary'])[3]");

    public static By viewRollBackHistoryBtn = By.xpath("//*[contains(text(),' View Rollback History')]");
    public static By editActionIcon = By.xpath("//*[@class='btn btn-mini btn-success']");
    public static By runBillS = By.cssSelector(".form-group #runBill");
    public static By customer_checkBox = By.id("chkDelete_0");

    public static By downloadPdf = By.xpath("//button[contains(text(),'Download')]");
    public static By emailBills = By.xpath("//button[contains(text(),'Email')]");
    public static By selectedCustomer = By.xpath("//a[contains(text(),'Selected')]");
    public static By selectedCustomers = By.xpath("(//a[contains(text(),'Selected customers')])[2]");

    public static By continueEmail = By.xpath("//button[contains(text(),'Continue')]");
    public static By status = By.cssSelector("#emailResultData  td:nth-child(5)");
    public static By dateSend = By.cssSelector("#emailResultData  td:nth-child(4)");

    public static By close = By.id("sendEmailResultClose");
    public static By download = By.id("submitSelected");
    static SoftAssert softAssert = new SoftAssert();
    public static void BillrunMethod_NoCycle() throws InterruptedException {
        // SoftAssert softAssert = new SoftAssert();

        jse.executeScript("window.scrollBy(0,-400)", "");
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);

        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        WebDriverWaits.ClickOn(Continue_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(OK_Button);
//			Thread.sleep(500000);
//			WebDriverWaits.WaitUntilInvisible(Spinner_Icon);
        WebDriverWaits.ClickAfter5mins(View_Button);
//			WebDriverWaits.ClickOn(View_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Cancel_Button);
        Thread.sleep(2000);

        WebDriverWaits.ClickOn(Yes_Button);
        Thread.sleep(2000);


    }

    public static void BillRunWithUncommittedStatement(String billCycleName, String customerId) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.navigate().refresh();

////		WebDriverWaits.ClickOn(X_BillrunCycle.Bill_Run_Complete_CloseButton);
//		WebDriverWaits.ClickOn(Cancel_Button);
//		WebDriverWaits.ClickOn(Yes_Button);
        Thread.sleep(2000);
        //WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
        Thread.sleep(2000);
        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select = new Select(BillRunCycOption);
        Thread.sleep(2000);
        select.selectByVisibleText(billCycleName);
        //BillRunCycleOption
        //driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        // Assert Warning: Customer 40113 previously billed on uncommitted statement. Do you want to proceed?
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(ConfirmationAssertion);
        String ExpectedMsg1 = "Customer " + customerId + "previously billed on uncommitted statement. Do you want to proceed?";
        softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully asserted the popup text while bill run with uncomitted statement.");
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(OK_Button);
        Thread.sleep(10000);

    }

   /* public static String BillRunCycle(String customerId) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWaits.ClickOn(Admin_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRunCycles_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(CycleName_Field);
        String BillCycleName = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(CycleName_Field, BillCycleName);
        WebDriverWaits.ClickOn(CustomerListFilter);
        WebDriverWaits.SendKeys(CustomerListFilter, customerId);
        Thread.sleep(2000);
        WebElement CustomerListOption = WebDriverWaits.WaitUntilVisibleWE(CustomerListFilterOpn);
        Select CustomerList = new Select(CustomerListOption);
        Thread.sleep(2000);
        CustomerList.selectByIndex(0);
        Thread.sleep(2000);
        WebElement CustomerListFirstOp = (WebElement) jse.executeScript("return document.querySelector('#bootstrap-duallistbox-nonselected-list_custnos > option')");
        WebDriverWaits.ClickOnWE(CustomerListFirstOp);

        WebDriverWaits.ClickOn(ArrowRight);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(SaveButton);
        // Assertion: Successfully added new bill run cycle.
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
        String ExpectedMsg1 = "Successfully added new bill run cycle.";
        softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully added new bill run cycle for single customer.");
        Thread.sleep(4000);
        System.out.println("Bill Cycle name --------- " + BillCycleName);
        return BillCycleName;
    }   */

    public static void SmallBillRunWithSingleCustomer(String billCycleName) throws InterruptedException {
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
        }
        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
        Thread.sleep(2000);
        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select = new Select(BillRunCycOption);
        Thread.sleep(4000);
        select.selectByVisibleText(billCycleName);
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        WebDriverWaits.ClickAfter5mins(View_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Cancel_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Yes_Button);
    }

    public static void Rollback_SmallBillRunWithSingleCustomer(String customerId) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchIcon);
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchField);
        WebDriverWaits.SendKeys(Flow6_7AddingServiceAndMeter.X_AddService.SearchField, customerId);
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchIcon);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Statement_Subtab);
        WebDriverWaits.ClickOn(ViewDetails_Icon);
        WebDriverWaits.ClickOn(Rollback_Button);
        WebDriverWaits.ClickOn(RollbackReason_Field);
        WebDriverWaits.SendKeys(RollbackReason_Field, "Kindly rollback the statement.");
        WebDriverWaits.ClickOn(Ok_Button);

        //Assert 	Rollback for customer 40037 and statement 7899 has been successful.
        Thread.sleep(10000);
        WebDriverWaits.ClickOn(RollbackCross_Icon);
        Thread.sleep(3000);


//		WebDriverWaits.ClickOn(Rollback_and_Fix_Tab);
//		WebDriverWaits.ClickOn(Continue_rollback_Button);
//		Thread.sleep(5000);
//		String ActualMsg1 = WebDriverWaits.GetText(RollbackCompleteSuccessMsg);
//		String ExpectedMsg2 = "Rollback complete.";
//		softAssert.assertEquals(ExpectedMsg2, ActualMsg1);
//		System.out.println("Successfully Rollback completed for single customer.");
//		WebDriverWaits.ClickOn(Cancel_Button);
        Thread.sleep(2000);


    }

    public static void rebillSingleCustomer(String billCycleName) throws InterruptedException {
        //Run bill again
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        //*Auto due date is enabled for the following customer category(Commercial,Residential,Business)
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        Thread.sleep(2000);
        WebElement BillRunCycOption2 = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select2 = new Select(BillRunCycOption2);
        Thread.sleep(2000);
        select2.selectByVisibleText(billCycleName);
        //driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        //	WebDriverWaits.ClickOn(Continue_Button);
        //	WebDriverWaits.ClickOn(OK_Button);
        //	Thread.sleep(200000);
        //	WebDriverWaits.ClickOn(View_Button);
        WebDriverWaits.ClickAfter5mins(View_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Cancel_Button);
        WebDriverWaits.ClickOn(Yes_Button);
        Thread.sleep(2000);

    }


    public static void filterCustomerId(String customerId) throws InterruptedException {
        WebDriverWaits.ClickOn(CustomerListFilter);
        System.out.println("Customer 1R -- " + CustomerID01R);
        System.out.println("Customer 2B -- " + CustomerID02B);
        System.out.println("Customer 3C -- " + CustomerID03C);
        WebDriverWaits.SendKeysWithClear(CustomerListFilter, customerId);
        Thread.sleep(2000);
        WebElement CustomerListOption = WebDriverWaits.WaitUntilVisibleWE(CustomerListFilterOpn);
        Select CustomerList = new Select(CustomerListOption);
        Thread.sleep(2000);
        CustomerList.selectByIndex(0);
        Thread.sleep(2000);
        WebElement CustomerListFirstOp = (WebElement) jse.executeScript("return document.querySelector('#bootstrap-duallistbox-nonselected-list_custnos > option')");
        WebDriverWaits.ClickOnWE(CustomerListFirstOp);
        WebDriverWaits.ClickOn(ArrowRight);
        Thread.sleep(2000);
    }

    public static void rollback_in_statementTab(String customerId) throws InterruptedException {
        Customer.searchCustomer(customerId);
        WebDriverWaits.ClickOn(Statement_Subtab);
        WebDriverWaits.ClickOn(ViewDetails_Icon);
        WebDriverWaits.ClickOn(Rollback_Button);
        WebDriverWaits.ClickOn(RollbackReason_Field);
        WebDriverWaits.SendKeys(RollbackReason_Field, "Kindly rollback the statement.");
        WebDriverWaits.ClickOn(Ok_Button);
        Thread.sleep(5000);
        //Assert Rollback for customer 40027 and statement 7892 has been successful.

        WebDriverWaits.ClickOn(RollbackCross_Icon);
    }

    public static void statementRebill(String customerId) throws InterruptedException {
        Customer.searchCustomer(customerId);
        WebDriverWaits.ClickOn(Statement_Subtab);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(viewRollBackHistoryBtn);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(editActionIcon);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(runBillS);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(Ok_Button);
        Thread.sleep(5000);

    }

    public static void rollback() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Rollback_and_Fix_Tab);
        WebDriverWaits.ClickOn(Continue_rollback_Button);
        Thread.sleep(5000);
        String ActualMsg1 = WebDriverWaits.GetText(RollbackCompleteSuccessMsg);
        String ExpectedMsg2 = "Rollback complete.";
        softAssert.assertEquals(ExpectedMsg2, ActualMsg1);
        System.out.println("Successfully Rollback completed for two customers.");
        WebDriverWaits.ClickOn(rollbackCancel);
        Thread.sleep(2000);

    }

    public static String createBillCycle(List<String> customerIdList) throws InterruptedException {
        driver.navigate().refresh();
        jse.executeScript("window.scrollBy(0,-500)", "");
        WebDriverWaits.ClickOn(Admin_Tab);
        WebDriverWaits.scrollIntoView(BillRunCycles_Subtab);
        WebDriverWaits.ClickOn(BillRunCycles_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(CycleName_Field);
        String billRunCycleName = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeysWithClear(CycleName_Field, billRunCycleName);
        System.out.println("Bill run cyccle create with name ---" + billRunCycleName);
        for (String customerId : customerIdList) {
            BillRun.filterCustomerId(customerId);
        }
        WebDriverWaits.ClickOn(SaveButton);
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Successfully added new bill run cycle.", ActualMsg);
        System.out.println("Successfully added new bill run cycle for  customers. " + billRunCycleName);
        Thread.sleep(4000);
        return billRunCycleName;
    }

    public static String editBillCycle(String oldBillCycleName) throws InterruptedException {
        driver.navigate().refresh();
        jse.executeScript("window.scrollBy(0,-500)", "");
        WebDriverWaits.ClickOn(Admin_Tab);
        WebDriverWaits.scrollIntoView(BillRunCycles_Subtab);
        WebDriverWaits.ClickOn(BillRunCycles_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.SendKeysWithClear(billSearch, oldBillCycleName);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(editActionBtn);
        String billRunCycleNewName = oldBillCycleName + RandomStrings.RequiredCharacters(3);
        WebDriverWaits.SendKeysWithClear(CycleName_Field, billRunCycleNewName);
        System.out.println("Bill run cycle renamed with name ---" + billRunCycleNewName);

        WebDriverWaits.ClickOn(SaveButton);
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Successfully updated " + oldBillCycleName + "cycle.", ActualMsg);
        System.out.println("Successfully added new bill run cycle for  customers. " + billRunCycleNewName);
        Thread.sleep(4000);
        return billRunCycleNewName;
    }

    public static void runBillCycle(String billRunCycleName) throws InterruptedException {
        LandingPage.navigateToHomePage();
        //First Time Bill run
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
        Thread.sleep(2000);
        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select = new Select(BillRunCycOption);
        Thread.sleep(2000);
        select.selectByVisibleText(billRunCycleName);
        Thread.sleep(2000);
        WebDriverWaits.scrollIntoView(BillRun_Button);
        WebDriverWaits.ClickOn(BillRun_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickAfter5mins(View_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Cancel_Button);
        WebDriverWaits.ClickOn(Yes_Button);
        Thread.sleep(2000);
    }

    public static void runBillCycleForRollBack(String billRunCycleName) throws InterruptedException {

        //First Time Bill run
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
        //WebDriverWaits.ClickOn(BillRunCycle_DropdownOpn);
        Thread.sleep(2000);
        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select = new Select(BillRunCycOption);
        Thread.sleep(2000);
        select.selectByVisibleText(billRunCycleName);
        //BillRunCycleOption
        //driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickAfter5mins(View_Button);
        Thread.sleep(2000);

    }

    public static void updateStatementDate(String customerId) throws InterruptedException {
        WebDriverWaits.ClickOn(Statement_Subtab);
        WebDriverWaits.ClickOn(EditDetails_Icon);
        String issueDate = DateAndTime.getDateWithDays("dd/MM/yyyy", 2);
        WebDriverWaits.SendKeys(newIssueDate, issueDate);
        WebDriverWaits.ClickOn(updateBtn);
        Thread.sleep(4000);
        SoftAssert softAssert = new SoftAssert();
        String issued = WebDriverWaits.GetText(textIssueDate);
        softAssert.assertEquals(issueDate, issued);
        Thread.sleep(2000);


    }

    public static void billRunCycleSearch(String billCycle) throws InterruptedException {
        Admin.navigateToBillRun();
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(billRunSearch);
        WebDriverWaits.SendKeysWithClear(billSearch, billCycle);

    }
    public static void viewBillDetails() throws InterruptedException {
        WebDriverWaits.ClickOn(ViewDetails_Icon);

    }
    public static void selectCustCheckBox() throws InterruptedException {
        WebDriverWaits.selectCheckBox(customer_checkBox);

    }
    public static void clickDownloadPdf() throws InterruptedException {
        WebDriverWaits.ClickOn(downloadPdf);

    }
    public static void clickEmailBills() throws InterruptedException {
        WebDriverWaits.ClickOn(emailBills);

    }
    public static void clickSelectedCustomer() throws InterruptedException {
        WebDriverWaits.ClickOn(selectedCustomer);

    }
    public static void clickSelectedCustomers() throws InterruptedException {
        WebDriverWaits.ClickOn(selectedCustomers);

    }
    public static void clickDownload_Popup() throws InterruptedException {
      WebDriverWaits.WaitUntilVisible(download);
        WebDriverWaits.ClickOn(download);

    }
    public static void clickContinueEmail() throws InterruptedException {
        WebDriverWaits.WaitUntilVisible(continueEmail);
        WebDriverWaits.ClickOn(continueEmail);
    }
    public static void verifyEmailResults() throws InterruptedException {
        WebDriverWaits.WaitUntilVisible(status);
        softAssert.assertEquals(WebDriverWaits.GetText(status),"Success");
        softAssert.assertEquals(WebDriverWaits.GetText(dateSend),DateAndTime.DateTimeGenerator("dd/MM/yyyy"));

    }
    public static void clickClose() throws InterruptedException {
        WebDriverWaits.ClickOn(close);
    }

    // =============Craeting BillRun Cycles for the customer==============

    public static By BillRunCyclesTab = By.xpath("//p[text()='Bill Run Cycles']");
    public static By CreateNew = By.xpath("//a[text()=' Create new ']");
    public static By CycleName = By.xpath("//input[@id='cyclename']");
    public static By AutomatedToggle = By.xpath("(//span[@class='switch-label'])[1]");
    public static By LaunchAutomate = By.xpath("//select[@id='automated_billing_schedule']");
    public static By BillPeriodEnd = By.xpath("//select[@id='bill_period_end_day']");
    public static By PaymentTermDay = By.xpath("//input[@name='payment_term_days']");
    public static By CustomerFilter = By.xpath("//input[@class='filter form-control']");
    public static By ArrowMark = By.xpath("//button[@class='btn move btn-default']");
    public static By SaveCycle = By.xpath("//button[text()='Save']");
    public static By PerticularCustomer = By.xpath("(//option[@class='0'])[4]");

    // =============Creating BillRun For the Customer=============

    public static By BillRunTab = By.xpath("//span[text()='Bill Run']");
    public static By RunTheBill = By.xpath("//span[text()='Run the bills']");
    /*
     * public static By StartDate=By.xpath("//select[@id='cycleDate']"); public
     * static By StartActiveDate=By.xpath("//td[@class='active day']"); public
     * static By NextMark=By.xpath("(//th[@class='next'])[1]"); public static By
     * Clickk=By.xpath("//td[text()='11']");
     */
    public static By Toggle = By.xpath("//span[@class='switch-label']");
    public static By BillRunCycleSelect = By.xpath("(//span[@class='filter-option pull-left'])[2]");
    public static By SelectBillRunCycle = By.xpath("(//input[@class='input-block-level form-control'])[2]");
    public static By EndDate = By.xpath("//input[@id='cycleEnd']");
    public static By Next = By.xpath("(//th[@class='next'])[1]");
    public static By Date = By.xpath("//td[text()='22']");
    // public static By DateSelect=By.xpath("(//td[@class='day'])[23]");
    public static By ClickIssueDate = By.xpath("//input[@id='issueDate']");
    public static By IssueDate = By.xpath("//td[text()='23']");
    public static By DueDate = By.xpath("//select[@id='dueDate'");
    public static By RunBillButton = By.xpath("//button[text()='Run Bill']");
    public static By ReloadButton = By.xpath("((//div[@class='box-header'])[1]|//span[text()='Reload'])[2]");
    public static By BellIcon = By.xpath("(//div[@class='container'])[1]//li[@id='notifications-dropdown']");
    public static By SearchBillBox = By.xpath("//input[@type='search']");
    public static By FirstOne=By.xpath("(//li[@class='dropdown-item'])[1]");
    public static By DateFrom=By.xpath("//input[@id='dateFrom']");
    public static By ActiveDayDatepicker = By.xpath("(//th[text()='Today'])[1]");
    public static By SelectStatus= By.xpath("//select[@id='billrunStatus']");
    public static By BillRunCustomer=By.xpath("(//input[@class='input-block-level form-control'])[1]");
    public static By BillSelect=By.xpath("(//span[@class='filter-option pull-left'])[1]");
    public static By Select1=By.xpath("//th[text()='Tax']");

    public static By ClickOnAdminTab=By.xpath("//span[text()='Admin']");


    // =============Committing  BillRun For the Customer=============

    public static By DetailsIcon= By.xpath("//i[@class='icon-th-large']");
    public static By ViewException=By.xpath("//a[text()='View Exceptions']");
    public static By CheckBox=By.xpath("//input[@name='exceptionId']");
    public static By ClearButton=By.xpath("//span[text()='Clear']");
    public static By YesButton=By.xpath("//button[text()='Yes']");
    public static By CommitStatement=By.xpath("(//div[@class='btn-group'])[1]");
    public static By CommitButton=By.xpath("//button[text()='Commit Statement']");
    public static By Countinuecommit=By.xpath("//button[text()='Continue commit']");
    public static By CommitOkButton=By.xpath("//button[text()='Ok']");
    public static By CustomerCheckbox=By.xpath("//input[@id='chkDelete_0']");

    //input[@id='chkDelete_0']
    //===========RollBack Created BillRun==================

    public static By RollBackDetailsIcon=By.xpath("//a[@class='btn btn-primary']");
    public static By RollBackOkButton=By.xpath("//a[text()=' Rollback']");
    public static By Reason=By.xpath("//textarea[@id='rollbackReason']");
    public static By ReasonOk=By.xpath("//button[text()='OK']");
    public static By Today=By.xpath("(//th[text()='Today'])[1]");
    public static By CrossIcon=By.xpath("(//button[text()='×'])[2]");


    //================Downloading ZIP file======================

    public static By DownloadButton=By.xpath("//button[contains(text(),'Download PDF')]");
    public static By Zip=By.xpath("//a[text()='  Separate pdf per customer (zip)']");
    public static By Download=By.xpath("(//button[text()='Download'])[1]");

    public static By BillRunCycleSucc=By.xpath(" //p/span[@id='resultMsg']");


    //============Creating BillRun Cycles For THe Customers===================

    public void ClickOnBillRunCyclesTab() {
        WebDriverWaits.scrollIntoView(BillRunCyclesTab);
        WebDriverWaits.ClickOn(BillRunCyclesTab);
    }

    public void ClickOnAdminTab(){
        WebDriverWaits.ClickOn(ClickOnAdminTab);
    }

    public void ClickOnCreateNewButton() {
        WebDriverWaits.ClickOn(CreateNew);
    }

    public void CycleName(String CycleNamefield) {
        WebDriverWaits.WaitUntilVisibleWE20(CycleName);
        WebDriverWaits.SendKeysWithClear(CycleName, CycleNamefield);
    }

    public void OnAutomatedToggle() {
        WebDriverWaits.ClickOn(AutomatedToggle);
    }

    public void LaunchAutomatedBilling() {
        WebDriverWaits.selectByVisibleText(LaunchAutomate, "Morning on 1st business day");
    }

    public void BillPeriod() {
        WebDriverWaits.selectByVisibleText(BillPeriodEnd, "End of the month");
    }

    public void PaymentTerm() {
        WebDriverWaits.SendKeysWithClear(PaymentTermDay, "1");
    }

    public void CustomerFilter(String CustomerFilterfield) {
        WebDriverWaits.scrollIntoView(CustomerFilter);
        WebDriverWaits.WaitUntilVisible(CustomerFilter);
        WebDriverWaits.SendKeysWithClear(CustomerFilter, CustomerFilterfield);
        WebDriverWaits.ClickOn(CustomerFilter);
    }

    public void ClickOnArrow() {
        WebDriverWaits.WaitUntilVisible(ArrowMark);
        WebDriverWaits.ClickOn(ArrowMark);
    }

    public void ClickOnSaveCycle() {
        WebDriverWaits.scrollIntoView(SaveCycle);
        WebDriverWaits.ClickOn(SaveCycle);
        //WebDriverWaits.ClickOn(Save);
    }

    public void ClickOnPerticularCustomer() {
        WebDriverWaits.ClickOn(PerticularCustomer);
        WebDriverWaits.ClickOn(PerticularCustomer);
    }

//============Creating BillRun for the Customer==============

    public void ClickOnBillRunTab() {
        WebDriverWaits.WaitUntilVisible(BillRunTab);
        WebDriverWaits.ClickOn(BillRunTab);

    }

    public void ClickOnRunTheBillsButton() {

        WebDriverWaits.ClickOn(RunTheBill);
    }

    /*
     * public void ClickOnStartDate() { WebDriverWaits.ClickOn(StartDate);
     * WebDriverWaits.ClickOn(StartActiveDate); }
     */


    public void SendBillRun(String SelectBillRunCycleField) throws AWTException {
        WebDriverWaits.SendKeysWithClear(SelectBillRunCycle, SelectBillRunCycleField);
        Robot s = new Robot();
        s.keyPress(KeyEvent.VK_ENTER);
        s.keyPress(KeyEvent.VK_ENTER);
        s.keyRelease(KeyEvent.VK_ENTER);
    }

    public void ClickOnToggle() {
        WebDriverWaits.WaitUntilVisibleWE20(Toggle);
        WebDriverWaits.ClickOn(Toggle);
    }

    public void SelectBillRun() throws AWTException {
        WebDriverWaits.ClickOn(BillRunCycleSelect);
    }



    public void ClickOnEndDate() {

        WebDriverWaits.WaitUntilVisible(EndDate);
        WebDriverWaits.SendKeysWithClear(EndDate, "09/23/2023");

    }

    public void ClickOnIssueDate() {
        WebDriverWaits.WaitUntilVisible(ClickIssueDate);
        WebDriverWaits.SendKeysWithClear(ClickIssueDate, "09/24/2023");
    }

    public void ClickOnRunBillButton() {
        WebDriverWaits.ClickOn(RunBillButton);
        WebDriverWaits.WaitUntilVisible(SearchBillBox);

    }


    public void ClickOnDateFrom() {

        WebDriverWaits.WaitUntilVisibleWE20(BellIcon);
        WebDriverWaits.ClickOn (BellIcon);
        WebDriverWaits.WaitUntilVisibleWE20(FirstOne);
        WebDriverWaits.ClickOn (FirstOne);

    }

    public void BillRunCycle(String BillRunCustomerfield) throws AWTException {

        WebDriverWaits.ClickOn(BillSelect);
        WebDriverWaits.SendKeysWithClear(BillRunCustomer, BillRunCustomerfield);
        Robot s = new Robot();
        s.keyPress(KeyEvent.VK_ENTER);
        s.keyRelease(KeyEvent.VK_ENTER);
    }

    public void ReloadButton() {
        WebDriverWaits.WaitUntilVisibleWE20(DateFrom);
        WebDriverWaits.ClickOn(DateFrom);
        WebDriverWaits.ClickOn(ActiveDayDatepicker);
        WebDriverWaits.WaitUntilVisibleWE20(ReloadButton);
        WebDriverWaits.ClickOn (ReloadButton);
    }

    public void ClickOnSearchBox(String SearchBillBoxField) {
        WebDriverWaits.WaitUntilVisible(SearchBillBox);
        WebDriverWaits.SendKeysWithClear(SearchBillBox, SearchBillBoxField);

    }



    //==============Commiting BillRun ====================================

    public void ClickOnDetailsIcon() throws InterruptedException {
        WebDriverWaits.WaitUntilVisible(DetailsIcon);
        WebDriverWaits.ClickOn(DetailsIcon);
    }

    public void ClearingException() {
        WebDriverWaits.WaitUntilVisibleWE20(ViewException);
        WebDriverWaits.ClickOn(ViewException);
        WebDriverWaits.WaitUntilVisibleWE20(CheckBox);
        WebDriverWaits.ClickOn(CheckBox);
        WebDriverWaits.ClickOn(ClearButton);
        WebDriverWaits.ClickOn(YesButton);
    }

    public void ClickOnCommitStatement(String SearchBillBoxField) throws InterruptedException {
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.selectCheckBox(CustomerCheckbox);
        WebDriverWaits.WaitUntilVisibleWE20(CommitStatement);
        WebDriverWaits.ClickOn(CommitStatement);
    }

    public void ClickOnCommitOkButton() throws InterruptedException {
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.ClickOn(CommitOkButton);
    }

    public void ClickOnOkcommit() {
        WebDriverWaits.ClickOn(Countinuecommit);
    }

    public void CommitButton() throws InterruptedException {
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.WaitUntilVisibleWE20(CommitButton);
        WebDriverWaits.ClickOn(CommitButton);
    }


    public void ClickOnRollBackDetailsIcon() throws InterruptedException {
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.ClickOn(RollBackDetailsIcon);
    }

    public void ClickOnRollBackButton() {
        WebDriverWaits.ClickOn(RollBackOkButton);
    }

    public void EnterReason() {
        WebDriverWaits.ClickOn(Reason);
        WebDriverWaits.SendKeysWithClear(Reason,"Testing");
        WebDriverWaits.ClickOn(ReasonOk);
        WebDriverWaits.ClickOn(CrossIcon);
    }

    //================Download Zip File===================

    public void ClickDownloadButton() throws AWTException, InterruptedException {

        WebDriverWaits.ClickOn (DownloadButton);
        WebDriverWaits.selectByVisibleText(Zip, "Separate pdf per customer (zip)");
        WebDriverWaits.ClickOn (Download);

    }

    public void CustomerCheckbox() throws InterruptedException {
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.selectCheckBox(CustomerCheckbox);
    }

    public void CreateBillRunCycle(){
        // Login.loginWithGroupName("Test Utilities");
      ClickOnAdminTab();
       ClickOnBillRunCyclesTab();
         ClickOnCreateNewButton();
       CycleName(Customer.CustomerFirstName);
        OnAutomatedToggle();
         LaunchAutomatedBilling();
         BillPeriod();
       PaymentTerm();
         CustomerFilter(Customer.CustomerFirstName);
         ClickOnPerticularCustomer();
         ClickOnArrow();
         ClickOnSaveCycle();
        String Expectedsuccmsg="Successfully added new bill run cycle.";
        softAssert.assertEquals(Expectedsuccmsg, BillRunCycleSucc);

        //p/span[@id='resultMsg']
    }

    public void BillRun() throws AWTException, InterruptedException {
        //String CustomerFirstName="";
        // Login.loginWithGroupName("Test Utilities");
       ClickOnBillRunTab();
        // Thread.sleep(1000);
        ClickOnRunTheBillsButton();
        // BillRun.ClickOnStartDate();
         SelectBillRun();
         Thread.sleep(1000);
         SendBillRun(Customer.CustomerFirstName);
        // BillRun.ClickOnStartDate();
        // BillRun.ClickOnDueDate();
         ClickOnToggle();
         ClickOnEndDate();
         ClickOnIssueDate();
         ClickOnRunBillButton();
         ClickOnSearchBox(Customer.CustomerFirstName);
        Thread.sleep(2000);
       BillRunCycle(Customer.CustomerFirstName);
         ReloadButton();
        ClickOnDateFrom();

        // Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Showing
        // 1 to 1 of 1 entries')]")).getText(), expectedBillRunSuccessText) ;
        // System.out.println("Texts match. Assertion passed.");
    }

    public void CommitBillRun() throws InterruptedException {
        CommitButton();
        ClickOnOkcommit();
        ClickOnCommitOkButton();
    }

    public void RollBack() throws InterruptedException {
        ClickOnBillRunTab();
         ReloadButton();
         ClickOnDateFrom();
         ClickOnDetailsIcon();
         ClickOnRollBackDetailsIcon();
        ClickOnRollBackButton();
         EnterReason();
    }

    public void DownloadZip() throws InterruptedException, AWTException {
         ClickOnBillRunTab();
         ReloadButton();
         ClickOnSearchBox(Customer.CustomerFirstName);
         ClickOnDetailsIcon();
         CustomerCheckbox();
         ClickDownloadButton();
    }
}

