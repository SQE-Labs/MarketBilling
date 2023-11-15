package POM;




import CommonMethods.DateAndTime;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

import static POM.Customer.*;
import static POM.WorkFlowTypes.RandomName1;


public class BillRun extends TestLogin {
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static By ConfirmationAssertion = By.xpath("//*[@class='bootstrap-dialog-message']");
    public static By BillRun_Tab = By.xpath("//span[text()='Bill Run']");
    public static By RunTheBills_Button = By.xpath("//span[text()='Run the bills']");
    public static By BillRun_StartDate_Datepicker = By.xpath("//*[@id='cycleDate']");
    public static By Select_BillRun_StartDate_Datepicker = By.xpath("//*[@class='active day']");
    public static By BillRun_EndDate_Datepicker = By.xpath("//*[@id='cycleEnd']");
    public static By BillRun=By.xpath("(//span[@class='filter-option pull-left'])[2]");
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
    public static By AddBillRunCycleButton_CreateNew = By.xpath("//a[@id='addBtn']");
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

    public static By Rollback_Button = By.xpath("//a[text()=' Rollback']");
    public static By RollbackReason_Field = By.xpath("//textarea[@id='rollbackReason']");
    public static By Ok_Button = By.xpath("//*[contains(text(),'OK')]");
    public static By RollbackCross_Icon = By.xpath("//*[@class='bootstrap-dialog-close-button']");

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
    public static By manualOveride=By.xpath("(//input[@class='input-block-level form-control'])[2]");
    public static By customerList=By.xpath("//select[@name='filter-category']");
    public static By filterButton=By.xpath("//button[text()='Filter']");
    public static By customId=By.xpath("//input[@name='text_contains']");
    public static By advanceArrowMark=By.xpath("//i[@class='icon-chevron-down']");
    public static By billRunCycleSelect = By.xpath("(//span[@class='filter-option pull-left'])[2]");
    public static By startDate=By.xpath("(//input[@class='date-picker'])[1]");

    public static By close = By.id("sendEmailResultClose");
    public static By download = By.xpath("(//button[text()='Download'])[1]");
    public static By billCycle= By.xpath("(//ul[@class='dropdown-menu inner selectpicker'])[2]");
    String Expectedsuccmsg = "Successfully updated .";




    static String BillCycleName = RandomStrings.RequiredCharacters(6);;


    static SoftAssert softAssert = new SoftAssert();

//    public static void BillrunMethod_NoCycle() throws InterruptedException {
//        // SoftAssert softAssert = new SoftAssert();
//
//        jse.executeScript("window.scrollBy(0,-400)", "");
//        Customer.SwitchToCustomerpage(2);
//        WebDriverWaits.ClickOn(BillRun_Tab);
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        WebDriverWaits.ClickOn(RunTheBills_Button);
//        WebDriverWaits.ClickOn(BillRun);
//        String cycleName="Cycle" + RandomStrings.RequiredCharacters(2);
//        WebDriverWaits.SendKeysWithClear(manualOveride,cycleName);
//        //   WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
//
//        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
//        if (!(DataInterface.autoDueDateEnabled)) {
//            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
//            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
//
//        }
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        WebDriverWaits.ClickOn(BillRun_Button);
//        WebDriverWaits.ClickOn(Continue_Button);
//        Thread.sleep(2000);
//        WebDriverWaits.ClickOn(OK_Button);
////			Thread.sleep(500000);
////			WebDriverWaits.WaitUntilInvisible(Spinner_Icon);
//        WebDriverWaits.ClickAfter5mins(View_Button);
////			WebDriverWaits.ClickOn(View_Button);
//        Thread.sleep(2000);
//        WebDriverWaits.ClickOn(Cancel_Button);
//        Thread.sleep(2000);
//
//        WebDriverWaits.ClickOn(Yes_Button);
//        Thread.sleep(2000);
//
//
//    }

    public static void BillRunWithUncommittedStatement(String billCycleName, String customerId) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(2000);
        WebDriverWaits.Waituntilvisible(BillRun_Tab);
        WebDriverWaits.ClickOn(BillRun_Tab);
        Thread.sleep(2000);
        WebDriverWaits.Waituntilvisible(RunTheBills_Button);
        WebDriverWaits.ClickOn(RunTheBills_Button);
//        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
//        if (!(DataInterface.autoDueDateEnabled)) {
//            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
//            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
//
//        }
//        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
//        Thread.sleep(2000);
//        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
//        Select select = new Select(BillRunCycOption);
//        Thread.sleep(2000);
//        select.selectByVisibleText(billCycleName);
//        //BillRunCycleOption
//        //driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
//        Thread.sleep(2000);
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//        WebDriverWaits.ClickOn(BillRun_Button);
//        // Assert Warning: Customer 40113 previously billed on uncommitted statement. Do you want to proceed?
//        Thread.sleep(2000);
        WebDriverWaits.ClickOn(billRunCycleSelect);
        WebDriverWaits.SendKeysWithClear(selectBillRunCycle,billCycleName);

        WebDriverWaits.ClickOn(startDate);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(endDate);
        WebDriverWaits.SendKeysWithClear(endDate, "27/10/2023");
        WebDriverWaits.WaitUntilVisible(clickIssueDate);
        WebDriverWaits.SendKeysWithClear(clickIssueDate, "27/10/2023");
        WebDriverWaits.ClickOn(runBillButton);
        String ActualMsg = WebDriverWaits.GetText(ConfirmationAssertion);
        String ExpectedMsg1 = "Customer " + customerId + "previously billed on uncommitted statement. Do you want to proceed?";
        softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully asserted the popup text while bill run with uncomitted statement.");
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(OK_Button);
        Thread.sleep(4000);

    }

    public static String BillRunCycle(String customerId) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
         WebDriverWaits.Waituntilvisible(Admin_Tab);
        WebDriverWaits.ClickOn(Admin_Tab);
        WebDriverWaits.scrollIntoView(BillRunCycles_Subtab);
       WebDriverWaits.Waituntilvisible(BillRunCycles_Subtab);
        WebDriverWaits.ClickOn(BillRunCycles_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
        WebDriverWaits.Waituntilvisible(CycleName_Field);
        WebDriverWaits.ClickOn(CycleName_Field);
        WebDriverWaits.SendKeys(CycleName_Field, BillCycleName);
        WebDriverWaits.scrollIntoView(advanceArrowMark);
        WebDriverWaits.ClickOn(advanceArrowMark);
        WebDriverWaits.SendKeysWithClear(customId,customerId);
        WebDriverWaits.ClickOn(filterButton);
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
        WebDriverWaits.Waituntilvisible(ArrowRight);
        WebDriverWaits.ClickOn(ArrowRight);
        WebDriverWaits.Waituntilvisible(SaveButton);
        WebDriverWaits.ClickOn(SaveButton);
        // Assertion: Successfully added new bill run cycle.
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
        String ExpectedMsg1 = "Successfully added new bill run cycle.";
        softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully added new bill run cycle for single customer.");
        Thread.sleep(2000);
        System.out.println("Bill Cycle name --------- " + BillCycleName);
        return BillCycleName;
    }

    public static void SmallBillRunWithSingleCustomer(String BillCycleName) throws InterruptedException, AWTException {
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(BillRun_Tab);
        WebDriverWaits.Waituntilvisible(RunTheBills_Button);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(RunTheBills_Button);
//        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
//        if (!(DataInterface.autoDueDateEnabled)) {
//            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
//            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
//        }
//        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
//        Thread.sleep(2000);
//        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
//        Select select = new Select(BillRunCycOption);
        //       Thread.sleep(4000);
        //       select.selectByVisibleText(billCycleName);
        //       Thread.sleep(2000);
        //       jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.Waituntilvisible(billRunCycleSelect);
        WebDriverWaits.ClickOn(billRunCycleSelect);
        Thread.sleep(3000);
        WebDriverWaits.SendKeysWithClear(selectBillRunCycle,BillCycleName);
        WebDriverWaits.byToWebElement(billCycle);
        WebDriverWaits.clickOnMoveToElemenet(billCycle);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(startDate);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(endDate);
        WebDriverWaits.SendKeysWithClear(endDate, "16/11/2023");
        WebDriverWaits.WaitUntilVisible(clickIssueDate);
        WebDriverWaits.SendKeysWithClear(clickIssueDate, "16/11/2023");
        WebDriverWaits.ClickOn(runBillButton);
        WebDriverWaits.WaitUntilVisible(searchBillBox);
        WebDriverWaits.SendKeysWithClear(searchBillBox,  BillCycleName);
        WebDriverWaits.Waituntilvisible(billSelect);
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(billSelect);
        WebDriverWaits.SendKeysWithClear(billRunCustomer, BillCycleName);
        Robot s1 = new Robot();
        s1.keyPress(KeyEvent.VK_ENTER);
        s1.keyRelease(KeyEvent.VK_ENTER);
        WebDriverWaits.Waituntilvisible(dateFrom);
        WebDriverWaits.ClickOn(dateFrom);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(reloadButton);
        WebDriverWaits.ClickOn(reloadButton);

//        WebDriverWaits.ClickOn(BillRun_Button);
//        WebDriverWaits.ClickAfter5mins(View_Button);
//        Thread.sleep(2000);
//        WebDriverWaits.ClickOn(Cancel_Button);
//        Thread.sleep(2000);
//        WebDriverWaits.ClickOn(Yes_Button);

    }

    public static void Rollback_SmallBillRunWithSingleCustomer(String billRunCycle ) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        WebDriverWaits.ClickOn(BillRun_Tab);
       WebDriverWaits. SendKeysWithClear(searchBox,billRunCycle);
        WebDriverWaits.ClickOn(ViewDetails_Icon);
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.ClickOn(detailsIcon);
        WebDriverWaits.Waituntilvisible(Rollback_Button);
        WebDriverWaits.ClickOn(Rollback_Button);
        WebDriverWaits.SendKeysWithClear(RollbackReason_Field,"RollBacking for update");
        WebDriverWaits.ClickOn(okButton);
        WebDriverWaits.ClickOn(crossMark);

    }

    public static void directRollBack(String billRunCycle) throws InterruptedException {
        WebDriverWaits.ClickOn(BillRun_Tab);
        WebDriverWaits. SendKeysWithClear(searchBox,billRunCycle);
        WebDriverWaits.ClickOn(ViewDetails_Icon);
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.ClickOn(rollBackAndFixButton);
        WebDriverWaits.ClickOn(CountinueRollBack);
        driver.navigate().refresh();


    }

    public static void rebillSingleCustomer(String billCycleName) throws InterruptedException, AWTException {
        //Run bill again
        WebDriverWaits.ClickOn(BillRun_Tab);
        WebDriverWaits.ClickOn(RunTheBills_Button);
//        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
//        if (!(DataInterface.autoDueDateEnabled)) {
//            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
//            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
//        }
//        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
//        Thread.sleep(2000);
//        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
//        Select select = new Select(BillRunCycOption);
        //       Thread.sleep(4000);
        //       select.selectByVisibleText(billCycleName);
        //       Thread.sleep(2000);
        //       jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.Waituntilvisible(billRunCycleSelect);
        WebDriverWaits.ClickOn(billRunCycleSelect);
        Thread.sleep(3000);
        WebDriverWaits.SendKeysWithClear(selectBillRunCycle,BillCycleName);
        WebDriverWaits.byToWebElement(billCycle);
        WebDriverWaits.clickOnMoveToElemenet(billCycle);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(startDate);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(endDate);
        WebDriverWaits.SendKeysWithClear(endDate, "08/12/2023");
        WebDriverWaits.WaitUntilVisible(clickIssueDate);
        WebDriverWaits.SendKeysWithClear(clickIssueDate, "08/12/2023");
        WebDriverWaits.ClickOn(runBillButton);
        WebDriverWaits.WaitUntilVisible(searchBillBox);
        WebDriverWaits.SendKeysWithClear(searchBillBox,  BillCycleName);
        WebDriverWaits.Waituntilvisible(billSelect);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(billSelect);
        WebDriverWaits.SendKeysWithClear(billRunCustomer, BillCycleName);
        Robot s1 = new Robot();
        s1.keyPress(KeyEvent.VK_ENTER);
        s1.keyRelease(KeyEvent.VK_ENTER);
        WebDriverWaits.Waituntilvisible(dateFrom);
        WebDriverWaits.ClickOn(dateFrom);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(reloadButton);
        WebDriverWaits.ClickOn(reloadButton);

//        WebDriverWaits.ClickOn(BillRun_Button);
//        WebDriverWaits.ClickAfter5mins(View_Button);
//        Thread.sleep(2000);
//        WebDriverWaits.ClickOn(Cancel_Button);
//        Thread.sleep(2000);
//        WebDriverWaits.ClickOn(Yes_Button);
    }


    public static void filterCustomerId(String customerId) throws InterruptedException {

        WebDriverWaits.SendKeysWithClear(customId,customerId);
        WebDriverWaits.ClickOn(filterButton);
        System.out.println("Customer 1R -- " + CustomerID01R);
        System.out.println("Customer 2B -- " + CustomerID02B);
        if(customerId==customerId){
            System.out.println("Customer 3C -- " + CustomerID03C);
        }

      //  WebDriverWaits.ClickOn(filterButton);
        WebDriverWaits.Waituntilvisible(CustomerListFilter);
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

    public static void rollback_in_statementTab(String customerId2) throws InterruptedException {
        WebDriverWaits.Waituntilvisible(Statement_Subtab);
        WebDriverWaits.ClickOn(Statement_Subtab);
        WebDriverWaits.ClickOn(ViewDetails_Icon);
        WebDriverWaits.ClickOn(Rollback_Button);
        WebDriverWaits.ClickOn(RollbackReason_Field);
        WebDriverWaits.SendKeys(RollbackReason_Field, "Kindly rollback the statement.");
        WebDriverWaits.ClickOn(Ok_Button);
        WebDriverWaits.Waituntilvisible(RollbackCross_Icon);
        //Assert Rollback for customer 40027 and statement 7892 has been successful.
        WebDriverWaits.ClickOn(RollbackCross_Icon);
    }

    public static void statementRebill(String customerId) throws InterruptedException {
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
        //   if(Pro)
     //   SoftAssert softAssert = new SoftAssert();
        WebDriverWaits.ClickOn(detailsIcon);
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.Waituntilvisible(rollBackAndFixButton);
        WebDriverWaits.ClickOn(rollBackAndFixButton);
        WebDriverWaits.ClickOn(CountinueRollBack);
        WebDriverWaits.ClickOn(crossMark);
        System.out.println("Successfully Rollback completed for two customers.");
        WebDriverWaits.SwitchToParentTab();
    }

    public static String createBillCycle(List<String> customerIdList) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(Admin_Tab);
        WebDriverWaits.scrollIntoView(BillRunCycles_Subtab);
        WebDriverWaits.ClickOn(BillRunCycles_Subtab);
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(CycleName_Field);
        String billRunCycleName = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeysWithClear(CycleName_Field, billRunCycleName);
        WebDriverWaits.scrollIntoView(advanceArrowMark);
        WebDriverWaits.ClickOn(advanceArrowMark);
        System.out.println("Bill run cyccle create with name ---" + billRunCycleName);
        for (String customerId : customerIdList) {
            filterCustomerId(customerId);
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
     //   driver.navigate().refresh();
       // WebDriverWaits.SwitchToParentTab();
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

        return billRunCycleNewName;
    }

    public static String runBillCycle(String billRunCycleName) throws InterruptedException, AWTException {
      //  LandingPage.navigateToHomePage();
        //First Time Bill run
        WebDriverWaits.Waituntilvisible(BillRun_Tab);
        WebDriverWaits.ClickOn(BillRun_Tab);
        //      jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(RunTheBills_Button);
//        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
//        if (!(DataInterface.autoDueDateEnabled)) {
//            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
//            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
//
//        }
//        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
//        Thread.sleep(2000);
//        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
//        Select select = new Select(BillRunCycOption);
//        Thread.sleep(2000);
//        select.selectByVisibleText(billRunCycleName);
//        Thread.sleep(2000);
//        WebDriverWaits.scrollIntoView(BillRun_Button);
//        WebDriverWaits.ClickOn(BillRun_Button);
//        Thread.sleep(2000);
//        WebDriverWaits.ClickAfter5mins(View_Button);
//        Thread.sleep(2000);
//        WebDriverWaits.ClickOn(Cancel_Button);
//        WebDriverWaits.ClickOn(Yes_Button);
//        Thread.sleep(2000);
        WebDriverWaits.Waituntilvisible(billRunCycleSelect);
        WebDriverWaits.ClickOn(billRunCycleSelect);
        WebDriverWaits.SendKeysWithClear(selectBillRunCycle,billRunCycleName);
//        Actions s = new Actions(driver);
//        s.moveToElement(driver.findElement(By.xpath("(//ul[@class='dropdown-menu inner selectpicker'])[2]"))).click().build().perform();
        Thread.sleep(2000);
        WebDriverWaits.byToWebElement(billCycle);
        WebDriverWaits.clickOnMoveToElemenet(billCycle);
        WebDriverWaits.ClickOn(startDate);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(endDate);
        WebDriverWaits.SendKeysWithClear(endDate, "08/12/2023");
        WebDriverWaits.WaitUntilVisible(clickIssueDate);
        WebDriverWaits.SendKeysWithClear(clickIssueDate, "08/12/2023");
        WebDriverWaits.ClickOn(runBillButton);
        WebDriverWaits.WaitUntilVisible(searchBillBox);
        WebDriverWaits.SendKeysWithClear(searchBillBox,  billRunCycleName);
        WebDriverWaits.Waituntilvisible(billSelect);
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(billSelect);
        WebDriverWaits.SendKeysWithClear(billRunCustomer, billRunCycleName);
        Robot s1 = new Robot();
        s1.keyPress(KeyEvent.VK_ENTER);
        s1.keyRelease(KeyEvent.VK_ENTER);
        WebDriverWaits.Waituntilvisible(dateFrom);
        WebDriverWaits.ClickOn(dateFrom);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(reloadButton);
        WebDriverWaits.ClickOn(reloadButton);

        return billRunCycleName;
    }

    public static String billRunForTwoCustomer(String billRunCycleName) throws InterruptedException, AWTException {

        //First Time Bill run
        WebDriverWaits.ClickOn(BillRun_Tab);
        //   jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(RunTheBills_Button);
//        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
//        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
//        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
//        if (!(DataInterface.autoDueDateEnabled)) {
//            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
//            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
//
//        }
//        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
//        //WebDriverWaits.ClickOn(BillRunCycle_DropdownOpn);
//        Thread.sleep(2000);
//        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
//        Select select = new Select(BillRunCycOption);
//        Thread.sleep(2000);
//        select.selectByVisibleText(billRunCycleName);
        //BillRunCycleOption
        //driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
        WebDriverWaits.Waituntilvisible(billRunCycleSelect);
        WebDriverWaits.ClickOn(billRunCycleSelect);
        WebDriverWaits.SendKeysWithClear(selectBillRunCycle,billRunCycleName);
        WebDriverWaits.byToWebElement(billCycle);
        WebDriverWaits.clickOnMoveToElemenet(billCycle);
        WebDriverWaits.ClickOn(startDate);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(endDate);
        WebDriverWaits.SendKeysWithClear(endDate, "08/12/2023");
        WebDriverWaits.WaitUntilVisible(clickIssueDate);
        WebDriverWaits.SendKeysWithClear(clickIssueDate, "08/12/2023");
        WebDriverWaits.ClickOn(runBillButton);
        WebDriverWaits.WaitUntilVisible(searchBillBox);
        WebDriverWaits.SendKeysWithClear(searchBillBox,  billRunCycleName);
        WebDriverWaits.Waituntilvisible(billSelect);
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(billSelect);
        WebDriverWaits.SendKeysWithClear(billRunCustomer, billRunCycleName);
        Robot s1 = new Robot();
        s1.keyPress(KeyEvent.VK_ENTER);
        s1.keyRelease(KeyEvent.VK_ENTER);
        WebDriverWaits.Waituntilvisible(dateFrom);
        WebDriverWaits.ClickOn(dateFrom);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(reloadButton);
        WebDriverWaits.ClickOn(reloadButton);
         return billRunCycleName;
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
        softAssert.assertEquals(WebDriverWaits.GetText(status), "Success");
        softAssert.assertEquals(WebDriverWaits.GetText(dateSend), DateAndTime.DateTimeGenerator("dd/MM/yyyy"));

    }

    public static void clickClose() throws InterruptedException {
        WebDriverWaits.ClickOn(close);
    }

    // =============Creating BillRun Cycles for the customer==============

    public static By billRunCyclesTab = By.xpath("//a//p[text()='Bill Run Cycles']");
    public static By createNew = By.xpath("//a[text()=' Create new ']");
    public static By cycleName = By.xpath("//input[@id='cyclename']");
    public static By automatedToggle = By.xpath("(//span[@class='switch-label'])[1]");
    public static By launchAutomate = By.xpath("//select[@id='automated_billing_schedule']");
    public static By billPeriodEnd = By.xpath("//select[@id='bill_period_end_day']");
    public static By paymentTermDay = By.xpath("//input[@name='payment_term_days']");
    public static By paymentTermDay1 = By.xpath("//input[@name='payment_term_days']");
    public static By clickOnDownArrow = By.xpath("//i[@class='icon-chevron-down']");
    public static By clickOnSelect = By.xpath("//select[@name='filter-category']");
    public static By passName = By.xpath("//input[@name='text_contains']");
    //public static By filterButton = By.xpath("//button[text()='Filter']");
    public static By arrowMark = By.xpath("//button[@class='btn move btn-default']");
    public static By saveCycle = By.xpath("//button[text()='Save']");
    public static By perticularCustomer = By.xpath("(//option[@class='0'])[30]");


    // =============Creating BillRun For the Customer=============


    public static By billRunTab = By.xpath("//span[text()='Bill Run']");

    public static By runTheBill = By.xpath("//span[text()='Run the bills']");

    public static By toggle = By.xpath("//span[@data-on='Yes']");
    //  public static By billRunCycleSelect = By.xpath("(//span[@class='filter-option pull-left'])[2]");
    public static By selectBillRunCycle = By.xpath("(//input[@class='input-block-level form-control'])[2]");
    public static By endDate = By.xpath("//input[@id='cycleEnd']");
    public static By next = By.xpath("(//th[@class='next'])[1]");

    public static By date = By.xpath("//td[text()='22']");
    // public static By DateSelect=By.xpath("(//td[@class='day'])[23]");
    public static By clickIssueDate = By.xpath("//input[@id='issueDate']");
    public static By issueDate = By.xpath("//td[text()='23']");
    public static By dueDate = By.xpath("//select[@id='dueDate'");
    public static By runBillButton = By.xpath("//button[text()='Run Bill']");
    public static By reloadButton = By.xpath("((//div[@class='box-header'])[1]|//span[text()='Reload'])[2]");
    public static By bellIcon = By.xpath("(//div[@class='container'])[1]//li[@id='notifications-dropdown']");
    public static By searchBillBox = By.xpath("//input[@type='search']");
    public static By firstOne = By.xpath("(//li[@class='dropdown-item'])[1]");
    public static By dateFrom = By.xpath("//input[@id='dateFrom']");
    public static By activeDayDatepicker = By.xpath("(//th[text()='Today'])[1]");
    public static By selectStatus = By.xpath("//select[@id='billrunStatus']");
    public static By billRunCustomer = By.xpath("(//input[@class='input-block-level form-control'])[1]");
    public static By billSelect = By.xpath("(//span[@class='filter-option pull-left'])[1]");
    public static By select1 = By.xpath("//th[text()='Tax']");

    public static By  AdminTab = By.xpath("//span[text()='Admin']");



    // =============Committing  BillRun For the Customer=============


    public static By detailsIcon = By.xpath("(//a[@class='btn btn-primary'])[1]");
    public static By details=By.xpath("//i[@class='icon-th-large']");
    public static By DetailsIcon = By.xpath("(//i[@class='icon-list-alt'])[2]");
    public static By viewException = By.xpath("//a[text()='View Exceptions']");


    public static By checkBox = By.xpath("//input[@name='exceptionId']");
    public static By clearButton = By.xpath("//span[text()='Clear']");
    public static By yesButton = By.xpath("//button[text()='Yes']");
    public static By commitStatement = By.xpath("(//div[@class='btn-group'])[1]");
    public static By commitButton = By.xpath("//button[text()='Commit Statement']");
    public static By countinuecommit = By.xpath("//button[text()='Continue commit']");
    public static By commitOkButton = By.xpath("//button[text()='Ok']");
    public static By customerCheckbox = By.xpath("//input[@id='chkDelete_0']");
    public static By closeButton=By.xpath("(//button[text()='Close'])[2]");

    //input[@id='chkDelete_0']
    //===========RollBack Created BillRun==================

    public static By rollBackDetailsIcon = By.xpath("//a[@class='btn btn-primary']");
    public static By rollBackAndFixButton = By.xpath("//button[text()='Rollback and Fix']");
    public static By CountinueRollBack=By.xpath("//button[text()='Continue rollback']");
    public static By okButton = By.xpath("//button[text()='OK']");
    public static By crossMark=By.xpath("(//button[text()='×'])[2]");
    public static By rollBackReason=By.xpath("//button[text()='Continue rollback']");
    public static By reasonOk = By.xpath("//button[text()='OK']");
    public static By today = By.xpath("(//th[text()='Today'])[1]");
    public static By crossIcon = By.xpath("(//button[text()='×'])[2]");


    //================Downloading ZIP file======================

    public static By downloadButton = By.xpath("//button[contains(text(),'Download PDF')]");
    public static By zip = By.xpath("//a[text()='  Separate pdf per customer (zip)']");
   // public static By download = By.xpath("(//button[text()='Download'])[1]");

    public static By BillRunCycleSucc = By.xpath(" //p/span[@id='resultMsg']");

    public static By firstValue = By.xpath("//*[@id=\"logContent\"]/div/div/div[2]/div[2]/div/div/ul/li[1]/a");

    //=============Editing the created BillRunCycles for the customer=============

    public static By searchBox = By.xpath("//input[@type='search']");
    public static By editBill = By.xpath("//i[@class='fa fa-pencil']");

    //=============Email BillRun To the perticuler customer==========

    public static By emailDropDown = By.xpath("(//button[@class='btn btn-large dropdown-toggle btn-primary'])[2]");
    public static By selectedEmailableCustomer = By.xpath("//a[text()=' Selected customers']");
    public static By emailButton = By.xpath("//button[text()='Continue email']");


    //============Creating BillRun Cycles For THe Customers===================

    public void clickOnBillRunCyclesTab() {
        WebDriverWaits.scrollIntoView(billRunCyclesTab);
        WebDriverWaits.Waituntilvisible(billRunCyclesTab);
        WebDriverWaits.ClickOn(billRunCyclesTab);
    }

    public void clickOnAdminTab() throws InterruptedException {

        WebDriverWaits.Waituntilvisible( AdminTab);
        WebDriverWaits.ClickOn( AdminTab);
    }
    public void clickOnAdminTab1() throws InterruptedException {
        WebDriverWaits.Waituntilvisible( AdminTab);
        WebDriverWaits.ClickOn( AdminTab);
    }


    public void clickOnCreateNewButton() throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWaits.Waituntilvisible(createNew);
        WebDriverWaits.ClickOn(createNew);
    }

    public void cycleName(String CycleNamefield) {
        WebDriverWaits.Waituntilvisible(cycleName);
        WebDriverWaits.SendKeysWithClear(cycleName, CycleNamefield);
    }


    public void onAutomatedToggle() {
        WebDriverWaits.ClickOn(automatedToggle);
    }

    public void launchAutomatedBilling() {
        WebDriverWaits.selectByVisibleText(launchAutomate, "Morning on 1st business day");
    }

    public void billPeriod() {
        WebDriverWaits.selectByVisibleText(billPeriodEnd, "End of the month");
    }

    public void paymentTerm() {
        WebDriverWaits.SendKeysWithClear(paymentTermDay, "1");
    }

    public void paymentTerm1() {
        WebDriverWaits.SendKeysWithClear(paymentTermDay1, "2");
    }

    public void customerFilter(String CustomerFirstName) {
        WebDriverWaits.scrollIntoView(clickOnDownArrow);
        WebDriverWaits.WaitUntilVisible(clickOnDownArrow);
        WebDriverWaits.ClickOn(clickOnDownArrow);
        WebDriverWaits.ClickOn(clickOnSelect);
        WebDriverWaits.selectByVisibleText(clickOnSelect, "Customer name");
        WebDriverWaits.ClickOn(passName);
        WebDriverWaits.SendKeysWithClear(passName, CustomerFirstName);
        WebDriverWaits.ClickOn(filterButton);
    }

    public void clickOnArrow() {
        WebDriverWaits.Waituntilvisible(arrowMark);
        WebDriverWaits.ClickOn(arrowMark);
    }

    public void clickOnSaveCycle() {
        WebDriverWaits.scrollIntoView(saveCycle);
        WebDriverWaits.ClickOn(saveCycle);
        //WebDriverWaits.ClickOn(Save);
    }

    public void clickOnPerticularCustomer() {
        WebDriverWaits.Waituntilvisible(perticularCustomer);
        WebDriverWaits.ClickOn(perticularCustomer);
        // WebDriverWaits.ClickOn(PerticularCustomer);
    }

//============Creating BillRun for the Customer==============

    public static void clickOnBillRunTab() {
        WebDriverWaits.Waituntilvisible(billRunTab);
        // WebDriverWaits.fluentWait_Clickable(BillRunTab);
        WebDriverWaits.ClickOn(billRunTab);

    }

    public void clickOnRunTheBillsButton() {
        WebDriverWaits.Waituntilvisible(runTheBill);
        WebDriverWaits.ClickOn(runTheBill);
    }

    /*
     * public void ClickOnStartDate() { WebDriverWaits.ClickOn(StartDate);
     * WebDriverWaits.ClickOn(StartActiveDate); }
     */


    public void sendBillRun(String SelectBillRunCycleField) throws AWTException, InterruptedException {
        WebDriverWaits.SendKeysWithClear(selectBillRunCycle, SelectBillRunCycleField);
        Actions s = new Actions(driver);
        s.moveToElement(driver.findElement(By.xpath("(//ul[@class='dropdown-menu inner selectpicker'])[2]"))).click().build().perform();
    }


    public void clickOnToggle() {
        WebDriverWaits.Waituntilvisible(toggle);
        WebDriverWaits.ClickOn(toggle);
    }

    public void selectBillRun() throws AWTException {
        WebDriverWaits.Waituntilvisible(billRunCycleSelect);
        WebDriverWaits.ClickOn(billRunCycleSelect);
    }


    public void clickOnEndDate() {
        WebDriverWaits.Waituntilvisible(endDate);
        WebDriverWaits.SendKeysWithClear(endDate, "15/10/2023");

    }

    public void clickOnIssueDate() {
        WebDriverWaits.WaitUntilVisible(clickIssueDate);
        WebDriverWaits.SendKeysWithClear(clickIssueDate, "15/10/2023");
    }

    public void clickOnRunBillButton() {
        WebDriverWaits.ClickOn(runBillButton);
        WebDriverWaits.WaitUntilVisible(searchBillBox);

    }


    public void clickOnDateFrom() {

        WebDriverWaits.WaitUntilVisibleWE20(bellIcon);
        WebDriverWaits.ClickOn(bellIcon);
        WebDriverWaits.WaitUntilVisibleWE20(firstOne);
        WebDriverWaits.ClickOn(firstOne);
    }
    public void notificationIcon(){
        WebDriverWaits.WaitUntilVisibleWE20(bellIcon);
        WebDriverWaits.ClickOn(bellIcon);
    }

    public void billRunCycle(String BillRunCustomerfield) throws AWTException {
        WebDriverWaits.Waituntilvisible(billSelect);
        WebDriverWaits.ClickOn(billSelect);
        WebDriverWaits.SendKeysWithClear(billRunCustomer, BillRunCustomerfield);
        Robot s = new Robot();
        s.keyPress(KeyEvent.VK_ENTER);
        s.keyRelease(KeyEvent.VK_ENTER);
    }

    public void reloadButton() {
        WebDriverWaits.Waituntilvisible(dateFrom);
        WebDriverWaits.ClickOn(dateFrom);
        WebDriverWaits.ClickOn(activeDayDatepicker);
        WebDriverWaits.Waituntilvisible(reloadButton);
        WebDriverWaits.ClickOn(reloadButton);
    }

    public static void clickOnSearchBox(String SearchBillBoxField) {
        WebDriverWaits.WaitUntilVisible(searchBillBox);
        WebDriverWaits.SendKeysWithClear(searchBillBox, SearchBillBoxField);

    }


    //==============Commiting BillRun ====================================

    public void clickOnDetailsIcon() throws InterruptedException {
        WebDriverWaits.Waituntilvisible(detailsIcon);
        WebDriverWaits.ClickOn(detailsIcon);
    }
    public void clickOnDetail(){
        WebDriverWaits.ClickOn(details);
    }

    public void clearingException() {
        WebDriverWaits.WaitUntilVisibleWE20(viewException);
        WebDriverWaits.ClickOn(viewException);
        WebDriverWaits.WaitUntilVisibleWE20(checkBox);
        WebDriverWaits.ClickOn(checkBox);
        WebDriverWaits.ClickOn(clearButton);
        WebDriverWaits.ClickOn(yesButton);
    }

    public void clickOnCommitStatement(String SearchBillBoxField) throws InterruptedException {
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.selectCheckBox(customerCheckbox);
        WebDriverWaits.WaitUntilVisibleWE20(commitStatement);
        WebDriverWaits.ClickOn(commitStatement);
    }

    public static void clickOnCommitOkButton() throws InterruptedException {
        //   WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.ClickOn(commitOkButton);
    }

    public static void clickOnOkcommit() {
        WebDriverWaits.ClickOn(countinuecommit);
    }

    public static void commitButton() throws InterruptedException {
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.WaitUntilVisibleWE20(commitButton);
        WebDriverWaits.ClickOn(commitButton);
    }
    public static void clickONDetailsIcon()   {
        WebDriverWaits.Waituntilvisible(detailsIcon);
        WebDriverWaits.ClickOn(detailsIcon);
    }

    public void clickOnRollBackButton() {

        WebDriverWaits.ClickOn(rollBackAndFixButton);
        WebDriverWaits.ClickOn(CountinueRollBack);
    }
    public void rollBackReason(){
        WebDriverWaits.Waituntilvisible(rollBackReason);
        WebDriverWaits.ClickOn(rollBackReason);
    }

    public void enterReason() {
        WebDriverWaits.ClickOn(crossMark);
    }
    public void clickCross() throws InterruptedException {
        WebDriverWaits.ClickOn(crossMark);


    }

    //================Download Zip File===================

    public static void clickDownloadButton() throws AWTException, InterruptedException {

        WebDriverWaits.ClickOn(downloadButton);
        WebDriverWaits.WaitUntilSelect(zip);
        WebDriverWaits.ClickOn(zip);
        WebDriverWaits.ClickOn(download);


    }

    public static void customerCheckbox() throws InterruptedException {
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.selectCheckBox(customerCheckbox);
    }

    //==========Editing the created BillRunCycle for the customer===============


    public void sendValueInSearchBox(String CustomerFirstName) {
        WebDriverWaits.Waituntilvisible(searchBox);
        WebDriverWaits.ClickOn(searchBox);
        WebDriverWaits.Waituntilvisible(searchBox);
        WebDriverWaits.SendKeysWithClear(searchBox, CustomerFirstName);
    }

    public void EditCycle() {
        WebDriverWaits.ClickOn(editBill);
    }


    //=============Email BillRun To the perticuler customer==========
    public static void clickOnEmailButton() {
        WebDriverWaits.ClickOn(emailDropDown);
    }

    public static void clickOnCustomer() {
        WebDriverWaits.ClickOn(selectedEmailableCustomer);
    }

    public static void clickOnConEmailButton() {
        WebDriverWaits.ClickOn(emailButton);
    }

    public void createBillRunCycle() throws InterruptedException {
        // Login.loginWithGroupName("Test Utilities");
        clickOnAdminTab();
        Thread.sleep(2000);
        clickOnBillRunCyclesTab();
        Thread.sleep(3000);
        clickOnCreateNewButton();
        cycleName(Customer.CustomerFirstName);
        onAutomatedToggle();
        launchAutomatedBilling();
        billPeriod();
        paymentTerm();
        customerFilter(Customer.CustomerFirstName);
        Thread.sleep(1000);
        clickOnPerticularCustomer();
        clickOnArrow();
        clickOnSaveCycle();
        String Expectedsuccmsg = "Successfully added new bill run cycle.";
        softAssert.assertEquals(Expectedsuccmsg, BillRunCycleSucc);

        //p/span[@id='resultMsg']
    }

    public void billRun() throws AWTException, InterruptedException {
        Thread.sleep(2000);
        clickOnBillRunTab();
        Thread.sleep(2000);
        clickOnRunTheBillsButton();
        selectBillRun();
        sendBillRun(Customer.CustomerFirstName);
        // Clicking 3 times in toggle button because of Toggle issue.
        clickOnToggle();
        clickOnToggle();
        Thread.sleep(1000);
        clickOnEndDate();
        clickOnIssueDate();
        clickOnRunBillButton();
        clickOnSearchBox(Customer.CustomerFirstName);
        Thread.sleep(2000);
        billRunCycle(Customer.CustomerFirstName);
        reloadButton();
        //    ClickOnDateFrom();

        // Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Showing
        // 1 to 1 of 1 entries')]")).getText(), expectedBillRunSuccessText) ;
        // System.out.println("Texts match. Assertion passed.");
    }

    public void commitEditedBillRun() throws InterruptedException {
        clickOnBillRunTab();
        reloadButton();
        clickOnDateFrom();
        commitButton();
        clickOnOkcommit();
        clickOnCommitOkButton();
    }

    public void rollBack() throws InterruptedException {
        Thread.sleep(3000);
        clickOnBillRunTab();
        Thread.sleep(1000);
        reloadButton();
        sendValueInSearchBox(RandomName1);
        clickONDetailsIcon();
        customerCheckbox();
        clickOnRollBackButton();
        clickCross();
    }

    public static void downloadZip() throws InterruptedException, AWTException {
        clickONDetailsIcon();
        customerCheckbox();
        clickDownloadButton();

    }

    public static void commitBillRun(String billRunCycle) throws InterruptedException {
        Thread.sleep(3000);
        clickOnBillRunTab();
        clickOnSearchBox(billRunCycle);
        clickONDetailsIcon();
        commitButton();
        clickOnOkcommit();
        clickOnCommitOkButton();
    }

    public static void emailBillRun() throws InterruptedException {
        clickOnEmailButton();
        WebDriverWaits.ClickOn(selectedEmailableCustomer);
        clickOnConEmailButton();
        WebDriverWaits.Waituntilvisible(closeButton);
        WebDriverWaits.ClickOn(closeButton);

    }


    public void reBillRun() throws AWTException, InterruptedException {
        Thread.sleep(2000);
        //  clickOnBillRunTab();

        clickOnRunTheBillsButton();
        Thread.sleep(1000);
        selectBillRun();
        sendBillRun(RandomName1);
        // Clicking 2 times in toggle button because of Toggle issue.
        clickOnToggle();
        clickOnToggle();
        Thread.sleep(1000);
        clickOnEndDate();
        clickOnIssueDate();
        clickOnRunBillButton();



    }
}