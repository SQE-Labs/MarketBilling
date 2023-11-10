package TestCases;

import CommonMethods.BaseTest;
import POM.Admin;
import POM.Login;
import POM.Offers;
import org.testng.annotations.Test;

public class TestOffers extends BaseTest {
    Offers offer = new Offers();

    @Test(priority = 0, enabled = true)
    public void createOfferGroup() {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able createOfferGroup ");
        Login.validLogin();
        Admin.navigateToAdmin();
        offer.createOfferGroupBusinessType("Business");
    }

    @Test(priority = 1, enabled = true)
    public void editOfferGroup() {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able createOfferGroup ");
        offer.editOfferGroupBusinessType();
    }

    @Test(priority = 2, enabled = true)
    public void deleteOfferGroup() throws InterruptedException {
        extentTest = extent.startTest(" createOfferGroup ");
        extentTest.setDescription(" Verify that User is able createOfferGroup ");
        offer.deleteOfferGroupBusinessType();
    }
}
