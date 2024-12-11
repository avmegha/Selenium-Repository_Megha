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
import com.ults.selenium.pageobjects.NewApplicationPage;
import com.ults.selenium.pageobjects.ParticularsOfHulls;
import com.ults.selenium.util.CacheManager;

public class ParticularsOfHulls_5 extends BaseConfiguration {

	WebDriver driver;

     //Constructor with WebDriver parameter
   public ParticularsOfHulls_5(WebDriver driver) {
       this.driver = driver;
  }
    NewApplicationPage_4 newApplicationPage_4;
    public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());

    public static final String EXCEL_FILE_PATH = "C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx";
    public static final String SHEET_NAME = "Sheet1";
    
    public void createHullsAndClickNext() throws InterruptedException, IOException {
        // Assuming previous login and navigation methods exist before hull creation.
    	validateDropdowns();         
    	validateMHull();     
    	validatePCapacity(); 
    	validateLengthOverall();  
    	validateLengthOnDeck();
    	validateBreadth();
    	validateDepth();
    	validateBHP() ;
    	validateBHT();
    	validateHPM();
    	validateHPT();

        // Click the Next button after vessel creation
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton2 = wait.until(ExpectedConditions.visibilityOf(ph.getnextButton2()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", nextButton2);  
        System.out.println("Next button clicked successfully after hull creation.");
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
    }

    @Test(priority = 1)
    public void validateDropdowns() throws IOException, InterruptedException {

        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Utility method to scroll, click, and select from dropdown
        selectFromDropdown(ph.getselectBuilder(), "ULTS Test", wait);
        selectFromDropdown(ph.getdeckAboveFreeBoard(), "Yes", wait);
        selectFromDropdown(ph.getyard(), "UL", wait);
        System.out.println("Builder: Test Builder, Deck above free board: Yes, Yard: UL");
    }

    /**
     * Utility method to handle scrolling, clicking, and selecting from a dropdown.
     * @throws InterruptedException 
     */
    public void selectFromDropdown(WebElement dropdown, String visibleText, WebDriverWait wait) throws InterruptedException {
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
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void validateMHull() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Material Of Hull", ph.getmaterialOfHull(), 1, 1);
    }

    @Test(priority = 3)
    public void validatePCapacity() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Passenger Capacity", ph.getpassengerCapacity(), 1, 2);
    }

    @Test(priority = 4)
    public void validateLengthOverall() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Length Overall", ph.getlengthOverall(), 1, 3);
    }

    @Test(priority = 5)
    public void validateLengthOnDeck() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Length On Deck", ph.getlengthOnDeck(), 1, 4);
    }

    @Test(priority = 6)
    public void validateBreadth() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Breadth", ph.getbreadth(), 1, 5);
    }

    @Test(priority = 7)
    public void validateDepth() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Depth", ph.getdepth(), 1, 6);
    }
    @Test(priority = 8)
    public void validateFrame() throws IOException, InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Increased timeout to 60 seconds

        // Try waiting for the presence of the iframe first
        WebElement frameElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/iframe[1]")));
        
        // Wait for the visibility of the iframe before switching
        wait.until(ExpectedConditions.visibilityOf(frameElement));

        driver.switchTo().frame(frameElement);
    }

    @Test(priority = 9)
    public void validateBHP() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Bulk Head Placement", ph.getbulkHeadsPlacement(), 1, 7);
    }

    @Test(priority = 10)
    public void validateBHT() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Bulk Head Thickness", ph.getbulkHeadsThickness(), 1, 8);
    }

    @Test(priority = 11)
    public void validateHPM() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Hull Plating Material", ph.gethullPlatingMaterial(), 1, 9);
    }

    @Test(priority = 12)
    public void validateHPT() throws IOException, InterruptedException {
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);
        validateField("Hull Plating Thickness", ph.gethullPlatingThickness(), 1, 10);
        driver.switchTo().defaultContent(); // Switch back to the default content after completing the frame interaction
    }

    @Test(priority = 13)
    public void clickNext2() throws IOException, InterruptedException {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        ParticularsOfHulls ph = new ParticularsOfHulls(driver);

        WebElement nextButton2 = wait2.until(ExpectedConditions.visibilityOf(ph.getnextButton2()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", nextButton2);
        System.out.println("Next button clicked from POH successfully");
    }

    /**
     * Utility method to handle waiting for an element, reading data from Excel, and handling StaleElementReferenceException.
     */
    public void validateField(String fieldName, WebElement element, int row, int column) throws IOException, InterruptedException {
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile(EXCEL_FILE_PATH, "Sheet3");
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
