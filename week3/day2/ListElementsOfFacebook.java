package week3.day2;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class ListElementsOfFacebook {
	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("www.facebook.com/");
		List<WebElement> elements=driver.findElements(By.tagName("a"));
		int totalElements=elements.size();
		System.out.println(elements);
		for (int i = 0;i<elements.size();i++) {
		System.out.println(elements.get(i).getText());	
		}
			
		}
	}


