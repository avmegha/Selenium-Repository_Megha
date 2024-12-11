package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchChromeBrowser {
	public static void main(String[] args) {
		
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://connect.ults.in/web/login");
		
		driver.findElement(By.id("email-id")).sendKeys("megha.av@ultsglobal.com");
		driver.findElement(By.name("password")).sendKeys("Ults@2024");
		driver.findElement(By.xpath("//button[@id='login-button-id']")).click();
		
		String title=driver.getTitle();
		System.out.println(title);
		
		if(title.contains("Ul")) {
				System.out.println("Logged into UlConnect");
		}
		else {
			System.out.println("Not logged in");
			
		}
		
		
	}

}
