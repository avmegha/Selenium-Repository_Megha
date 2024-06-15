package week3.day1;

public class Overloading {
	
	public void reportStep(String msg, String  status) {
		System.out.println(msg+status);
	}
public void reportStep(String msg, String  status, boolean snap) {
	if(snap) {
		System.out.println(msg+status);
	}
}
public static void main(String[] args) {
	Overloading ov=new Overloading();
	ov.reportStep("Hello", " Testleaf ");
	ov.reportStep("happy", " learning ", true);
}
}
