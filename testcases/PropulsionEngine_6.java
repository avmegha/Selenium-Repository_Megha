package testcases;

import java.io.IOException;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
import com.ults.selenium.pageobjects.ParticularsOfHulls;
import com.ults.selenium.pageobjects.PropulsionEnginesPage;
import com.ults.selenium.util.CacheManager;

public class PropulsionEngine_6 extends BaseConfiguration {

    public WebDriver driver;
    
   public PropulsionEngine_6(WebDriver driver) {
      this.driver = driver;
   }
    
    NewApplicationPage_4 newApplicationPage_4;
    ParticularsOfHulls_5 particularsOfHulls;  // Updated class name
    
    public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());

    public static final String EXCEL_FILE_PATH = "C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx";
    public static final String SHEET_NAME = "Sheet1";
    
    public void createEnginesAndClickNext() throws InterruptedException, IOException {
        // Assuming previous login and navigation methods exist before hull creation.
    	validateDropdowns2();         
    	validatenoOfSetsWithBHP();     
    	validateBrand(); 
    	validateModelNo();  
    	validateEngineType();
    	validateDiaOfPropShaft();
    	validateDepth();
    	validateGearType() ;
    	
        // Click the Next button after engine creation
    	PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton3 = wait.until(ExpectedConditions.visibilityOf(pe.getnextButton3()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", nextButton3);  
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
    }

    @Test(priority = 1)
    public void validateDropdowns2() throws IOException, InterruptedException {
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Utility method to scroll, click, and select from dropdown
        selectFromDropdown(pe.getNoOfGears(), "5", wait);
        selectFromDropdown(pe.getEngineSide(), "Port Side", wait);
        System.out.println("No of gears: 5, Side of Engine: Port Side");
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
    public void validatenoOfSetsWithBHP() throws IOException, InterruptedException {
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        validateField("noOfSetsWithBHP", pe.getnoOfSetsWithBHP(), 1, 1);
    }

    @Test(priority = 3)
    public void validateBrand() throws IOException, InterruptedException {
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        validateField("Brand", pe.getBrand(), 1, 2);
    }

    @Test(priority = 4)
    public void validateModelNo() throws IOException, InterruptedException {
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        validateField("Model No", pe.getModelNo(), 1, 3);
    }

    @Test(priority = 5)
    public void validateEngineType() throws IOException, InterruptedException {
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        validateField("Engine Type", pe.getEngineType(), 1, 4);
    }

    @Test(priority = 6)
    public void validateDiaOfPropShaft() throws IOException, InterruptedException {
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        validateField("Dia Of Prop Shaft", pe.getDiaOfPropShaft(), 1, 5);
    }

    @Test(priority = 7)
    public void validateDepth() throws IOException, InterruptedException {
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        validateField("Mat Of Prop Shaft", pe.getMatOfPropShaft(), 1, 6);
    }

    @Test(priority = 8)
    public void validateGearType() throws IOException, InterruptedException {
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);
        validateField("Gear Type", pe.getGearType(), 1, 7);
    }

    @Test(priority = 9)
    public void clickNext3() throws IOException, InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        PropulsionEnginesPage pe = new PropulsionEnginesPage(driver);

        WebElement nextButton3 = wait2.until(ExpectedConditions.visibilityOf(pe.getnextButton3()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", nextButton3);
        System.out.println("Next button clicked from Prop Engines successfully");
    }

    /**
     * Utility method to handle waiting for an element, reading data from Excel, and handling StaleElementReferenceException.
     */
    public void validateField(String fieldName, WebElement element, int row, int column) throws IOException, InterruptedException {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile(EXCEL_FILE_PATH, "Sheet4");
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
                // Optionally, you can re-locate the element here if necessary
                element = wait.until(ExpectedConditions.visibilityOf(element));
            }
        }
    }
}
