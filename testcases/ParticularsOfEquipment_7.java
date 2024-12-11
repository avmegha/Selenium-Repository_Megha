package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ults.selenium.configurationfiles.BaseConfiguration;
import com.ults.selenium.configurationfiles.ExcelUtils;
import com.ults.selenium.pageobjects.ParticularsOfEquipmentPage;
import com.ults.selenium.pageobjects.ParticularsOfFireAppliancePage;
import com.ults.selenium.pageobjects.PropulsionEnginesPage;
import com.ults.selenium.util.CacheManager;

public class ParticularsOfEquipment_7 extends BaseConfiguration{
public WebDriver driver;

public ParticularsOfEquipment_7(WebDriver driver) {
this.driver = driver;
}
    NewApplicationPage_4 newApplicationPage_4;
    ParticularsOfHulls_5 particularsOfHulls;  
    PropulsionEngine_6 propulsionEngine;
   
    public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());

    public static final String EXCEL_FILE_PATH = "C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx";
    public static final String SHEET_NAME = "Sheet1";
   
    public void createEquipmentsAndClickNext() throws InterruptedException, IOException {
    // Assuming previous login and navigation methods exist before hull creation.
    validateDropdowns3();        
    validatePort();    
    validateStarboard();
    validateSpare();  
    validateRope();
    validateLight();
    validateBuoy();
    
        // Click the Next button after equipment creation
   ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton4 = wait.until(ExpectedConditions.visibilityOf(peq.getnextButton4()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", nextButton4);  
        System.out.println("Next button clicked successfully after engine creation.");
    }

    @BeforeTest
    public void setUp() throws IOException, InterruptedException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        driver.get(CacheManager.getString(selenium_test_url_kmp));
        log.info("Navigated to Home page");

        newApplicationPage_4 = new NewApplicationPage_4(driver);
        newApplicationPage_4.createVesselAndClickNext();

        System.out.println("Owner Details given and Next button clicked. Ready for Particulars of Hulls tests.");
        Thread.sleep(3000); // Consider using WebDriverWait instead of Thread.sleep()

        particularsOfHulls = new ParticularsOfHulls_5(driver);  // Updated instantiation
        particularsOfHulls.createHullsAndClickNext();

        System.out.println("Hulls Details given and Next button clicked. Ready for Propulsion of Engine tests.");
        Thread.sleep(3000); // Consider using WebDriverWait instead of Thread.sleep()
       
        propulsionEngine = new PropulsionEngine_6(driver);  // Updated instantiation
        propulsionEngine.createEnginesAndClickNext();
       
        System.out.println("Engine Details given and Next button clicked. Ready for Particulars of equipment tests.");
        Thread.sleep(3000); // Consider using WebDriverWait instead of Thread.sleep()
             
    }
    @Test(priority = 1)
    public void validateDropdowns3() throws IOException, InterruptedException {
    ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Utility method to scroll, click, and select from dropdown
        selectFromDropdown(peq.getNoOfRopes(), "5", wait);
        selectFromDropdown(peq.getNoOfSearchLight(), "6", wait);
        selectFromDropdown(peq.getSoundSignals(), "Mechanical", wait);
        System.out.println("No of Ropes: 5, No of serach lights: 6, Sound Signals: Mechanical");
    }

    /**
     * Utility method to handle scrolling, clicking, and selecting from a dropdown.
     */
    public void selectFromDropdown(WebElement dropdown, String visibleText, WebDriverWait wait) {
        // Scroll to the dropdown
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);

        // Try clicking the dropdown normally or using JS as a fallback
        try {
            wait.until(ExpectedConditions.elementToBeClickable(dropdown)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
        }

        // Select the option from the dropdown
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }
   
    @Test(priority = 2)
    public void validatePort() throws IOException, InterruptedException {
    ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);
        validateField("PortWt", peq.getPortWt(), 1, 1);
        validateField("PortMat", peq.getPortMat(), 1, 2);
        validateField("PortChainType", peq.getPortChainType(), 1, 7);
        validateField("PortChainSize", peq.getPortChainSize(), 1, 8);
        validateField("PortChainLength", peq.getPortChainLength(), 1, 9);
    }

    @Test(priority = 3)
    public void validateStarboard() throws IOException, InterruptedException {
    ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);
        validateField("StarboardWt", peq.getStarboardWt(), 1, 3);
        validateField("StarboardMat", peq.getStarboardMat(), 1, 4);
        validateField("StChainType", peq.getStChainType(), 1, 10);
        validateField("StChainSize", peq.getStChainSize(), 1, 11);
        validateField("StChainLength", peq.getStChainLength(), 1, 12);
    }

    @Test(priority = 4)
    public void validateSpare() throws IOException, InterruptedException {
    ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);
        validateField("SpareWt", peq.getSpareWt(), 1, 5);
        validateField("SpareMat", peq.getSpareMat(), 1, 6);
    }

    @Test(priority = 5)
    public void validateRope() throws IOException, InterruptedException {
    ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);
        validateField("RopeSize", peq.getRopeSize(), 1, 13);
        validateField("RopeMat", peq.getRopeMat(), 1, 14);
    }
    @Test(priority = 6)
    public void validateLight() throws IOException, InterruptedException {
    ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);
        validateField("LightSize", peq.getLightSize(), 1, 15);
        validateField("LightPower", peq.getLightPower(), 1, 16);
        validateField("NavLight", peq.getNavLight(), 1, 19);
    }
    @Test(priority = 7)
    public void validateBuoy() throws IOException, InterruptedException {
    ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);
        validateField("LifeBuoy", peq.getLifeBuoy(), 1, 17);
        validateField("BuoyantLanyard", peq.getBuoyantLanyard(), 1, 18);
    }

   @Test(priority = 9)
    public void clickNext4() throws IOException, InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver);

        WebElement nextButton4 = wait2.until(ExpectedConditions.visibilityOf(peq.getnextButton4()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", nextButton4);
        System.out.println("Next button clicked from part of equipment successfully");
    }


    /**
     * Utility method to handle waiting for an element, reading data from Excel, and handling StaleElementReferenceException.
     */
   public void validateField(String fieldName, WebElement element, int row, int column) throws IOException, InterruptedException {
       ExcelUtils excelUtils = new ExcelUtils();
       excelUtils.setExcelFile(EXCEL_FILE_PATH, "Sheet5");
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

       String fieldValue = excelUtils.getCellData(row, column);

       // Scroll into view and handle click interception using a fallback
       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
       try {
           wait.until(ExpectedConditions.elementToBeClickable(element)).click();
       } catch (ElementClickInterceptedException e) {
           ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
       }

       // Retry mechanism for stale elements
       for (int i = 0; i < 3; i++) {
           try {
               WebElement fieldElement = wait.until(ExpectedConditions.visibilityOf(element));
               fieldElement.clear();
               fieldElement.sendKeys(fieldValue);
               System.out.println(fieldName + ": " + fieldValue);
               break;
           } catch (StaleElementReferenceException e) {
               System.out.println("Stale element encountered, retrying " + fieldName + "...");
               element = wait.until(ExpectedConditions.visibilityOf(element));
           }
       }
   }
}