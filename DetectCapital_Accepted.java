package ctci;

public class DetectCapital_Accepted {
	
	static String word = "LeetCode";
	
	public static void main(String[] args) {
		
		boolean allCaps = true;
		for(int i = 0; i < word.length(); i++) {
			if(!Character.isUpperCase(word.charAt(i))) {
				allCaps = false;
				break;
			}
		}
		
		boolean firstIsCap = true;
		if(!Character.isUpperCase(word.charAt(0))) {
			firstIsCap = false;
		}
		else {
			for(int i = 1; i < word.length(); i++) {
				if(Character.isUpperCase(word.charAt(i))) {
					firstIsCap = false;
					break;
				}
			}
		}
		
		boolean allLower = true;
		for(int i = 0; i < word.length(); i++) {
			if(Character.isUpperCase(word.charAt(i))) {
				allLower = false;
				break;
			}
		}
		
		System.out.println(allCaps || firstIsCap || allLower);
	}

}
