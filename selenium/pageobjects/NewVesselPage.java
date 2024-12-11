package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;

public class NewVesselPage {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();
		
	By addvessel         = By.xpath("//button[contains(@class,'add-new-btn btn')]");
			
	public NewVesselPage(WebDriver driver) {
		
		this.driver = driver;
	}

	public WebElement getAddVessel() { 
	return driver.findElement(addvessel); 
} 
}

