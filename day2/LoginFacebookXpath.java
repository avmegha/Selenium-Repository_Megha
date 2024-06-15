package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginFacebookXpath {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("avmegha@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("abcd");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}

}
