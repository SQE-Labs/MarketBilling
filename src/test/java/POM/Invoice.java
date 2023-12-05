package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;

import static BrowsersBase.BrowsersInvoked.driver;

public class Invoice {
    public static By createInvoiceBtn = By.xpath("//a[text()=' Create new invoice']");
    public static By invoice_name = By.id("invoice_name");
    public static By saveInvoice = By.id("saveInvoice");
    public static By category = By.id("category");
    public static By invoice_content_area_ifr = By.id("invoice_content_area_ifr");
    public static By saveTemplate = By.id("saveTemplate");
    public static By okBtn = By.xpath("//button[text()='OK']");
    public static By finishBtn = By.className("icon-arrow-right");
    public static By editBtn = By.className("icon-edit");
    public static By search = By.xpath("//label/input");
    public static By tinymce = By.xpath("//body[@id='tinymce']");
    public static By saveSettings = By.id("save");
    public static By backToInvoice =By.xpath("//*[@id=\"invoiceContent\"]/div[1]/a");

    public static String invoiceName;

    public static void clickCreateNewInvoiceBtn() {
        WebDriverWaits.ClickOn(createInvoiceBtn);
    }
    public static void enterNewInvoice(String invoiceName) {
        WebDriverWaits.SendKeys(invoice_name, invoiceName);
    }

    public static void searchInvoice(String invoiceName) {
        WebDriverWaits.SendKeys(search, invoiceName);
    }

    public static void click_EditInvoiceBtn() {
        WebDriverWaits.ClickOn(editBtn);
    }

    public static void selectInvoiceCheckBox(String checkBoxId) {
        WebDriverWaits.scrollIntoView(By.id(checkBoxId));
        WebDriverWaits.selectCheckBox(By.id(checkBoxId));
    }

    public static void clickSave() {
        WebDriverWaits.ClickOn(saveInvoice);
    }

    public static void click_BackToInvoice() {
        WebDriverWaits.scrollIntoView(backToInvoice);
        WebDriverWaits.ClickOn(backToInvoice);
    }


    public static void clickOkbtn() {
        WebDriverWaits.ClickOn(okBtn);
    }

    public static void selectCategory(String name) throws InterruptedException {
        WebDriverWaits.WaitUntilVisibleWE(category);
        WebDriverWaits.selectByIndex(category, 0);
        Thread.sleep(4000);
    }

    public static void create_Invoice(String selectCategory1Txt, String selectCategory2Txt, String selectCategory3Txt, String templateTxt) throws InterruptedException {
        clickCreateNewInvoiceBtn();
        invoiceName="Invoice"+ RandomStrings.RequiredDigits(3);
        enterNewInvoice(invoiceName);
        selectInvoiceCheckBox(selectCategory1Txt);
        selectInvoiceCheckBox(selectCategory2Txt);
        clickSave();
        Thread.sleep(3000);
        selectCategory(selectCategory3Txt);
        //enterTemplateText(templateTxt);
        clickSaveTemplate();
        //click_BackToInvoice();
    }

    public static void edit_Invoice(String selectCategory1Txt, String selectCategory2Txt, String selectCategory3Txt, String selectCategory4Txt,String templateTxt) throws InterruptedException {
        searchInvoice(invoiceName);
        click_EditInvoiceBtn();
        selectInvoiceCheckBox(selectCategory1Txt);
        selectInvoiceCheckBox(selectCategory2Txt);
        selectInvoiceCheckBox(selectCategory3Txt);
        clickSave();
        selectCategory(selectCategory4Txt);
       // enterTemplateText(templateTxt);
        clickSaveTemplate();
    }

    public static void enterTemplateText(String txt) {

        driver.switchTo().frame(1);
        WebDriverWaits.WaitUntilVisible(tinymce);
        WebDriverWaits.ClickOn(tinymce);
        WebDriverWaits.SendKeysWithClear(tinymce, txt);
        driver.switchTo().parentFrame();

    }

    public static void clickSaveTemplate() {
        WebDriverWaits.scrollIntoView(saveTemplate);
        WebDriverWaits.ClickOn(saveTemplate);
        WebDriverWaits.WaitUntilVisible(okBtn);
        WebDriverWaits.ClickOn(okBtn);
        WebDriverWaits.scrollIntoView(backToInvoice);
        WebDriverWaits.ClickOn(backToInvoice);

    }

    public static void createNewInvoice(String invoiceName) throws InterruptedException {
        WebDriverWaits.ClickOn(createInvoiceBtn);
        WebDriverWaits.SendKeys(invoice_name, invoiceName);
        Invoice.selectInvoiceCheckBox("TRANSACTION-SUMMARY");
        Invoice.selectInvoiceCheckBox("TRANSACTION-SUMMARY-LIST");
        Invoice.selectInvoiceCheckBox("BILLPAY");
        Invoice.clickSave();
        Invoice.selectCategory("BILLPAY");
        Invoice.enterTemplateText("Personalised customer Sample  edited template text");
        Invoice.clickSaveTemplate();
    }
}
