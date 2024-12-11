package com.ults.selenium.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ults.selenium.commonfunctions.CommonFunctions;

public class LoginPage {

	public WebDriver driver;
	CommonFunctions cf = new CommonFunctions();

	//By user_name = By.cssSelector("#userName");
	
	By username = By.xpath("//input[@id='username']");

	By password = By.xpath("//input[@id='password']");

	By loginButton = By.xpath("//input[@id='kc-login']");

	//By logoutButton = By.xpath("//button[2]/span[1]");
	
	By logoutButton=By.xpath("//span[normalize-space()='Log Out']");

	
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;

	}

	
	public WebElement getUsername() { //return driver.findElement(user_name);
		return driver.findElement(username); 
	}
	 

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLoginButton() {
		return driver.findElement(loginButton);
	}

	public WebElement getLogoutButton() {
		return driver.findElement(logoutButton);
	}
	 public void login(String username, String password) {
	        getUsername().sendKeys(username);
	        getPassword().sendKeys(password);
	        getLoginButton().click();
	    }
	
}