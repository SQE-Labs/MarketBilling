package POM;

import CommonMethods.DateAndTime;
import CommonMethods.InternalMethods;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;

import static BrowsersBase.BrowsersInvoked.driver;
import static POM.GroupEdit.softAssert;

public class Services {
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static Select select;
    // Search Field
    public static By SearchField = By.xpath("(//*[@id=\"search_input\"])[1]");
    public static By SearchIcon = By.xpath("//button[@id='btn_search']");

    // Select the Residential/Business/Commercial customer created in add customer
    public static By TwosearchResults = By.xpath("//*[@class='icon-edit ']");
    public static By selectResidentialCustomer_Record = By.xpath("(//td[@class='sorting_1']/a)[1]");
    public static By selectBusinessCustomer_Record = By.xpath("(//td[@class='sorting_1']/a)[2]");
    public static By selectBusinessCustomer_Record1 = By.xpath("(//td[@class='sorting_1']/a)[1]"); // Just temporary
    // due to issue
    public static By selectCommercialCustomer_Record = By.xpath("(//td[@class='sorting_1']/a)[1]");
    public static By OverviewTab = By.xpath("//*[@class=\"icon-eye-open\"]"); // //*[contains(text(),'Overview')]

    // Add Service for Residential/Business/Commercial customer
    public static By RetailElectricity_Plus_Subtab = By.xpath("(//*[@class='icon-minus'])[2]");
    public static By Market_Type_Field = By.xpath("//*[@id='marketTypeSel']");
    public static By NMI_Field = By.xpath("//*[@id=\"NMI\"]");
    public static By Service_Plan_Dropdown = By.xpath("//*[@class='chosen-container chosen-container-multi']");
    public static By Service_Plan_Elec = By.xpath("//*[@id='planNo_chosen']/div/ul/li[1]");

    public static By Move_In_Date_Datepicker = By.xpath("//*[@id=\"proposedDate\"]");
    public static By SelectCurrentDate = By.xpath("//*[@class=\"active day\"]");
    public static By Select_Use_Structured_Address_Togglebutton = By.xpath("//*[@class=\"switch-label\"]");
    public static By Building_Name_Field = By.xpath("//*[@id=\"buildingName\"]");
    public static By UnitType_Dropdown = By.xpath("//*[@id=\"flatType\"]");
    public static By Street_Number_Suffix_Dropdown = By.xpath("//*[@id=\"houseNBRSuffix\"]");
    public static By Suburb_Field = By.xpath("//*[@id=\"locality\"]");
    public static By Postal_Code_field = By.xpath("//*[@id=\"postCode\"]");
    public static By StateDropdown = By.xpath("//*[@id=\"state\"]");
    public static By AddButton = By.xpath("//*[@id=\"submitBttn\"]");

    // Edit Residential/Business/Commercial customer service
    public static By ServiceTab = By.xpath("//*[@class=\"icon-power-off\"]");
    public static By Search_FieldOnPage = By.xpath("//*[@class=\"dataTables_filter\"]");
    public static By Edit_icon = By.xpath("//*[@class=\"btn btn-primary toolt\"]");
    public static By Service_Status_Dropdown = By.xpath("//*[@id=\"serviceStatus\"]");
    public static By Netting_Config_Dropdown = By.xpath("//*[@id=\"nettingConfig\"]");
    public static By Sub_Channel_Aggregation_Dropdown = By.xpath("//*[@id=\"subChannelAggregation\"]");
    public static By SaveChanges_Button = By.xpath("//*[@class=\"btn btn-primary iseditable\"]");
    public static By OkButton = By.xpath("//*[contains(text(),'OK')]");
    public static By CustomerSuccessEditMsg = By.xpath("//div[@class='alert alert-success']/center");

    public static String M_AddService(String customerId ) throws InterruptedException {
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(SearchField);
        Thread.sleep(4000);
        String ThirdRecID = WebDriverWaits.GetText(selectResidentialCustomer_Record);
       WebDriverWaits.SendKeys(SearchField, ThirdRecID);
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(2000);
        InternalMethods.SwitchToCustomerpage();
        WebDriverWaits.ClickOn(OverviewTab);
        WebDriverWaits.ClickOn(RetailElectricity_Plus_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Market_Type_Field);
        WebElement Option = WebDriverWaits.WaitUntilVisibleWE(Market_Type_Field);
        select = new Select(Option);
        select.selectByVisibleText("Off Market");
        Thread.sleep(4000);
        jse.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(NMI_Field);
        String ServiceIDLater1 = RandomStrings.RequiredDigits(10);
        WebDriverWaits.SendKeys(NMI_Field, ServiceIDLater1);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(Service_Plan_Dropdown);
//        WebElement Option2 = WebDriverWaits.WaitUntilVisibleWE(Service_Plan_Dropdown);
//        select = new Select(Option2);
//        select.selectByVisibleText("Electricity Template Plan");
      Thread.sleep(2000);
        WebDriverWaits.ClickOn(Service_Plan_Elec);
       // WebDriverWaits.ClickOn(Move_In_Date_Datepicker);
        WebDriverWaits.SendKeys(Move_In_Date_Datepicker, DateAndTime.DateTimeGenerator("dd/MM/yyyy"));
        //WebDriverWaits.ClickOn(SelectCurrentDate);
       // WebDriverWaits.scrollIntoView(Select_Use_Structured_Address_Togglebutton);
      //  WebDriverWaits.ClickOn(Select_Use_Structured_Address_Togglebutton);
//        WebDriverWaits.Waituntilvisible(Building_Name_Field);
//        WebDriverWaits.ClickOn(Building_Name_Field);
//        WebDriverWaits.SendKeys(Building_Name_Field, "Los angels");
//        WebDriverWaits.ClickOn(UnitType_Dropdown);
//        WebElement BlockOption = WebDriverWaits.WaitUntilVisibleWE(UnitType_Dropdown);
//        select = new Select(BlockOption);
//        select.selectByVisibleText("Block");
//        WebDriverWaits.ClickOn(Street_Number_Suffix_Dropdown);
//        WebElement VOption = WebDriverWaits.WaitUntilVisibleWE(Street_Number_Suffix_Dropdown);
//        select = new Select(VOption);
//        select.selectByVisibleText("V");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(Suburb_Field);
        WebDriverWaits.SendKeys(Suburb_Field, "Almor Distt 324");
        WebDriverWaits.ClickOn(Postal_Code_field);
        String RandomNumber2 = RandomStrings.RequiredDigits(15);
        WebDriverWaits.SendKeys(Postal_Code_field, RandomNumber2);
        WebDriverWaits.ClickOn(StateDropdown);
        WebElement StateOption = WebDriverWaits.WaitUntilVisibleWE(StateDropdown);
        select = new Select(StateOption);
        select.selectByVisibleText("New South Wales");
        WebDriverWaits.ClickOn(AddButton);
        jse.executeScript("window.scrollBy(0,-300)", "");
        System.out.println(ServiceIDLater1);

        return ServiceIDLater1;
    }

    public static String M_AddService1(String customerId ) throws InterruptedException {
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(SearchField);
        Thread.sleep(4000);
        String ThirdRecID = WebDriverWaits.GetText(selectResidentialCustomer_Record);
        WebDriverWaits.SendKeys(SearchField, ThirdRecID);
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(2000);
        InternalMethods.SwitchToCustomerpage(4);//2
        WebDriverWaits.ClickOn(OverviewTab);
        WebDriverWaits.ClickOn(RetailElectricity_Plus_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Market_Type_Field);
        WebElement Option = WebDriverWaits.WaitUntilVisibleWE(Market_Type_Field);
        select = new Select(Option);
        select.selectByVisibleText("Off Market");
        Thread.sleep(4000);
        jse.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(NMI_Field);
        String ServiceIDLater2 = RandomStrings.RequiredDigits(10);
        WebDriverWaits.SendKeys(NMI_Field, ServiceIDLater2);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(Service_Plan_Dropdown);
//        WebElement Option2 = WebDriverWaits.WaitUntilVisibleWE(Service_Plan_Dropdown);
//        select = new Select(Option2);
//        select.selectByVisibleText("Electricity Template Plan");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Service_Plan_Elec);
        // WebDriverWaits.ClickOn(Move_In_Date_Datepicker);
        WebDriverWaits.SendKeys(Move_In_Date_Datepicker, DateAndTime.DateTimeGenerator("dd/MM/yyyy"));
        //WebDriverWaits.ClickOn(SelectCurrentDate);
        // WebDriverWaits.scrollIntoView(Select_Use_Structured_Address_Togglebutton);
        //  WebDriverWaits.ClickOn(Select_Use_Structured_Address_Togglebutton);
//        WebDriverWaits.Waituntilvisible(Building_Name_Field);
//        WebDriverWaits.ClickOn(Building_Name_Field);
//        WebDriverWaits.SendKeys(Building_Name_Field, "Los angels");
//        WebDriverWaits.ClickOn(UnitType_Dropdown);
//        WebElement BlockOption = WebDriverWaits.WaitUntilVisibleWE(UnitType_Dropdown);
//        select = new Select(BlockOption);
//        select.selectByVisibleText("Block");
//        WebDriverWaits.ClickOn(Street_Number_Suffix_Dropdown);
//        WebElement VOption = WebDriverWaits.WaitUntilVisibleWE(Street_Number_Suffix_Dropdown);
//        select = new Select(VOption);
//        select.selectByVisibleText("V");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(Suburb_Field);
        WebDriverWaits.SendKeys(Suburb_Field, "Almor Distt 324");
        WebDriverWaits.ClickOn(Postal_Code_field);
        String RandomNumber2 = RandomStrings.RequiredDigits(15);
        WebDriverWaits.SendKeys(Postal_Code_field, RandomNumber2);
        WebDriverWaits.ClickOn(StateDropdown);
        WebElement StateOption = WebDriverWaits.WaitUntilVisibleWE(StateDropdown);
        select = new Select(StateOption);
        select.selectByVisibleText("New South Wales");
        WebDriverWaits.ClickOn(AddButton);
        jse.executeScript("window.scrollBy(0,-300)", "");
        System.out.println(ServiceIDLater2);

        return ServiceIDLater2;
    }

    public static String M_AddService2(String customerId ) throws InterruptedException {
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(SearchField);
        Thread.sleep(4000);
        String ThirdRecID = WebDriverWaits.GetText(selectResidentialCustomer_Record);
        WebDriverWaits.SendKeys(SearchField, ThirdRecID);
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(2000);
        InternalMethods.SwitchToCustomerpage(6);//3
        WebDriverWaits.ClickOn(OverviewTab);
        WebDriverWaits.ClickOn(RetailElectricity_Plus_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Market_Type_Field);
        WebElement Option = WebDriverWaits.WaitUntilVisibleWE(Market_Type_Field);
        select = new Select(Option);
        select.selectByVisibleText("Off Market");
        Thread.sleep(4000);
        jse.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(NMI_Field);
        String ServiceIDLater2 = RandomStrings.RequiredDigits(10);
        WebDriverWaits.SendKeys(NMI_Field, ServiceIDLater2);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(Service_Plan_Dropdown);
//        WebElement Option2 = WebDriverWaits.WaitUntilVisibleWE(Service_Plan_Dropdown);
//        select = new Select(Option2);
//        select.selectByVisibleText("Electricity Template Plan");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Service_Plan_Elec);
        // WebDriverWaits.ClickOn(Move_In_Date_Datepicker);
        WebDriverWaits.SendKeys(Move_In_Date_Datepicker, DateAndTime.DateTimeGenerator("dd/MM/yyyy"));
        //WebDriverWaits.ClickOn(SelectCurrentDate);
        // WebDriverWaits.scrollIntoView(Select_Use_Structured_Address_Togglebutton);
        //  WebDriverWaits.ClickOn(Select_Use_Structured_Address_Togglebutton);
//        WebDriverWaits.Waituntilvisible(Building_Name_Field);
//        WebDriverWaits.ClickOn(Building_Name_Field);
//        WebDriverWaits.SendKeys(Building_Name_Field, "Los angels");
//        WebDriverWaits.ClickOn(UnitType_Dropdown);
//        WebElement BlockOption = WebDriverWaits.WaitUntilVisibleWE(UnitType_Dropdown);
//        select = new Select(BlockOption);
//        select.selectByVisibleText("Block");
//        WebDriverWaits.ClickOn(Street_Number_Suffix_Dropdown);
//        WebElement VOption = WebDriverWaits.WaitUntilVisibleWE(Street_Number_Suffix_Dropdown);
//        select = new Select(VOption);
//        select.selectByVisibleText("V");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(Suburb_Field);
        WebDriverWaits.SendKeys(Suburb_Field, "Almor Distt 324");
        WebDriverWaits.ClickOn(Postal_Code_field);
        String RandomNumber2 = RandomStrings.RequiredDigits(15);
        WebDriverWaits.SendKeys(Postal_Code_field, RandomNumber2);
        WebDriverWaits.ClickOn(StateDropdown);
        WebElement StateOption = WebDriverWaits.WaitUntilVisibleWE(StateDropdown);
        select = new Select(StateOption);
        select.selectByVisibleText("New South Wales");
        WebDriverWaits.ClickOn(AddButton);
        jse.executeScript("window.scrollBy(0,-300)", "");
        System.out.println(ServiceIDLater2);

        return ServiceIDLater2;
    }
    public static String M_AddService3(String customerId ) throws InterruptedException {
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(SearchField);
        Thread.sleep(4000);
        String ThirdRecID = WebDriverWaits.GetText(selectResidentialCustomer_Record);
        WebDriverWaits.SendKeys(SearchField, ThirdRecID);
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(2000);
        InternalMethods.SwitchToCustomerpage(8);//4
        WebDriverWaits.ClickOn(OverviewTab);
        WebDriverWaits.ClickOn(RetailElectricity_Plus_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Market_Type_Field);
        WebElement Option = WebDriverWaits.WaitUntilVisibleWE(Market_Type_Field);
        select = new Select(Option);
        select.selectByVisibleText("Off Market");
        Thread.sleep(4000);
        jse.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(NMI_Field);
        String ServiceIDLater2 = RandomStrings.RequiredDigits(10);
        WebDriverWaits.SendKeys(NMI_Field, ServiceIDLater2);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(Service_Plan_Dropdown);
//        WebElement Option2 = WebDriverWaits.WaitUntilVisibleWE(Service_Plan_Dropdown);
//        select = new Select(Option2);
//        select.selectByVisibleText("Electricity Template Plan");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Service_Plan_Elec);
        // WebDriverWaits.ClickOn(Move_In_Date_Datepicker);
        WebDriverWaits.SendKeys(Move_In_Date_Datepicker, DateAndTime.DateTimeGenerator("dd/MM/yyyy"));
        //WebDriverWaits.ClickOn(SelectCurrentDate);
        // WebDriverWaits.scrollIntoView(Select_Use_Structured_Address_Togglebutton);
        //  WebDriverWaits.ClickOn(Select_Use_Structured_Address_Togglebutton);
//        WebDriverWaits.Waituntilvisible(Building_Name_Field);
//        WebDriverWaits.ClickOn(Building_Name_Field);
//        WebDriverWaits.SendKeys(Building_Name_Field, "Los angels");
//        WebDriverWaits.ClickOn(UnitType_Dropdown);
//        WebElement BlockOption = WebDriverWaits.WaitUntilVisibleWE(UnitType_Dropdown);
//        select = new Select(BlockOption);
//        select.selectByVisibleText("Block");
//        WebDriverWaits.ClickOn(Street_Number_Suffix_Dropdown);
//        WebElement VOption = WebDriverWaits.WaitUntilVisibleWE(Street_Number_Suffix_Dropdown);
//        select = new Select(VOption);
//        select.selectByVisibleText("V");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(Suburb_Field);
        WebDriverWaits.SendKeys(Suburb_Field, "Almor Distt 324");
        WebDriverWaits.ClickOn(Postal_Code_field);
        String RandomNumber2 = RandomStrings.RequiredDigits(15);
        WebDriverWaits.SendKeys(Postal_Code_field, RandomNumber2);
        WebDriverWaits.ClickOn(StateDropdown);
        WebElement StateOption = WebDriverWaits.WaitUntilVisibleWE(StateDropdown);
        select = new Select(StateOption);
        select.selectByVisibleText("New South Wales");
        WebDriverWaits.ClickOn(AddButton);
        jse.executeScript("window.scrollBy(0,-300)", "");
        System.out.println(ServiceIDLater2);

        return ServiceIDLater2;
    }


    // Methods to add Residential Service
    public static void EditService() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        // Methods to Edit Residential Service
        WebDriverWaits.ClickOn(ServiceTab);
        // Search service id ("N" + random+"11"); which is created above
        WebDriverWaits.ClickOn(Edit_icon);
        jse.executeScript("window.scrollBy(0,300)", "");
        WebDriverWaits.ClickOn(Service_Status_Dropdown);
        WebElement StatusOption = WebDriverWaits.WaitUntilVisibleWE(Service_Status_Dropdown);
        select = new Select(StatusOption);
        select.selectByVisibleText("Connected");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(SaveChanges_Button);
        WebDriverWaits.ClickOn(OkButton);
        //Assert:  Successfully saved service details.
//			String ActualMsg = WebDriverWaits.GetText(CustomerSuccessEditMsg);
//			String ExpectedMsg1 = "Successfully saved service details.";
//			softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully edited customer");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
    public static void navigateToEditServices() throws InterruptedException {
        WebDriverWaits.ClickOn(ServiceTab);
        // Search service id ("N" + random+"11"); which is created above
        WebDriverWaits.ClickOn(Edit_icon);
        jse.executeScript("window.scrollBy(0,300)", "");
    }

     //===========UPDATED NEW CODES==========

    // =========Creating Service for the customer=============

  //  public static By OverviewTab = By.xpath("//a[text()=' Overview']");
    public static By retailElectricity = By.xpath("(//i[@class='icon-minus'])[2]");
    public static By marketType = By.xpath("//select[@id='marketTypeSel']");
    public static By generateNMI = By.xpath("//button[@id='generateNMIButton']");
    public static By selectService = By.xpath("//ul[@class='chosen-choices']");
    public static By search = By.xpath("//li[@class='search-field']");
    public static By moveSearch = By.xpath("//input[@id='proposedDate']");
    public static By moveInDate = By.xpath("//td[@class='active day']");
    public static By cityNames = By.xpath("//*[@id=\"locality\"]");
    public static By postCode = By.xpath("//*[@id=\"postCode\"]");
    public static By selectState1 = By.xpath("//*[@id=\"state\"]");
   public static By moveinSearch = By.xpath("//label[text()='Move-In Date']");
    public static By ServiceSuccMsg=By.xpath("//div[contains(text(),'The Service has been created successfully.')]");

    public void clickOnOverviewTab() {
        WebDriverWaits.ClickOn(OverviewTab);
    }

    public void clickRetailElectricity() {
        WebDriverWaits.ClickOn(retailElectricity);
    }


    public void selectMarketType() {
        WebDriverWaits.selectByVisibleText(marketType, "Off Market");
    }

    public void clickOnGenerateNMI() {
        WebDriverWaits.ClickOn(generateNMI);

    }

    public void selectServicePlan() throws AWTException {

        WebDriverWaits.ClickOn(selectService);
    }

    public void servicePlan() throws AWTException, InterruptedException {
        Thread.sleep(2000);

        WebDriverWaits.ClickOn(search);
        // Actions as= new Actions(driver);
        // as.moveToElement(driver.findElement(By.xpath("//ul[@class='Electricity
        // Template Plan']"))).perform();
        Actions as=new Actions(driver);
        as.moveToElement(driver.findElement(By.xpath("//li[text()='Ausgrid - SME Anytime + Controlled Load 2']"))).click().build().perform();
    }

    public void moveInDate() {
        WebDriverWaits.ClickOn(moveinSearch);
        WebDriverWaits.ClickOn(moveSearch);

    }

    public void selectProposeDate() {
        WebDriverWaits.ClickOn(moveInDate);
    }

    public void enterCityNmae(String CityName) {
        WebDriverWaits.WaitUntilVisibleWE(cityNames);
        WebDriverWaits.SendKeysWithClear(cityNames,  CityName);
    }

    public void enterPostCode(String PostalCode) {
        WebDriverWaits.SendKeysWithClear(postCode, PostalCode);
    }

    public void selectState(String selectState) {

        WebDriverWaits.selectByVisibleText(selectState1,  selectState);
    }

    public void clickOnAddButton() {
        WebDriverWaits.ClickOn(AddButton);
    }

    public void createService(String CityName, String PostalCode, String selectState) throws AWTException, InterruptedException {
         clickOnOverviewTab();
        clickRetailElectricity();
         selectMarketType();
        clickOnGenerateNMI();
        selectServicePlan();
        servicePlan();
        moveInDate();
        selectProposeDate();
        enterCityNmae(CityName);
       enterPostCode(PostalCode);
        selectState(selectState);
        clickOnAddButton();
        Thread.sleep(2000);
        String Expectedmsg="The Service has been created successfully.";
        softAssert.assertEquals(Expectedmsg, ServiceSuccMsg);
    }



}
