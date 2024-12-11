package com.ults.selenium.pomcollection;

import org.openqa.selenium.WebDriver;

import com.ults.selenium.commonfunctions.DashboardPage;
import com.ults.selenium.pageobjects.LoginPage;
import com.ults.selenium.pageobjects.NewApplicationPage;
import com.ults.selenium.pageobjects.NewVesselPage;
import com.ults.selenium.pageobjects.ParticularsOfEquipmentPage;
import com.ults.selenium.pageobjects.ParticularsOfFireAppliancePage;
import com.ults.selenium.pageobjects.ParticularsOfHulls;
import com.ults.selenium.pageobjects.PropulsionEnginesPage;
import com.ults.selenium.pageobjects.AdditionalInformationPage;
import com.ults.selenium.pageobjects.Dashboard_Page;
import com.ults.selenium.pageobjects.FileUploadPage;



public class pomFile {

	public WebDriver driver;

	public pomFile(WebDriver rdriver) {
		this.driver = rdriver;
	}

// Need to create object for each page objects

	public LoginPage getLoginPage() {
		LoginPage lp = new LoginPage(driver);
		return lp;
	}
	
	
	 public Dashboard_Page getDashboard_Page() { 
	 Dashboard_Page dp=new Dashboard_Page(driver); 
	 return dp; 
	  }
	
	 public NewVesselPage getNewVesselPage() { 
	 NewVesselPage nv=new  NewVesselPage(driver); 
	 return nv; 
	 }
	 
	 public NewApplicationPage getNewApplicationPage() { 
	 NewApplicationPage na=new  NewApplicationPage(driver); 
	 return na; 
	 }
	 public ParticularsOfHulls getParticularsOfHulls() { 
	 ParticularsOfHulls ph=new  ParticularsOfHulls(driver); 
	 return ph; 
		 }
	 public PropulsionEnginesPage getPropulsionEnginesPage() { 
	 PropulsionEnginesPage pe=new  PropulsionEnginesPage(driver); 
	 return pe; 
			 }
	 public ParticularsOfEquipmentPage getParticularsOfEquipmentPage() { 
	 ParticularsOfEquipmentPage peq=new  ParticularsOfEquipmentPage(driver); 
	 return peq; 
			 } 
	 public ParticularsOfFireAppliancePage getParticularsOfFireAppliancePage() { 
	 ParticularsOfFireAppliancePage pf=new  ParticularsOfFireAppliancePage(driver); 
	 return pf; 
				 } 
	 public AdditionalInformationPage getAdditionalInformationPage() { 
		 AdditionalInformationPage ai=new  AdditionalInformationPage(driver); 
	 return ai; 
				 } 
	 
	 public FileUploadPage getFileUploadPage() { 
	 FileUploadPage fu=new  FileUploadPage(driver); 
	 return fu; 
	 
	 }
}