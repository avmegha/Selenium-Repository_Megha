package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ults.selenium.configurationfiles.BaseConfiguration;
import com.ults.selenium.configurationfiles.ExcelUtils;
import com.ults.selenium.pageobjects.AdditionalInformationPage;
import com.ults.selenium.pageobjects.NewVesselPage;
import com.ults.selenium.pageobjects.ParticularsOfFireAppliancePage;
import com.ults.selenium.pomcollection.pomFile;
import com.ults.selenium.util.CacheManager;

public class AdditionalInfo_9 extends BaseConfiguration {
	public WebDriver driver;
	
	public AdditionalInfo_9(WebDriver driver) {
    	this.driver = driver;
    	}
	
    NewApplicationPage_4 newApplicationPage_4;
    ParticularsOfHulls_5 particularsOfHulls;  
    PropulsionEngine_6 propulsionEngine;
    ParticularsOfEquipment_7 particularsOfEquipment;
    FireAppliance_8 fireAppliance;
    
    public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());

    public static final String EXCEL_FILE_PATH = "C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx";
    public static final String SHEET_NAME = "Sheet1";
    
    public void createAddInfoAndClickNext() throws InterruptedException, IOException {
        // Assuming previous login and navigation methods exist before hull creation.
    	validateNoOfPortableFE();        
    	validateFireExt();   
    	validateDevices();
    	validateWater();
               
            // Click the Next button after addInfo creation
    	    AdditionalInformationPage ai=new  AdditionalInformationPage(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement nextButton6 = wait.until(ExpectedConditions.visibilityOf(ai.getnextButton6()));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", nextButton6);  
            System.out.println("Next button clicked successfully after add info creation.");
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
   
        fireAppliance = new FireAppliance_8(driver);  // Updated instantiation
        fireAppliance.createFireApplianceAndClickNext();
        
        System.out.println("Fire appliance details given and Next button clicked. Ready for Additional Information tests.");
    }
    
@Test(priority = 1)  
public void validateNoOfPortableFE() {
        
	AdditionalInformationPage ai=new  AdditionalInformationPage(driver); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ai.getnoOfPortableFE())).click();
        System.out.println("Number of portable Fire extinguisher :5");
}
   @Test(priority = 2)
   public void validateFireExt() throws IOException, InterruptedException {
	   AdditionalInformationPage ai=new  AdditionalInformationPage(driver); 
       validateField("sodaAcid", ai.getsodaAcid(), 1, 1);
       validateField("foam", ai.getfoam(), 1, 2);
       validateField("dryPowder", ai.getdryPowder(), 1, 3);
       validateField("anyOtherTypes", ai.getanyOtherTypes(), 1, 4);
   }

   @Test(priority = 3)
   public void validateDevices() throws IOException, InterruptedException {
	   AdditionalInformationPage ai=new  AdditionalInformationPage(driver);
	   
       validateField("partOfCommEquip", ai.getpartOfCommEquip(), 1, 5);
       validateField("partOfPollCtrlDevices", ai.getpartOfPollCtrlDevices(), 1, 6);
       validateField("sewTreatAndDisposal", ai.getsewTreatAndDisposal(), 1, 7);
       validateField("solidWasteProcessAndDisposal", ai.getsolidWasteProcessAndDisposal(), 1, 8);
       validateField("soundPollCtrl", ai.getsoundPollCtrl(), 1, 9);
   }
       
   @Test(priority = 4)
       public void validateWater() throws IOException, InterruptedException {
       AdditionalInformationPage ai=new  AdditionalInformationPage(driver);
       validateField("waterConsumption", ai.getwaterConsumption(), 1, 10);
       validateField("sourceOfWater", ai.getsourceOfWater(), 1, 11);
   }

   @Test(priority = 5)
   public void clickNext6() throws IOException, InterruptedException {
       WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
       AdditionalInformationPage ai=new  AdditionalInformationPage(driver);
       WebElement nextButton6 = wait2.until(ExpectedConditions.elementToBeClickable(ai.getnextButton6()));
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();", nextButton6);
       System.out.println("Next button clicked from additional info page successfully");
   }

   /**
    * Utility method to handle waiting for an element, reading data from Excel, and handling StaleElementReferenceException.
    */
   public void validateField(String fieldName, WebElement element, int row, int column) throws IOException, InterruptedException {
       ExcelUtils excelUtils = new ExcelUtils();
       excelUtils.setExcelFile(EXCEL_FILE_PATH, "Sheet7");
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


	
	