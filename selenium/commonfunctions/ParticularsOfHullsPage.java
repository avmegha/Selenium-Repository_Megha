package com.ults.selenium.commonfunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ults.selenium.pomcollection.pomFile;

public class ParticularsOfHullsPage extends CommonFunctions {
private WebDriver driver;

	
	public ParticularsOfHullsPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public void hulls(String MHull, String PCapacity, String LengthOverall, String LengthOnDeck, String Breadth, String Depth, String BHP, String BHT,String HPM, String HPT)
    {
        pomFile pom=new pomFile (driver);
        
        sendKeys(pom.getParticularsOfHulls().getmaterialOfHull(), MHull);
        sendKeys(pom.getParticularsOfHulls().getpassengerCapacity(), PCapacity);
        sendKeys(pom.getParticularsOfHulls().getlengthOverall(), LengthOverall);
        sendKeys(pom.getParticularsOfHulls().getlengthOnDeck(), LengthOnDeck);
        sendKeys(pom.getParticularsOfHulls().getbreadth(), Breadth);
        sendKeys(pom.getParticularsOfHulls().getdepth(), Depth);
        
        sendKeys(pom.getParticularsOfHulls().getbulkHeadsPlacement(),BHP);
        sendKeys(pom.getParticularsOfHulls().getbulkHeadsThickness(), BHT);
        sendKeys(pom.getParticularsOfHulls().gethullPlatingMaterial(), HPM);
        sendKeys(pom.getParticularsOfHulls().gethullPlatingThickness(), HPT);
        click(pom.getParticularsOfHulls().getnextButton2());
        
    }
}


