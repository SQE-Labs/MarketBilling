package CommonMethods;

import BrowsersBase.BrowsersInvoked;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static CommonMethods.BaseTest.extentTest;


public class WebDriverWaits extends BrowsersInvoked {
    static WebDriverWait wait = new WebDriverWait(driver, 10);
    static WebDriverWait wait20 = new WebDriverWait(driver, 20);
    static WebDriverWait wait5mins = new WebDriverWait(driver, 120);

    public static void WaitUntilPresent(By element) {
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public static void WaitUntilVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static void WaitUntilVisible5mins(By element) {
        wait5mins.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    public static void WaitUntilInvisible(By element) {
        wait.until(ExpectedConditions.invisibilityOf((WebElement) element));
    }

    public static WebElement WaitUntilVisibleWE(By element) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static WebElement WaitUntilVisibleWE20(By element) {
        return wait20.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static List<WebElement> WaitUntilVisibleList(By element) {
        return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
    }

    public static void ClickOn(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            WebElement ele = driver.findElement(element);
            ele.click();
            extentTest.log(LogStatus.PASS, "Clicked on : " + element);
        } catch (Exception e) {
            extentTest.log(LogStatus.FAIL, "Click failed  on : " + element + " with exception ");
            throw new RuntimeException(e);
        }

        //System.out.println("Clicked On " + element);
    }

    public static void SendKeys(By element, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement ele = driver.findElement(element);
        ele.sendKeys(value);
        extentTest.log(LogStatus.PASS, "Entered  " + value + " for element : " + element);
    }

    public static void SendKeysWithClear(By element, String value) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement ele = driver.findElement(element);
        ele.clear();
        ele.sendKeys(value);
        extentTest.log(LogStatus.PASS, "Entered  " + value + " for element : " + element);
    }

    public static void ClickOnWE(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void ClickOnWE20(WebElement element) {
        wait20.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public static void ClickAfter5mins(By element) {
        wait5mins.until(ExpectedConditions.elementToBeClickable(element));
        WebElement ele = driver.findElement(element);
        ele.click();
        extentTest.log(LogStatus.PASS, "Clicked on : " + element);

    }

    public static String GetText(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement ele = driver.findElement(element);
        String text = ele.getText();
        extentTest.log(LogStatus.PASS, "Text retrieved  " + text + " for element : " + element);

        return text;
    }

    public static void selectCheckBox(By element) {

        WebElement checkBoxElement = driver.findElement(element);
        boolean isSelected = checkBoxElement.isSelected();

//performing click operation if element is not checked
        if (isSelected == false) {
            checkBoxElement.click();
            extentTest.log(LogStatus.PASS, "Selected CheckBox  for element : " + element);

        }
    }

    public static void selectByValue(By element, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        WebElement ele = driver.findElement(element);
        ele.click();
        Select dropdown = new Select(ele);
        dropdown.selectByValue(value);
        extentTest.log(LogStatus.PASS, "Selected Dropdown with value  : " + value);

    }

    public static void scrollIntoView(By element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement ele = driver.findElement(element);
        jse.executeScript("arguments[0].scrollIntoView(true);", ele);
        extentTest.log(LogStatus.PASS, "Scrolled for element : " + element);


    }

    public static void selectByVisibleText(By element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        WebElement ele = driver.findElement(element);
        ele.click();
        Select dropdown = new Select(ele);
        dropdown.selectByVisibleText(text);
        extentTest.log(LogStatus.PASS, "Selected Dropdown with text  : " + text);

    }

    public static void selectByIndex(By element, int index) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        WebElement ele = driver.findElement(element);
        ele.click();
        Select dropdown = new Select(ele);
        dropdown.selectByIndex(index);
    }

    public static void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public static boolean isElementPresent(By by) {
        boolean exists = false;
        List list = driver.findElements(by);
        // We can verify the presence using list.size() or list.isEmpty()
        if (!list.isEmpty()) {
            exists = true;
        }
        return exists;
    }
}
