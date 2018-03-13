package ctci;

public class CountBinarySubstringsFourthTry {
	
	public static void main(String[] args) {
		
		/*
		 * BRANCH 'MASTER'
		 * This branch saves more work than temp, but does not pass test cases
		 */
		
		
		/* TEST CASES
		 * 3: 00110 
		 * 6: 00110011
		 * 4: 10101
		 * 5: 1110000100
		 * 3: 00100
		 */
		
		//TST
		
		
		String s = "00110";
		//int evenOrOdd = s.length() % 2;
		
		int count = 0;
		int curStreak = 0;
		int streakA = 1;
		int streakB = 1;
		int streakAholder = 0;
		int streakBholder = 0;
		
		for(int i = 0; i < s.length() - 1; i++) {
			System.out.println("comparing " + s.charAt(i) + " and " + s.charAt(i+1) + "\ni: " + i);
			if(curStreak % 2 == 0 && s.charAt(i) == s.charAt(i + 1) ) {
				streakA++;
				System.out.println("increased a");
				streakAholder = streakA;
				streakBholder = streakB;
			}
			else if(curStreak % 2 == 0) { //the 10 at end aren't equal..
				curStreak++;
				System.out.println("curStreak now == " + curStreak);
				System.out.println(streakA + "\n" + streakB);
				streakAholder = streakA;
				streakBholder = streakB;
			}
			else if(curStreak % 2 == 1 && s.charAt(i) == s.charAt(i + 1) && streakB < streakA) {
				streakB++;
				System.out.println("increased b");
				streakAholder = streakA;
				streakBholder = streakB;
			}
			else if(curStreak % 2 == 1) {
				System.out.println("\n~~~~~\nend of both streaks\nstreakA: " + streakA + "\nstreakB: " + streakB + "\ni: " + i);
				curStreak++;
//				if((streakA + streakB) % 2 == 1) {
//					count--; //because you're going to count it again later
//				}
				System.out.println("curStreak now == " + curStreak);
				count += Math.min(streakA, streakB);
				System.out.println("count += " + Math.min(streakA, streakB));
				
//				if(streakA == streakB && streakA != 1) {
//					s = s.substring(streakA + streakB, s.length());
//				}
//				else {
//					s = s.substring(streakA, s.length());
//				}
				System.out.println("new string: " + s);
				
				streakAholder = streakA;
				streakBholder = streakB;
//				if(streakBholder == 0 && s.charAt(s.length() - 1) != s.charAt(s.length() - 2)) {
//					streakBholder = 1;
//				}
//				if(streakAholder == 0 && s.charAt(s.length() - 1) != s.charAt(s.length() - 2)) {
//					streakAholder = 1;
//				}
				
				streakA = 1;
				streakB = 1;
				//i = -1;
				
//				StringBuilder temp = new StringBuilder(s);
//				temp.delete(0, streakA + streakB);
			}
			
			boolean all0 = s.replaceAll("0", "").equals("");
			boolean all1 = s.replaceAll("1", "").equals("");
			if( (streakAholder + streakBholder) == s.length() && !all0 && !all1) { //if odd, we want s.length-2. if even we want s.length - 1... but it takes the "new" s.len
				System.out.println("Final if()");
				System.out.println("streak a: " + streakAholder + "\nstreak B: " + streakBholder);
				count += Math.min(streakAholder, streakBholder);
				System.out.println("count += " + Math.min(streakAholder, streakBholder));
				i = 50000; //ensure loop doesn't run again
			}
		}
		System.out.println("count: " + count);
	}

}
