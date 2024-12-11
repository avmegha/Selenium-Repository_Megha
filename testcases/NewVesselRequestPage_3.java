package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ults.selenium.configurationfiles.BaseConfiguration;
import com.ults.selenium.configurationfiles.ExcelUtils;
import com.ults.selenium.pageobjects.Dashboard_Page;
import com.ults.selenium.pageobjects.LoginPage;
import com.ults.selenium.pageobjects.NewVesselPage;
import com.ults.selenium.util.CacheManager;

public class NewVesselRequestPage_3 extends BaseConfiguration {
    public WebDriver driver;
    public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());

    // Declare the Excel file path and sheet name as constants
    public static final String EXCEL_FILE_PATH = "C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx";
    public static final String SHEET_NAME = "Sheet1";

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
            Dashboard_Page dp = new Dashboard_Page(driver);
            NewVesselPage nv=new  NewVesselPage(driver); 
            
            // Enter username and password
            lp.getUsername().sendKeys(username1);
            lp.getPassword().sendKeys(password1);

            // Wait for login button to be clickable, then click
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(lp.getLoginButton())).click();
            log.info("Logged in successfully");
            log.info("Navigated to the Dashboard page");
    }
   
    @Test(priority = 2, dependsOnMethods = "validateLogin")
    public void validateDashboard() {
        // Initialize Dashboard_Page object and pass the driver
        Dashboard_Page dp = new Dashboard_Page(driver);

        // Wait for the "Apply for New Vessel" button to be clickable, then click
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(dp.getApplyForNewVessel())).click();
        log.info("Apply for New Vessel button clicked successfully");
       }
    @Test(priority = 3, dependsOnMethods = "validateDashboard")
    public void validateNewVesselRequest() {
        
    	NewVesselPage nv=new  NewVesselPage(driver); 

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(nv.getAddVessel())).click();
        log.info("Add Vessel button clicked successfully");
       }
}