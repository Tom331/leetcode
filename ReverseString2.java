package ctci;

import java.util.Collections;

public class ReverseString2 {
	
	public static void main(String[] args) {
		String input = "abcdefghijk";
		reverseStr(input, 2);
	}
	
public static String reverseStr(String s, int k) {
	
	String finalString = "";
	int count = 0;
	int strPointer = 0;
	while(count < s.length() - 1) {
		String firstHalf = "";
		String secondHalf = "";
		while(strPointer %k/2 != 0) {
			firstHalf += String.valueOf(s.charAt(strPointer));
			strPointer++;
		}
		
		while(strPointer % k/2 != 0) {
			secondHalf += String.valueOf(s.charAt(strPointer));
			strPointer++;
		}
		new StringBuilder(secondHalf).reverse().toString();
		finalString += firstHalf;
		finalString += secondHalf;
		System.out.println(finalString);
		count++;
	}
        
	return s;
    }
	
}


