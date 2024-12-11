package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ults.selenium.commonfunctions.CommonFunctions;

public class ParticularsOfHulls {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();
	
	// Method to scroll the window by 700 pixels
    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
    }
		
	By selectBuilder = By.xpath("//select[contains(@class,'text-input ')]");
	By materialOfHull = By.xpath("//label[text()='Material of the hull']/following-sibling::input");
	By deckAboveFreeBoard = By.xpath("//label[text()='Whether with a deck above free board dec']/following-sibling::select");
	By passengerCapacity = By.xpath("//label[text()='Passenger Capacity']/following-sibling::input"); 
	By lengthOverall = By.xpath("//label[text()='Length Overall (in meters)']/following-sibling::input");
	By lengthOnDeck = By.xpath("//label[text()='Length on Deck (in meters)']/following::input");
	By breadth = By.xpath("//label[text()='Breadth (in meters)']/following::input");
	By depth = By.xpath("//label[text()='Depth (in meters)']/following::input");
	By yard = By.xpath("//label[text()='Yard']/following-sibling::select");
	By bulkHeadsPlacement = By.xpath("//input[@placeholder='Enter bulk heads placement']");
	By bulkHeadsThickness =	By.xpath("//input[@placeholder='Enter bulk heads thickness']");
	By hullPlatingMaterial = By.xpath("//input[@placeholder='Enter hull plating material']");
	By hullPlatingThickness = By.xpath("//input[@placeholder='Enter hull plating thickness']");
	By nextButton2 = By.xpath("(//button[contains(@class,'btn-sucess float-right')]/following-sibling::button)[2]");
	
	
public ParticularsOfHulls(WebDriver driver) {
	
	this.driver = driver;
}

public WebElement getselectBuilder() { 
return driver.findElement(selectBuilder); 
}
public WebElement getmaterialOfHull() { 
return driver.findElement(materialOfHull); 
}
public WebElement getdeckAboveFreeBoard() { 
return driver.findElement(deckAboveFreeBoard); 
}
public WebElement getpassengerCapacity() { 
return driver.findElement(passengerCapacity); 
}
public WebElement getlengthOverall() { 
return driver.findElement(lengthOverall); 
}
public WebElement getlengthOnDeck() { 
return driver.findElement(lengthOnDeck); 
}
public WebElement getbreadth() { 
return driver.findElement(breadth); 
}
public WebElement getdepth() { 
return driver.findElement(depth); 
}
public WebElement getyard() { 
return driver.findElement(yard); 
}
public WebElement getbulkHeadsPlacement() { 
return driver.findElement(bulkHeadsPlacement); 
}
public WebElement getbulkHeadsThickness() { 
return driver.findElement(bulkHeadsThickness); 
}
public WebElement gethullPlatingMaterial() { 
return driver.findElement(hullPlatingMaterial); 
}
public WebElement gethullPlatingThickness() { 
return driver.findElement(hullPlatingThickness); 
}
public WebElement getnextButton2() { 
return driver.findElement(nextButton2); 
}
} 