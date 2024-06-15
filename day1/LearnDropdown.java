package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {
public static void main(String[] args) {
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.leafground.com/select.xhtml");
	WebElement db=driver.findElement(By.className("ui-selectonemenu"));
	Select option=new Select(db);
	option.selectByIndex(3);		
	
}
}
