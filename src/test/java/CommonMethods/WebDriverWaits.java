package CommonMethods;

import BrowsersBase.BrowsersInvoked;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;


public class WebDriverWaits extends BrowsersInvoked {
	static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	static WebDriverWait wait20 = new WebDriverWait(driver, Duration.ofSeconds(10));
	static WebDriverWait wait80 = new WebDriverWait(driver, Duration.ofSeconds(90));
	static WebDriverWait wait5mins = new WebDriverWait(driver, Duration.ofSeconds(10));

	public static void WaitUntilPresent(By element) {
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public static void WaitUntilVisible(By element) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static void Waituntilvisible(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(20)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (TimeoutException e) {
			WebElement ele = driver.findElement(element);
			ele.click();

		}
	}

	public static void WaitUntilVisible5mins(By element) {
		wait5mins.until(ExpectedConditions.visibilityOfElementLocated(element));
	}


	public static void refreshPage() {
		driver.navigate().refresh();
	}

	public static WebElement WaitUntilVisibleWE(By element) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static WebElement WaitUntilVisibleWE20(By element) {
		return wait20.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static WebElement WaitUntilVisibleWE80(By element) {
		return wait80.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public static List<WebElement> WaitUntilVisibleList(By element) {
		return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
	}

	public static void ClickOn(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(15)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
		}
		WebElement ele = driver.findElement(element);
		ele.click();
		//System.out.println("Clicked On " + element);
	}

	public static void ClickOnE(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(15)));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (ElementClickInterceptedException e) {

		}
		WebElement ele = driver.findElement(element);
		ele.click();
		//System.out.println("Clicked On " + element);
	}


	public static void SendKeys(By element, String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		ele.sendKeys(value);
		//System.out.println(ele+" ------"+value);
	}

	public static void SendKeysWithClear(By element, String value) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		ele.clear();
		ele.sendKeys(value);
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
	}

	public static String GetText(By element) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		WebElement ele = driver.findElement(element);
		String text = ele.getText();
		return text;
	}

	public static void selectCheckBox(By element) {

		WebElement checkBoxElement = driver.findElement(element);
		boolean isSelected = checkBoxElement.isSelected();

//performing click operation if element is not checked
		if (isSelected == false) {
			checkBoxElement.click();
		}
	}

	public static void toggleButton(By element, boolean value) {

		WebElement checkBoxElement = driver.findElement(element);
		String data = checkBoxElement.getAttribute("data-on");

//performing click operation if element is not checked
		if (data != "Yes") {
			checkBoxElement.click();
		}
	}

	public static void selectByValue(By element, String value) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement ele = driver.findElement(element);
		ele.click();
		Select dropdown = new Select(ele);
		dropdown.selectByValue(value);
	}

	public static void scrollIntoView(By element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(element);
		jse.executeScript("arguments[0].scrollIntoView(true);", ele);

	}

	public static void scrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(2000);

	}

	public static void scrollPageEnd() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

	}

	public static void selectByVisibleText(By element, String text) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		WebElement ele = driver.findElement(element);
		ele.click();
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(text);
	}

	public static void WaitUntilSelect(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, (Duration.ofSeconds(15)));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeSelected(element));
			WebElement ele = driver.findElement(element);
		} catch (TimeoutException e) {

		}
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

	public static void CloseOtherTabs() throws InterruptedException {
		String originalHandle = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();

		for (String handle : tabs) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(originalHandle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);
		System.out.print(driver.getCurrentUrl());
		Thread.sleep(3000);
	}

	public static void SwitchToNewTab() throws InterruptedException {
		String originalHandle = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();

		for (String handle : tabs) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
			}
		}
	}

	public static void SwitchToParentTab() {
		String originalHandle = driver.getWindowHandle();
		Set<String> tabs = driver.getWindowHandles();

		for (String handle : tabs) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().defaultContent();
			}
		}
	}


	public static void SwitchToFrameId(String id) throws InterruptedException {
		driver.switchTo().frame(id);
		Thread.sleep(2000);
	}

	public static void SwitchToParentFrame() throws InterruptedException {
		driver.switchTo().parentFrame();
		Thread.sleep(2000);
	}


	public static void uploadFileUsingRobot(String filepath) throws AWTException {
		// creating object of Robot class
		Robot rb = new Robot();

		// copying File path to Clipboard
		StringSelection str = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	//create method moveToelemenet
	public static WebElement moveToelemenet(WebElement element) {
		Actions s = new Actions(driver);
		s.moveToElement(element).click().build().perform();
        return element;
    }

	public static WebElement byToWebElement(By by) {
		return driver.findElement(by);
	}
	public static void clickOnMoveToElemenet(By element) {
		Actions s = new Actions(driver);
		byToWebElement(element).click();

	}
}
