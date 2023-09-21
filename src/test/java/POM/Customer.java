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
import static POM.Flow5_AddCustomer.*;
import static POM.Services.SearchField;
import static POM.Services.SearchIcon;
import static POM.GroupEdit.softAssert;

public class Customer {

    public static String CustomerFirstName = "Caerry" + RandomStrings.RequiredCharacters(2);
    public static String CustomersurName = "Carse"
            + RandomStrings.RequiredCharacters(2);
    public static final String SUCCESS_MESG = "Successfully saved customer.";
    public static String RandomName1;
    public static By customerId = By.xpath("//*[@id=\"tbl-customer\"]/tbody/tr[1]/td[1]/a");
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
    public static By customerTab = By.xpath("//span[text()='Customers']");
    public static By customerType = By.xpath("//select[@id='custTypeEl']");
    public static By catagoryType = By.xpath("//select[@id='category']");
    public static By companyType = By.xpath("//input[@id='company']");
    public static By abnType = By.xpath("//input[@id='abn']");
    public static By titleType = By.xpath("//select[@id='sal']");
    public static By firstName = By.xpath("//input[@id='firstName']");
    public static By surName = By.xpath("//input[@id='surname']");
    public static By phoneNumber = By.xpath("//input[@id='contact_phone']");
    public static By contactEmail = By.xpath("//input[@id='contact_email']");
    public static By address1 = By.xpath("//input[@id='hAddress']");
    public static By cityName = By.xpath("//input[@id='hSuburb']");
    public static By countryName = By.xpath("//select[@id='hCountryList']");
    public static By stateName = By.xpath("//select[@id='hState']");
    public static By postalCode = By.xpath("//input[@name='pcode']");
    public static By saveButton = By.xpath("//a[text()=' Save Customer']");
    public static By saveOnlyButton = By.xpath("//button[text()='Save Only']");
    public static By searchIcon = By.xpath("//*[@class='glyphicon glyphicon-search']");
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

        //verify customer creation success message.
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(CustomerSuccessMsg);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(SUCCESS_MESG, ActualMsg);
        //changeCustomerStatus();
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

    public static Customer clickRecentCustomerId(){
        WebDriverWaits.ClickOn(customerId);
        return  new Customer();
    }

    public static void navigateToCustomer() throws InterruptedException {
        clickSearchIcon();
        clickRecentCustomerId();
        WebDriverWaits.SwitchToNewTab();

    }

    public static void clickSearchIcon(){
        WebDriverWaits.ClickOn(searchIcon);
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

    public void clickOnCustomerTab() {
        WebDriverWaits.ClickOn(customerTab);
    }

    public void selectCustomerType() {
        WebDriverWaits.selectByVisibleText(customerType, "Owner");
    }

    public void selectCatagoryType() {
        WebDriverWaits.WaitUntilVisible(catagoryType);
        WebDriverWaits.selectByVisibleText(catagoryType, "Business");
    }

    public void enterAbnNumber(String ABNType) {
        WebDriverWaits.scrollIntoView(abnType);
        WebDriverWaits.SendKeysWithClear(abnType,ABNType);
    }

    public void selectTitleType() {
        WebDriverWaits.WaitUntilVisible(titleType);
        WebDriverWaits.selectByVisibleText(titleType, "Mr.");
    }

    public void enterCompanyType(String CompanyTypeField) {
        WebDriverWaits.scrollIntoView(companyType);
        WebDriverWaits.SendKeysWithClear(companyType, CompanyTypeField);
    }

    public void enterFirstName(String FirstNameField) {
        WebDriverWaits.scrollIntoView(firstName);
        WebDriverWaits.SendKeysWithClear(firstName, FirstNameField);
    }

    public void enterSurName(String SurNameField) {
        WebDriverWaits.SendKeysWithClear(surName, SurNameField);
    }

    public void enterPhoneNumber(String phn) {
        WebDriverWaits.WaitUntilVisible(phoneNumber);
        WebDriverWaits.SendKeysWithClear(phoneNumber, phn);
    }

    public void enterContactEmail(String ContactEmailTypeField) {
        WebDriverWaits.SendKeysWithClear(contactEmail, ContactEmailTypeField);
    }

    public void enterAddress1(String Address1Type) {
        WebDriverWaits.SendKeysWithClear(address1, Address1Type );
    }

    public void enterCityName(String CityNameField) {
        WebDriverWaits.SendKeysWithClear(cityName, CityNameField);
    }

    public void enterCountryName(String CountryNameField) {
        WebDriverWaits.selectByVisibleText(countryName, CountryNameField);
    }

    public void enterStateName(String StateNameField) {
        WebDriverWaits.selectByVisibleText(stateName,  StateNameField);
    }

    public void enterPostalCode(String PostalCodeField) {
        WebDriverWaits.SendKeysWithClear(postalCode, PostalCodeField);
    }

    public void clickOnSaveCustomerButton() {
        WebDriverWaits.scrollIntoView(saveButton);
        WebDriverWaits.ClickOn(saveButton);
    }

    public void clickOnSaveOnlyButton() {
        WebDriverWaits.ClickOn(saveOnlyButton);
    }

    public void createCustomer(String ABNType, String phn, String Address1Type, String CityNameField, String CountryNameField, String StateNameField, String PostalCodeField){

        clickOnCustomerTab();
        selectCustomerType();
        selectCatagoryType();
        enterCompanyType(CustomerFirstName);
        enterAbnNumber(ABNType );
        selectTitleType();
        enterFirstName(CustomerFirstName);
        enterSurName(CustomersurName);
        enterPhoneNumber( phn);
        enterContactEmail(CustomerFirstName + "@yopmail.com");
        enterAddress1( Address1Type);
        enterCityName( CityNameField);
        enterCountryName(CountryNameField);
        enterStateName(StateNameField );
        enterPostalCode( PostalCodeField);
        clickOnSaveCustomerButton();
        clickOnSaveOnlyButton();
        String Expectedmsg="Successfully saved customer.";
        softAssert.assertAll();
    }
    public static void FirstResidentialCustomer() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.navigate().refresh();
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(CustomerIcontab);
        WebDriverWaits.ClickOn(CustomerTypedropdown);
        WebElement TenantOption = WebDriverWaits.WaitUntilVisibleWE(CustomerTypedropdown);
//					driver.findElement(CustomerTypedropdown);
        Select select = new Select(TenantOption);
        select.selectByVisibleText("Tenant");
        WebDriverWaits.ClickOn(Categorydropdown);
        WebElement ResidentialOption = WebDriverWaits.WaitUntilVisibleWE(Categorydropdown);
        select = new Select(ResidentialOption);
        select.selectByVisibleText("Residential");
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
        //WebDriverWaits.SendKeys(GivenNameField, "Babar");

        WebDriverWaits.ClickOn(SurnameField);
        RandomName2 = RandomStrings.RequiredCharacters(6);
        Thread.sleep(2000);
        WebDriverWaits.SendKeys(SurnameField, RandomName2);
        //WebDriverWaits.SendKeys(SurnameField, "Asam");

        WebDriverWaits.ClickOn(PhoneBHField);
        String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
        WebDriverWaits.SendKeys(PhoneBHField, RandomNumber);

        Thread.sleep(2000);

        jse.executeScript("window.scrollBy(0,200)", "");

        Thread.sleep(1000);

        WebDriverWaits.ClickOn(EmailField);
        WebDriverWaits.SendKeys(EmailField, "test_Resdnt2@yopmail.com");

        jse.executeScript("window.scrollBy(0,400)", "");

        Thread.sleep(1000);

        WebDriverWaits.ClickOn(AccountManagementSection);

        Thread.sleep(1000);

        jse.executeScript("window.scrollBy(0,300)", "");

        WebDriverWaits.ClickOn(ContractStartDate_Datepicker);
        WebDriverWaits.ClickOn(CurrentDate);

        WebDriverWaits.ClickOn(ContractTerm_Field);
        WebDriverWaits.SendKeys(ContractTerm_Field, "10");


        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWaits.ClickOn(SaveCustomerButton);
        WebDriverWaits.ClickOn(SaveOnlyButton);
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(CustomerSuccessMsg);
        String ExpectedMsg1 = "Successfully saved customer.";
        softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully saved customer");

        Thread.sleep(4000);

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWaits.ClickOn(ChangeStatusButton);
        WebDriverWaits.ClickOn(NewStatusDropdown);
        WebElement ActiveOption = WebDriverWaits.WaitUntilVisibleWE(NewStatusDropdown);
        select = new Select(ActiveOption);
        select.selectByVisibleText("Active");

        WebDriverWaits.ClickOn(ReasonforchangeField);
        WebDriverWaits.SendKeys(ReasonforchangeField, "Only For testing Residential Type of Category");

        WebDriverWaits.ClickOn(Save_button_on_popup);

        String ExpectedMsg2 = "Status change successful.";
        softAssert.assertEquals(ExpectedMsg2, "Status change successful.");
        System.out.println("Status change successful.");

        Thread.sleep(4000);

        WebDriverWaits.ClickOn(Closepopup_icon);
        driver.navigate().to(DataInterface.AdminURL);
        Thread.sleep(8000);
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchIcon);
        Thread.sleep(4000);
        CustomerID01R = WebDriverWaits.GetText(Flow6_7AddingServiceAndMeter.X_AddService.selectBusinessCustomer_Record1);

    }

    public static void SecondBusinessCustomer() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        WebDriverWaits.ClickOn(CustomerIcontab);

        WebDriverWaits.ClickOn(CustomerTypedropdown);
        WebElement OtherOption = WebDriverWaits.WaitUntilVisibleWE(CustomerTypedropdown);
        Select select = new Select(OtherOption);
        select.selectByVisibleText("Others");

//				softAssert.assertTrue(TenantText.equals("Tenant"));
        softAssert.assertAll();

        WebDriverWaits.ClickOn(Categorydropdown);
        WebElement BusinessOption = WebDriverWaits.WaitUntilVisibleWE(Categorydropdown);
        select = new Select(BusinessOption);
        select.selectByVisibleText("Business");

        WebDriverWaits.ClickOn(Address1field);
        WebDriverWaits.SendKeys(Address1field, "Madirma B-Town");

        WebDriverWaits.ClickOn(Cityfield);
        WebDriverWaits.SendKeys(Cityfield, "Saint Augustine");

        WebDriverWaits.ClickOn(Statedropdown);
        WebElement TASOption = WebDriverWaits.WaitUntilVisibleWE(Statedropdown);
        select = new Select(TASOption);
        select.selectByVisibleText("TAS");

        WebDriverWaits.ClickOn(PostalCodefield);
        WebDriverWaits.SendKeys(PostalCodefield, "6541");

        jse.executeScript("window.scrollBy(0,400)", "");

        WebDriverWaits.ClickOn(FirstCustomer.CompanyNameField);
        WebDriverWaits.SendKeys(FirstCustomer.CompanyNameField, "FranklinCovey");

        WebDriverWaits.ClickOn(ABNField);
        WebDriverWaits.SendKeys(ABNField, "32165485216");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,650)", "");

        WebDriverWaits.ClickOn(TitleDropdown);
        WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(TitleDropdown);
        select = new Select(DrOption);
        select.selectByVisibleText("Dr.");

        WebDriverWaits.ClickOn(GivenNameField);
        RandomName3 = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(GivenNameField, RandomName3);
        //WebDriverWaits.SendKeys(GivenNameField, "Moien");

        WebDriverWaits.ClickOn(SurnameField);
        RandomName4 = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(SurnameField, RandomName4);
        //WebDriverWaits.SendKeys(SurnameField, "Alli");

        WebDriverWaits.ClickOn(PhoneBHField);
        String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
        WebDriverWaits.SendKeys(PhoneBHField, RandomNumber);

        jse.executeScript("window.scrollBy(0,300)", "");

        WebDriverWaits.ClickOn(EmailField);
        WebDriverWaits.SendKeys(EmailField, "testBusiness@yopmail.com");

        jse.executeScript("window.scrollBy(0,400)", "");

        WebDriverWaits.ClickOn(AccountManagementSection);

        jse.executeScript("window.scrollBy(0,300)", "");

        WebDriverWaits.ClickOn(ContractStartDate_Datepicker);
        WebDriverWaits.ClickOn(CurrentDate);

        WebDriverWaits.ClickOn(ContractTerm_Field);
        WebDriverWaits.SendKeys(ContractTerm_Field, "10");

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWaits.ClickOn(SaveCustomerButton);
        WebDriverWaits.ClickOn(SaveOnlyButton);

        String ExpectedMsg2 = "Successfully saved customer";
        softAssert.assertEquals(ExpectedMsg2, "Successfully saved customer");
        System.out.println("Successfully saved customer");

        Thread.sleep(4000);

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWaits.ClickOn(ChangeStatusButton);

        // popup assertion

        WebDriverWaits.ClickOn(NewStatusDropdown);
        Thread.sleep(3000);
        WebElement ActiveOption = WebDriverWaits.WaitUntilVisibleWE(NewStatusDropdown);
        select = new Select(ActiveOption);
        select.selectByVisibleText("Active");

        WebDriverWaits.ClickOn(ReasonforchangeField);
        WebDriverWaits.SendKeys(ReasonforchangeField, "Only For testing Residential Type of Category");

        WebDriverWaits.ClickOn(Save_button_on_popup);

        String ExpectedMsg4 = "Status change successful.";
        softAssert.assertEquals(ExpectedMsg4, "SStatus change successful.");
        System.out.println("Status change successful.");

        Thread.sleep(4000);

        WebDriverWaits.ClickOn(Closepopup_icon);
        driver.navigate().to(DataInterface.AdminURL);
        Thread.sleep(8000);
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchIcon);
        Thread.sleep(3000);
        CustomerID02B = WebDriverWaits.GetText(Flow6_7AddingServiceAndMeter.X_AddService.selectBusinessCustomer_Record1);

    }
    public static void ThirdCommercialCustomer() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        WebDriverWaits.ClickOn(CustomerIcontab);

        WebDriverWaits.ClickOn(CustomerTypedropdown);
        WebElement OtherOption = WebDriverWaits.WaitUntilVisibleWE(CustomerTypedropdown);
        Select select = new Select(OtherOption);
        select.selectByVisibleText("Others");

//						softAssert.assertTrue(TenantText.equals("Tenant"));
        softAssert.assertAll();

        WebDriverWaits.ClickOn(Categorydropdown);
        WebElement CommercialOption = WebDriverWaits.WaitUntilVisibleWE(Categorydropdown);
        select = new Select(CommercialOption);
        select.selectByVisibleText("Commercial");

        WebDriverWaits.ClickOn(Address1field);
        WebDriverWaits.SendKeys(Address1field, "Madirma B-Town");

        WebDriverWaits.ClickOn(Cityfield);
        WebDriverWaits.SendKeys(Cityfield, "Saint Augustine");

        WebDriverWaits.ClickOn(Statedropdown);
        WebElement TASOption = WebDriverWaits.WaitUntilVisibleWE(Statedropdown);
        select = new Select(TASOption);
        select.selectByVisibleText("QLD");

        WebDriverWaits.ClickOn(PostalCodefield);
        WebDriverWaits.SendKeys(PostalCodefield, "3546");

        jse.executeScript("window.scrollBy(0,400)", "");

        WebDriverWaits.ClickOn(FirstCustomer.CompanyNameField);
        WebDriverWaits.SendKeys(FirstCustomer.CompanyNameField, "Testing Company SQE");

        WebDriverWaits.ClickOn(ABNField);
        WebDriverWaits.SendKeys(ABNField, "95623111254");
        Thread.sleep(2000);
        jse.executeScript("window.scrollBy(0,650)", "");

        WebDriverWaits.ClickOn(TitleDropdown);
        WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(TitleDropdown);
        select = new Select(DrOption);
        select.selectByVisibleText("Dr.");

        WebDriverWaits.ClickOn(GivenNameField);
        RandomName5 = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(GivenNameField, RandomName5);
        //	WebDriverWaits.SendKeys(GivenNameField, "Siyon");

        WebDriverWaits.ClickOn(SurnameField);
        RandomName6 = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(SurnameField, RandomName6);
        //WebDriverWaits.SendKeys(SurnameField, "mandis");

        WebDriverWaits.ClickOn(PhoneBHField);
        String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
        WebDriverWaits.SendKeys(PhoneBHField, RandomNumber);

        jse.executeScript("window.scrollBy(0,300)", "");

        WebDriverWaits.ClickOn(EmailField);
        WebDriverWaits.SendKeys(EmailField, "testcommercial@yopmail.com");

        jse.executeScript("window.scrollBy(0,400)", "");

        // WebDriverWaits.ClickOn(AccountManagementSection);

        jse.executeScript("window.scrollBy(0,400)", "");

        Thread.sleep(1000);

        WebDriverWaits.ClickOn(ContractStartDate_Datepicker);
        WebDriverWaits.ClickOn(CurrentDate);

        WebDriverWaits.ClickOn(ContractTerm_Field);
        WebDriverWaits.SendKeys(ContractTerm_Field, "10");

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWaits.ClickOn(SaveCustomerButton);
        WebDriverWaits.ClickOn(SaveOnlyButton);

        String ExpectedMsg5 = "Successfully saved customer";
        softAssert.assertEquals(ExpectedMsg5, "Successfully saved customer");
        System.out.println("Successfully saved customer");
        Thread.sleep(4000);

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        WebDriverWaits.ClickOn(ChangeStatusButton);


        WebDriverWaits.ClickOn(NewStatusDropdown);
        WebElement ActiveOption = WebDriverWaits.WaitUntilVisibleWE(NewStatusDropdown);
        select = new Select(ActiveOption);
        select.selectByVisibleText("Active");

        WebDriverWaits.ClickOn(ReasonforchangeField);
        WebDriverWaits.SendKeys(ReasonforchangeField, "Only For testing Residential Type of Category");

        WebDriverWaits.ClickOn(Save_button_on_popup);

        String ExpectedMsg6 = "Status change successful.";
        softAssert.assertEquals(ExpectedMsg6, "SStatus change successful.");
        System.out.println("Status change successful.");

        Thread.sleep(4000);

        WebDriverWaits.ClickOn(Closepopup_icon);

        driver.navigate().to(DataInterface.AdminURL);
        Thread.sleep(8000);
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchIcon);
        Thread.sleep(3000);
        CustomerID03C = WebDriverWaits.GetText(Flow6_7AddingServiceAndMeter.X_AddService.selectBusinessCustomer_Record1);

    }
}