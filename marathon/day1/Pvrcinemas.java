package marathon.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Pvrcinemas {
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pvrcinemas.com/");
		
		driver.findElement(By.xpath("//span[text()='Chennai']")).click();
		driver.findElement(By.xpath("//span[text()='Cinema']")).click();
		driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'INOX National,Virugambakkam Chennai')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Tomorrow']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/ul[1]/li[1]/span[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'07:15 PM')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'sc-jlZhRR ewzZVH')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='SL.SILVER|F:21']")).click();
		Thread.sleep(3000);
		String bookingMovie = driver.findElement(By.xpath("//h5[contains(text(),'WEAPON')]")).getText();
		System.out.println(bookingMovie);
		Thread.sleep(3000);
		String bookingCinema = driver.findElement(By.xpath("//p[text()='INOX National,Virugambakkam Chennai']")).getText();
		System.out.println(bookingCinema);
		String  grandTotal1=driver.findElement(By.xpath("//div[@class='grand-prices']/h6")).getText();
		System.out.println("Grand Total1=" +grandTotal1);
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(3000);
		String  grandTotal2=driver.findElement(By.xpath("//h6[text()='Grand Total']")).getText();
		System.out.println("Grand Total2=" +grandTotal2);
		if(grandTotal1.equals(grandTotal2)) {
			System.out.println("Both prices are equal");
		}
		else {
			System.out.println("Both prices are different");
		}
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		Thread.sleep(3000);
		String pageTitle=driver.getTitle();
		System.out.println(pageTitle);
		
		
	}

}