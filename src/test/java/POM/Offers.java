package POM;

import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;

import static POM.Customer.RandomName2;
import static POM.WorkFlowTypes.RandomName1;

public class Offers
{
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

public void createOfferGroupBusinessType(String customerTypeDropDownText){
    clickOnOfferTab();
    clickOnPlusIcon();
    enterInofferGroupField(RandomName1);
    selectcustomerTypeDropDown(customerTypeDropDownText);
    clickdateValidFromField();
    clickOnSaveButton();
    clickOnOkButton();
}
public void editOfferGroupBusinessType(){
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

}
