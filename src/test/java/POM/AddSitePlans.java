package POM;

import CommonMethods.DateAndTime;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;

//import static POM.Flow6_7AddingServiceAndMeter.X_AddService.Edit_icon;
//import static POM.Flow6_7AddingServiceAndMeter.X_AddService.ServiceTab;
//import static POM.Flow6_7AddingServiceAndMeter.jse;
//import static POM.Services;
//import static POM.

public class AddSitePlans extends TestLogin {

    public static By sitePlans = By.xpath("//*[contains(text(), 'Site Plans')]");
    public static By siteParameters = By.xpath("//*[contains(text(), 'Site Parameters')]");
    public static By addPlanBtn = By.id("addPlanBtn");
    public static By planSelected = By.cssSelector("[data-id='select_plan']");
    public static By elecTemplate = By.xpath("//*[@class='dropdown-menu open']/ul/li[2]");

    public static By okButton = By.xpath("//*[contains(text(), 'OK')]");

    public static By activeDay = By.cssSelector(".active.day");
    public static By groupPlans = By.id("groupPlans");
    public static By startDate = By.id("startDate");
    public static By endDate = By.id("endDate");
    public static By addPlanToTableBtn = By.cssSelector("button#addPlanToTableBtn");
    public static By saveServiceParamsBtn = By.xpath("(//button[text()='Save'])[4]");
    public static By saveChanges = By.cssSelector("button#saveChangesBtn");
    public static By addParamBtn = By.id("ad");
    public static By effectiveDate = By.id("effectiveDate");

    public static By serviceTab = By.xpath("//*[@class=\"icon-power-off\"]");
    public static By parameterName = By.id("parameterName");
    public static By paramValue = By.id("paramValue");
    public static By Sitedate=By.xpath("//input[@id='effectiveDate']");
    public static By Today=By.xpath("(//th[text()='Today'])[1]");
    public static By Edit_icon = By.xpath("//*[@class=\"btn btn-primary toolt\"]");
    public static By AddButt=By.xpath("//button[@id='addParamBtn']");


/*    public static void addSitePlan() throws InterruptedException {
        WebDriverWaits.ClickOn(ServiceTab);
        WebDriverWaits.ClickOn(Edit_icon);
        WebDriverWaits.scrollIntoView(sitePlans);
        WebDriverWaits.ClickOn(sitePlans);
        WebDriverWaits.ClickOn(addPlanBtn);
        //TO_DO
        WebDriverWaits.ClickOn(planSelected);
        WebDriverWaits.ClickOn(elecTemplate);
        // WebDriverWaits.ClickOn(groupPlans);
        WebDriverWaits.SendKeys(startDate, DateAndTime.DateTimeGenerator("dd/MM/yyyy"));
        WebDriverWaits.ClickOn(activeDay);
        WebDriverWaits.SendKeys(endDate, "15/09/2023");
     //   WebDriverWaits.ClickOn(activeDay);
        WebDriverWaits.ClickOn(addPlanToTableBtn);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(saveChanges);
        WebDriverWaits.WaitUntilVisible(okButton);
        WebDriverWaits.ClickOn(okButton);
        WebDriverWaits.WaitUntilVisible(okButton);
        WebDriverWaits.ClickOn(okButton);

    }   */

    public static void addSiteParameters() throws InterruptedException {
        WebDriverWaits.ClickOn(serviceTab);
        WebDriverWaits.ClickOn(Edit_icon);
       WebDriverWaits.scrollIntoView(siteParameters);
        WebDriverWaits.ClickOn(siteParameters);
        WebDriverWaits.ClickOn(addParamBtn);
        WebDriverWaits.ClickOn(Sitedate);
        WebDriverWaits.ClickOn(Today);
        WebDriverWaits.ClickOn(parameterName);
        WebDriverWaits.selectByVisibleText(parameterName, "Minimum Demand kVA");
        WebDriverWaits.SendKeys(paramValue, "10.158");
        WebDriverWaits.WaitUntilVisible(paramValue);
        WebDriverWaits.ClickOn(AddButt);
        Thread.sleep(1000);
        WebDriverWaits.WaitUntilVisible(saveServiceParamsBtn);
        WebDriverWaits.ClickOn(saveServiceParamsBtn);
    }
}
