package TestCases;

import CommonMethods.BaseTest;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import POM.Login;
import POM.WorkFlowTypes;
import org.testng.annotations.Test;

import static POM.WorkFlowTypes.*;


public class TestWorkFlowTypes extends BaseTest {
    WorkFlowTypes WorkFlow=new WorkFlowTypes();
    public String RandomName1;
    @Test(priority = 0,enabled = true)
    public void createFlowType() throws InterruptedException {
        extentTest = extent.startTest(" Add WorkFlowTypes ");
        extentTest.setDescription(" Verify that User is able to add WorkFlowTypes ");
        // Login.validLogin();
        RandomName1 =  RandomStrings.RequiredCharacters(2);
         WorkFlow.createWorkFlowType(RandomName1);
        WebDriverWaits.validate_SuccessTXT(succ_Msg,"Successfully added the workflow type '" +RandomName1+"'.");
    }
    @Test(priority = 1,enabled = true)
    public void editFlowType() throws InterruptedException {
        extentTest = extent.startTest(" Edit WorkFlowTypes ");
        extentTest.setDescription(" Verify that User is able to Edit WorkFlowTypes or Not ");
        WorkFlow.editWorkFlowType(RandomName1);
        WebDriverWaits.validate_SuccessTXT(editedSucc_Msg,"Successfully updated the workflow type '"+RandomName1+"'.");
    }

    @Test(priority = 2,enabled = true)
    public void deleteFlowType() throws InterruptedException {
        extentTest = extent.startTest(" Delete WorkFlowTypes ");
        extentTest.setDescription(" Verify that User is able to Delete WorkFlowTypes or Not ");
        WorkFlow.deleteWorkFlowType(RandomName1);
        WebDriverWaits.validate_SuccessTXT( deletedSucc_Msg,"Successfully deleted workflow type.");
    }
}
