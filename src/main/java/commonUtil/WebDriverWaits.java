package commonUtil;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebDriverWaits extends BrowsersInvoked{


	   		public static void WaitUntilPresent(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
		    wait.until(ExpectedConditions.presenceOfElementLocated (element)); }
		    
	   		public static void WaitUntilVisible(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);

				wait.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	   		
	   		public static void WaitUntilVisible5mins(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 5;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
				wait.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	
	   		
	   		public static void WaitUntilInvisible(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
				wait.until(ExpectedConditions.invisibilityOf((WebElement) element)); }
	   		
	   		public static WebElement WaitUntilVisibleWE(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
				return wait.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	   		   		
	   		public static WebElement WaitUntilVisibleWE20(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 20;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
				return wait.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	   		
	   		public static List <WebElement> WaitUntilVisibleList(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
				return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element)); }
	   		
		    public static void ClickOn(By element,Integer... timeout) {
				 Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		        wait.until(ExpectedConditions.elementToBeClickable(element));
		        WebElement ele = driver.findElement(element);
		        ele.click();}
		    
		    public static void SendKeys(By element, String value,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);

				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		        WebElement ele = driver.findElement(element);
		        ele.sendKeys(value);}
		    
		    public static void ClickOnWE(WebElement element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
				wait.until(ExpectedConditions.elementToBeClickable(element));
		        element.click();}
		    
		    public static void ClickOnWE20(WebElement element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);

				wait.until(ExpectedConditions.elementToBeClickable(element));
		        element.click();}
		    
		    public static void ClickAfter5mins(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);

				wait.until(ExpectedConditions.elementToBeClickable(element));
		        WebElement ele = driver.findElement(element);
		        ele.click();}
			    
		    public static String GetText(By element,Integer... timeout) {
				Integer timeoutVal = timeout.length > 0 ? timeout[0] : 2;
				WebDriverWait wait = new WebDriverWait(driver,timeoutVal);
				wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		        WebElement ele = driver.findElement(element);
		        String text = ele.getText();
		        return text;}
}
