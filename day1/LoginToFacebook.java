package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToFacebook {
	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys("avmegha@gmail.com");
	    driver.findElement(By.name("pass")).sendKeys("abcd");
	    driver.findElement(By.name("login")).click();
	    String title= driver.getTitle();
	    System.out.println(title);
	    if (title.contains("Home")) {
	    	System.out.println("Logged in to Facebook");
	    }
	    else {
	    	System.out.println("Not logged in");
	    }
	
		//driver.close();

	}
}
