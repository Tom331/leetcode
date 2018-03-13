package ctci;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Google_GetSomePractice {
	
	
	
	
	public static void main(String[] args) {
		String tempStr = "2-4A0r7-4k";
		int k = 3;
		
		tempStr = tempStr.replace("-", "");
		tempStr = tempStr.toUpperCase();
		
		StringBuilder str = new StringBuilder(tempStr);
		StringBuilder finalString = new StringBuilder("");
		System.out.println(str);
		finalString = str;
		System.out.println("finalstring: " + finalString);

		for(int i = finalString.length(); i >=0; i-=k) {
			finalString.insert(i, '-');
		}
		
		if(finalString.charAt(finalString.length()-1) == '-') {
			finalString.deleteCharAt(finalString.length()-1);
		}
		if(finalString.charAt(0) == '-') {
			finalString.deleteCharAt(0);
		}
		System.out.println(finalString);
		
	}	

}