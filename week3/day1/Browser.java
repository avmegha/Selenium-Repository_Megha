package week3.day1;

public class Browser {

	String browserName= "Chrome";
	float browserVersion= 3.1f;
	
	public void openUrl() {
		System.out.println("URL Opened-from GP class");
	}
	public void closeBrowser() {
		System.out.println("URL Closed-from GP class");
		}
	public void navigateBack() {
		System.out.println("Navigate back-from GP class");
		}
	public static void main(String[] args) {
		Browser br=new Browser();
		System.out.println(br.browserName);
		System.out.println(br.browserVersion);
	}
		

}

