package acix;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminLogin {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://ui.acix-admin-qa.ults.build/licensemanagement");
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("Admin@1234");;
		Thread.sleep(2000);
		driver.findElement(By.id("kc-login")).click();
		Thread.sleep(2000);
		driver.navigate().refresh(); 
		
	}
	

}
