package helper;

import CommonMethods.WebDriverWaits;
import org.openqa.selenium.WebElement;
import POM.Services;
import java.util.ArrayList;
import java.util.List;

import static BrowsersBase.BrowsersInvoked.driver;
import static POM.Services.*;

public class Navigation  {

    public static void searchResults() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> EditIcon = driver.findElements( edit_icon);
        if (EditIcon.size() == 2) {
            WebDriverWaits.ClickOn(twoSearchResults);


        }



    }

}
