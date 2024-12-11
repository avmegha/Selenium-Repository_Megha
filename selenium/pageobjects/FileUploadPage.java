package com.ults.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;

public class FileUploadPage {
	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();

	
	By genArrPlanFile = By.name("uploads[generalArrangementPlan]");
	By linesPlanOffsetTable = By.name("uploads[linesPlanOffsetTable]");
	By structuralDrawings = By.name("uploads[structuralDrawings]");
	By midshipDrawings = By.name("uploads[midshipDrawings]");
	By deckAreaCalculation = By.name("uploads[deckAreaCalculation]");
	
	
	By freeBoardMarkings = By.name("uploads[freeboardMarkings]");
	By shellExpansion = By.name("uploads[shellExpansion]");
	By machineryLayout =By.name("uploads[machineryLayout]");
	By steeringPlan = By.name("uploads[steeringPlan]");
	By shaftingAndSternGear =By.name("uploads[shaftingSternGear]");
	By pipingArrangement = By.name("uploads[pipingArrangement]");
	By propellerDrawings= By.name("uploads[propellerDrawings]");
	
	
	By bilgeWaterSystemPlan = By.name("uploads[bilgeWaterSystemPlan]");
	By accommodationPlan = By.name("uploads[accommodationPlan]");
	By fuelOilTransfer = By.name("uploads[fuelOiltransferEngineCooling]");
	By electricalDrawing = By.name("uploads[electricalDrawing]");
	By ventillationPlan = By.name("uploads[ventilationPlan]");
	
	By lifeSavingAppliances = By.name("uploads[lifeSavingPlan]");
	By fireFightingAppliances = By.name("uploads[fireFightingPlan]");
	By communicationEquipment = By.name("uploads[navigationalPlan]");
	By compartmentSubDivCalc = By.name("uploads[compartmentSubdivision]");
	By preliminaryStability = By.name("uploads[preliminaryStability]");
	By damageStability = By.name("uploads[damageStability]");
	
	By previewButton = By.xpath("//button[@type='submit']");
	
	public FileUploadPage(WebDriver driver) {
		
		this.driver = driver;

	}

	public WebElement getgenArrPlanFile() { 
		return driver.findElement(genArrPlanFile); 
			
	}
	public WebElement getlinesPlanOffsetTable() { 
		return driver.findElement(linesPlanOffsetTable); 
}
	public WebElement getstructuralDrawings() { 
		return driver.findElement(structuralDrawings); 
			
	}
	public WebElement getmidshipDrawings() { 
		return driver.findElement(midshipDrawings); 
} 
	
	public WebElement getdeckAreaCalculation() { 
		return driver.findElement(deckAreaCalculation); 
			
	}
	
	
	public WebElement getfreeBoardMarkings() { 
		return driver.findElement(freeBoardMarkings); 
} 
		
	public WebElement getshellExpansion() { 
		return driver.findElement(shellExpansion); 
			
	}
	
	
	public WebElement getmachineryLayout() { 
		return driver.findElement(machineryLayout); 
}
	public WebElement getpropellerDrawings() { 
		return driver.findElement(propellerDrawings); 
			
	}
	public WebElement getshaftingAndSternGear() { 
		return driver.findElement(shaftingAndSternGear); 	
}

	public WebElement getsteeringPlan() { 
		return driver.findElement(steeringPlan); 
			
	}
	public WebElement getpipingArrangement() { 
		return driver.findElement(pipingArrangement); 	
}
	public WebElement getbilgeWaterSystemPlan() { 
		return driver.findElement(bilgeWaterSystemPlan); 
			
	}
	public WebElement getaccommodationPlan() { 
		return driver.findElement(accommodationPlan); 	
}	
	
	public WebElement getfuelOilTransfer() { 
		return driver.findElement(fuelOilTransfer); 	
}
	public WebElement getelectricalDrawing() { 
		return driver.findElement(electricalDrawing); 
			
	}
	public WebElement getventillationPlan() { 
		return driver.findElement(ventillationPlan); 	
}
	
	public WebElement getlifeSavingAppliances() { 
		return driver.findElement(lifeSavingAppliances); 	
}
	public WebElement getfireFightingAppliances() { 
		return driver.findElement(fireFightingAppliances); 
			
	}
	public WebElement getcommunicationEquipment() { 
		return driver.findElement(communicationEquipment); 	
}
	public WebElement getcompartmentSubDivCalc() { 
		return driver.findElement(compartmentSubDivCalc); 	
}
	
	public WebElement getpreliminaryStability() { 
		return driver.findElement(preliminaryStability); 	
}
	public WebElement getdamageStability() { 
		return driver.findElement(damageStability); 
			
	}
	public WebElement getpreview() { 
		return driver.findElement(previewButton); 	
}	
}