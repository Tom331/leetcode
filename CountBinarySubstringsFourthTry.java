package ctci;

public class CountBinarySubstringsFourthTry {
	
	public static void main(String[] args) {
		/*
		 * BRANCH 'TEMP'
		 * correct for all my test cases, but gets 'time limit exceeded' on test case 37/90 when submitting
		 */
		
		/* TEST CASES
		 * 3: 00110 
		 * 6: 00110011
		 * 4: 10101
		 * 5: 1110000100
		 * 2: 00100
		 * 	  might be 3
		 */
		
		//TST
		//test2
		
		
		String s = "00100";
		//int evenOrOdd = s.length() % 2;
		
		int count = 0;
		int curStreak = 0;
		int streakA = 1;
		int streakB = 1;
		int streakAholder = 0;
		int streakBholder = 0;
		
		for(int i = 0; i < s.length() - 1; i++) {
			if(curStreak % 2 == 0 && s.charAt(i) == s.charAt(i + 1) ) {
				streakA++;
				streakAholder = streakA;
				streakBholder = streakB;
			}
			else if(curStreak % 2 == 0) { //the 10 at end aren't equal..
				curStreak++;
				streakAholder = streakA;
				streakBholder = streakB;
			}
			else if(curStreak % 2 == 1 && s.charAt(i) == s.charAt(i + 1) && streakB < streakA) {
				streakB++;
				streakAholder = streakA;
				streakBholder = streakB;
			}
			else if(curStreak % 2 == 1) {
				curStreak++;

				count += Math.min(streakA, streakB);
				s = s.substring(streakA, s.length());
				
				streakAholder = streakA;
				streakBholder = streakB;

				
				streakA = 1;
				streakB = 1;
				i = -1;

			}
			
			boolean all0 = s.replaceAll("0", "").equals("");
			boolean all1 = s.replaceAll("1", "").equals("");
			if( (streakAholder + streakBholder) == s.length() && !all0 && !all1) { //if odd, we want s.length-2. if even we want s.length - 1... but it takes the "new" s.len
				count += Math.min(streakAholder, streakBholder);
				i = 50000; //ensure loop doesn't run again
			}
		}
		System.out.println("count: " + count);
	}

}
