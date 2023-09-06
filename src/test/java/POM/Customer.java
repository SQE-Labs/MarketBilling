package POM;

import BrowsersBase.DataInterface;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static BrowsersBase.BrowsersInvoked.driver;
import static POM.Flow5_AddCustomer.CustomerID01R;
import static POM.Flow6_7AddingServiceAndMeter.X_AddService.SearchField;
import static POM.Flow6_7AddingServiceAndMeter.X_AddService.SearchIcon;
import static POM.GroupEdit.softAssert;

public class Customer {

   public static String CustomerFirstName = "Aman" + RandomStrings.RequiredCharacters(2);
    public static String CustomersurName = "sam" + RandomStrings.RequiredCharacters(2);
    public static final String SUCCESS_MESG = "Successfully saved customer.";
    public static String RandomName1;
    public static String RandomName2;
    public static Select select;
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static By CustomerIcontab = By.xpath("//span[text()='Customers']");
    public static By CustomerTypedropdown = By.xpath("//select[@id='custTypeEl']");
    public static By Categorydropdown = By.xpath("//*[@id='category']");
    public static By Address1field = By.xpath("//*[@id='hAddress']");
    public static By Cityfield = By.xpath("//*[@id='hSuburb']");
    public static By Statedropdown = By.xpath("//*[@id='hState']");
    public static By PostalCodefield = By.xpath("//*[@name='pcode']");

    // Company/Business Details
    public static By CompanyNameField = By.xpath("//*[@id=\"company\"]");
    public static By ABNField = By.xpath("//*[@id=\"abn\"]");
    // Contact Details
    public static By TitleDropdown = By.xpath("//*[@name='sal']");
    public static By GivenNameField = By.xpath("//*[@name='firstName']");
    public static By SurnameField = By.xpath("//*[@name='surname']");
    public static By PhoneBHField = By.xpath("//*[@name='contact_phone']");
    public static By EmailField = By.xpath("//*[@name='contact_email']");
    public static By AccountManagementSection = By.xpath("//*[@id='accountManagementPlus']");
    public static By ContractStartDate_Datepicker = By.id("contract_start_date");
    public static By PaymentTermMethod_Dropdown = By.xpath("//*[@id='payment_term']");
    public static By PaymentTermMethod_DropdownOpnC2 = By.xpath("//*[@id='payment_term']/option[2]");
    public static By PaymentTermMethod_DropdownOpn_B3 = By.xpath("//*[@id='payment_term']/option[3]");
    public static By PaymentTermMethod_DropdownOpnE1 = By.xpath("//*[@id='payment_term']/option[1]");
    public static By CurrentDate = By.xpath("//*[@class=\"active day\"]");
    public static By ContractTerm_Field = By.xpath("//*[@id='contract_term']");
    // Scroll to last of the page
    public static By SaveCustomerButton = By.xpath("//*[@value='Save Customer']");
    // public static By SaveandAddProvisioning= By.xpath("//*[contains(text(),'Save
    // and Add Provisioning')])[2]");

    public static By SaveOnlyButton = By.xpath("//button[contains(text(),'Save Only')]");
    public static By CustomerSuccessMsg = By.xpath("//div[@class='alert alert-success']/center");

    // Scroll the page to last again
    // Change Status button appears
    public static By ChangeStatusButton = By.xpath("//*[@class=\"btn btn-danger\"]");
    public static By NewStatusDropdown = By.xpath("//select[@id='acctStatus']");
    public static By ReasonforchangeField = By.xpath("//*[@id='statusReason']");
    public static By Save_button_on_popup = By.xpath("//*[@id='save']");
    public static By Closepopup_icon = By.xpath("//*[@class='close']");
    public static By Company_Name_Field = By.xpath("//*[@id=\"company\"]");


    public static By settingsTab = By.xpath("//a[text()=' Settings']");

    public static By communications = By.xpath("(//*[contains(text(),'Communications')])[1]");

    //=======NEW UPDATED CODES=========
    // ========Creating Customer=======
    public static By CustomerTab = By.xpath("//span[text()='Customers']");
    public static By CustomerType = By.xpath("//select[@id='custTypeEl']");
    public static By CatagoryType = By.xpath("//select[@id='category']");
    public static By CompanyType = By.xpath("//input[@id='company']");
    public static By AbnType = By.xpath("//input[@id='abn']");
    public static By TitleType = By.xpath("//select[@id='sal']");
    public static By FirstName = By.xpath("//input[@id='firstName']");
    public static By SurName = By.xpath("//input[@id='surname']");
    public static By PhoneNumber = By.xpath("//input[@id='contact_phone']");
    public static By ContactEmail = By.xpath("//input[@id='contact_email']");
    public static By Address1 = By.xpath("//input[@id='hAddress']");
    public static By CityName = By.xpath("//input[@id='hSuburb']");
    public static By CountryName = By.xpath("//select[@id='hCountryList']");
    public static By StateName = By.xpath("//select[@id='hState']");
    public static By PostalCode = By.xpath("//input[@name='pcode']");
    public static By SaveButton = By.xpath("//a[text()=' Save Customer']");
  //  public static By SaveOnlyButton = By.xpath("//button[text()='Save Only']");
    public static By ActualMsg1 = By.xpath("//center[text()='Successfully saved customer.']");
    private static String CustomerID01R;


    public static Communications clickCommunications(){
        WebDriverWaits.ClickOn(communications);
        return new Communications();
    }

    public static String createCustomer(String type, String category, String email) throws InterruptedException {
        driver.get(DataInterface.URL);
        Thread.sleep(3000);
        //Account Type
        WebDriverWaits.ClickOn(CustomerIcontab);
        WebDriverWaits.ClickOn(CustomerTypedropdown);
        WebElement TenantOption = WebDriverWaits.WaitUntilVisibleWE(CustomerTypedropdown);
        Select select = new Select(TenantOption);
        select.selectByVisibleText(type);
        WebDriverWaits.ClickOn(Categorydropdown);
        WebElement ResidentialOption = WebDriverWaits.WaitUntilVisibleWE(Categorydropdown);
        select = new Select(ResidentialOption);
        select.selectByVisibleText(category);
        //Contact Details
        if (category.equals("Business" )|| category.equals( "Commercial")) {
            addBusinessDetails();
        }
        addContactDetails(email);
        addAccountManagement(category);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(SaveCustomerButton);
        WebDriverWaits.ClickOn(SaveOnlyButton);
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(CustomerSuccessMsg);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(SUCCESS_MESG, ActualMsg);
        changeCustomerStatus();
        String customerId=searchRecentCustomer();
        System.out.println("CustomerId generated ------"+customerId);
        return customerId ;

    }

    public static void addContactDetails(String email) throws InterruptedException {
        WebDriverWaits.ClickOn(Address1field);
        WebDriverWaits.SendKeys(Address1field, "Madirma R-Town");
        WebDriverWaits.ClickOn(Cityfield);
        WebDriverWaits.SendKeys(Cityfield, "Mills NY");
        WebDriverWaits.ClickOn(Statedropdown);
        WebElement WAOption = WebDriverWaits.WaitUntilVisibleWE(Statedropdown);
        select = new Select(WAOption);
        select.selectByVisibleText("WA");
        WebDriverWaits.ClickOn(PostalCodefield);
        WebDriverWaits.SendKeys(PostalCodefield, "1265");
        jse.executeScript("window.scrollBy(0,500)", "");
        WebDriverWaits.ClickOn(TitleDropdown);
        WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(TitleDropdown);
        select = new Select(DrOption);
        select.selectByVisibleText("Dr.");
        WebDriverWaits.ClickOn(GivenNameField);
        RandomName1 = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(GivenNameField, RandomName1);
        WebDriverWaits.ClickOn(SurnameField);
        RandomName2 = RandomStrings.RequiredCharacters(6);
        Thread.sleep(2000);
        WebDriverWaits.SendKeys(SurnameField, RandomName2);
        jse.executeScript("window.scrollBy(0,200)", "");
        WebDriverWaits.ClickOn(PhoneBHField);
        String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
        WebDriverWaits.SendKeys(PhoneBHField, RandomNumber);
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,200)", "");
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(EmailField);
        WebDriverWaits.SendKeys(EmailField, email);
        jse.executeScript("window.scrollBy(0,400)", "");
        Thread.sleep(1000);
    }

    public static void addBusinessDetails() throws InterruptedException {
        WebDriverWaits.ClickOn(Flow5_AddCustomer.FirstCustomer.CompanyNameField);
        WebDriverWaits.SendKeys(Flow5_AddCustomer.FirstCustomer.CompanyNameField, "FranklinCovey");
        jse.executeScript("window.scrollBy(0,400)", "");
        WebDriverWaits.ClickOn(ABNField);
        WebDriverWaits.SendKeys(ABNField, "32165485216");
        Thread.sleep(2000);
    }

    public static void addAccountManagement(String category) throws InterruptedException {
        WebDriverWaits.scrollIntoView(AccountManagementSection);
        if(category!="Commercial")
        WebDriverWaits.ClickOn(AccountManagementSection);
        WebDriverWaits.scrollIntoView(ContractStartDate_Datepicker);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(ContractStartDate_Datepicker);
        WebDriverWaits.ClickOn(CurrentDate);
        WebDriverWaits.ClickOn(ContractTerm_Field);
        WebDriverWaits.SendKeys(ContractTerm_Field, "10");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void changeCustomerStatus() throws InterruptedException {
        Thread.sleep(4000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(ChangeStatusButton);
        WebDriverWaits.ClickOn(NewStatusDropdown);
        Thread.sleep(4000);
        WebElement ActiveOption = WebDriverWaits.WaitUntilVisibleWE(NewStatusDropdown);
        select = new Select(ActiveOption);
        select.selectByVisibleText("Active");
        WebDriverWaits.ClickOn(ReasonforchangeField);
        WebDriverWaits.SendKeys(ReasonforchangeField, "Only For testing Residential Type of Category");
        WebDriverWaits.ClickOn(Save_button_on_popup);
        System.out.println("Status change successful.");
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(Closepopup_icon);
    }
    public static String searchRecentCustomer() throws InterruptedException {
        driver.get(DataInterface.AdminURL);
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(4000);
        return WebDriverWaits.GetText(Flow6_7AddingServiceAndMeter.X_AddService.selectBusinessCustomer_Record1);
    }
    public static String searchAndNavigateToRecentCustomer() throws InterruptedException {
        driver.get(DataInterface.URL);
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(4000);
        String customerId=WebDriverWaits.GetText(Flow6_7AddingServiceAndMeter.X_AddService.selectBusinessCustomer_Record1);
        WebDriverWaits.SendKeys(SearchField,customerId);
        WebDriverWaits.ClickOn(SearchIcon);
        return  customerId;
    }
    public static void searchCustomer(String CustomerID01R) throws InterruptedException {

        LandingPage.navigateToHomePage();
        WebDriverWaits.ClickOn(SearchIcon);
        WebDriverWaits.ClickOn(SearchField);
        WebDriverWaits.SendKeys(SearchField,CustomerID01R);
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(2000);
    }
    public static Settings navigateTo_CustomerSettings(String customerID) throws InterruptedException {
        LandingPage.navigateToHomePage();
        WebDriverWaits.ClickOn(SearchIcon);
        WebDriverWaits.ClickOn(SearchField);
        WebDriverWaits.SendKeys(SearchField, customerID);
        WebDriverWaits.ClickOn(SearchIcon);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(settingsTab);
        return new Settings();
    }

    //========NEW UPDATED CODES============

    public void ClickOnCustomerTab() {
        WebDriverWaits.ClickOn(CustomerTab);
    }

    public void SelectCustomerType() {
        WebDriverWaits.selectByVisibleText(CustomerType, "Owner");
    }

    public void SelectCatagoryType() {
        WebDriverWaits.WaitUntilVisible(CatagoryType);
        WebDriverWaits.selectByVisibleText(CatagoryType, "Business");
    }

    public void EnterAbnNumber(String ABNType) {
        WebDriverWaits.scrollIntoView(AbnType);
        WebDriverWaits.SendKeysWithClear(AbnType,ABNType);
    }

    public void SelectTitleType() {
        WebDriverWaits.WaitUntilVisible(TitleType);
        WebDriverWaits.selectByVisibleText(TitleType, "Mr.");
    }

    public void EnterCompanyType(String CompanyTypeField) {
        WebDriverWaits.scrollIntoView(CompanyType);
        WebDriverWaits.SendKeysWithClear(CompanyType, CompanyTypeField);
    }

    public void EnterFirstName(String FirstNameField) {
        WebDriverWaits.scrollIntoView(FirstName);
        WebDriverWaits.SendKeysWithClear(FirstName, FirstNameField);
    }

    public void EnterSurName(String SurNameField) {
        WebDriverWaits.SendKeysWithClear(SurName, SurNameField);
    }

    public void EnterPhoneNumber(String phn) {
        WebDriverWaits.WaitUntilVisible(PhoneNumber);
        WebDriverWaits.SendKeysWithClear(PhoneNumber, phn);
    }

    public void EnterContactEmail(String ContactEmailTypeField) {
        WebDriverWaits.SendKeysWithClear(ContactEmail, ContactEmailTypeField);
    }

    public void EnterAddress1(String Address1Type) {
        WebDriverWaits.SendKeysWithClear(Address1, Address1Type );
    }

    public void EnterCityName(String CityNameField) {
        WebDriverWaits.SendKeysWithClear(CityName, CityNameField);
    }

    public void EnterCountryName(String CountryNameField) {
        WebDriverWaits.selectByVisibleText(CountryName, CountryNameField);
    }

    public void EnterStateName(String StateNameField) {
        WebDriverWaits.selectByVisibleText(StateName,  StateNameField);
    }

    public void EnterPostalCode(String PostalCodeField) {
        WebDriverWaits.SendKeysWithClear(PostalCode, PostalCodeField);
    }

    public void ClickOnSaveCustomerButton() {
        WebDriverWaits.scrollIntoView(SaveButton);
        WebDriverWaits.ClickOn(SaveButton);
    }

    public void ClickOnSaveOnlyButton() {
        WebDriverWaits.ClickOn(SaveOnlyButton);
    }



    public void CreateCustomer(String ABNType, String phn, String Address1Type, String CityNameField, String CountryNameField, String StateNameField, String PostalCodeField){

        ClickOnCustomerTab();
        SelectCustomerType();
        SelectCatagoryType();
        EnterCompanyType(CustomerFirstName);
        EnterAbnNumber(ABNType );
        SelectTitleType();
        EnterFirstName(CustomerFirstName);
        EnterSurName(CustomersurName);
        EnterPhoneNumber( phn);
        EnterContactEmail(CustomerFirstName + "@yopmail.com");
        EnterAddress1( Address1Type);
        EnterCityName( CityNameField);
        EnterCountryName(CountryNameField);
        EnterStateName(StateNameField );
        EnterPostalCode( PostalCodeField);
        ClickOnSaveCustomerButton();
        ClickOnSaveOnlyButton();
        String Expectedmsg="Successfully saved customer.";
        softAssert.assertEquals(Expectedmsg, ActualMsg1);
    }
}
