package week3.day1;

public class ReverseAString {
	public static void main(String[] args) {
		String input= "Megha";
		char[] ch=input.toCharArray();
		for(int i=ch.length-1;i>=0;i--) {
			System.out.println(ch[i]);
		}
	}

}
