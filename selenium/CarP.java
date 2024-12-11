package week3.day1;

public class CarP extends VehicleGP {

	public void gear() {
		System.out.println("Iam coming from P -gear");
	}
	public static void main(String[] args) {
		CarP p=new CarP();
		p.brake();
		p.gear();
		p.horn();
	}
}
