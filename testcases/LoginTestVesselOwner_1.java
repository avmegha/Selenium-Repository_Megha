package testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.ults.selenium.pageobjects.LoginPage;
import com.ults.selenium.util.CacheManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.ults.selenium.configurationfiles.BaseConfiguration;
import com.ults.selenium.configurationfiles.ExcelUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class LoginTestVesselOwner_1 extends BaseConfiguration {
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

    @Test
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
        log.info("Logged in successfully");
        // Clear the username and password fields after login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginSuccessElement"))); // Adjust as per actual element
        lp.getUsername().clear();
        lp.getPassword().clear();
    }
//    @AfterTest
//    public void teardown() {
//        driver.close();
//    }
}
