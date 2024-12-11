package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;
import com.ults.selenium.commonfunctions.NewApplicationOwnerDetailsPage;

public class Dashboard_Page {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();

	//By user_name = By.cssSelector("#userName");
	
	By applyfornewvessel = By.xpath("//span[text()='Apply for New Vessel']");
	By addvessel         = By.xpath("//button[contains(@class,'add-new-btn btn')]");
			

	public Dashboard_Page(WebDriver driver) {
		
		this.driver = driver;

	}

	public WebElement getApplyForNewVessel() { 
		return driver.findElement(applyfornewvessel); 
			
	}
	public WebElement getAddVessel() { 
		return driver.findElement(addvessel); 
} 
}