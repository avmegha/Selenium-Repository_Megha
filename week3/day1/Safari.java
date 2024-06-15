package week3.day1;

public class Safari extends Browser{
	public void readerMode() {
		System.out.println("This is reader mode from Safari-subclass");
	}
	public void fullscreenMode() {
		System.out.println("This is fullscreen mode from Safari-subclass");
	}
	public static void main(String[] args) {
		Safari sf= new Safari();
		sf.closeBrowser();
		sf.openUrl();
		sf.navigateBack();
	}
}
