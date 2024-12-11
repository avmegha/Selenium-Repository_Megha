package com.ults.selenium.commonfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ults.selenium.pomcollection.pomFile;

public class PartOfPropOfEngines extends CommonFunctions {
private WebDriver driver;

	
	public PartOfPropOfEngines(ChromeDriver driver) {
		this.driver=driver;
	}
public void Engines(String NoOfSetsWithBHP, String Brand, String ModelNo, String EngineType, String DiaOfPropShaft, String MatOfPropShaft, String GearType)
{
    pomFile pom=new pomFile (driver);
    
    sendKeys(pom.getPropulsionEnginesPage().getnoOfSetsWithBHP(), NoOfSetsWithBHP);
    sendKeys(pom.getPropulsionEnginesPage().getBrand(), Brand);
    sendKeys(pom.getPropulsionEnginesPage().getModelNo(), ModelNo);
    sendKeys(pom.getPropulsionEnginesPage().getEngineType(), EngineType);
    sendKeys(pom.getPropulsionEnginesPage().getDiaOfPropShaft(), DiaOfPropShaft);
    sendKeys(pom.getPropulsionEnginesPage().getMatOfPropShaft(), MatOfPropShaft);
    sendKeys(pom.getPropulsionEnginesPage().getGearType(), GearType);
}
}
