package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;
import com.ults.selenium.pomcollection.pomFile;

public class NewApplicationPage {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();
		
	By selectDistrict  = By.xpath("//label[text()='Select District']/following-sibling::select");
	
	By selectPortOfRegistry = By.xpath("//label[text()='Select Port of Registry']/following-sibling::select");
	
	By selectPort = By.xpath("//label[@for='portName']/following-sibling::select[1]");
	
	By vesselName = By.xpath("//label[text()='Name of Vessel']/following::input");
	
	By vesselCategory = By.xpath("//label[text()='Category of Vessel']/following-sibling::select");
	
	By vesselType = By.xpath("//label[text()='Type of Vessel']/following-sibling::select");
	
	By vesselSubType = By.xpath("//label[text()='Sub Type of Vessel']/following-sibling::select");
	
	By saveAsDraftButton = By.xpath("//button[text()='Save as Draft']");
	
	By nextButton = By.xpath("//button[@type='submit']");
			
	public NewApplicationPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement getselectDistrict() { 
	return driver.findElement(selectDistrict); 
} 
	
	public WebElement getselectPortOfRegistry() { 
	return driver.findElement(selectPortOfRegistry); 
} 
	public WebElement getselectPort() { 
	return driver.findElement(selectPort); 
} 
	public WebElement getvesselName() { 
	return driver.findElement(vesselName); 	
}
	public WebElement getvesselCategory() { 
	return driver.findElement(vesselCategory); 	
}
	public WebElement getvesselType() { 
	return driver.findElement(vesselType); 	
}
	public WebElement getvesselSubType() { 
	return driver.findElement(vesselSubType); 	
}
	public WebElement getsaveAsDraftButton() { 
	return driver.findElement(saveAsDraftButton); 	
}
	public WebElement getnextButton() { 
	return driver.findElement(nextButton); 	
}
}
