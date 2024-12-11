package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ults.selenium.configurationfiles.BaseConfiguration;
import com.ults.selenium.configurationfiles.ExcelUtils;
import com.ults.selenium.pageobjects.AdditionalInformationPage;
import com.ults.selenium.pageobjects.FileUploadPage;
import com.ults.selenium.pageobjects.ParticularsOfFireAppliancePage;
import com.ults.selenium.pageobjects.PropulsionEnginesPage;
import com.ults.selenium.util.CacheManager;

public class FileUploads_10 extends BaseConfiguration {
	public WebDriver driver;

    NewApplicationPage_4 newApplicationPage_4;
    ParticularsOfHulls_5 particularsOfHulls;  
    PropulsionEngine_6 propulsionEngine;
    ParticularsOfEquipment_7 particularsOfEquipment;
    FireAppliance_8 fireAppliance;
    AdditionalInfo_9 additionalInfo;
    
    public static Logger log = LogManager.getLogger(BaseConfiguration.class.getName());

    public static final String EXCEL_FILE_PATH = "C:\\Users\\meghaav\\eclipse-workspace\\KMB\\LoginPage\\LoginPageVesselOwner.xlsx";
    public static final String SHEET_NAME = "Sheet1";
    
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
        Thread.sleep(3000);
        
        particularsOfHulls = new ParticularsOfHulls_5(driver);  // Updated instantiation
        particularsOfHulls.createHullsAndClickNext();
        Thread.sleep(3000);
        
        System.out.println("Hulls Details given and Next button clicked. Ready for Propulsion of Engine tests.");
        Thread.sleep(3000);
        
        propulsionEngine = new PropulsionEngine_6(driver);  // Updated instantiation
        propulsionEngine.createEnginesAndClickNext();
        
        System.out.println("Engine Details given and Next button clicked. Ready for Particulars of equipment tests.");
        
        particularsOfEquipment = new ParticularsOfEquipment_7(driver);  // Updated instantiation
        particularsOfEquipment.createEquipmentsAndClickNext();
        
        System.out.println("Equipments Details given and Next button clicked. Ready for Particulars of fire appliance tests.");
   
        fireAppliance = new FireAppliance_8(driver);  // Updated instantiation
        fireAppliance.createFireApplianceAndClickNext();
        
        System.out.println("Fire appliance details given and Next button clicked. Ready for Additional Information tests.");
        
        additionalInfo = new AdditionalInfo_9(driver);  // Updated instantiation
        additionalInfo.createAddInfoAndClickNext();
        
        System.out.println("Additional details given and Next button clicked. Ready for Additional Information tests.");
    }

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
    
       
        @Test(priority = 1)
        public void validateFileUploads() {
            try {
                FileUploadPage fu = new FileUploadPage(driver);

                // General Arrangement Plan file upload
                String filePath1 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";

                JavascriptExecutor js = (JavascriptExecutor) driver;

                // Make the file input visible (if hidden)
                WebElement genArrPlanFile = fu.getgenArrPlanFile();
                js.executeScript("arguments[0].style.display='block';", genArrPlanFile);

                // Upload first file
                genArrPlanFile.sendKeys(filePath1);
                System.out.println("General Arrangement Plan uploaded successfully: " + filePath1);

                
                
                String filePath2 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement linesPlanOffsetTable = fu.getlinesPlanOffsetTable();
                js.executeScript("arguments[0].style.display='block';", linesPlanOffsetTable);

                // Upload second file
                linesPlanOffsetTable.sendKeys(filePath2);
                System.out.println("Lines Plan and Offset Table file uploaded successfully: " + filePath2);
        
                 
                String filePath3 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement structuralDrawings = fu.getstructuralDrawings();
                js.executeScript("arguments[0].style.display='block';", structuralDrawings);

                // Upload third file
                structuralDrawings.sendKeys(filePath3);
                System.out.println("Structural Drawings file uploaded successfully: " + filePath3);
        
                
                String filePath4 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement midshipDrawings = fu.getmidshipDrawings();
                js.executeScript("arguments[0].style.display='block';", midshipDrawings);

                // Upload fourth file
                midshipDrawings.sendKeys(filePath4);
                System.out.println("Midship Drawings file uploaded successfully: " + filePath4);
        
                
                String filePath5 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement deckAreaCalculation = fu.getdeckAreaCalculation();
                js.executeScript("arguments[0].style.display='block';", deckAreaCalculation);

                // Upload fifth file
                deckAreaCalculation.sendKeys(filePath5);
                System.out.println("Deck Area Calculation file uploaded successfully: " + filePath5);
   
                
                String filePath6 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement freeBoardMarkings = fu.getfreeBoardMarkings();
                js.executeScript("arguments[0].style.display='block';", freeBoardMarkings);

                // Upload sixth file
                freeBoardMarkings.sendKeys(filePath6);
                System.out.println("Free board Markings file uploaded successfully: " + filePath6);
                
                String filePath7 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement shellExpansion = fu.getshellExpansion();
                js.executeScript("arguments[0].style.display='block';", shellExpansion);

                // Upload seventh file
                shellExpansion.sendKeys(filePath7);
                System.out.println("Shell Expansion file uploaded successfully: " + filePath7);
                
                
                String filePath8 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement steeringPlan = fu.getsteeringPlan();
                js.executeScript("arguments[0].style.display='block';", steeringPlan);

                // Upload eighth file
                steeringPlan.sendKeys(filePath8);
                System.out.println("Steering Plan file uploaded successfully: " + filePath8);
                
                String filePath9 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement machineryLayout = fu.getmachineryLayout();
                js.executeScript("arguments[0].style.display='block';", machineryLayout);

                // Upload nineth file
                machineryLayout.sendKeys(filePath9);
                System.out.println("Machinery Layout file uploaded successfully: " + filePath9);
                
                String filePath10 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement shaftingAndSternGear = fu.getshaftingAndSternGear();
                js.executeScript("arguments[0].style.display='block';", shaftingAndSternGear);

                // Upload tenth file
                shaftingAndSternGear.sendKeys(filePath10);
                System.out.println("Shafting and Stern Gear file uploaded successfully: " + filePath10);
                
                String filePath11 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement pipingArrangement = fu.getpipingArrangement();
                js.executeScript("arguments[0].style.display='block';", pipingArrangement);

                // Upload eleventh file
                pipingArrangement.sendKeys(filePath11);
                System.out.println("Piping arrangement file uploaded successfully: " + filePath11);
                
                
                String filePath12 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement propellerDrawings = fu.getpropellerDrawings();
                js.executeScript("arguments[0].style.display='block';", propellerDrawings);

                // Upload twelfth file
                propellerDrawings.sendKeys(filePath12);
                System.out.println("Propeller Drawings file uploaded successfully: " + filePath12);
                
                String filePath13 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement bilgeWaterSystemPlan = fu.getbilgeWaterSystemPlan();
                js.executeScript("arguments[0].style.display='block';", bilgeWaterSystemPlan);

                // Upload thirteenth file
                bilgeWaterSystemPlan.sendKeys(filePath13);
                System.out.println("Bilge water system file uploaded successfully: " + filePath13);
                
                
                String filePath14 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement accommodationPlan = fu.getaccommodationPlan();
                js.executeScript("arguments[0].style.display='block';", accommodationPlan);

                // Upload fourteenth file
                accommodationPlan.sendKeys(filePath14);
                System.out.println("Accommodation Plan file uploaded successfully: " + filePath14);
                
                
                String filePath15 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement fuelOilTransfer = fu.getfuelOilTransfer();
                js.executeScript("arguments[0].style.display='block';", fuelOilTransfer);

                // Upload fifteenth file
                fuelOilTransfer.sendKeys(filePath15);
                System.out.println("Fuel oil transfer file uploaded successfully: " + filePath15);
                
                
                String filePath16 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement electricalDrawing = fu.getelectricalDrawing();
                js.executeScript("arguments[0].style.display='block';", electricalDrawing);

                // Upload sixteenth file
                electricalDrawing.sendKeys(filePath16);
                System.out.println("Electrical Drawings file uploaded successfully: " + filePath16);
                
                String filePath17 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement ventillationPlan = fu.getventillationPlan();
                js.executeScript("arguments[0].style.display='block';", ventillationPlan);

                // Upload seventeenth file
                ventillationPlan.sendKeys(filePath17);
                System.out.println("ventillation Plan file uploaded successfully: " + filePath17);
                
                String filePath18 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement lifeSavingAppliances = fu.getlifeSavingAppliances();
                js.executeScript("arguments[0].style.display='block';", lifeSavingAppliances);

                // Upload eighteenth file
                lifeSavingAppliances.sendKeys(filePath18);
                System.out.println("Life saving appliances file uploaded successfully: " + filePath18);
                
                
                String filePath19 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement fireFightingAppliances = fu.getfireFightingAppliances();
                js.executeScript("arguments[0].style.display='block';", fireFightingAppliances);

                // Upload nineteenth file
                fireFightingAppliances.sendKeys(filePath19);
                System.out.println("Fire fighting appliances file uploaded successfully: " + filePath19);
                
                
                String filePath20 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement communicationEquipment = fu.getcommunicationEquipment();
                js.executeScript("arguments[0].style.display='block';", communicationEquipment);

                // Upload twentieth file
                communicationEquipment.sendKeys(filePath20);
                System.out.println("Communication equipment file uploaded successfully: " + filePath20);
                
                
                String filePath21 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement compartmentSubDivCalc = fu.getcompartmentSubDivCalc();
                js.executeScript("arguments[0].style.display='block';",compartmentSubDivCalc);

                // Upload twentyfirst file
                compartmentSubDivCalc.sendKeys(filePath21);
                System.out.println("Compartment subdivision file uploaded successfully: " + filePath21);
                
                
                String filePath22 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement preliminaryStability = fu.getpreliminaryStability();
                js.executeScript("arguments[0].style.display='block';", preliminaryStability);

                // Upload twentysecond file
                preliminaryStability.sendKeys(filePath22);
                System.out.println("Preliminary Stability file uploaded successfully: " + filePath22);
                
                
                String filePath23 = System.getProperty("user.dir") + "\\data\\Testleaf Certificate.pdf";
                WebElement damageStability = fu.getdamageStability();
                js.executeScript("arguments[0].style.display='block';", damageStability);

                // Upload twentythird file
                damageStability.sendKeys(filePath23);
                System.out.println("Damage Stability file uploaded successfully: " + filePath23);
                
                
             } catch (Exception e) {
                System.err.println("Error during file upload: " + e.getMessage());
                e.printStackTrace();
            }
        }
        @Test(priority = 2)
        public void validatePreview() {
            
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                FileUploadPage fu = new FileUploadPage(driver);
                Actions actions = new Actions(driver);
                
                WebElement previewButton = wait.until(ExpectedConditions.elementToBeClickable(fu.getpreview()));

                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", previewButton);

                js.executeScript("arguments[0].click();", previewButton);
                
                actions.moveToElement(previewButton).click().perform();

                System.out.println("Preview clicked from file upload page successfully");
                if (previewButton.isEnabled() && previewButton.isDisplayed()) {
                    System.out.println("Preview button is enabled and visible.");
                } else {
                    System.out.println("Preview button is not clickable.");
                }

            
            } 
     
        }

   
     
