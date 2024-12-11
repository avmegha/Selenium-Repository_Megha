package com.ults.selenium.commonfunctions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ults.selenium.pageobjects.Dashboard_Page;
import com.ults.selenium.pomcollection.pomFile;

public class FileUpload extends CommonFunctions{
	private WebDriver driver;
	
	public FileUpload(ChromeDriver driver) {
		this.driver=driver;
	}
public void genArrPlanFile() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getgenArrPlanFile());  			   
}

public void linesPlanOffsetTable() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getlinesPlanOffsetTable());
} 

public void structuralDrawings() {
	pomFile pom=new pomFile (driver);
    click(pom.getFileUploadPage().getstructuralDrawings());   			   
}

public void midshipDrawings() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getmidshipDrawings());
}

public void deckAreaCalculation() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getdeckAreaCalculation());
}

public void freeBoardMarkings() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getfreeBoardMarkings());
}

public void shellExpansion() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getshellExpansion());
}

public void machineryLayout() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getmachineryLayout());
}
	
public void propellerDrawings() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getpropellerDrawings());
}

public void shaftingAndSternGear() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getshaftingAndSternGear());
}

public void steeringPlan() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getsteeringPlan());
}

public void pipingArrangement() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getpipingArrangement());
}

public void bilgeWaterSystemPlan() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getbilgeWaterSystemPlan());
}

public void accommodationPlan() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getaccommodationPlan());
}

public void fuelOilTransfer() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getfuelOilTransfer());
}

public void electricalDrawing() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getelectricalDrawing());
}

public void ventillationPlan() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getventillationPlan());
}

public void lifeSavingAppliances() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getlifeSavingAppliances());
}

public void fireFightingAppliances() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getfireFightingAppliances());
}
public void communicationEquipment() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getcommunicationEquipment());
}

public void compartmentSubDivCalc() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getcompartmentSubDivCalc());
}

public void preliminaryStability() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getpreliminaryStability());
}

public void damageStability() {
pomFile pom=new pomFile (driver);
click(pom.getFileUploadPage().getdamageStability());
}
public void preview() {
	pomFile pom=new pomFile (driver);
	 click(pom.getFileUploadPage().getpreview());
}
}
