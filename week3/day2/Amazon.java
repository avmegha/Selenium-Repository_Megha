package week3.day2;

public class Amazon extends CanaraBank {
	public static void main(String[] args) {
		Amazon A=new Amazon();
		A.cashOnDelivery();
		A.cardPayments();
		A.internetBanking();
		A.recordPaymentDetails();
		A.upiPayments();
	}
public void recordPaymentDetails() {
	System.out.println("Record payment details from abstract class");
}
public void internetBanking() {
	System.out.println("Internet banking from Abstract class");	
}
public void cashOnDelivery() {
	System.out.println("COD from Abstract class");	
}
public void cardPayments() {
	System.out.println("Credit Card from Abstract class");	
}
public void upiPayments() {
	System.out.println("UPI from Abstract class");	
}

}
