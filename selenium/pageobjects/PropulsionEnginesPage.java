package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;

public class PropulsionEnginesPage {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();
	
	// Method to scroll the window by 700 pixels
    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");

}
    By noOfSetsWithBHP = By.xpath("//input[@class='text-input form-control']");
    By Brand = By.xpath("//label[text()='Manufacturers Name/Brand']/following::input");
    By ModelNo = By.xpath("//label[text()='Model Number/Engine Serial Number']/following::input");
    By EngineType = By.xpath("//label[text()='Type of Engine']/following::input");
    By DiaOfPropShaft = By.xpath("//label[text()='Diameter of propulsion shaft (in mm)']/following-sibling::input");
    By MatOfPropShaft = By.xpath("//label[text()='Material of propulsion shaft']/following-sibling::input");
    By GearType = By.xpath("//label[text()='Type of gears']/following::input");
    By NoOfGears = By.xpath("//label[text()='No of gears']/following-sibling::select");
    By EngineSide = By.xpath("//label[text()='Side of Engine']/following-sibling::select");
    By nextButton3 = By.xpath("(//button[contains(@class,'btn-sucess float-right')]/following-sibling::button)[2]");
    
    
    public PropulsionEnginesPage(WebDriver driver) {
    	
    	this.driver = driver;
    }

    public WebElement getnoOfSetsWithBHP() { 
    return driver.findElement(noOfSetsWithBHP); 
    }
    public WebElement getBrand() { 
    return driver.findElement(Brand); 
    }
    public WebElement getModelNo() { 
    return driver.findElement(ModelNo); 
    }
	
    public WebElement getEngineType() { 
        return driver.findElement(EngineType); 
        }
    public WebElement getDiaOfPropShaft() { 
        return driver.findElement(DiaOfPropShaft); 
    
   }
    public WebElement getMatOfPropShaft() { 
        return driver.findElement(MatOfPropShaft); 
        }
    public WebElement getGearType() { 
        return driver.findElement(GearType); 
        }
    public WebElement getNoOfGears() { 
        return driver.findElement(NoOfGears); 
        }
    public WebElement getEngineSide() { 
        return driver.findElement(EngineSide); 
        }
    public WebElement getnextButton3() { 
        return driver.findElement(nextButton3); 
        }
}
