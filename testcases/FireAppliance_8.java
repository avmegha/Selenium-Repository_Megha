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
import com.ults.selenium.util.CacheManager;

public class FireAppliance_8 extends BaseConfiguration {
    public WebDriver driver;
    
    public FireAppliance_8(WebDriver driver) {
    	this.driver = driver;
    	}

    NewApplicationPage_4 newApplicationPage_4;
    ParticularsOfHulls_5 particularsOfHulls;  
    PropulsionEngine_6 propulsionEngine;
    ParticularsOfEquipment_7 particularsOfEquipment;

    public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());

    public static final String EXCEL_FILE_PATH = "C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx";
    public static final String SHEET_NAME = "Sheet1";
    
    public void createFireApplianceAndClickNext() throws InterruptedException, IOException {
        // Assuming previous login and navigation methods exist before hull creation.
                
        validateFirePumps();   
        validateFireMains();
        validateDropdowns4();    
        
            // Click the Next button after fire appliance creation
            ParticularsOfFireAppliancePage pf = new ParticularsOfFireAppliancePage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement nextButton5 = wait.until(ExpectedConditions.visibilityOf(pf.getnextButton5()));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", nextButton5);  
            System.out.println("Next button clicked successfully after fire appliance creation.");
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

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        particularsOfHulls = new ParticularsOfHulls_5(driver);  // Updated instantiation
        particularsOfHulls.createHullsAndClickNext();

        System.out.println("Hulls Details given and Next button clicked. Ready for Propulsion of Engine tests.");
        
        propulsionEngine = new PropulsionEngine_6(driver);  // Updated instantiation
        propulsionEngine.createEnginesAndClickNext();
        
        System.out.println("Engine Details given and Next button clicked. Ready for Particulars of equipment tests.");
        
        particularsOfEquipment = new ParticularsOfEquipment_7(driver);  // Updated instantiation
        particularsOfEquipment.createEquipmentsAndClickNext();
        
        System.out.println("Equipments Details given and Next button clicked. Ready for Particulars of fire appliance tests.");
    }

    @Test(priority = 3)
    public void validateDropdowns4() throws IOException, InterruptedException {
        ParticularsOfFireAppliancePage pf = new ParticularsOfFireAppliancePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Utility method to scroll, click, and select from dropdown
        selectFromDropdown(pf.getNoOfHyd(), "5", wait);
        selectFromDropdown(pf.getNoOfHose(), "6", wait);
        selectFromDropdown(pf.getNozzles(), "Jet type", wait);
        System.out.println("No of Hydrants: 5, No of Hoses: 6, Nozzles: Jet type");
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
    
    @Test(priority = 1)
    public void validateFirePumps() throws IOException, InterruptedException {
        try {
            ParticularsOfFireAppliancePage pf = new ParticularsOfFireAppliancePage(driver);
            log.info("Instantiating ParticularsOfFireAppliancePage.");
            validateField("FirePumpSize", pf.getFirePumpSize(), 1, 1);
            validateField("FirePumpCapacity", pf.getFirePumpCapacity(), 1, 2);
            log.info("Fire pump validations completed.");
        } catch (Exception e) {
            log.error("Exception in validateFirePumps: " + e.getMessage(), e);
        }
    }


    @Test(priority = 2)
    public void validateFireMains() throws IOException, InterruptedException {
        ParticularsOfFireAppliancePage pf = new ParticularsOfFireAppliancePage(driver);
        validateField("FireMainsDia", pf.getFireMainsDia(), 1, 3);
        validateField("FireMainsMat", pf.getFireMainsMat(), 1, 4);
        validateField("AnyOtherEquip", pf.getAnyOtherEquip(), 1, 5);
    }

    @Test(priority = 4)
    public void clickNext5() throws IOException, InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        ParticularsOfFireAppliancePage pf = new ParticularsOfFireAppliancePage(driver);

        WebElement nextButton5 = wait2.until(ExpectedConditions.elementToBeClickable(pf.getnextButton5()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", nextButton5);
        System.out.println("Next button clicked from fire appliance page successfully");
    }

    /**
     * Utility method to handle waiting for an element, reading data from Excel, and handling StaleElementReferenceException.
     */
    public void validateField(String fieldName, WebElement element, int row, int column) throws IOException, InterruptedException {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile(EXCEL_FILE_PATH, "Sheet6");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        String fieldValue = excelUtils.getCellData(row, column);

        // Scroll to the element and click it
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        // Retry mechanism for handling stale elements
        for (int i = 0; i < 3; i++) {
            try {
                WebElement fieldElement = wait.until(ExpectedConditions.visibilityOf(element));
                fieldElement.clear(); // Clear the field if necessary
                fieldElement.sendKeys(fieldValue);
                System.out.println(fieldName + ": " + fieldValue);
                break; // Exit the loop if successful
            } catch (StaleElementReferenceException e) {
                System.out.println("Encountered stale element while entering " + fieldName + ", retrying...");
                element = wait.until(ExpectedConditions.visibilityOf(element)); // Re-locate the element if stale
            }
        }
    }
}
