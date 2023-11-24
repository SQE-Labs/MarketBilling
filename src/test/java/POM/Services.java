package POM;

import CommonMethods.DateAndTime;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import static BrowsersBase.BrowsersInvoked.driver;
import static CommonMethods.WebDriverWaits.byToWebElement;
import static POM.GroupEdit.softAssert;

public class Services {
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static Select select;
    public static String ServiceIDLater3;
    public static String ServiceIDLater1;
    // Search Field
    public static By searchField = By.xpath("(//*[@id=\"search_input\"])[1]");
    public static By searchIcon = By.xpath("//button[@id='btn_search']");


    // Select the Residential/Business/Commercial customer created in add customer
    public static By twoSearchResults = By.xpath("//*[@class='icon-edit ']");
    public static By selectRecord = By.xpath("(//td[@class='sorting_1']/a)[1]");
    public static By selectBusinessCustomer_Record = By.xpath("(//td[@class='sorting_1']/a)[2]");
    public static By selectBusinessCustomer_Record1 = By.xpath("(//td[@class='sorting_1']/a)[1]"); // Just temporary
    // due to issue
    public static By selectCommercialCustomer_Record = By.xpath("(//td[@class='sorting_1']/a)[1]");
    public static By overviewTab = By.xpath("//*[@class=\"icon-eye-open\"]");

    public static By Overview = By.xpath("//*[@class=\"icon-eye-open\"]");


    // //*[contains(text(),'Overview')]

    // Add Service for Residential/Business/Commercial customer
    public static By retailElectricity_Plus_Subtab = By.xpath("(//*[@class='icon-minus'])[2]");
    public static By market_Type_Field = By.xpath("//*[@id='marketTypeSel']");
    public static By nMI_Field = By.xpath("//button[text()='Generate Virtual NMI']");
    public static By service_Plan_Dropdown = By.xpath("//li[@class='search-field']");
    public static By service_Plan_Elec = By.xpath("//li[text()='Electricity Template Plan']");

    public static By move_In_Date_Datepicker = By.xpath("//*[@id=\"proposedDate\"]");
    public static By SelectCurrentDate = By.xpath("//*[@class=\"active day\"]");
    public static By Select_Use_Structured_Address_Togglebutton = By.xpath("//*[@class=\"switch-label\"]");
    public static By Building_Name_Field = By.xpath("//*[@id=\"buildingName\"]");
    public static By UnitType_Dropdown = By.xpath("//*[@id=\"flatType\"]");
    public static By Street_Number_Suffix_Dropdown = By.xpath("//*[@id=\"houseNBRSuffix\"]");
    public static By suburb_Field = By.xpath("//*[@id=\"locality\"]");
    public static By postal_Code_field = By.xpath("//*[@id=\"postCode\"]");
    public static By stateDropdown = By.xpath("//select[@id='state']");
    public static By addButton = By.xpath("//*[@id=\"submitBttn\"]");

    // Edit Residential/Business/Commercial customer service
    public static By serviceTab = By.xpath("//*[@class=\"icon-power-off\"]");
    public static By Search_FieldOnPage = By.xpath("//*[@class=\"dataTables_filter\"]");
    public static By edit_icon = By.xpath("//*[@class=\"btn btn-primary toolt\"]");
    public static By service_Status_Dropdown = By.xpath("//*[@id=\"serviceStatus\"]");
    public static By Netting_Config_Dropdown = By.xpath("//*[@id=\"nettingConfig\"]");
    public static By Sub_Channel_Aggregation_Dropdown = By.xpath("//*[@id=\"subChannelAggregation\"]");
    public static By saveChanges_Button = By.xpath("//*[@class=\"btn btn-primary iseditable\"]");
    public static By OkButton = By.xpath("//*[contains(text(),'OK')]");
    public static By CustomerSuccessEditMsg = By.xpath("//div[@class='alert alert-success']/center");
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

    //   public static By ServiceTab = By.xpath("//*[@class=\"icon-power-off\"]");
    public static By moveinSearch = By.xpath("//label[text()='Move-In Date']");
    public static By serviceSuccMsg = By.xpath("//div[contains(text(),'The Service has been created successfully.')]");

    public static String M_AddService(String offMarket, String subField, String StateName) throws InterruptedException {
        WebDriverWaits.ClickOn(searchIcon);
        WebDriverWaits.Waituntilvisible(searchField);
        WebDriverWaits.ClickOn(searchField);
        Thread.sleep(2000);
        String ThirdRecID = WebDriverWaits.GetText(selectRecord);
        WebDriverWaits.SendKeys(searchField, ThirdRecID);

        WebDriverWaits.ClickOn(selectRecord);
        //  WebDriverWaits.ClickOn(selectRecord);
        //  Customer.switchToCustomerpage();
        WebDriverWaits.SwitchToNewTab();
        WebDriverWaits.ClickOn(overviewTab);
        WebDriverWaits.ClickOn(retailElectricity_Plus_Subtab);
        WebDriverWaits.Waituntilvisible(market_Type_Field);
        WebDriverWaits.ClickOn(market_Type_Field);
        WebDriverWaits.selectByVisibleText(market_Type_Field, offMarket);
        WebDriverWaits.scrollIntoView(nMI_Field);
        WebDriverWaits.ClickOn(nMI_Field);
//        String ServiceIDLater1 = RandomStrings.RequiredDigits(10);
//        WebDriverWaits.SendKeys(nMI_Field, ServiceIDLater1);
        WebDriverWaits.Waituntilvisible(service_Plan_Dropdown);
        WebDriverWaits.ClickOn(service_Plan_Dropdown);
        Thread.sleep(6000);
        WebDriverWaits.ClickOn(service_Plan_Elec);
        WebDriverWaits.SendKeys(move_In_Date_Datepicker, DateAndTime.DateTimeGenerator("dd/MM/yyyy"));
        WebDriverWaits.scrollIntoView(suburb_Field);
        WebDriverWaits.ClickOn(suburb_Field);
        WebDriverWaits.SendKeys(suburb_Field, subField);
        WebDriverWaits.ClickOn(postal_Code_field);
        String RandomNumber2 = RandomStrings.RequiredDigits(15);
        WebDriverWaits.SendKeys(postal_Code_field, RandomNumber2);
        WebDriverWaits.ClickOn(stateDropdown);
        WebDriverWaits.selectByVisibleText(stateDropdown, StateName);
        WebDriverWaits.ClickOn(addButton);
        Thread.sleep(3000);
        System.out.println(ServiceIDLater1);
        return ServiceIDLater1;
    }

    public static String addService(String offMarket, String StateName, String subField) throws InterruptedException {
        Customer.switchToCustomerpage();
        //   WebDriverWaits.SwitchToNewTab();
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(overviewTab);
        WebDriverWaits.ClickOn(retailElectricity_Plus_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(market_Type_Field);
        WebDriverWaits.selectByVisibleText(market_Type_Field, offMarket);
        WebDriverWaits.scrollIntoView(nMI_Field);
        WebDriverWaits.ClickOn(nMI_Field);
        String ServiceIDLater1 = RandomStrings.RequiredDigits(10);
        WebDriverWaits.SendKeys(nMI_Field, ServiceIDLater1);
        WebDriverWaits.Waituntilvisible(service_Plan_Dropdown);
        WebDriverWaits.ClickOn(service_Plan_Dropdown);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(service_Plan_Elec);
        WebDriverWaits.ClickOn(moveSearch);
        WebDriverWaits.ClickOn(moveInDate);
        //  WebDriverWaits.SendKeys(move_In_Date_Datepicker, DateAndTime.DateTimeGenerator("dd/MM/yyyy"));
        WebDriverWaits.scrollIntoView(suburb_Field);
        WebDriverWaits.ClickOn(suburb_Field);
        WebDriverWaits.SendKeys(suburb_Field, subField);
        WebDriverWaits.ClickOn(postal_Code_field);
        String RandomNumber2 = RandomStrings.RequiredDigits(15);
        WebDriverWaits.SendKeys(postal_Code_field, RandomNumber2);
        WebDriverWaits.ClickOn(stateDropdown);
        WebDriverWaits.selectByVisibleText(stateDropdown, StateName);
        WebDriverWaits.ClickOn(addButton);
        System.out.println(ServiceIDLater1);

        return ServiceIDLater1;
    }


    public static void navigateToEditServices() throws InterruptedException {
        WebDriverWaits.ClickOn(serviceTab);
        // Search service id ("N" + random+"11"); which is created above
        //  WebDriverWaits.ClickOn(Edit_icon);

    }


    public void clickOnOverviewTab() {
        WebDriverWaits.ClickOn(overviewTab);
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
        Actions as = new Actions(driver);
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
        WebDriverWaits.SendKeysWithClear(cityNames, CityName);
    }

    public void enterPostCode(String PostalCode) {
        WebDriverWaits.SendKeysWithClear(postCode, PostalCode);
    }

    public void selectState(String selectState) {

        WebDriverWaits.selectByVisibleText(selectState1, selectState);
    }

    public void clickOnAddButton() {
        WebDriverWaits.ClickOn(addButton);
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
        String Expectedmsg = "The Service has been created successfully.";
        softAssert.assertEquals(Expectedmsg, serviceSuccMsg);
    }
    // Methods to add Residential Service


    // Methods to add Business Service


    public static void editService(String serviceStatus) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWaits.ClickOn(serviceTab);
        WebDriverWaits.ClickOn(edit_icon);
        WebDriverWaits.scrollIntoView(service_Status_Dropdown);
        WebDriverWaits.ClickOn(service_Status_Dropdown);
        WebDriverWaits.selectByVisibleText(service_Status_Dropdown, serviceStatus);
        WebDriverWaits.scrollIntoView(saveChanges_Button);
        WebDriverWaits.ClickOn(saveChanges_Button);
        WebDriverWaits.WaitUntilVisible(OkButton);
        WebDriverWaits.ClickOn(OkButton);
        System.out.println("Successfully edited customer");
        driver.navigate().refresh();

    }


}