package TestCases;

import CommonMethods.BaseTest;
import POM.Admin;
import POM.Flow5_AddCustomer;
import POM.Login;
import POM.Offer;
import org.testng.annotations.Test;

public class TestOffers extends BaseTest {

    @Test(priority = 1,enabled = true)
    public  void createOffers() throws InterruptedException {
        extentTest = extent.startTest(" Add Offer ");
        extentTest.setDescription(" Verify that User is able to add Offer. ");
        Login.ValidLogin();
        Admin.navigateToAdmin();
        Offer.navigateToOfferPage();
        Offer.createOffer("Asd","asaa");
    }

}
