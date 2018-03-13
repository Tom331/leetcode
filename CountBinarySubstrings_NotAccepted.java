package ctci;

//https://leetcode.com/problems/count-binary-substrings/description/
public class CountBinarySubstrings_NotAccepted {

	public static void main(String[] args) {
		String str = "10101";
		char[] charArray = str.toCharArray();
		System.out.println(charArray);
		int finalSubstringCount = 1;
		
		char c = str.charAt(0);
		boolean allEqual = true;
		for(int i = 1; i<str.length(); i++) {
			if(str.charAt(i) != c)
				allEqual = false;
			    //return 0;
		}
		
		if(allEqual) {
			System.out.println("all strings equal");
			//return 0
		}
		
		for(int i = 0; i<str.length(); i++) {
			int j = i;
			
			int firstSubstringCount = 0;
			int secondSubstringCount = 0;
			String temp = String.valueOf(charArray[i]);
			
			while(j < str.length()-1 && charArray[i] == (charArray[++j])) {
				temp+=charArray[j];
			}
			firstSubstringCount = temp.length();
			System.out.println("1st...temp: " + temp + ", i: " + i + ", j: " + j + " length: " + firstSubstringCount);
			
			temp = String.valueOf(charArray[j]);
			while(j < str.length()-1 && charArray[j] == (charArray[++j])) {
				temp+=charArray[j];
			}
			secondSubstringCount = temp.length();
			System.out.println("2nd...temp: " + temp + ", i: " + i + ", j: " + j + " length: " + secondSubstringCount);
			
			if(firstSubstringCount == secondSubstringCount)
				finalSubstringCount++;
		}
//		if(finalSubstringCount %2 == 0)
//			finalSubstringCount++;
		System.out.println("\n" + finalSubstringCount);
	}
}
