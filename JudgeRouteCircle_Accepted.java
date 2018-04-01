package ctci;

public class JudgeRouteCircle_Accepted {
	
	public static void main(String[] args) {
		System.out.println(judgeCircle("UUDDDLLRUR"));
	}
	
	public static boolean judgeCircle(String moves) {
		int numU = 0;
		int numD = 0;
		int numL = 0;
		int numR = 0;
		for(int i = 0; i < moves.length(); i++) {
			if(moves.charAt(i) == 'U')
				numU++;
			if(moves.charAt(i) == 'D')
				numD++;
			if(moves.charAt(i) == 'L')
				numL++;
			if(moves.charAt(i) == 'R')
				numR++;
		}
		if(numU == numD && numL == numR)
			return true;
		else
			return false;
	}

}
