package week3.day1;

public class Chrome extends Browser{
	public void openIncognito() {
		System.out.println("Opening in Incognito from subclass CHROME");
	}
	public void clearCache() {
		System.out.println("Cache clearing from subclass CHROME");
	}
	public static void main(String[] args) {
		Chrome cr=new Chrome();
		cr.closeBrowser();
		cr.openUrl();
		cr.navigateBack();
	}
}
