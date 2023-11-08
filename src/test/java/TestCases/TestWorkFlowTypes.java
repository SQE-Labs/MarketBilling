package TestCases;

import CommonMethods.BaseTest;
import POM.WorkFlowTypes;
import org.testng.annotations.Test;

public class TestWorkFlowTypes extends BaseTest {
    WorkFlowTypes WorkFlow=new WorkFlowTypes();

    @Test(priority = 0,enabled = true)
    public void createFlowType() {
        extentTest = extent.startTest(" Add WorkFlowTypes ");
        extentTest.setDescription(" Verify that User is able to add WorkFlowTypes ");
//       Login.validLogin();
         WorkFlow.createWorkFlowType();
    }
    @Test(priority = 1,enabled = true)
    public void editFlowType(){
        extentTest = extent.startTest(" Edit WorkFlowTypes ");
        extentTest.setDescription(" Verify that User is able to Edit WorkFlowTypes or Not ");
        WorkFlow.editWorkFlowType();
    }
    @Test(priority = 2,enabled = true)
    public void deleteFlowType() throws InterruptedException {
        extentTest = extent.startTest(" Delete WorkFlowTypes ");
        extentTest.setDescription(" Verify that User is able to Delete WorkFlowTypes or Not ");
        WorkFlow.deleteWorkFlowType();
    }
}
