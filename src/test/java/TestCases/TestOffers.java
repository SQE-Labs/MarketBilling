package TestCases;



import CommonMethods.BaseTest;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import POM.Admin;
import POM.GroupEdit;
import POM.Login;
import POM.Offers;
import org.testng.annotations.Test;

import java.awt.*;

import static POM.CorrespondenceSetup.softAssert;
import static POM.Offers.*;


public class TestOffers extends BaseTest {

    String RandomName1 ;
    String offerName = RandomStrings.RequiredCharacters(4);
    String randomOfferDisplayName = RandomStrings.RequiredCharacters(4);
    @Test(priority = 0, enabled = true)
    public void createOfferGroup() throws InterruptedException {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able to createOfferGroup ");
       Login.validLogin();
        Offers offer = new Offers();
        GroupEdit msg=new GroupEdit();
        RandomName1 = "Offer_Group_"+ RandomStrings.RequiredCharacters(2);
        Admin.navigateToAdmin();
        offer.createOfferGroupBusinessType(RandomName1, "Business");
        WebDriverWaits.validate_SuccessTXT(offerGroupSucc_Msg,"Offer Group " +RandomName1+ " added successfully.");

        //Assertions
        //to validate newly created offer group in table

    }

    @Test(priority = 1, enabled = true)
    public void editOfferGroup() throws InterruptedException {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able createOfferGroup ");
        Offers offer = new Offers();
        GroupEdit msg=new GroupEdit();
        offer.editOfferGroupBusinessType(RandomName1);
        WebDriverWaits.validate_SuccessTXT(editedOfferGroupSucc_Msg,"Changes to "+RandomName1+" saved successfully.");
    }

    @Test(priority = 2, enabled = false)
    public void deleteOfferGroup() throws InterruptedException {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able createOfferGroup ");
        Offers offer = new Offers();
        offer.deleteOfferGroupBusinessType();
        WebDriverWaits.validate_SuccessTXT(deleteOfferGroup,"Offer Group "+RandomName1+" removed successfully.");

    }

    @Test(priority = 3, enabled = true)
    public void createOffer() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" create Offer");
        extentTest.setDescription(" Verify that User is able create Offer or not ");
        Offers offer = new Offers();
        offer.createOffer(offerName, randomOfferDisplayName, RandomName1);
        WebDriverWaits.validate_SuccessTXT(offerSucc_Msg,"Offer added successfully.");

    }

    @Test(priority = 4, enabled = true)
    public void editOffer() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" create Offer");
        extentTest.setDescription(" Verify that User is able create Offer or not ");
        Offers offer = new Offers();
        offer.editOffer(RandomName1,offerName);
      //  WebDriverWaits.validate_SuccessTXT(editedOfferSucc_Msg,"Offer saved successfully.");
    }
}
