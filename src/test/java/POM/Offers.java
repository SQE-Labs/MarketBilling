package POM;


import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;

import java.awt.*;



public class Offers
{
    public static String offerName = RandomStrings.RequiredCharacters(4);
    public static String randomOfferDisplayName = RandomStrings.RequiredCharacters(4);

public static By offerTab=By.xpath("//p[text()='Offer']");
public static By plusIcon=By.xpath("(//i[@class='icon-plus'])[2]");
public static By offerGroupField=By.xpath("//input[@id='offerGroupName']");
public static By customerTypeDropDown=By.xpath("//select[@id='customerType']");
public static By dateValidFromField=By.xpath("//input[@id='OG_dateValidFrom']");
public static By dateValidToField=By.xpath("//input[@id='OG_dateValidTo']");
public static By saveButton=By.xpath("//button[text()='Save']");
public static By todayButton=By.xpath("(//th[text()='Today'])[1]");
public static By okButton=By.xpath("//button[text()='OK']");

//++++++++Edit offerGroup++++++++++
public static By searchField=By.xpath("(//input[@type='search'])[2]");
public static By editIcon=By.xpath("(//a[@class='btn btn-info'])[1]");
public static By selectDate=By.xpath("(//td[@class='day'])[6]");
public static By editSaveButton=By.xpath("(//button[text()='Save'])[1]");
public static By crossIcon=By.xpath("//button[text()='×']");

//++++++Delete offerGroup++++++++++
public static By deleteIcon=By.xpath("(//a[@class='btn btn-danger'])[1]");
public static By deleteOkButton=By.xpath("//button[text()='OK']");
public static By succOkButton=By.xpath("//button[text()='OK']");

//++++++Create offer++++++++
    public static By offerPlusIcon=By.xpath("(//i[@class='icon-plus'])[3]");
    public static By offerNameField=By.xpath("//input[@id='offerName']");
    public static By offerDisplayName=By.xpath("//input[@id='offerDisplayName']");
    public static By offerGroupDropDown=By.xpath("(//button[@class='btn dropdown-toggle selectpicker btn-default'])[1]");
    public static By offerGroupSearchField=By.xpath("(//input[@class='input-block-level form-control'])[1]");
    public static By offerGroupText=By.xpath("//*[@id=\"formOffer\"]/div[4]/div/div[1]/div/ul/li[171]/a");
    public static By dateValidFrom=By.xpath("//input[@id='dateValidFrom']");
    public static By todayText=By.xpath("//th[text()='Today']");
    public static By offerSaveButton=By.xpath("(//button[text()='Save'])[2]");

public void clickOnOfferTab(){
    WebDriverWaits.scrollIntoView(offerTab);
    WebDriverWaits.ClickOn(offerTab);
}
public void clickOnPlusIcon(){
    WebDriverWaits.ClickOn(plusIcon);
}
public void enterInofferGroupField(String offerGroupFieldText){
    WebDriverWaits.SendKeysWithClear(offerGroupField,offerGroupFieldText);
}
public void selectcustomerTypeDropDown(String customerTypeDropDownText){
    WebDriverWaits.selectByVisibleText(customerTypeDropDown,customerTypeDropDownText);
}
public void clickdateValidFromField(){
    WebDriverWaits.ClickOn(dateValidFromField);
    WebDriverWaits.ClickOn(todayButton);
}
public void clickdateValidToField(){
    WebDriverWaits.ClickOn(dateValidToField);
    WebDriverWaits.ClickOn(todayButton);
}
public void clickOnSaveButton(){
    WebDriverWaits.ClickOn(saveButton);
}
public void clickOnOkButton(){
    WebDriverWaits.ClickOn(okButton);
}

//++++++++Edit offerGroup++++++++
public void enterInSearchField(String searchFieldText){
    WebDriverWaits.SendKeysWithClear(searchField,searchFieldText);
}
public void clickOnEditIcon(){
    WebDriverWaits.ClickOn(editIcon);
}
public void clickeditSaveButton(){
    WebDriverWaits.ClickOn(editSaveButton);
}
public void clickOnCrossIcon(){
    WebDriverWaits.ClickOn(crossIcon);
}

//+++++delete offerGroup+++++++++

    public void clickOnDeleteIcon(){
        WebDriverWaits.ClickOn(deleteIcon);

    }
    public void clickdeleteOkButton(){
    WebDriverWaits.ClickOn(deleteOkButton);
    }
    public void clickOkOnsuccMsg(){
    WebDriverWaits.Waituntilvisible(succOkButton);
    WebDriverWaits.ClickOn(succOkButton);
    }

    //++++++++++CRETAE OFFER+++++++++++
    public void clickOnofferPlusIcon(){
    WebDriverWaits.ClickOn(offerPlusIcon);
    }
    public void enterTextInofferNameField(String offerNameFieldText){
    WebDriverWaits.SendKeysWithClear(offerNameField,offerNameFieldText);
    }

    public void enterTextInofferDisplayName(String offerDisplayNameFieldText){
        WebDriverWaits.SendKeysWithClear(offerDisplayName,offerDisplayNameFieldText);
    }
    public void clickOnofferGroupDropDown(String offerGroupSearchFieldText) throws InterruptedException, AWTException {
    WebDriverWaits.ClickOn(offerGroupDropDown);
    WebDriverWaits.SendKeysWithClear(offerGroupSearchField,offerGroupSearchFieldText);
    Thread.sleep(2000);
      WebDriverWaits.SelectElementByRobotClass();
   // WebDriverWaits.ClickOn(offerGroupText);
    }
    public void clickOndateValidFrom(){
    WebDriverWaits.Waituntilvisible(dateValidFrom);
    WebDriverWaits.ClickOn(dateValidFrom);
    WebDriverWaits.ClickOn(todayText);
    }
    public void clickOnOfferSaveButton() throws InterruptedException {
    WebDriverWaits.scrollIntoView(offerSaveButton);
    WebDriverWaits.scrollDown();
    WebDriverWaits.ClickOn(offerSaveButton);
    }

public void createOfferGroupBusinessType(String RandomName1,String customerTypeDropDownText){
    clickOnOfferTab();
    clickOnPlusIcon();
    enterInofferGroupField(RandomName1);
    selectcustomerTypeDropDown(customerTypeDropDownText);
    clickdateValidFromField();
    clickOnSaveButton();
    clickOnOkButton();
}
public void editOfferGroupBusinessType(String RandomName1){
    enterInSearchField(RandomName1);
    clickOnEditIcon();
    clickdateValidToField();
    clickeditSaveButton();
    clickOnCrossIcon();
}
public void deleteOfferGroupBusinessType() throws InterruptedException {
    clickOnDeleteIcon();
    clickdeleteOkButton();
    Thread.sleep(2000);
    clickOkOnsuccMsg();
}
public void createOffer( String offerName,String randomOfferDisplayName,String RandomName1 ) throws InterruptedException, AWTException {
    clickOnofferPlusIcon();
    enterTextInofferNameField(offerName);
    enterTextInofferDisplayName(randomOfferDisplayName);
    clickOnofferGroupDropDown(RandomName1);
    clickOndateValidFrom();
    clickOnOfferSaveButton();
    clickOnCrossIcon();

}

}
