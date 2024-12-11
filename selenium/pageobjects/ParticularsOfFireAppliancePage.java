package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;

public class ParticularsOfFireAppliancePage {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();
	
	// Method to scroll the window by 700 pixels
    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");

}
    By FirePumpSize = By.xpath("//input[@id='fire_pumps[0].size']");
    By FirePumpCapacity = By.xpath("//input[@placeholder='Enter Capacity of Fire Pumps']");
    
    By FireMainsDia = By.xpath("(//input[contains(@class,'text-input form-control')])[3]");
    By FireMainsMat = By.xpath("//input[@placeholder='Enter Fire Mains Material']");
        
    By NoOfHyd = By.xpath("//label[text()='No of hydrants']/following-sibling::select");
    By NoOfHose = By.xpath("//label[text()='No of Hose']/following-sibling::select");
    By Nozzles = By.xpath("//label[text()='Nozzles']/following-sibling::select");
        
    By AnyOtherEquip = By.xpath("//label[text()='Any other Equipments']/following::input");
    
    By nextButton5 = By.xpath("(//div[contains(@class,'btn-col address-button')]//button)[3]");
    
public ParticularsOfFireAppliancePage(WebDriver driver) {
    	
    	this.driver = driver;
    }

    public WebElement getFirePumpSize() { 
    return driver.findElement(FirePumpSize); 
    }
    public WebElement getFirePumpCapacity() { 
    return driver.findElement(FirePumpCapacity); 
    }
    public WebElement getFireMainsDia() { 
    return driver.findElement(FireMainsDia); 
    }
    public WebElement getFireMainsMat() { 
    return driver.findElement(FireMainsMat); 
    }
        public WebElement getNoOfHyd() { 
        return driver.findElement(NoOfHyd); 
        }
        public WebElement getNoOfHose() { 
        return driver.findElement(NoOfHose); 
        }
        public WebElement getNozzles() { 
        return driver.findElement(Nozzles); 
        }
        public WebElement getAnyOtherEquip() { 
        return driver.findElement(AnyOtherEquip); 
        }
        public WebElement getnextButton5() { 
        return driver.findElement(nextButton5); 
        }
}
