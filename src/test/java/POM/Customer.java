package POM;


import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static BrowsersBase.BrowsersInvoked.driver;
import static POM.Invoice.category;
import static POM.Services.*;
import static POM.Services.selectBusinessCustomer_Record1;
import static POM.Templates.softAssert;

public class Customer {

    public static String CustomerFirstName = "Caerry" + RandomStrings.RequiredCharacters(2);


    public static final String SUCCESS_MESG = "Successfully saved customer.";
 //   public static String CustomerFirstName = "Caerry" + RandomStrings.RequiredCharacters(2);
    public static String RandomName1;
    public static By customerId = By.xpath("//*[@id=\"tbl-customer\"]/tbody/tr[1]/td[1]/a");
    public static String RandomName2;

    public static Select select;
    public static String CustomerID01R;
    public static String CustomerID02B;
    public static String CustomerID03C;

    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static By customerIcontab = By.xpath("//span[text()='Customers']");
    public static By customerTypedropdown = By.xpath("//select[@id='custTypeEl']");
    public static By categorydropdown = By.xpath("//*[@id='category']");
    public static By address1field = By.xpath("//*[@id='hAddress']");
    public static By cityfield = By.xpath("//*[@id='hSuburb']");
    public static By statedropdown = By.xpath("//*[@id='hState']");
    public static By postalCodefield = By.xpath("//*[@name='pcode']");

    // Company/Business Details
    public static By companyNameField = By.xpath("//*[@id=\"company\"]");
    public static By abnField = By.xpath("//*[@id=\"abn\"]");
    // Contact Details
    public static By titleDropdown = By.xpath("//*[@name='sal']");
    public static By givenNameField = By.xpath("//*[@name='firstName']");
    public static By surnameField = By.xpath("//*[@name='surname']");
    public static By phoneBHField = By.xpath("//*[@name='contact_phone']");
    public static By emailField = By.xpath("//*[@name='contact_email']");
    public static By accountManagementSection = By.xpath("//*[@id='accountManagementPlus']");
    public static By contractStartDate_Datepicker = By.xpath("//input[@id='contract_start_date']");
    public static By PaymentTermMethod_Dropdown = By.xpath("//*[@id='payment_term']");
    public static By PaymentTermMethod_DropdownOpnC2 = By.xpath("//*[@id='payment_term']/option[2]");
    public static By PaymentTermMethod_DropdownOpn_B3 = By.xpath("//*[@id='payment_term']/option[3]");
    public static By PaymentTermMethod_DropdownOpnE1 = By.xpath("//*[@id='payment_term']/option[1]");
    public static By currentDate = By.xpath("//*[@class=\"active day\"]");
    public static By contractTerm_Field = By.xpath("//*[@id='contract_term']");
    // Scroll to last of the page
    public static By saveCustomerButton = By.xpath("//*[@value='Save Customer']");
    // public static By SaveandAddProvisioning= By.xpath("//*[contains(text(),'Save
    // and Add Provisioning')])[2]");

    public static By saveOnlyButton = By.xpath("//button[contains(text(),'Save Only')]");
    public static By customerSuccessMsg = By.xpath("//div[@class='alert alert-success']/center");

    // Scroll the page to last again
    // Change Status button appears
    public static By changeStatusButton = By.xpath("//*[@class=\"btn btn-danger\"]");
    public static By newStatusDropdown = By.xpath("//select[@id='acctStatus']");
    public static By reasonforchangeField = By.xpath("//*[@id='statusReason']");
    public static By save_button_on_popup = By.xpath("//*[@id='save']");
    public static By closepopup_icon = By.xpath("//*[@class='close']");
    public static By Company_Name_Field = By.xpath("//*[@id=\"company\"]");

    public static By comm = By.xpath("//option[text()='Commercial']");
    public static By settingsTab = By.xpath("//a[text()=' Settings']");

    public static By communications = By.xpath("(//*[contains(text(),'Communications')])[1]");

    //=======NEW UPDATED CODES=========
    // ========Creating Customer=======

 //   public static By SaveOnlyButton = By.xpath("//button[text()='Save Only']");
    public static By searchIcon = By.xpath("//*[@class='glyphicon glyphicon-search']");
    public static By ActualMsg1 = By.xpath("//center[text()='Successfully saved customer.']");
 //   private static String CustomerID01R;


    public static Communications clickCommunications() {
        WebDriverWaits.ClickOn(communications);
        return new Communications();
    }

    public static String createCustomer(String type, String category,String contactTermField, String abnField,String companyName,String addressField,String cityField,String stateField,String postalField,String titledropDown,String email) throws InterruptedException {
        //driver.get(DataInterface.URL);
        Thread.sleep(3000);
        //Account Type
        WebDriverWaits.ClickOn(customerIcontab);
        WebDriverWaits.ClickOn(customerTypedropdown);
        WebDriverWaits.selectByVisibleText(customerTypedropdown,type);
        WebDriverWaits.ClickOn(categorydropdown);
        WebDriverWaits.selectByVisibleText(categorydropdown,category);
        //Contact Details
        if (category.equals("Business") || category.equals("Commercial")) {
            addBusinessDetails(abnField,companyName);
        }
        addContactDetails(addressField,cityField,stateField,postalField,titledropDown,email);
        addAccountManagement(contactTermField,category);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(saveCustomerButton);
        WebDriverWaits.ClickOn(saveOnlyButton);

        //verify customer creation success message.
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(customerSuccessMsg);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(SUCCESS_MESG, ActualMsg);
        //changeCustomerStatus();
        String customerId = searchRecentCustomer();
        System.out.println("CustomerId generated ------" + customerId);
        return customerId;

    }

    public static void addContactDetails(String addressTextField,String cityTextField,String stateTextField,String postalTextField,String titledropDown,String email) throws InterruptedException {
        WebDriverWaits.ClickOn(address1field);
        WebDriverWaits.SendKeys(address1field, addressTextField );
        WebDriverWaits.ClickOn(cityfield);
        WebDriverWaits.SendKeys(cityfield,  cityTextField);
        WebDriverWaits.ClickOn(statedropdown);
        WebDriverWaits.selectByVisibleText(statedropdown, stateTextField);
        WebDriverWaits.ClickOn(postalCodefield);
        WebDriverWaits.SendKeys(postalCodefield,  postalTextField);
      WebDriverWaits.scrollIntoView(titleDropdown);
        WebDriverWaits.ClickOn(titleDropdown);
        WebDriverWaits.selectByVisibleText(titleDropdown, titledropDown);
        WebDriverWaits.ClickOn(givenNameField);
        RandomName1 = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(givenNameField, RandomName1);
        WebDriverWaits.ClickOn(surnameField);
        RandomName2 = RandomStrings.RequiredCharacters(6);
        Thread.sleep(2000);
        WebDriverWaits.SendKeys(surnameField, RandomName2);
         WebDriverWaits.scrollIntoView(phoneBHField);
        WebDriverWaits.ClickOn(phoneBHField);
        String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
        WebDriverWaits.SendKeys(phoneBHField, RandomNumber);
        WebDriverWaits.scrollIntoView(emailField);
        WebDriverWaits.ClickOn(emailField);
        WebDriverWaits.SendKeys(emailField, email);
        WebDriverWaits.scrollPageEnd();
    }

    public static void addBusinessDetails(String companyName,String ABNField) throws InterruptedException {
        WebDriverWaits.ClickOn(Customer.companyNameField);
        WebDriverWaits.SendKeys(Customer.companyNameField,companyName  );
        WebDriverWaits.scrollIntoView(abnField);
        WebDriverWaits.ClickOn(abnField);
        WebDriverWaits.SendKeys(abnField,  ABNField);
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

    public static void addAccountManagement(String category, String contactTermField ) throws InterruptedException {
        WebDriverWaits.scrollIntoView(accountManagementSection);
        if(category!="Commercial")
            WebDriverWaits.ClickOn(accountManagementSection);
        WebDriverWaits.scrollIntoView(contractStartDate_Datepicker);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(contractStartDate_Datepicker);
        WebDriverWaits.ClickOn(currentDate);
        WebDriverWaits.ClickOn(contractTerm_Field);
        WebDriverWaits.SendKeys(contractTerm_Field , contactTermField);
       // jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.scrollPageEnd();
    }

    public static void changeCustomerStatus(String newStatus, String reason ) throws InterruptedException {
        WebDriverWaits.scrollIntoView(changeStatusButton);
        WebDriverWaits.ClickOn(changeStatusButton);
        WebDriverWaits.ClickOn(newStatusDropdown);
        Thread.sleep(4000);
        WebDriverWaits.selectByVisibleText(newStatusDropdown, reason);//"Active"
        WebDriverWaits.ClickOn(reasonforchangeField);
        WebDriverWaits.SendKeys(reasonforchangeField, newStatus );//"Only For testing Residential Type of Category"
        WebDriverWaits.ClickOn(save_button_on_popup);
        System.out.println("Status change successful. ");
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(closepopup_icon);
    }

    public static String searchRecentCustomer() throws InterruptedException {
       // driver.get(DataInterface.AdminURL);
        WebDriverWaits.ClickOn(searchIcon);
        Thread.sleep(4000);
        return WebDriverWaits.GetText(Services.selectBusinessCustomer_Record1);
    }

    public static String searchAndNavigateToRecentCustomer() throws InterruptedException {
      //  driver.get(DataInterface.URL);
        WebDriverWaits.ClickOn(searchIcon);
        Thread.sleep(4000);
        String customerId = WebDriverWaits.GetText(Services.selectBusinessCustomer_Record1);
        WebDriverWaits.SendKeys(searchField, customerId);
        WebDriverWaits.ClickOn(searchIcon);
        return customerId;
    }


    public static void searchCustomer(String CustomerID01R) throws InterruptedException {

      //  LandingPage.navigateToHomePage();
        WebDriverWaits.ClickOn(searchIcon);
        WebDriverWaits.ClickOn(searchField);
        WebDriverWaits.SendKeys(searchField, CustomerID01R);
        WebDriverWaits.ClickOn(searchIcon);
        Thread.sleep(2000);
    }

    public static Settings navigateTo_CustomerSettings(String customerID) throws InterruptedException {
      //  LandingPage.navigateToHomePage();
        WebDriverWaits.ClickOn(searchIcon);
        WebDriverWaits.ClickOn(searchField);
        WebDriverWaits.SendKeys(searchField, customerID);
        WebDriverWaits.ClickOn(searchIcon);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(settingsTab);
        return new Settings();
    }
//
//    //========NEW UPDATED CODES============
//
//    public void clickOnCustomerTab() {
//        WebDriverWaits.ClickOn(customerTab);
//    }
//
//    public void selectCustomerType() {
//        WebDriverWaits.selectByVisibleText(customerType, "Owner");
//    }
//
//    public void selectCatagoryType() {
//        WebDriverWaits.WaitUntilVisible(catagoryType);
//        WebDriverWaits.selectByVisibleText(catagoryType, "Business");
//    }
//
//    public void enterAbnNumber(String ABNType) {
//        WebDriverWaits.scrollIntoView(abnType);
//        WebDriverWaits.SendKeysWithClear(abnType,ABNType);
//    }
//
//    public void selectTitleType() {
//        WebDriverWaits.WaitUntilVisible(titleType);
//        WebDriverWaits.selectByVisibleText(titleType, "Mr.");
//    }
//
//    public void enterCompanyType(String CompanyTypeField) {
//        WebDriverWaits.scrollIntoView(companyType);
//        WebDriverWaits.SendKeysWithClear(companyType, CompanyTypeField);
//    }
//
//    public void enterFirstName(String FirstNameField) {
//        WebDriverWaits.scrollIntoView(firstName);
//        WebDriverWaits.SendKeysWithClear(firstName, FirstNameField);
//    }
//
//    public void enterSurName(String SurNameField) {
//        WebDriverWaits.SendKeysWithClear(surName, SurNameField);
//    }
//
//    public void enterPhoneNumber(String phn) {
//        WebDriverWaits.WaitUntilVisible(phoneNumber);
//        WebDriverWaits.SendKeysWithClear(phoneNumber, phn);
//    }
//
//    public void enterContactEmail(String ContactEmailTypeField) {
//        WebDriverWaits.SendKeysWithClear(contactEmail, ContactEmailTypeField);
//    }
//
//    public void enterAddress1(String Address1Type) {
//        WebDriverWaits.SendKeysWithClear(address1, Address1Type );
//    }
//
//    public void enterCityName(String CityNameField) {
//        WebDriverWaits.SendKeysWithClear(cityName, CityNameField);
//    }
//
//    public void enterCountryName(String CountryNameField) {
//        WebDriverWaits.selectByVisibleText(countryName, CountryNameField);
//    }
//
//    public void enterStateName(String StateNameField) {
//        WebDriverWaits.selectByVisibleText(stateName,  StateNameField);
//    }
//
//    public void enterPostalCode(String PostalCodeField) {
//        WebDriverWaits.SendKeysWithClear(postalCode, PostalCodeField);
//    }
//
//    public void clickOnSaveCustomerButton() {
//        WebDriverWaits.scrollIntoView(saveButton);
//        WebDriverWaits.ClickOn(saveButton);
//    }
//
//    public void clickOnSaveOnlyButton() {
//        WebDriverWaits.ClickOn(saveOnlyButton);
//    }
//
//    public void createCustomer(String ABNType, String phn, String Address1Type, String CityNameField, String CountryNameField, String StateNameField, String PostalCodeField){
//
//        clickOnCustomerTab();
//        selectCustomerType();
//        selectCatagoryType();
//        enterCompanyType(CustomerFirstName);
//        enterAbnNumber(ABNType );
//        selectTitleType();
//        enterFirstName(CustomerFirstName);
//        enterSurName(CustomersurName);
//        enterPhoneNumber( phn);
//        enterContactEmail(CustomerFirstName + "@yopmail.com");
//        enterAddress1( Address1Type);
//        enterCityName( CityNameField);
//        enterCountryName(CountryNameField);
//        enterStateName(StateNameField );
//        enterPostalCode( PostalCodeField);
//        clickOnSaveCustomerButton();
//        clickOnSaveOnlyButton();
//        String Expectedmsg="Successfully saved customer.";
//        softAssert.assertAll();
    //   }

    public static void accountTypeSection(String customerType, String category) {
        WebDriverWaits.ClickOn(customerIcontab);
        WebDriverWaits.ClickOn(customerTypedropdown);
        WebDriverWaits.selectByVisibleText(customerTypedropdown,customerType);
       WebDriverWaits.ClickOn(categorydropdown);
        WebDriverWaits.selectByVisibleText(categorydropdown,category);
    }

    public static void postalCodeSection(String addressfield, String cityfield1, String postalCodefield1, String state) {
        WebDriverWaits.ClickOn(address1field);
        WebDriverWaits.SendKeys(address1field, addressfield);
        WebDriverWaits.ClickOn(cityfield);
        WebDriverWaits.SendKeys(cityfield, cityfield1);
        WebDriverWaits.ClickOn(statedropdown);
        WebDriverWaits.selectByVisibleText(statedropdown,state);
        WebDriverWaits.ClickOn(postalCodefield);
        WebDriverWaits.SendKeys(postalCodefield, postalCodefield1);
    }

    public static void contactDetailsSection(String title, String emailTextField) throws InterruptedException {
        WebDriverWaits.scrollIntoView(titleDropdown);
        WebDriverWaits.ClickOn(titleDropdown);
        WebDriverWaits.selectByVisibleText(titleDropdown,title);
        WebDriverWaits.ClickOn(givenNameField);
        RandomName1 = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(givenNameField, RandomName1);
        //WebDriverWaits.SendKeys(GivenNameField, "Babar");
        WebDriverWaits.ClickOn(surnameField);
        RandomName2 = RandomStrings.RequiredCharacters(6);
        Thread.sleep(2000);
        WebDriverWaits.SendKeys(surnameField, RandomName2);
        //WebDriverWaits.SendKeys(SurnameField, "Asam");
        WebDriverWaits.ClickOn(phoneBHField);
        String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
        WebDriverWaits.SendKeys(phoneBHField, RandomNumber);
        WebDriverWaits.scrollIntoView(emailField);
        WebDriverWaits.ClickOn(emailField);
        WebDriverWaits.SendKeys(emailField, emailTextField);
    }


    public static void saveButton() throws InterruptedException {
        WebDriverWaits.scrollIntoView(saveCustomerButton);
        WebDriverWaits.ClickOn(saveCustomerButton);
        WebDriverWaits.ClickOn(saveOnlyButton);
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(customerSuccessMsg);
        String ExpectedMsg1 = "Successfully saved customer.";
        softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully saved customer");
    }

    public static void accountManagementSection(String contractTerm) throws InterruptedException {
        WebDriverWaits.scrollIntoView(accountManagementSection);
        WebDriverWaits.scrollIntoView(contractStartDate_Datepicker);
        WebDriverWaits.Waituntilvisible(contractStartDate_Datepicker);
        WebDriverWaits.ClickOn(contractStartDate_Datepicker);
        WebDriverWaits.Waituntilvisible(currentDate);
        WebDriverWaits.ClickOn(currentDate);
        WebDriverWaits.ClickOn(contractTerm_Field);
        WebDriverWaits.SendKeys(contractTerm_Field, contractTerm);
        WebDriverWaits.scrollIntoView(saveCustomerButton);
        WebDriverWaits.ClickOn(saveCustomerButton);
        WebDriverWaits.ClickOn(saveOnlyButton);
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(customerSuccessMsg);
        String ExpectedMsg1 = "Successfully saved customer.";
        softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully saved customer");
    }


    public static void statusChangeSection(String status) throws InterruptedException {
        WebDriverWaits.scrollIntoView(changeStatusButton);
        WebDriverWaits.ClickOn(changeStatusButton);
        WebDriverWaits.ClickOn(newStatusDropdown);
        WebDriverWaits.selectByVisibleText(newStatusDropdown,status);
        WebDriverWaits.ClickOn(reasonforchangeField);
        WebDriverWaits.SendKeys(reasonforchangeField, "Only For testing Residential Type of Category");
        WebDriverWaits.ClickOn(save_button_on_popup);
        String ExpectedMsg2 = "Status change successful.";
        softAssert.assertEquals(ExpectedMsg2, "Status change successful.");
        System.out.println("Status change successful.");
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(closepopup_icon);
        //to analysed
      //  driver.navigate().to(DataInterface.AdminURL);
        Thread.sleep(8000);
        WebDriverWaits.ClickOn(Services.searchIcon);
        Thread.sleep(4000);
    }
    public static void switchToCustomerpage() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> overViewTab = driver.findElements(overviewTab);
        if (overViewTab.size() == 0) {
            WebDriverWaits.ClickOn( selectBusinessCustomer_Record1);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            Thread.sleep(3000);
            driver.switchTo().window((String) tabs.get(1));
        }
    }
    public static void SwitchToCustomerpage(int windowIndex) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> overViewTab = driver.findElements( overviewTab);
        if (overViewTab.size() == 0) {
            WebDriverWaits.ClickOn( selectBusinessCustomer_Record1);
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            Thread.sleep(3000);
            driver.switchTo().window((String) tabs.get(windowIndex));
        }



    }

    public static void companyDetailSection(String companyName, String abnType) {
        WebDriverWaits.scrollIntoView(companyNameField);
        WebDriverWaits.ClickOn(Customer.companyNameField);
        WebDriverWaits.SendKeys(Customer.companyNameField, companyName);
        WebDriverWaits.ClickOn(abnField);
        WebDriverWaits.SendKeys(abnField, abnType);
    }


    public static String createResidentialCustomer(String customerType, String category, String Addressfield, String Cityfield1, String PostalCodefield1, String state,String title,String emailField, String contactTermField, String status) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        //driver.navigate().refresh();
        accountTypeSection(customerType, category);
        postalCodeSection(Addressfield, Cityfield1, PostalCodefield1, state);
         contactDetailsSection(title, emailField);
        addAccountManagement(category,contactTermField);// accountManagement
        saveButton();
        statusChangeSection(status);
        CustomerID01R = WebDriverWaits.GetText(Services.selectBusinessCustomer_Record1);
        return CustomerID01R;
    }

    public static String creteBusinessCustomer(String customerType, String catagory, String Addressfield, String Cityfield1, String PostalCodefield1, String state, String companyName, String abnType, String title, String emailField,String category,String contactTermField, String status) throws InterruptedException {

        accountTypeSection(customerType, catagory);
        postalCodeSection(Addressfield, Cityfield1, PostalCodefield1, state);
        companyDetailSection(companyName, abnType);
        contactDetailsSection(title, emailField);
        addAccountManagement(category,contactTermField);
        saveButton();
        statusChangeSection(status);
        CustomerID02B = WebDriverWaits.GetText(Services.selectBusinessCustomer_Record1);
        return CustomerID02B;
    }

    public static String createCommercialCustomer(String customerType, String catagory, String Addressfield, String Cityfield1, String PostalCodefield1, String state, String companyName, String abnType, String title, String emailField, String categoryTxt, String status) throws InterruptedException {


        accountTypeSection(customerType, catagory);
        postalCodeSection(Addressfield, Cityfield1, PostalCodefield1, state);
        companyDetailSection(companyName, abnType);
        contactDetailsSection(title, emailField);
        accountManagementSection(categoryTxt);
        statusChangeSection(status);
        CustomerID03C = WebDriverWaits.GetText(Services.selectBusinessCustomer_Record1);
        return CustomerID03C;
    }
}