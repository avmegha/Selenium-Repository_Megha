package com.ults.selenium.commonfunctions;

import org.openqa.selenium.WebDriver;

import com.ults.selenium.pomcollection.pomFile;

public class PartOfFireAppliance extends CommonFunctions{
	private WebDriver driver;

	public void Fire(String FirePumpSize, String FirePumpCapacity, String FireMainsDia, String FireMainsMat, 
			String AnyOtherEquip)
	{
	    pomFile pom=new pomFile (driver);
	    
	    sendKeys(pom.getParticularsOfFireAppliancePage().getFirePumpSize(), FirePumpSize);
	    sendKeys(pom.getParticularsOfFireAppliancePage().getFirePumpCapacity(), FirePumpCapacity);
	    sendKeys(pom.getParticularsOfFireAppliancePage().getFireMainsDia(), FireMainsDia);
	    sendKeys(pom.getParticularsOfFireAppliancePage().getFireMainsMat(), FireMainsMat);
	    sendKeys(pom.getParticularsOfFireAppliancePage().getAnyOtherEquip(), AnyOtherEquip);
	}   
}
