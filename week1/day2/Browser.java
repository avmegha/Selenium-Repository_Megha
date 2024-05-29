package week1.day2;

public class Browser {
	public String launchBrowser(String browserName)
	{
		System.out.println("Browser Launched Successfully");
		return browserName;
	}
public void loadUrl()
{
	System.out.println("Application url loaded Successfully");
}
public static void main(String[] args) {
	Browser method=new Browser();
	method.launchBrowser("Browser launched Successfully");
	method.loadUrl();
	
}
}
