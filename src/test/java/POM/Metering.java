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
    public static By ConsumptiomType=By.xpath("//select[@id='consumptionType']");
    public static SoftAssert softAssert = new SoftAssert();

    public static String
    add_Metering() throws InterruptedException {

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

    public static String create_Register(String networkCodeTxt,String unitTxt,String timeofDayTxt,String dailFormatTxt,
                                        String demand1Txt,String demand2Txt,String nmiSuffixTxt) throws InterruptedException {
       //jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
         WebDriverWaits.scrollIntoView(MeterEdit_icon);
         Thread.sleep(1000);
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
        WebDriverWaits.SendKeys(NetworkTariffCode_Field, networkCodeTxt);
        WebDriverWaits.ClickOn(UnitOfMeasure_Field);
        WebDriverWaits.SendKeys(UnitOfMeasure_Field, unitTxt);
        WebDriverWaits.ClickOn(TimeofDay_Field);
        WebDriverWaits.SendKeys(TimeofDay_Field, timeofDayTxt);
//        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.scrollIntoView(DialFormat_Field);
        WebDriverWaits.ClickOn(DialFormat_Field);
        WebDriverWaits.SendKeys(DialFormat_Field, dailFormatTxt);
        WebDriverWaits.ClickOn(Demand1_Field);
        WebDriverWaits.SendKeys(Demand1_Field, demand1Txt);
        WebDriverWaits.ClickOn(Demand2_Field);
        WebDriverWaits.SendKeys(Demand2_Field, demand2Txt);
        WebDriverWaits.ClickOn(NMISuffix_Field);
        WebDriverWaits.SendKeys(NMISuffix_Field, nmiSuffixTxt);
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

    public static void add_MeterReads(String readType,String peakValue, String offPeakValue, String shoulderValue) throws InterruptedException {
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
        WebDriverWaits.scrollIntoView(Save_Button);
        WebDriverWaits.ClickOn(Save_Button);
        Thread.sleep(2000);

      //  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }


    // ==========Creating Meter============

    public static By servicesTab = By.xpath("//a[text()=' Services']");
    public static By meteringPlusIcon = By.xpath("(//i[@class='icon-plus'])[4]");
    public static By meterNumber = By.xpath("//input[@id='meterNo']");
    public static By manageIcon = By.xpath("//i[@class='icon-edit']");
    public static By configurationType = By.xpath("//option[text()='POS']");
    public static By lastTest = By.xpath("//input[@id='maintenanceDate']");
    public static By activeDate = By.xpath("//td[@class='active day']");
    public static By dateConnected = By.xpath("//input[@id='datecon']");
    public static By activeDateConnected = By.xpath("//td[@class='active day']");
    public static By createMeter = By.xpath("//button[text()='Create Meter']");
    // public static By MeterManage=By.xpath("//i[@class='icon-edit']");
//	public static By MeterRegister=By.xpath("(//i[@class='icon-plus'])[1]");

    // ==========Creating MeterRegister=========
    public static By registerManage = By.xpath("//button[@title='Manage']");
    public static By plusicon = By.xpath("(//i[@class='icon-plus'])[1]");
    public static By register = By.xpath("//input[@id='registerNo']");
    public static By networkTariffCode = By.xpath("//input[@id='networkTariffCode']");
    public static By unitOfMeasure = By.xpath("//input[@id='unitOfMeasure']");
    public static By timeOfDay = By.xpath("//input[@id='timeOfDay']");
    public static By dialFormat = By.xpath("//input[@id='dialFormat']");
    public static By demand1 = By.xpath("//input[@id='demand1']");
    public static By demand2 = By.xpath("//input[@id='demand2']");
    public static By nMISuffix = By.xpath("//input[@id='nmiSuffix']");
    public static By datecon = By.xpath("//input[@id='datecon']");
    public static By activeDateConnect = By.xpath("//td[@class='active day']");
    public static By registerButton = By.xpath("//button[text()='Create Register']");
    public static By save = By.xpath("//button[text()='x']");

    // =========Creating Meter Reads===========

    public static By meterReadTab = By.xpath("//a[text()=' Meter Reads']");
    public static By selectMeter = By.xpath("//select[@id='meterNo']");
 //   public static By MeterReadTab = By.xpath("//a[text()='Meter Reads']");
    public static By service = By.xpath("//select[@id='nmis']");
    public static By k = By.xpath("(//option[text()='KarlieVf'])[1]");
    public static By meterRead = By.xpath("//a[@id='viewMeterReads']");
    public static By addRead = By.xpath("//a[text()=' Add Read']");
    public static By readType = By.xpath("//select[@id='rreadType']");
    public static By readDate = By.xpath("//input[@id='rreadDate']");
    public static By activeDay = By.xpath("//td[@class='active day']");
    public static By meterReadPeak = By.xpath("//input[@id='modalReadingP']");
    public static By meterReadOffPeak = By.xpath("//input[@id='modalReadingO']");
    public static By meterReadShoulder = By.xpath("//input[@id='modalReadingS']");
    public static By saveInitial = By.xpath("(//button[text()='Save'])[2]");
    public static By meterNum = By.xpath("//select[@id='rmeterno']");
    public static By readTypeActual = By.xpath("//select[@id='rreadType']");
    public static By readDateActual = By.xpath("//input[@id='rreadDate']");
    public static By activeDayActual = By.xpath("//td[@class='active day']");
    public static By meterReadPeakActual = By.xpath("//input[@id='modalReadingP']");
    public static By meterReadOffPeakActual = By.xpath("//input[@id='modalReadingO']");
    public static By meterReadShoulderActual = By.xpath("//input[@id='modalReadingS']");
    public static By saveActual = By.xpath("(//button[text()='Save'])[2]");
    public static By consumptionType=By.xpath("//select[@id='consumptionType']");
    public static By succMeterReg=By.xpath("(//center/p)[1]");
    public static By ConfType=By.xpath("//select[@id='configurationType']");

    public void clickOnServicesTab() {
        WebDriverWaits.ClickOn(servicesTab);
    }

    public void clickOnPlusIcon() {
        WebDriverWaits.scrollIntoView(meteringPlusIcon);
        WebDriverWaits.ClickOn(meteringPlusIcon);
    }

    public void clickOnManageIcon() {
        WebDriverWaits.WaitUntilVisibleWE20(manageIcon);
        WebDriverWaits.ClickOn(manageIcon);

    }

    public void enterMeterNumber(String MeterNumberText) {
        WebDriverWaits.SendKeysWithClear(meterNumber, MeterNumberText);
    }

    public void selectConfigureType() throws InterruptedException {
        WebDriverWaits.ClickOn(ConfType);
        WebDriverWaits.Waituntilvisible(configurationType);
        WebDriverWaits.ClickOn(configurationType);
    }

    public void selectConsumptionType() {
        WebDriverWaits.WaitUntilVisible(consumptionType);
        WebDriverWaits.selectByVisibleText(consumptionType, "Cumulative");
    }

    public void selectLastTestDate() {
        WebDriverWaits.ClickOn(lastTest);
        WebDriverWaits.ClickOn(activeDate);
    }

    public void selectDateConnected() {
        WebDriverWaits.ClickOn(dateConnected);
        WebDriverWaits.ClickOn(activeDateConnected);
    }

    public void clickOnCreateMeter() {
        WebDriverWaits.scrollIntoView(createMeter);
        WebDriverWaits.ClickOn(createMeter);
    }


    // ===========Creating Meter Register================

    public void clickONManages() {
        WebDriverWaits.scrollIntoView(registerManage);
        WebDriverWaits.Waituntilvisible(registerManage);
        WebDriverWaits.ClickOn(registerManage);
    }

    public void clickOnplus() {
        WebDriverWaits.scrollIntoView(plusicon);
        WebDriverWaits.ClickOn(plusicon);
    }

    public void clickOnMeterRegister(String RegisterField) {
        WebDriverWaits.SendKeysWithClear(register, RegisterField);
    }

    public void clickOnNetworkTariffCode() {
        WebDriverWaits.SendKeysWithClear(networkTariffCode, "NA");
    }

    public void clickOnUnitOfMeasure() {
        WebDriverWaits.SendKeysWithClear(unitOfMeasure, "KWH");
    }

    public void clickOntimeOfDay() {
        WebDriverWaits.SendKeysWithClear(timeOfDay, "ALLDAY");
    }

    public void clickOndialFormat() {
        WebDriverWaits.SendKeysWithClear(dialFormat, "5");
    }

    public void clickOndemand1() {
        WebDriverWaits.SendKeysWithClear(demand1, "0");
    }

    public void clickOndemand2() {
        WebDriverWaits.SendKeysWithClear(demand2, "0");
    }

    public void clickOnNmi() {
        WebDriverWaits.SendKeysWithClear(nMISuffix, "17");
    }

    public void cliKOnDate() {
        WebDriverWaits.ClickOn(datecon);
        WebDriverWaits.ClickOn(activeDateConnect);
    }

    public void clickOnRegister() {
        WebDriverWaits.ClickOn(registerButton);
    }

    public void clickOnSave() {
        WebDriverWaits.WaitUntilVisible(save);
        WebDriverWaits.scrollIntoView(save);
        WebDriverWaits.ClickOn(save);
    }

    // =========Creating Meter Reads===========

    public void clickOnMeterReadTab() {
        WebDriverWaits.Waituntilvisible(meterReadTab);
        WebDriverWaits.ClickOn(meterReadTab);
    }

    public void service(String Servicefield) {
        WebDriverWaits.selectByVisibleText(service, Servicefield);
    }

    public void clickOnMeterReads() throws AWTException {
        WebDriverWaits.WaitUntilVisible(selectMeter);
        WebDriverWaits.ClickOn(selectMeter);
        WebDriverWaits.selectByIndex(selectMeter, 0);
        // WebDriverWaits.selectByVisibleText(SelectMeter,"SelectMeterfiled");
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public void clickOnMeterRead() {
        WebDriverWaits.scrollIntoView(meterRead);
        WebDriverWaits.ClickOn(meterRead);
    }

    public void clickOnAddRead() throws InterruptedException {
        WebDriverWaits.Waituntilvisible(addRead);
        WebDriverWaits.ClickOn(addRead);
    }

    public void enterReadType() throws InterruptedException {
//        WebDriverWaits.WaitUntilVisible(ReadType);
//        WebDriverWaits.ClickOn(ReadType);
        WebDriverWaits.WaitUntilSelect(readType);
        WebDriverWaits.selectByVisibleText(readType, "Initial");
    }

    public void enterReadDate() {
        WebDriverWaits.ClickOn(readDate);
        WebDriverWaits.ClickOn(activeDay);
    }

    public void meterReadPeak() {
        WebDriverWaits.SendKeysWithClear(meterReadPeak, "150");
    }

    public void meterReadOffPeak() {
        WebDriverWaits.SendKeysWithClear(meterReadOffPeak, "200");
    }

    public void meterReadShoulder() {
        WebDriverWaits.SendKeysWithClear(meterReadShoulder, "300");
    }

    public void clickOnSaveInitial() throws InterruptedException {
        WebDriverWaits.scrollIntoView(saveInitial);
        WebDriverWaits.WaitUntilVisibleWE(saveInitial);
        WebDriverWaits.scrollIntoView(saveInitial);
        WebDriverWaits.ClickOn(saveInitial);
    }

    public void selectMeter(String MeterNumfield) {
        WebDriverWaits.selectByVisibleText(meterNum, MeterNumfield);
    }

    public void enterReadTypeActual() {
        WebDriverWaits.WaitUntilSelect(readTypeActual);
        WebDriverWaits.selectByVisibleText(readTypeActual, "Actual Read");
    }

    public void enterReadDateActual() {
        WebDriverWaits.ClickOn(readDateActual);
        WebDriverWaits.ClickOn(activeDayActual);
    }

    public void meterReadPeakActual() {
        WebDriverWaits.SendKeysWithClear(meterReadPeakActual, "200");
    }

    public void meterReadOffPeakActual() {
        WebDriverWaits.SendKeysWithClear(meterReadOffPeakActual, "400");
    }

    public void meterReadShoulderActual() {
        WebDriverWaits.SendKeysWithClear(meterReadShoulderActual, "600");
    }

    public void clickOnSaveActual() throws InterruptedException {
        WebDriverWaits.scrollIntoView(saveActual);
        WebDriverWaits.WaitUntilVisibleWE(saveActual);
        WebDriverWaits.scrollIntoView(saveInitial);
        WebDriverWaits.ClickOn(saveInitial);
    }

    public void createMeter() throws InterruptedException {
        clickOnServicesTab();
        clickOnManageIcon();
        clickOnPlusIcon();
        enterMeterNumber(Customer.CustomerFirstName);
    //    SelectConsumptionType();
        selectConfigureType();
        selectLastTestDate();
        selectDateConnected();
        clickOnCreateMeter();
     //   String SuccMeterRegister=" Successfully created meter register.";
     //
        //
        //   softAssert.assertEquals(SuccMeterRegister, SuccMeterReg );
    }

    public void createMeterRegister() throws InterruptedException {
        Thread.sleep(2000);
         clickONManages();
         clickOnplus();
        clickOnMeterRegister(Customer.CustomerFirstName);
         clickOnNetworkTariffCode();
         clickOnUnitOfMeasure();
         clickOntimeOfDay();
         clickOndialFormat();
         clickOndemand1();
         clickOndemand2();
         clickOnNmi();
         cliKOnDate();
        clickOnRegister();
        String SuccMeterRegister=" Successfully created meter register.";
        softAssert.assertEquals(SuccMeterRegister, succMeterReg );
        	//BillRun.ClickOnSave();
    }


    public void createMeterReads() throws InterruptedException {
        Thread.sleep(2000);
         clickOnMeterReadTab();
         Thread.sleep(2000);
         clickOnMeterRead();
         clickOnAddRead();
         enterReadType();
        enterReadDate();
         meterReadPeak();
       meterReadOffPeak();
         meterReadShoulder();
         clickOnSaveInitial();
         Thread.sleep(1000);
        clickOnAddRead();
         selectMeter(Customer.CustomerFirstName);
         enterReadTypeActual();
         enterReadDateActual();
         meterReadPeakActual();
        meterReadOffPeakActual();
        meterReadShoulderActual();
         clickOnSaveActual();
    }

}
