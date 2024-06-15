package week3.day1;

public class Edge extends Browser {
	public void takeSnap() {
		System.out.println("Take snap from subclass Edge");
	}
	public void clearCookies() {
		System.out.println("Clear Cookies from subclass Edge");
	}
	public static void main(String[] args) {
		Edge ed=new Edge();
		ed.openUrl();
		ed.closeBrowser();
		ed.navigateBack();
	}
}
