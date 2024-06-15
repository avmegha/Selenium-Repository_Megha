package week3.day2;

import java.util.Iterator;

public class StringNoOfOccurance {
public static void main(String[] args) {
	String name= "Megha Binesh";
	int count=0;
	for (int i = 0; i < name.length(); i++) {
		
	if(name.charAt(i)=='e') {
		count++;
	}
 }
System.out.println("he number of occurance of e:"+count);	
}
}
