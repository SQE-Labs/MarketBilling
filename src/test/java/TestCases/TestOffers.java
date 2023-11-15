package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.RandomStrings;
import POM.Admin;
import POM.Login;
import POM.Offers;
import POM.WorkFlowTypes;
import org.testng.annotations.Test;

import java.awt.*;


import static POM.Offers.offerName;
import static POM.Offers.randomOfferDisplayName;
import static POM.WorkFlowTypes.RandomName1;


public class TestOffers extends BaseTest {


    Offers offer = new Offers();

    @Test(priority = 0, enabled = true)
    public void createOfferGroup() {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able createOfferGroup ");
        Login.validLogin();
        Admin.navigateToAdmin();
        offer.createOfferGroupBusinessType(RandomName1,"Business");
    }

    @Test(priority = 1, enabled = true)
    public void editOfferGroup() {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able createOfferGroup ");
        offer.editOfferGroupBusinessType(RandomName1);
    }

    @Test(priority = 2, enabled = false)
    public void deleteOfferGroup() throws InterruptedException {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able createOfferGroup ");
        offer.deleteOfferGroupBusinessType();
    }
    @Test(priority = 3, enabled = true)
    public void createOffer() throws InterruptedException, AWTException {
        extentTest = extent.startTest(" createOffer ");
        extentTest.setDescription(" Verify that User is able createOffer or not  ");

        offer. createOffer( offerName,randomOfferDisplayName,RandomName1);
    }
}
