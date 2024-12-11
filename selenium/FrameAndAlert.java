package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameAndAlert {
	public static void main(String[] args)throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		Thread.sleep(2000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[contains(text(),'Try it')]"));
		Thread.sleep(2000);
		Alert alert=driver.switchTo().alert();
		String alertText=alert.getText();
		System.out.println(alertText);
		alert.accept();
		String text=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println(text);
		driver.switchTo().parentFrame();
		driver.findElement(By.id("tryhome")).click();
		
	}
}
