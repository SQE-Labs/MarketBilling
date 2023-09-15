package BrowsersBase;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static BrowsersBase.BrowsersInvoked.driver;

public interface DataInterface {

    public static String URL = "https://futurexenergyuat.utilibill.com.au/futurexenergy/";
    public static String Username = "sqeTest";
    public static String Password = "Sqe123!@#";
    public static String BaseURL = "https://futurexenergyuat.utilibill.com.au";
   public static String AdminURL = BaseURL + "/futurexenergy";

//    public static String URL= "https://dev01.utilitybilling.com/marketdev";
//    public static String  Username= "testreport+226@sqelabs.com";
//    public static String  Password= "test@1234";
//    public static String  groupName= "Markettest8887";
//    public static String BaseURL = "https://dev01.utilitybilling.com/marketdev";
//    public static String AdminURL = BaseURL + "/marketdev";

//    public static String URL = "https://markettest.utilibill.com.au/marketbilling/";
//    public static String Username = "testreport+226@sqelabs.com";
//    public static String Password = "test@1234";

//    public static String URL = "https://utility-qa02.utilitybilling.com/utilityqa02/";
//    public static String Username = "sqe.shilpa";
//    public static String Password = "Sqe123!@#";
//
//    public static String BaseURL = "https://markettest.utilibill.com.au";
//    public static String AdminURL = BaseURL + "/marketbilling/SrvAdministration";
   public static String browserMain = "Chrome";
   public static boolean autoDueDateEnabled = true;



}
