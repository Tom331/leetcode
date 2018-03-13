package ctci;

public class Practice {
	
	public static boolean canConstruct(String ransomNote, String magazine) {
        boolean canCreate = true;
        
        for(int i = 0; i < ransomNote.length(); i++) {
        	int charPosition = magazine.indexOf(ransomNote.charAt(i));
        	if(charPosition == -1) {
        		System.out.println("not found..return false");
        		return false;
        	}
        	StringBuilder sb = new StringBuilder(magazine);
        	sb.deleteCharAt(charPosition);
        	magazine = sb.toString();
        }
		return canCreate;
    }

	public static void main(String[] args) {
		String ransomNote = "aa";
		String magazine = "ab";
		canConstruct(ransomNote, magazine);
	}
	
}
