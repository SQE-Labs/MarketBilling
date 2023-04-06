package TestCases;

import CommonMethods.BaseTest;
import POM.Login;
import POM.Plans;
import POM.TouImport;
import org.testng.annotations.Test;

public class TestAddPlan extends BaseTest {


    @Test(priority = 2,enabled = true)
    public  void TouImport() throws InterruptedException {
        extentTest = extent.startTest(" TouImport ");
        //Login.ValidLogin();
        extentTest.setDescription(" Verify that User is able to do TouImport");
        TouImport.TOUImportFile();

    }

    @Test(priority = 3,enabled = true)
    public  void AddPlanwithoutTOUDefinition() throws InterruptedException {
        extentTest = extent.startTest(" AddPlanwithoutTOUDefinition ");
        extentTest.setDescription(" Verify that User is able to add simple plan. ");
        Plans.AddPlanwithoutTOUDefinition();
    }

    @Test(priority = 4,enabled = true)
    public  void PlanwithTOUDefinition_Network_and_Retail_Trf() throws InterruptedException {
        extentTest = extent.startTest(" PlanwithTOUDefinition_Network_and_Retail_Trf ");
        extentTest.setDescription(" Verify that User is able to add plan with TOU definition. ");
        Plans.PlanwithTOUDefinition_Network_and_Retail_Trf();
    }

    @Test(priority = 5,enabled = true)
    public  void PlanwithDemandTOUdefinition_Network_and_Retail_Trf() throws InterruptedException {
        extentTest = extent.startTest(" PlanwithDemandTOUdefinition_Network_and_Retail_Trf ");
        extentTest.setDescription(" Verify that User is able to add plan with Demand TOU definition ");
        Plans.PlanwithDemandTOUdefinition_Network_and_Retail_Trf();
    }



    @Test(priority = 6,enabled=true)
    public static void Add_ProRated_Rates() throws InterruptedException {
        extentTest = extent.startTest(" Add_ProRated_Rates ");
        Login.ValidLogin();
        extentTest.setDescription(" Verify that User is able to add ProRated Rates ");
    //    Plans.Add_ProRated_Rates();
    }
}
