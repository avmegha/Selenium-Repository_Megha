package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ults.selenium.configurationfiles.BaseConfiguration;
import com.ults.selenium.configurationfiles.ExcelUtils;
import com.ults.selenium.pageobjects.Dashboard_Page;
import com.ults.selenium.pageobjects.LoginPage;
import com.ults.selenium.pageobjects.NewApplicationPage;
import com.ults.selenium.pageobjects.NewVesselPage;
import com.ults.selenium.util.CacheManager;

public class NewApplicationPage_4 extends BaseConfiguration {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());
    
    public NewApplicationPage_4(WebDriver driver) {
    this.driver = driver;
    }
    // Declare the Excel file path and sheet name as constants
    public static final String EXCEL_FILE_PATH = "C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx";
    public static final String SHEET_NAME = "Sheet1";
    
    
    public void createVesselAndClickNext() throws InterruptedException, IOException {
        // Assuming previous login and navigation methods exist before vessel creation.
        validateLogin();         // Perform the login
        validateDashboard();     // Navigate to dashboard
        validateNewVesselRequest(); // Click on Add Vessel
        validateOwnerDetails();  // Fill the owner details

        // Filling in the vessel name and selecting vessel categories.
        validatevesselName();

        // Click the Next button after vessel creation
        NewApplicationPage na = new NewApplicationPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton = wait.until(ExpectedConditions.visibilityOf(na.getnextButton()));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", nextButton);  
        System.out.println("Next button clicked successfully after vessel creation.");
    }

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

        // Fetch URL from CacheManager
        driver.get(CacheManager.getString(selenium_test_url_kmp));
        log.info("Navigated to Home page");
    }
       
    @Test(priority=1)
   
    public void validateLogin() throws IOException, InterruptedException {
            // Initialize ExcelUtils and load the Excel file
            ExcelUtils excelUtils = new ExcelUtils();
            excelUtils.setExcelFile("C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx", "Sheet1");

            // Fetch login credentials from Excel
            String username1 = excelUtils.getCellData(1, 1);
            String password1 = excelUtils.getCellData(1, 2);

            // Initialize LoginPage object
            LoginPage lp = new LoginPage(driver);
                      
            
            // Enter username and password
            lp.getUsername().sendKeys(username1);
            lp.getPassword().sendKeys(password1);

            // Wait for login button to be clickable, then click
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(lp.getLoginButton())).click();
            System.out.println("Logged in successfully");
            System.out.println("Navigated to the Dashboard page");
            Thread.sleep(3000);
    }
   
    @Test(priority = 2, dependsOnMethods = "validateLogin")
    public void validateDashboard() throws InterruptedException {
        // Initialize Dashboard_Page object and pass the driver
        Dashboard_Page dp = new Dashboard_Page(driver);

        // Wait for the "Apply for New Vessel" button to be clickable, then click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dp.getApplyForNewVessel())).click();
        System.out.println("Apply for New Vessel button clicked successfully");
        Thread.sleep(3000);
       }
    
   
    @Test(priority = 3, dependsOnMethods = "validateDashboard")
    public void validateNewVesselRequest() throws InterruptedException {
        
    	NewVesselPage nv=new  NewVesselPage(driver); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nv.getAddVessel())).click();
        System.out.println("Add Vessel button clicked successfully");
        Thread.sleep(3000);
       }
    @Test(priority = 4, dependsOnMethods = "validateNewVesselRequest")
    public void validateOwnerDetails() throws InterruptedException {    	
    	
    	 NewApplicationPage na=new  NewApplicationPage(driver);  
    	 
    	//District selection
    	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
         wait1.until(ExpectedConditions.elementToBeClickable(na.getselectDistrict())).click(); 
            	 
     	 Select optionDistrict=new Select(na.getselectDistrict());
    	 optionDistrict.selectByVisibleText("Kozhikode");
    	 System.out.println("District Selection: Kozhikode");	
    	
    	//Port of Registry selection
   	   WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
       wait2.until(ExpectedConditions.elementToBeClickable(na.getselectPortOfRegistry())).click(); 
        
 	   Select optionPortOfRegistry=new Select(na.getselectPortOfRegistry());
	   optionPortOfRegistry.selectByVisibleText("Beypore");
	   System.out.println("Port of Registry: Beypore");	
	   
	 //Port Selection
   	   WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
       wait3.until(ExpectedConditions.elementToBeClickable(na.getselectPort())).click(); 
          
 	   Select optionPort=new Select(na.getselectPort());
	   optionPort.selectByVisibleText("Beypore");
	   System.out.println("Port Selection: Beypore");	
	       	}
    @Test(priority = 5)
    public void validatevesselName() throws IOException, InterruptedException {
        // Initialize ExcelUtils and load the Excel file
        ExcelUtils excelUtils = new ExcelUtils();
        excelUtils.setExcelFile("C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx", "Sheet2");

        // Fetch vessel name
        String vesselname = excelUtils.getCellData(1, 1);
              
        NewApplicationPage na = new NewApplicationPage(driver);
        
        // Enter vesselname 
        na.getvesselName().sendKeys(vesselname);
        System.out.println("Vessel name entered: VesselULTS");
        
     // Add an explicit wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement vesselCategory = wait.until(ExpectedConditions.elementToBeClickable(na.getvesselCategory()));

        try {
            // Try using JavaScript to click the element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", vesselCategory);
            System.out.println("Vessel category clicked using JavaScript");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
           
  	   Select optionVesselCategory=new Select(na.getvesselCategory());
 	   optionVesselCategory.selectByVisibleText("Category A");
 	   System.out.println("Vessel category: Category A");
 	  
 	 //Vessel Type Selection
    	WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait3.until(ExpectedConditions.elementToBeClickable(na.getvesselType())).click(); 
        	   
  	   Select optionVesselType=new Select(na.getvesselType());
 	   optionVesselType.selectByVisibleText("House Boat");
 	   System.out.println("Vessel type: House Boat");
 	   
 	  // Add an explicit wait for the element to be clickable
       WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(20));
       WebElement vesselSubType = wait.until(ExpectedConditions.elementToBeClickable(na.getvesselSubType()));

       try {
           // Try using JavaScript to click the element
           JavascriptExecutor js = (JavascriptExecutor) driver;
           js.executeScript("arguments[0].click();", vesselSubType);
           System.out.println("Vessel subtype clicked using JavaScript");
       } catch (Exception e) {
           e.printStackTrace();
       }
 	          
 	   Select optionVesselSubtype=new Select(na.getvesselSubType());
	   optionVesselSubtype.selectByVisibleText("House Boat with Single Deck");
	   System.out.println("Vessel Subtype: House Boat with Single Deck");
	      
	   
	   //WebDriverWait wait9 = new WebDriverWait(driver, Duration.ofSeconds(10));
	   WebElement nextButton = wait.until(ExpectedConditions.visibilityOf(na.getnextButton()));
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("arguments[0].click();", nextButton);   
       System.out.println("Next button clicked from Owner Details successfully");
    }
}