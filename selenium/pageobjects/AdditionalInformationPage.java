package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;

public class AdditionalInformationPage {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();
	
	// Method to scroll the window by 700 pixels
    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");

}
	By noOfPortableFE = By.xpath("//label[text()='No of portable fire extinguisher with particulars']/following-sibling::select");
	By sodaAcid = By.xpath("//label[text()='Soda acid']/following::input");
	By foam = By.xpath("//label[text()='Foam']/following::input");
	
	By dryPowder = By.xpath("//label[text()='Dry Powder']/following::input");
	By anyOtherTypes = By.xpath("//label[text()='Any other types']/following::input");
	By partOfCommEquip = By.xpath("//label[text()='Particulars of Communication Equipments']/following::input");
	
	By partOfPollCtrlDevices = By.xpath("//label[text()='Particular of Pollution control devices']/following-sibling::input");
	By sewTreatAndDisposal = By.xpath("//label[text()='Sewage Treatment and Disposal']/following-sibling::input");
	By solidWasteProcessAndDisposal = By.xpath("//label[text()='Solid Waste Processing and Disposal']/following::input");
	
	By soundPollCtrl = By.xpath("//label[text()='Sound Pollution Control']/following::input");
	By waterConsumption = By.xpath("//label[text()='Water Consumption/Day']/following::input");
	By sourceOfWater = By.xpath("//label[text()='Source of Water']/following-sibling::input");
	
	By nextButton6 = By.xpath("(//button[contains(@class,'btn-sucess float-right')]/following-sibling::button)[2]");
	
public AdditionalInformationPage(WebDriver driver) {
    	
    	this.driver = driver;
    }

    public WebElement getnoOfPortableFE() { 
    return driver.findElement(noOfPortableFE); 
    }
    public WebElement getsodaAcid() { 
    return driver.findElement(sodaAcid); 
    }
    public WebElement getfoam() { 
    return driver.findElement(foam); 
    }
    
    public WebElement getdryPowder() { 
        return driver.findElement(dryPowder); 
        }
        public WebElement getanyOtherTypes() { 
        return driver.findElement(anyOtherTypes); 
        }
        public WebElement getpartOfCommEquip() { 
        return driver.findElement(partOfCommEquip); 
        
        }
        public WebElement getpartOfPollCtrlDevices() { 
            return driver.findElement(partOfPollCtrlDevices); 
            }
            public WebElement getsewTreatAndDisposal() { 
            return driver.findElement(sewTreatAndDisposal); 
            }
            public WebElement getsolidWasteProcessAndDisposal() { 
            return driver.findElement(solidWasteProcessAndDisposal); 
            }
            
            public WebElement getsoundPollCtrl() { 
                return driver.findElement(soundPollCtrl); 
                
                }
                public WebElement getwaterConsumption() { 
                    return driver.findElement(waterConsumption); 
                    }
                    public WebElement getsourceOfWater() { 
                    return driver.findElement(sourceOfWater); 
                    }
                    public WebElement getnextButton6() { 
                    return driver.findElement(nextButton6); 
                    }
        }

