package com.ults.selenium.commonfunctions;

import org.openqa.selenium.WebDriver;

import com.ults.selenium.pomcollection.pomFile;


public class LoginVesselOwner extends CommonFunctions{
	 private WebDriver driver;

	    public LoginVesselOwner(WebDriver driver) {
	          this.driver = driver;
	    }

public void login(String UName, String PWord)
    {
        pomFile pom=new pomFile (driver);
        
        sendKeys(pom.getLoginPage().getUsername(), UName);
        sendKeys(pom.getLoginPage().getPassword(), PWord);
        click(pom.getLoginPage().getLoginButton());
        
    }
}

//Call to the script file like this
/*
 * Login lp=new Login(); lp.login(call from
 * configconstant(variablenameforusername),
 * prop.getProperty(variablenameforpassword));
 */