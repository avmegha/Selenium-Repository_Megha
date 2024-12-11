package com.ults.selenium.commonfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ults.selenium.pomcollection.pomFile;

public class AdditionalInfoPage extends CommonFunctions {
private WebDriver driver;

	
	public AdditionalInfoPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public void AddInfo(String sodaAcid, String foam, String dryPowder, String anyOtherTypes, String partOfCommEquip, String partOfPollCtrlDevices, String sewTreatAndDisposal, String solidWasteProcessAndDisposal,String soundPollCtrl, String waterConsumption, String sourceOfWater)
    {
        pomFile pom=new pomFile (driver);
        
        sendKeys(pom.getAdditionalInformationPage().getsodaAcid(), sodaAcid);
        sendKeys(pom.getAdditionalInformationPage().getfoam(), foam);
        sendKeys(pom.getAdditionalInformationPage().getdryPowder(), dryPowder);
        sendKeys(pom.getAdditionalInformationPage().getanyOtherTypes(), anyOtherTypes);
        sendKeys(pom.getAdditionalInformationPage().getpartOfCommEquip(), partOfCommEquip);
        sendKeys(pom.getAdditionalInformationPage().getpartOfPollCtrlDevices(), partOfPollCtrlDevices);
        
        sendKeys(pom.getAdditionalInformationPage().getsewTreatAndDisposal(),sewTreatAndDisposal);
        sendKeys(pom.getAdditionalInformationPage().getsolidWasteProcessAndDisposal(), solidWasteProcessAndDisposal);
        sendKeys(pom.getAdditionalInformationPage().getsoundPollCtrl(), soundPollCtrl);
        sendKeys(pom.getAdditionalInformationPage().getwaterConsumption(), waterConsumption);
        sendKeys(pom.getAdditionalInformationPage().getsourceOfWater(), sourceOfWater);
        
        click(pom.getAdditionalInformationPage().getnextButton6());
    } 
    
}



