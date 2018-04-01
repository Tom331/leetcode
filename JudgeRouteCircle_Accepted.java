package ctci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JudgeRouteCircle_Accepted {
	
	public static void main(String[] args) {
		System.out.println(judgeCircle("UUDDDLLRUR"));
	}
	
	public static <T> boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < moves.length(); i++) {
			if(moves.charAt(i) == 'U')
				x++;
			if(moves.charAt(i) == 'D')
				x--;
			if(moves.charAt(i) == 'L')
				y--;
			if(moves.charAt(i) == 'R')
				y++;
		}
		return x == 0 && y == 0;
	}

}
