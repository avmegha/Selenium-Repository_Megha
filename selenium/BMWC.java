package week3.day1;

public class BMWC extends CarP {
	public void sunroof() {
		System.out.println("I am coming from C-Sunroof");
	}
	public static void main(String[] args) {
		BMWC c=new BMWC();
		c.brake();
		c.gear();
		c.horn();
		c.sunroof();
	}
}
