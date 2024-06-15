package marathon.day1;

	

	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.support.ui.Select;


public class AmazonTestcase {
		
	public static void main(String[] args)throws InterruptedException {
	EdgeDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	driver.get("https://www.amazon.in/");
	driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags for b");
	Thread.sleep(3000);

	driver.findElement(By.xpath("//div[@class='s-suggestion-container']/div[@role='button']")).click();
	Thread.sleep(3000);

	String count = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='search']/span[2]/div[1]/h1[1]/div[1]/div[1]/div[1]/div[1]")).getText();
	System.out.println("Count of Bags available :" +count);
	Thread.sleep(3000);

	driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::i")).click();
	System.out.println("Brand SkyBags selected");
	Thread.sleep(3000);

	driver.findElement(By.xpath("(//div[contains(@class,'a-checkbox a-checkbox-fancy')]//i)[2]")).click();
	 System.out.println("Brand Gear selected");
	 Thread.sleep(3000);
	 
	driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
	 Thread.sleep(3000);
	 
	 driver.findElement(By.xpath("//div[@id='a-popover-2']//ul[@role='listbox']/li[5]/a[@href='javascript:void(0)']")).click();
	System.out.println("Newest Arrival selected");
	Thread.sleep(3000);

	String bagSummary= driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/span/div/div/div[2]/div[1]/h2/a/span")).getText();
	System.out.println(bagSummary);
	   Thread.sleep(3000);
	   
	 String title=driver.findElement(By.xpath("//span[@class='nav-a-content']//img")).getText();
	System.out.println(title);
	//driver.close();
}
}