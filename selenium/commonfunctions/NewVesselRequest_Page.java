package com.ults.selenium.commonfunctions;
	
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.ults.selenium.pageobjects.Dashboard_Page;
	import com.ults.selenium.pomcollection.pomFile;

	public class NewVesselRequest_Page  extends CommonFunctions{
		private WebDriver driver;
		
		public NewVesselRequest_Page(ChromeDriver driver) {
			this.driver=driver;
		}
			
		public void clickOnAddVessel() {
	        pomFile pom=new pomFile (driver);
	        click(pom.getDashboard_Page().getAddVessel());
		}  			   
	}

