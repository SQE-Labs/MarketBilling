package TestCases;
import CommonMethods.BaseTest;
import CommonMethods.DateAndTime;
import CommonMethods.RandomStrings;
import POM.*;
import org.testng.annotations.Test;
import java.util.Random;
public class Imports extends BaseTest {
    String meterNo;
    String serviceId;
    String customerId;

    @Test(priority = 1, enabled = true)
    public void Import_Customers() throws Exception {
        String columnData = "Alternative Customer Number,Category,Customer Type,Salutation,First Name,Surname,Billing Address,Billing Address2,Billing Suburb,Billing State,Billing Postal (Zip) Code,Billing Country,Phone Number,Mobile Number,Fax Number,Email Address,Company,Business Name Type,Company Trading Name,ABN,ACN,Notes/Feedbacks,Is Home Address same as Billing Address?,Home Address,Home Address2,Home Suburb,Home State,Home Postal (Zip) Code,Home Country,Billing Email,Account Name,Authentication Type,Authentication Number,Date of Birth,Referee Name,Referee Contact Number,Referee Relationship to Tenant,Enable Internet Access?,Internet Password,Secondary Customer Name,Secondary Phone Number,Secondary Mobile Number,Secondary Fax Number,Secondary Email,Life Support Status,Purchase Order,Contract Start Date,Contract Term,Overdue Interest % (Base Rate) ,Overdue Interest % (Additional) ,Early Payment Discount,Early Payment Discount Rate,Payment Term Method ,Payment Term Number of Days ,Card First Name,Card Last Name,Card Type,Card No.,Card Start Date,Card Expiry Date";
        System.out.println("user.dir");
        String filePath = System.getProperty("user.dir") + "/TestData/Customer_Import.csv";
       // C:\Users\Itsqe\Downloads\MarketBilling-main\MarketBilling-main\test-output

                String category ="R";
        String firstName = Data.FirstName.getFirstName().toString();
        String lastName = Data.LastName.getLastName().toString();
        String billingAddress = "" + RandomStrings.RequiredCharacters(10);
//        String billing suburb= "Victorian Suburb"
//        String Billing State="VIC";
//        String Billing Postal (Zip) Code= "3"+RandomStrings.RequiredDigits(3);
//        String Billing Country=
//        String postalCode =  RandomStrings.RequiredDigits("4");
        String phoneNumber = "03" + RandomStrings.RequiredDigits(8);
        String MobileNumber = "0" + RandomStrings.RequiredDigits(9);
        String emailAddress = firstName + lastName + "@yopmail.com";
//        String CardFirstName = "Glen" + RandomStrings.RequiredCharacters("5");
//        String CardLastName= "Maxwell" + RandomStrings.RequiredCharacters("5");
//        String CardStartDate=
//        String CardExpiryDate=
        String futureDate = DateAndTime.futureDateGenerator("");
        String rowData = ",R,Tenant,Mr,"+firstName+","+lastName+",Madirma R-Town, MILLS NY, WA 1265,,Victorian ,VIC,3401,Australia,"+phoneNumber+","+MobileNumber+", ,"+emailAddress+", , , , , Yes, , , , , , , , , , , , , , , , , , , , , , , , , , , , , , , ,Gilli,Andrews,VAC,4200000000000000,"+futureDate+",09/03/2041";
        // rowData= rowData.replace();
        String[] row = rowData.split(",");
        String[] column = columnData.split(",");

        CSVHelper.createCSVGeneric(filePath, column, row);
       // Imports importObj = Admin.navigateToAdmin();
        //importObj.importFile(filePath, "Customer");

    }

    @Test(priority = 0,enabled = false)
    public void Add_Customer_and_Service_for_Imports() throws Exception {
         extentTest = extent.startTest("Add_Customer_and_Service");
		 customerId = Customer.createCustomer("Tenant", "Commercial", "residential123@yopmail.com");
		 serviceId= Services.M_AddService(customerId);
		 Services.EditService();
         // customerId="40999";
         //   serviceId="8916573225";

	}

    @Test(priority = 1,enabled = false)
    public void Import_Meter_Number() throws Exception {
        extentTest = extent.startTest(" Meter Number import ");
        extentTest.setDescription(" Verify that User is able to run meter number import");
         int random2 = (new Random()).nextInt(900) + 100;
        String meterImport_FilePath = System.getProperty("user.dir") + "/TestData/Electricity - Meter Import Template.csv";
        String col = "*Service ID,*Meter Serial Number,*Status,*Consumption Type,*Configuration,Multiplier,Constant,Hazard,Location,Additional Site Info,Meter Point ID,Next Scheduled Read Date,Manufacturer,Model,Meter Read Type,Route,Walk Order,*Meter Installation Type,*Date Connected,Date Removed";
         meterNo = "TestMeter" + random2;
       //  meterNo="Meters359";
        String prodate = DateAndTime.DateTimeGenerator("dd/MM/yyyy");
        CSVHelper.ImportMeterNumber(meterImport_FilePath, col, serviceId, meterNo, "Current", "Cumulative", "POS", "", "", "", "", "", "", "", "", "", "", "", "", "BASIC", prodate, "");
        MeterImport.meterNumberImport(meterImport_FilePath);
    }

    @Test(priority = 2,enabled = false)
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
    @Test(priority = 3,enabled = false)
    public void Import_Meter_Reads_Initial() throws Exception {
        extentTest = extent.startTest(" Meter Reads Import ");
        extentTest.setDescription(" Verify that User is able to   Import Meter reads");
        String path = System.getProperty("user.dir") + "/TestData/Meter Read Import Template - Manual.csv";
        String readDate = DateAndTime.DateTimeGenerator("dd/MM/yyyy");
        //meterNo="Meters359";
        String col = "*Service ID,*Meter Number,*Date of Read,*Meter Read,*Period,*Read Type [I-Initial / A-Actual / C - Consumption / E-Estimate],Notes,Is Read Rollover? [Yes/No],Unit? [GAC-Cubic meter (m3)/GAB-Cubic feet (ft3)/GAA-British thermal unit (btu)/GAD-Kilowatt hour (kWh)/GAE-Mega joules (MJ)/GAF-Therms (th)],Datastream,Special Type";
        CSVHelper.ImportMeterReads(path,col, serviceId,meterNo,readDate,"100","P","I","notes","","","E1","none");
        MeterImport.meterReadsImport(path);

    }
    @Test(priority = 4,enabled = false)
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
