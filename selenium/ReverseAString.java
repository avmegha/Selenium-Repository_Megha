package week1.assignments;

public class ReverseAString {
	public static void main(String[] args) {
		String input = "Dilip";
		char[] ch = input.toCharArray();
		
		for(int i= ch.length-1; i>=0; i--)
		{
			System.out.print(ch[i]);
		}
		
	}

}
