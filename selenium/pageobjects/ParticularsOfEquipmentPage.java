package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;

public class ParticularsOfEquipmentPage {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();
	
	// Method to scroll the window by 700 pixels
    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");

}
    By PortWt = By.xpath("//label[text()='Anchor-Port weight (in kg)']/following-sibling::input");
    By PortMat = By.xpath("//label[text()='Anchor-Port Material']/following::input");
    
    By StarboardWt = By.xpath("//label[text()='Starboard weight (in kg)']/following::input");
    By StarboardMat = By.xpath("//label[text()='Starboard Material']/following-sibling::input");
    
    By SpareWt = By.xpath("//label[text()='Anchor-Spare weight (in kg)']/following-sibling::input");
    By SpareMat = By.xpath("//label[text()='Anchor-Spare Material']/following-sibling::input");
    
    By PortChainSize = By.xpath("//label[text()='Port-Chain Size (in meters)']/following::input");
    By PortChainType = By.xpath("//label[text()='Port Chain Type']/following-sibling::input");
    By PortChainLength = By.xpath("//label[text()='Port Chain Length (in meters)']/following::input");
    
    By StChainSize = By.xpath("//label[text()='Starboard Chain Size (in meters)']/following-sibling::input");
    By StChainType = By.xpath("//label[text()='Starboard Chain Type']/following::input");
    By StChainLength = By.xpath("//label[text()='Starboard Chain Length (in meters)']/following-sibling::input");
    
    By RopeSize = By.xpath("//label[text()='Ropes Size (in meters)']/following-sibling::input");
    By RopeMat = By.xpath("//label[text()='Ropes Material']/following::input");
    By NoOfRopes = By.xpath("//label[text()='No of Ropes']/following-sibling::select");
    By NoOfSearchLight = By.xpath("//label[text()='Search Lights Number']/following-sibling::select");
    
    By LightSize = By.xpath("//label[text()='Search Lights Size']/following::input");
    By LightPower = By.xpath("//label[text()='Search Lights Power (in Volts)']/following::input");
    
    By LifeBuoy = By.xpath("//label[text()='Life buoys']/following::input");
    By BuoyantLanyard = By.xpath("//label[text()='Buoyant appartus with self ignited light/buoyant lanyard']/following-sibling::input");
    By NavLight = By.xpath("//label[text()='Navigation Lights giving particulars']/following::input");
    
    By SoundSignals = By.xpath("//label[text()='Sound Signals']/following-sibling::select");
    
    By nextButton4 =By.xpath("(//button[contains(@class,'btn-sucess float-right')]/following-sibling::button)[2]");
    
    public ParticularsOfEquipmentPage(WebDriver driver) {
    	
    	this.driver = driver;
    }

    public WebElement getPortWt() { 
    return driver.findElement(PortWt); 
    }
    public WebElement getPortMat() { 
    return driver.findElement(PortMat); 
    }
    public WebElement getStarboardWt() { 
    return driver.findElement(StarboardWt); 
    }
	
    public WebElement getStarboardMat() { 
        return driver.findElement(StarboardMat); 
        }
    public WebElement getSpareWt() { 
        return driver.findElement(SpareWt); 
    
   }
    public WebElement getSpareMat() { 
        return driver.findElement(SpareMat); 
        }
    public WebElement getPortChainSize() { 
        return driver.findElement(PortChainSize); 
        }
    public WebElement getPortChainType() { 
        return driver.findElement(PortChainType); 
        }
    public WebElement getPortChainLength() { 
        return driver.findElement(PortChainLength); 
        }
    public WebElement getStChainSize() { 
        return driver.findElement(StChainSize); 
        }
    public WebElement getStChainType() { 
        return driver.findElement(StChainType); 
        }
    public WebElement getStChainLength() { 
        return driver.findElement(StChainLength); 
        }
    public WebElement getRopeSize() { 
        return driver.findElement(RopeSize); 
        }
    public WebElement getRopeMat() { 
        return driver.findElement(RopeMat); 
        }
    public WebElement getNoOfRopes() { 
        return driver.findElement(NoOfRopes); 
        }
    public WebElement getNoOfSearchLight() { 
        return driver.findElement(NoOfSearchLight); 
        }
    public WebElement getLightSize() { 
        return driver.findElement(LightSize); 
        }
    public WebElement getLightPower() { 
        return driver.findElement(LightPower); 
        }

    public WebElement getLifeBuoy() { 
        return driver.findElement(LifeBuoy); 
        }
    public WebElement getBuoyantLanyard() { 
        return driver.findElement(BuoyantLanyard); 
        }
    public WebElement getNavLight() { 
        return driver.findElement(NavLight); 
        }
    public WebElement getSoundSignals() { 
        return driver.findElement(SoundSignals); 
        }
    public WebElement getnextButton4() { 
        return driver.findElement(nextButton4); 
        }
}
    
