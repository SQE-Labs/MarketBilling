package TestCases;
import CommonMethods.BaseTest;
import CommonMethods.DateAndTime;
import POM.*;
import org.testng.annotations.Test;
import java.util.Random;
public class Imports extends BaseTest {
    String meterNo;
    String serviceId;
    String customerId;

    @Test(priority = 0)
    public void Add_Customer_and_Service_for_Imports() throws Exception {
         extentTest = extent.startTest("Add_Customer_and_Service");
         //Login.validLogin();
         customerId = Customer.createCustomer("Tenant", "10","Commercial", "32165485216","FranklinCovey","Madirma R-Town","Mills NY","WA","1265","Dr.","residential123@yopmail.com" );
        // serviceId= Services.M_AddService(customerId);
         Services.editService("Connected");
//         customerId="45809";
//         serviceId="6507343299";


	}

    @Test(priority = 1,enabled = true)
    public void Import_Meter_Number() throws Exception {
        extentTest = extent.startTest(" Meter Number import ");
        extentTest.setDescription(" Verify that User is able to run meter number import");
       // Login.ValidLogin();
         int random2 = (new Random()).nextInt(900) + 100;
        String meterImport_FilePath = System.getProperty("user.dir") + "/TestData/Electricity - Meter Import Template.csv";
        String col = "*Service ID,*Meter Serial Number,*Status,*Consumption Type,*Configuration,Multiplier,Constant,Hazard,Location,Additional Site Info,Meter Point ID,Next Scheduled Read Date,Manufacturer,Model,Meter Read Type,Route,Walk Order,*Meter Installation Type,*Date Connected,Date Removed";
         meterNo = "TestMeter" + random2;
        // meterNo="Meters359";
        String prodate = DateAndTime.DateTimeGenerator("dd/MM/yyyy");
        CSVHelper.ImportMeterNumber(meterImport_FilePath, col, serviceId, meterNo, "Current", "Cumulative", "POS", "", "", "", "", "", "", "", "", "", "", "", "", "BASIC", prodate, "");
        MeterImport.meterNumberImport(meterImport_FilePath);
    }

    @Test(priority = 2,enabled = true)
    public void Import_Meter_Register() throws Exception {
        extentTest = extent.startTest(" Meter Register Import ");
        extentTest.setDescription(" Verify that User is able to run meter register using Import");
        String path = System.getProperty("user.dir") + "/TestData/Register Import Template.csv";
        String prodate = DateAndTime.DateTimeGenerator("dd/MM/yyyy");
       // meterNo="Meters359";
        String col = "*Service ID, *Meter Serial Number, *Register ID, *Network Tariff Code, *Unit Of Measure, *Time Of Day, *Multiplier, *Dial Format, *Suffix, *Controlled Load, *Status, *Consumption Type, *Demand1, *Demand2, *Date Connected, Date Removed ";
        CSVHelper.ImportMeterRegister(path,col, serviceId,meterNo,"1","NA","KWH","ALLDAY","1","5","11","No","Current","Cumulative","0","0",prodate,"" );
        //CSVHelper.ImportMeterRegister(path,col, serviceId,meterNo,"1","NA","KWH","ALLDAY","1","5","11","No","Current","Actual","0","0",prodate,"" );
        MeterImport.meterRegisterImport(path);

    }
    @Test(priority = 3,enabled = true)
    public void Import_Meter_Reads_Initial() throws Exception {
        extentTest = extent.startTest(" Meter Reads Import ");
        extentTest.setDescription(" Verify that User is able to   Import Meter reads");
        String path = System.getProperty("user.dir") + "/TestData/Meter Read Import Template - Manual.csv";
        String readDate = DateAndTime.DateTimeGenerator("dd/MM/yyyy");
        //meterNo="Meters359";
        String col = "*Service ID,*Meter Number,*Date of Read,*Meter Read,*Period,*Read Type [I-Initial / A-Actual / C - Consumption / E-Estimate],Notes,Is Read Rollover? [Yes/No],Unit? [GAC-Cubic meter (m3)/GAB-Cubic feet (ft3)/GAA-British thermal unit (btu)/GAD-Kilowatt hour (kWh)/GAE-Mega joules (MJ)/GAF-Therms (th)],Datastream,Special Type";
        CSVHelper.ImportMeterReads(path,col, serviceId,meterNo,readDate,"200","P","I","notes","","","E1","none");
        MeterImport.meterReadsImport(path);

    }
    @Test(priority = 4,enabled = true)
    public void Import_Meter_Reads_Consumption() throws Exception {
        extentTest = extent.startTest(" Meter Reads Import ");
        extentTest.setDescription(" Verify that User is able to   Import Meter reads");
        String path = System.getProperty("user.dir") + "/TestData/Meter Read Import Template - Manual.csv";
        String readDate = DateAndTime.DateTimeGenerator("dd/MM/yyyy");
        String col = "*Service ID,*Meter Number,*Date of Read,*Meter Read,*Period,*Read Type [I-Initial / A-Actual / C - Consumption / E-Estimate],Notes,Is Read Rollover? [Yes/No],Unit? [GAC-Cubic meter (m3)/GAB-Cubic feet (ft3)/GAA-British thermal unit (btu)/GAD-Kilowatt hour (kWh)/GAE-Mega joules (MJ)/GAF-Therms (th)],Datastream,Special Type";
        CSVHelper.ImportMeterReads(path,col, serviceId,meterNo,readDate,"250","P","C","notes","","","12","");
        MeterImport.meterReadsImport(path);
    }
}
