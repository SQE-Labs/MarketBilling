package POM;

import CommonMethods.DateAndTime;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;

import static POM.Flow6_7AddingServiceAndMeter.X_AddService.Edit_icon;
import static POM.Flow6_7AddingServiceAndMeter.X_AddService.ServiceTab;
import static POM.Flow6_7AddingServiceAndMeter.jse;

public class AddSitePlans  extends TestLogin {

    public static By sitePlans = By.xpath("//*[contains(text(), 'Site Plans')]");
    public static By siteParameters = By.xpath("//*[contains(text(), 'Site Parameters')]");

    public static By addPlanBtn = By.id("addPlanBtn");
    public static By planSelected = By.id("planSelected");
    public static By activeDay = By.cssSelector(".active.day");

    public static By groupPlans = By.id("groupPlans");


    public static By startDate = By.id("startDate");
    public static By endDate = By.id("endDate");
    public static By addPlanToTableBtn = By.id("addPlanToTableBtn");
    public static By saveServiceParamsBtn = By.id("saveServiceParamsBtn");


    public static By addParamBtn = By.id("ad");
    public static By effectiveDate = By.id("effectiveDate");
    public static By parameterName = By.id("parameterName");
    public static By paramValue = By.id("paramValue");




    public  static  void addSitePlan(){
        WebDriverWaits.ClickOn(ServiceTab);
        WebDriverWaits.ClickOn(Edit_icon);
        jse.executeScript("window.scrollBy(0,1000)", "");

        WebDriverWaits.ClickOn(sitePlans);
        WebDriverWaits.ClickOn(addPlanBtn);
        WebDriverWaits.SendKeys(planSelected, "Electricity Template Plan");
        WebDriverWaits.ClickOn(groupPlans);
        WebDriverWaits.SendKeys(startDate,DateAndTime.DateTimeGenerator("dd/mm/yyyy"));
        WebDriverWaits.ClickOn(activeDay);

        WebDriverWaits.SendKeys(endDate, DateAndTime.DateTimeGenerator("dd/mm/yyyy"));
//        WebDriverWaits.ClickOn(startDate);
        WebDriverWaits.ClickOn(activeDay);
        WebDriverWaits.ClickOn(addPlanToTableBtn);
        WebDriverWaits.ClickOn(saveServiceParamsBtn);

    }

    public  static  void addSiteParameters(){
        WebDriverWaits.ClickOn(ServiceTab);
        WebDriverWaits.ClickOn(Edit_icon);
        jse.executeScript("window.scrollBy(0,1000)", "");
        WebDriverWaits.ClickOn(siteParameters);
        WebDriverWaits.ClickOn(addParamBtn);
        WebDriverWaits.SendKeys(effectiveDate,"Electricity Template Plan");
        WebDriverWaits.selectByVisibleText(parameterName,"");
        WebDriverWaits.SendKeys(paramValue,"Test Value");
        WebDriverWaits.ClickOn(addParamBtn);
        WebDriverWaits.ClickOn(saveServiceParamsBtn);

    }
}