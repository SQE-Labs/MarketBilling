package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

import static BrowsersBase.BrowsersInvoked.driver;
import static POM.GroupEdit.softAssert;

public class Metering {
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static By AddMeterIcon = By.xpath("//a[@id='addMeter']/i");
    public static By MeterSerialNumber_Field = By.xpath("//*[@id='meterNo']");
    public static By ConfigurationType_Dropdown = By.xpath("//*[@id='configurationType']");
    public static By ConfigurationType_Opn = By.xpath("//option[text()='POS']");
    public static By LastTestdate_Datepiker = By.xpath("//*[@id='maintenanceDate']");
    public static By Select_LastTestdate_Datepiker = By.xpath("//td[@class='active day']");
    public static By DateConnected_Datepicker = By.xpath("//*[@id='datecon']");
    public static By Select_DateConnected_Datepicker = By.xpath("//*[@class='active day']");
    public static By CreateMeter_Button = By.xpath("//*[@id='createMeter']");
    public static By MeterEdit_icon = By.xpath("//*[@class='icon-edit']");
    public static By AddMeterRegister_Icon = By.xpath("//*[@id='addRegister']");
    public static By RegisterID_Field = By.xpath("//*[@id='registerNo']");
    public static By NetworkTariffCode_Field = By.xpath("//*[@id='networkTariffCode']");
    public static By UnitOfMeasure_Field = By.xpath("//*[@id='unitOfMeasure']");
    public static By TimeofDay_Field = By.xpath("//*[@id='timeOfDay']");
    public static By DialFormat_Field = By.xpath("//*[@id='dialFormat']");
    public static By Demand1_Field = By.xpath("//*[@id='demand1']");
    public static By Demand2_Field = By.xpath("//*[@id='demand2']");
    public static By NMISuffix_Field = By.xpath("//*[@id='nmiSuffix']");
    public static By DateConnectedDatepicker = By.xpath("//*[@id='datecon']");
    public static By SelectTodayDateConnected_Datepicker = By.xpath("//*[@class='active day']");
    public static By CreateRegister_Button = By.xpath("//*[@id='createRegister']");
    public static By MeterReads_Tab = By.xpath("//*[@class='icon-bar-chart']");
    public static By ServiceName_Dropdown = By.xpath("//*[@id='nmis']");
    public static By ServiceName_DropdownOpn = By.xpath("//*[@id='nmis']/option[2]");
    public static By MeterNumber_Dropdown = By.xpath("//*[@id='meterNo']");
    public static By MeterNumber_DropdownOpn = By.xpath("//*[@id='meterNo']/option[2]");
    public static By ViewMeterReads = By.xpath("//*[@id='viewMeterReads']");
    public static By AddMeterReads = By.xpath("//*[@title='Add Read']");
    public static By MeterNo_Dropdown = By.xpath("//*[@id='rmeterno']");
    public static By MeterNo_DropdownOpn = By.xpath("//*[@id='rmeterno']/option[2]");
    public static By RegisterNo_Dropdown = By.xpath("//*[@id='rregno']");
    public static By RegisterNo_DropdownOpn = By.xpath("//*[@id='rregno']/option[2]");
    public static By ReadType_Dropdown = By.id("rreadType");
    public static By ReadType_DropdownOpn1 = By.xpath("//*[@id='rreadType']/option[2]");
    public static By ReadType_DropdownOpn2 = By.xpath("//*[@id='rreadType']/option[4]");
    public static By ReadDate_Datepicker = By.xpath("//*[@id='rreadDate']");
    public static By Select_ReadDate_Datepicker = By.xpath("//*[@class='active day']");
    public static By MeterReadPeak_Field = By.xpath("//*[@id='modalReadingP']");
    public static By MeterReadOffPeak_Field = By.xpath("//*[@id='modalReadingO']");
    public static By MeterReadShoulder_Field = By.xpath("//*[@id='modalReadingS']");
    public static By Save_Button = By.xpath("(//button[contains(text(),'Save')])[2]");
    public static By CustomerSuccessMeterRegister = By.xpath("//div[@class='alert alert-success']/center");
    public static SoftAssert softAssert = new SoftAssert();

    public static String AddMeter() throws InterruptedException {

//        jse.executeScript("window.scrollBy(0,1000)", "");
        System.out.println("I am clicking add meter button");
        WebDriverWaits.scrollIntoView(AddMeterIcon);
        WebDriverWaits.ClickOn(AddMeterIcon);
        System.out.println("I am on add meter page");
        WebDriverWaits.ClickOn(MeterSerialNumber_Field);
        String RandomNumber1 = "Meter" + RandomStrings.RequiredDigits(3);
        WebDriverWaits.SendKeys(MeterSerialNumber_Field, RandomNumber1);
        WebDriverWaits.ClickOn(ConfigurationType_Dropdown);
        WebDriverWaits.ClickOn(ConfigurationType_Opn);
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        WebDriverWaits.scrollIntoView(LastTestdate_Datepiker);
        WebDriverWaits.ClickOn(LastTestdate_Datepiker);
        WebDriverWaits.ClickOn(Select_LastTestdate_Datepiker);
        WebDriverWaits.ClickOn(DateConnected_Datepicker);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Select_DateConnected_Datepicker);
         WebDriverWaits.scrollIntoView(CreateMeter_Button);
        WebDriverWaits.ClickOn(CreateMeter_Button);
        Thread.sleep(4000);
        String ExpectedMsg = "Successfully registered meter";
        softAssert.assertEquals(ExpectedMsg, "Successfully registered meter");
        Thread.sleep(4000);
        return RandomNumber1;
    }

    public static String createRegister() throws InterruptedException {
       //jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
         WebDriverWaits.scrollIntoView(MeterEdit_icon);
        WebDriverWaits.ClickOn(MeterEdit_icon);
     //   jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.scrollIntoView(AddMeterRegister_Icon);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(AddMeterRegister_Icon);

        //Create register
        WebDriverWaits.ClickOn(RegisterID_Field);
        Thread.sleep(2000);
        String registerId = "1215" + RandomStrings.RequiredDigits(3);
        WebDriverWaits.SendKeys(RegisterID_Field, registerId);
        WebDriverWaits.ClickOn(NetworkTariffCode_Field);
        WebDriverWaits.SendKeys(NetworkTariffCode_Field, "Na");
        WebDriverWaits.ClickOn(UnitOfMeasure_Field);
        WebDriverWaits.SendKeys(UnitOfMeasure_Field, "KWH");
        WebDriverWaits.ClickOn(TimeofDay_Field);
        WebDriverWaits.SendKeys(TimeofDay_Field, "ALLDAY");
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.scrollIntoView(DialFormat_Field);
        WebDriverWaits.ClickOn(DialFormat_Field);
        WebDriverWaits.SendKeys(DialFormat_Field, "5");
        WebDriverWaits.ClickOn(Demand1_Field);
        WebDriverWaits.SendKeys(Demand1_Field, "0");
        WebDriverWaits.ClickOn(Demand2_Field);
        WebDriverWaits.SendKeys(Demand2_Field, "0");
        WebDriverWaits.ClickOn(NMISuffix_Field);
        WebDriverWaits.SendKeys(NMISuffix_Field, "17");
        WebDriverWaits.ClickOn(DateConnectedDatepicker);
        WebDriverWaits.ClickOn(SelectTodayDateConnected_Datepicker);
        WebDriverWaits.ClickOn(CreateRegister_Button);
        // Validate Successfully created meter register.
//        String ActualSucessMsg = WebDriverWaits.GetText(CustomerSuccessMeterRegister);
//        String ExpectedSucessMsg1 = "Successfully created meter register.";
//        softAssert.assertEquals(ExpectedSucessMsg1, ActualSucessMsg);
//        Thread.sleep(3000);
        System.out.println("register Id created ----- "+registerId);
        return registerId;
    }

    public static void  addMeterReads(String readType,String peakValue, String offPeakValue, String shoulderValue) throws InterruptedException {
       Thread.sleep(3000);
        WebDriverWaits.ClickOn(MeterReads_Tab);

     //   WebDriverWaits.ClickOn(ServiceName_Dropdown);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(ServiceName_DropdownOpn);
        WebDriverWaits.ClickOn(MeterNumber_Dropdown);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(MeterNumber_DropdownOpn);
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.scrollIntoView(ViewMeterReads);
        WebDriverWaits.ClickOn(ViewMeterReads);
        WebDriverWaits.scrollIntoView(AddMeterReads);
        WebDriverWaits.ClickOn(AddMeterReads);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(MeterNo_Dropdown);
        WebDriverWaits.ClickOn(MeterNo_DropdownOpn);
        WebDriverWaits.ClickOn(RegisterNo_Dropdown);
        WebDriverWaits.ClickOn(RegisterNo_DropdownOpn);
        WebDriverWaits.ClickOn(RegisterNo_DropdownOpn);
        WebDriverWaits.selectByVisibleText(ReadType_Dropdown,readType);
        // WebElement ReadTypeOption2 = WebDriverWaits.WaitUntilVisibleWE(ReadType_Dropdown);
        // select = new Select(ReadTypeOption2);
        // select.selectByVisibleText("Actual Read");
        WebDriverWaits.ClickOn(ReadDate_Datepicker);
        WebDriverWaits.ClickOn(Select_ReadDate_Datepicker);
        WebDriverWaits.ClickOn(MeterReadPeak_Field);
        WebDriverWaits.SendKeys(MeterReadPeak_Field, peakValue);
        WebDriverWaits.ClickOn(MeterReadOffPeak_Field);
        WebDriverWaits.SendKeys(MeterReadOffPeak_Field, offPeakValue);
        WebDriverWaits.ClickOn(MeterReadShoulder_Field);
        WebDriverWaits.SendKeys(MeterReadShoulder_Field, shoulderValue);
        WebDriverWaits.ClickOn(Save_Button);
        Thread.sleep(2000);
      //  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    // ==========Creating Meter============

    public static By ServicesTab = By.xpath("//a[text()=' Services']");
    public static By MeteringPlusIcon = By.xpath("(//i[@class='icon-plus'])[4]");
    public static By MeterNumber = By.xpath("//input[@id='meterNo']");
    public static By ManageIcon = By.xpath("//i[@class='icon-edit']");
    public static By configurationType = By.xpath("//select[@id='configurationType']");
    public static By LastTest = By.xpath("//input[@id='maintenanceDate']");
    public static By ActiveDate = By.xpath("//td[@class='active day']");
    public static By DateConnected = By.xpath("//input[@id='datecon']");
    public static By ActiveDateConnected = By.xpath("//td[@class='active day']");
    public static By CreateMeter = By.xpath("//button[text()='Create Meter']");
    // public static By MeterManage=By.xpath("//i[@class='icon-edit']");
//	public static By MeterRegister=By.xpath("(//i[@class='icon-plus'])[1]");

    // ==========Creating MeterRegister=========
    public static By RegisterManage = By.xpath("//button[@title='Manage']");
    public static By Plusicon = By.xpath("(//i[@class='icon-plus'])[1]");
    public static By Register = By.xpath("//input[@id='registerNo']");
    public static By NetworkTariffCode = By.xpath("//input[@id='networkTariffCode']");
    public static By unitOfMeasure = By.xpath("//input[@id='unitOfMeasure']");
    public static By timeOfDay = By.xpath("//input[@id='timeOfDay']");
    public static By dialFormat = By.xpath("//input[@id='dialFormat']");
    public static By demand1 = By.xpath("//input[@id='demand1']");
    public static By demand2 = By.xpath("//input[@id='demand2']");
    public static By NMISuffix = By.xpath("//input[@id='nmiSuffix']");
    public static By datecon = By.xpath("//input[@id='datecon']");
    public static By ActiveDateConnect = By.xpath("//td[@class='active day']");
    public static By RegisterButton = By.xpath("//button[text()='Create Register']");
    public static By Save = By.xpath("//button[text()='x']");

    // =========Creating Meter Reads===========

    public static By MeterReadTab = By.xpath("//a[text()=' Meter Reads']");
    public static By SelectMeter = By.xpath("//select[@id='meterNo']");
    public static By MeterReads = By.xpath("//a[text()='Meter Reads']");
    public static By Service = By.xpath("//select[@id='nmis']");
    public static By k = By.xpath("(//option[text()='KarlieVf'])[1]");
    public static By MeterRead = By.xpath("//a[text()='Meter Reads']");
    public static By AddRead = By.xpath("//a[text()=' Add Read']");
    public static By ReadType = By.xpath("//select[@id='rreadType']");
    public static By ReadDate = By.xpath("//input[@id='rreadDate']");
    public static By ActiveDay = By.xpath("//td[@class='active day']");
    public static By MeterReadPeak = By.xpath("//input[@id='modalReadingP']");
    public static By MeterReadOffPeak = By.xpath("//input[@id='modalReadingO']");
    public static By MeterReadShoulder = By.xpath("//input[@id='modalReadingS']");
    public static By SaveInitial = By.xpath("(//button[text()='Save'])[2]");
    public static By MeterNum = By.xpath("//select[@id='rmeterno']");
    public static By ReadTypeActual = By.xpath("//select[@id='rreadType']");
    public static By ReadDateActual = By.xpath("//input[@id='rreadDate']");
    public static By ActiveDayActual = By.xpath("//td[@class='active day']");
    public static By MeterReadPeakActual = By.xpath("//input[@id='modalReadingP']");
    public static By MeterReadOffPeakActual = By.xpath("//input[@id='modalReadingO']");
    public static By MeterReadShoulderActual = By.xpath("//input[@id='modalReadingS']");
    public static By SaveActual = By.xpath("(//button[text()='Save'])[2]");
    public static By ConsumptionType=By.xpath("//select[@id='consumptionType']");
    public static By SuccMeterReg=By.xpath("(//center/p)[1]");

    public void ClickOnServicesTab() {
        WebDriverWaits.ClickOn(ServicesTab);
    }

    public void ClickOnPlusIcon() {
        WebDriverWaits.scrollIntoView(MeteringPlusIcon);
        WebDriverWaits.ClickOn(MeteringPlusIcon);
    }

    public void ClickOnManageIcon() {
        WebDriverWaits.WaitUntilVisibleWE20(ManageIcon);
        WebDriverWaits.ClickOn(ManageIcon);

    }

    public void EnterMeterNumber(String MeterNumberText) {
        WebDriverWaits.SendKeysWithClear(MeterNumber, MeterNumberText);
    }

    public void SelectConfigureType() {
        WebDriverWaits.WaitUntilVisible(configurationType);
        WebDriverWaits.selectByVisibleText(configurationType, "POS");
    }

 /*   public void SelectConsumptionType() {
        WebDriverWaits.WaitUntilVisible(ConsumptionType);
        WebDriverWaits.selectByVisibleText(ConsumptionType, "Cumulative");
    } */

    public void SelectLastTestDate() {
        WebDriverWaits.ClickOn(LastTest);
        WebDriverWaits.ClickOn(ActiveDate);
    }

    public void SelectDateConnected() {
        WebDriverWaits.ClickOn(DateConnected);
        WebDriverWaits.ClickOn(ActiveDateConnected);
    }

    public void ClickOnCreateMeter() {
        WebDriverWaits.scrollIntoView(CreateMeter);
        WebDriverWaits.ClickOn(CreateMeter);
    }


    // ===========Creating Meter Register================

    public void ClickONManages() {
        // JavascriptExecutor js =(JavascriptExecutor) driver;
        WebDriverWaits.WaitUntilVisible(RegisterManage);
        WebDriverWaits.scrollIntoView(RegisterManage);
        // WebDriverWaits.WaitUntilVisibleWE20(RegisterManage);
        WebDriverWaits.ClickOn(RegisterManage);
    }

    public void ClickOnplus() {
        WebDriverWaits.scrollIntoView(Plusicon);
        WebDriverWaits.ClickOn(Plusicon);
    }

    public void ClickOnMeterRegister(String RegisterField) {
        WebDriverWaits.SendKeysWithClear(Register, RegisterField);
    }

    public void ClickOnNetworkTariffCode() {
        WebDriverWaits.SendKeysWithClear(NetworkTariffCode, "NA");
    }

    public void ClickOnUnitOfMeasure() {
        WebDriverWaits.SendKeysWithClear(unitOfMeasure, "KWH");
    }

    public void ClickOntimeOfDay() {
        WebDriverWaits.SendKeysWithClear(timeOfDay, "ALLDAY");
    }

    public void ClickOndialFormat() {
        WebDriverWaits.SendKeysWithClear(dialFormat, "5");
    }

    public void ClickOndemand1() {
        WebDriverWaits.SendKeysWithClear(demand1, "0");
    }

    public void ClickOndemand2() {
        WebDriverWaits.SendKeysWithClear(demand2, "0");
    }

    public void ClickOnNmi() {
        WebDriverWaits.SendKeysWithClear(NMISuffix, "17");
    }

    public void CliKOnDate() {
        WebDriverWaits.ClickOn(datecon);
        WebDriverWaits.ClickOn(ActiveDateConnect);
    }

    public void ClickOnRegister() {
        WebDriverWaits.ClickOn(RegisterButton);
    }

    public void ClickOnSave() {
        WebDriverWaits.WaitUntilVisible(Save);
        WebDriverWaits.scrollIntoView(Save);
        WebDriverWaits.ClickOn(Save);
    }

    // =========Creating Meter Reads===========

    public void ClickOnMeterReadTab() {
        WebDriverWaits.WaitUntilVisible(MeterReadTab);
        WebDriverWaits.ClickOn(MeterReadTab);
    }

    public void Service(String Servicefield) {
        WebDriverWaits.selectByVisibleText(Service, Servicefield);
    }

    public void ClickOnMeterReads() throws AWTException {
        WebDriverWaits.WaitUntilVisible(SelectMeter);
        WebDriverWaits.ClickOn(SelectMeter);
        WebDriverWaits.selectByIndex(SelectMeter, 0);
        // WebDriverWaits.selectByVisibleText(SelectMeter,"SelectMeterfiled");
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public void ClickOnMeterRead() {
        WebDriverWaits.ClickOn(MeterRead);
    }

    public void ClickOnAddRead() {
        WebDriverWaits.ClickOn(AddRead);
    }

    public void EnterReadType() {
        WebDriverWaits.selectByVisibleText(ReadType, "Initial");
    }

    public void EnterReadDate() {
        WebDriverWaits.ClickOn(ReadDate);
        WebDriverWaits.ClickOn(ActiveDay);
    }

    public void MeterReadPeak() {
        WebDriverWaits.SendKeysWithClear(MeterReadPeak, "150");
    }

    public void MeterReadOffPeak() {
        WebDriverWaits.SendKeysWithClear(MeterReadOffPeak, "200");
    }

    public void MeterReadShoulder() {
        WebDriverWaits.SendKeysWithClear(MeterReadShoulder, "300");
    }

    public void ClickOnSaveInitial() throws InterruptedException {
        WebDriverWaits.scrollIntoView(SaveInitial);
        WebDriverWaits.WaitUntilVisibleWE(SaveInitial);
        WebDriverWaits.scrollIntoView(SaveInitial);
        WebDriverWaits.ClickOn(SaveInitial);
    }

    public void SelectMeter(String MeterNumfield) {
        WebDriverWaits.selectByVisibleText(MeterNum, MeterNumfield);
    }

    public void EnterReadTypeActual() {
        WebDriverWaits.selectByVisibleText(ReadTypeActual, "Actual Read");
    }

    public void EnterReadDateActual() {
        WebDriverWaits.ClickOn(ReadDateActual);
        WebDriverWaits.ClickOn(ActiveDayActual);
    }

    public void MeterReadPeakActual() {
        WebDriverWaits.SendKeysWithClear(MeterReadPeakActual, "200");
    }

    public void MeterReadOffPeakActual() {
        WebDriverWaits.SendKeysWithClear(MeterReadOffPeakActual, "400");
    }

    public void MeterReadShoulderActual() {
        WebDriverWaits.SendKeysWithClear(MeterReadShoulderActual, "600");
    }

    public void ClickOnSaveActual() throws InterruptedException {
        WebDriverWaits.scrollIntoView(SaveActual);
        WebDriverWaits.WaitUntilVisibleWE(SaveActual);
        WebDriverWaits.scrollIntoView(SaveInitial);
        WebDriverWaits.ClickOn(SaveInitial);
    }

    public void CreateMeter(){
        ClickOnServicesTab();
        ClickOnManageIcon();
        ClickOnPlusIcon();
        EnterMeterNumber(Customer.CustomerFirstName);
    //    SelectConsumptionType();
        SelectConfigureType();
        SelectLastTestDate();
        SelectDateConnected();
        ClickOnCreateMeter();
     //   String SuccMeterRegister=" Successfully created meter register.";
     //
        //
        //   softAssert.assertEquals(SuccMeterRegister, SuccMeterReg );
    }

    public void CreateMeterRegister(){
         ClickONManages();
         ClickOnplus();
        ClickOnMeterRegister(Customer.CustomerFirstName);
         ClickOnNetworkTariffCode();
         ClickOnUnitOfMeasure();
         ClickOntimeOfDay();
         ClickOndialFormat();
         ClickOndemand1();
         ClickOndemand2();
         ClickOnNmi();
         CliKOnDate();
        ClickOnRegister();
        String SuccMeterRegister=" Successfully created meter register.";
        softAssert.assertEquals(SuccMeterRegister, SuccMeterReg );
        	//BillRun.ClickOnSave();
    }

    public void CreateMeterReads() throws InterruptedException {
        Thread.sleep(2000);
         ClickOnMeterReadTab();
        // BillRun.ClickOnMeterReads();
       ClickOnMeterRead();
         ClickOnAddRead();
         EnterReadType();
        EnterReadDate();
         MeterReadPeak();
       MeterReadOffPeak();
         MeterReadShoulder();
         ClickOnSaveInitial();
         ClickOnAddRead();
         SelectMeter(Customer.CustomerFirstName);
         EnterReadTypeActual();
         EnterReadDateActual();
         MeterReadPeakActual();
        MeterReadOffPeakActual();
        MeterReadShoulderActual();
         ClickOnSaveActual();
    }

}
