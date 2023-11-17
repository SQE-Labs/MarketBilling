package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static BrowsersBase.BrowsersInvoked.driver;
import static CommonMethods.WebDriverWaits.*;

public class WorkFlowTypes
{
    //++++++++++Create workflow types+++++++++++++

    public static By adminTab =By.xpath("//span[text()='Admin']");
    public static By workFlowTypeSubTab=By.xpath("//p[text()='Workflow Types']");
    public static By createNewLogTypeButton=By.xpath("//a[text()=' Create new log type ']");
    public static By typeNameField=By.xpath("//input[@name='type_name']");
    public static By displayName=By.xpath("//input[@name='display_name']");
    public static By saveButton=By.xpath("//button[text()='Save']");
    public static By succ_Msg=By.xpath("//p[@id='msgP']");

    //+++++++++++Edit workflow type++++++++++++++
    public static By searchField=By.xpath("//input[@type='search']");
    public static By editIcon=By.xpath("//a[@class='btn btn-info edit-logtype']");
    public static By actionDropDown=By.xpath("//select[@id='contact_action_days']");

    //+++++++++++Delete workflow type++++++++++++++
    public static By deleteIcon=By.xpath("//tbody[@id='logtypeListBody']//i[@class='icon-trash']");
    public static By okButton=By.xpath("//button[text()='OK']");
    public void clickAdminTab(){
        WebDriverWaits.ClickOn(adminTab);
    }

    public void clickWorkFlowSubTab(){
        WebDriverWaits.scrollIntoView(workFlowTypeSubTab);
        WebDriverWaits.ClickOn(workFlowTypeSubTab);
    }

    public void clickOncreateNewLogTypeButton(){
        WebDriverWaits.ClickOn(createNewLogTypeButton);
    }

    public void clickOntypeNameField(String typeNameFieldText){
        WebDriverWaits.SendKeysWithClear(typeNameField,typeNameFieldText);
    }

    public void clickOndisplayName(String displayTypeText){
        WebDriverWaits.SendKeysWithClear(displayName,displayTypeText);
    }
    public void clickOnSaveButton(){
        WebDriverWaits.Waituntilvisible(saveButton);
        WebDriverWaits.scrollIntoView(saveButton);
        WebDriverWaits.ClickOn(saveButton);
    }

    //++++++++++Edit WorkFlowTypes++++++++++

    public void searchFieldText(String text){
        WebDriverWaits.SendKeysWithClear(searchField,text);
    }
    public void selectTextFromActionDropDown(){
        WebDriverWaits.selectByVisibleText(actionDropDown,"2");
    }
    public void clickOnEditIcon(){
        WebDriverWaits.ClickOn(editIcon);
    }

    //++++++++Delete WorkFlowType++++++++++
    public void clickOnDeleteIcon(){
        WebDriverWaits.Waituntilvisible(deleteIcon);
         WebDriverWaits.ClickOn(deleteIcon);
    }
    public void clickOnOkButton(){
        WebDriverWaits.ClickOn(okButton);
    }

    public void createWorkFlowType(String RandomName1){
        Admin.navigateToAdmin();
        clickWorkFlowSubTab();
        clickOncreateNewLogTypeButton();
        clickOntypeNameField(RandomName1);
        clickOndisplayName(RandomName1);
        clickOnSaveButton();
    }

    public void editWorkFlowType(String RandomName1){
        Admin.navigateToAdmin();
        clickWorkFlowSubTab();
        searchFieldText(RandomName1);
        clickOnEditIcon();
        selectTextFromActionDropDown();
        clickOnSaveButton();
    }

    public void deleteWorkFlowType(String RandomName1) throws InterruptedException {
        Admin.navigateToAdmin();
        clickWorkFlowSubTab();
        searchFieldText(RandomName1);
        Thread.sleep(3000 );
        clickOnDeleteIcon();
        clickOnOkButton();
    }
}
