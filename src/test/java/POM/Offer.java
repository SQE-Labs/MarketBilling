package POM;

import CommonMethods.BaseTest;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;

public class Offer extends BaseTest {


    public static By offerIcon = By.xpath("//*[contains(text(), 'Offer')]");
    public static By offersPlusIcon = By.xpath("(//i[@class='icon-plus'])[3]");
    public static By offerName = By.id("offerName");
    public static By offerDisplayName = By.id("offerDisplayName");
    public static By offerGroupDrpdown = By.xpath("(//span[@class='filter-option pull-left'])[1]");
    public static By dateValidFrom = By.xpath("dateValidFrom");
    public static By dateValidTo = By.id("dateValidTo");



    public static void navigateToOfferPage(){
        WebDriverWaits.scrollIntoView(offerIcon);
        WebDriverWaits.ClickOn(offerIcon);
    }

    public static void createOffer(String offerNameTxt,String offerDisplayNameTxt) throws InterruptedException {
        WebDriverWaits.scrollIntoView(offersPlusIcon);
        WebDriverWaits.ClickOn(offersPlusIcon);
        WebDriverWaits.SendKeys(offerName,offerNameTxt);
        WebDriverWaits.SendKeys(offerDisplayName,offerDisplayNameTxt);
        WebDriverWaits.ClickOn(offerGroupDrpdown);
        Thread.sleep(2000);
        WebDriverWaits.selectByIndex(offerGroupDrpdown,1);
        WebDriverWaits.ClickOn(dateValidFrom);
        WebDriverWaits.ClickOn(dateValidTo);
    }
}
