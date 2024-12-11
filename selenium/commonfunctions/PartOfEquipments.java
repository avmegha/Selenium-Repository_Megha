package com.ults.selenium.commonfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ults.selenium.pomcollection.pomFile;

public class PartOfEquipments extends CommonFunctions {
private WebDriver driver;

public void Equipments(String PortWt, String PortMat, String StarboardWt, String StarboardMat, 
		String SpareWt, String SpareMat, 
		String PortChainType, String PortChainSize, String PortChainLength,
		String StChainType, String StChainSize, String StChainLength,
		String RopeSize, String RopeMat,String LightSize, String LightPower,
		String LifeBuoy, String BuoyantLanyard, String NavLight)
{
    pomFile pom=new pomFile (driver);
    
    sendKeys(pom.getParticularsOfEquipmentPage().getPortWt(), PortWt);
    sendKeys(pom.getParticularsOfEquipmentPage().getPortMat(), PortMat);
    sendKeys(pom.getParticularsOfEquipmentPage().getStarboardWt(), StarboardWt);
    sendKeys(pom.getParticularsOfEquipmentPage().getStarboardMat(), StarboardMat);
    sendKeys(pom.getParticularsOfEquipmentPage().getSpareWt(), SpareWt);
    sendKeys(pom.getParticularsOfEquipmentPage().getSpareMat(), SpareMat);
    sendKeys(pom.getParticularsOfEquipmentPage().getPortChainType(), PortChainType);
    sendKeys(pom.getParticularsOfEquipmentPage().getPortChainSize(), PortChainSize);
    sendKeys(pom.getParticularsOfEquipmentPage().getPortChainLength(), PortChainLength);
    sendKeys(pom.getParticularsOfEquipmentPage().getStChainType(), StChainType);
    sendKeys(pom.getParticularsOfEquipmentPage().getStChainSize(), StChainSize);
    sendKeys(pom.getParticularsOfEquipmentPage().getStChainLength(), StChainLength);
    sendKeys(pom.getParticularsOfEquipmentPage().getRopeSize(), RopeSize);
    sendKeys(pom.getParticularsOfEquipmentPage().getRopeMat(), RopeMat);
    sendKeys(pom.getParticularsOfEquipmentPage().getLightSize(), LightSize);
    sendKeys(pom.getParticularsOfEquipmentPage().getLightPower(), LightPower);
    sendKeys(pom.getParticularsOfEquipmentPage().getLifeBuoy(), LifeBuoy);
    sendKeys(pom.getParticularsOfEquipmentPage().getBuoyantLanyard(), BuoyantLanyard);
    sendKeys(pom.getParticularsOfEquipmentPage().getNavLight(), NavLight);
}
}



