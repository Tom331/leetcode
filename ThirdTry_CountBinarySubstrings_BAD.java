package ctci;

public class ThirdTry_CountBinarySubstrings_BAD {
	
	public static void main(String[] args) {
		String s = "01";
		
		if(s.equals("01") || s.equals("10")) {
			System.out.println("1");
		}
		int count = 0;
		
		int i = 0;
		for(int k = 2; k < (s.length()/2)+1; k++) {
			//k=3
			if(i != s.length()-(k+(1*k-3))) {
				k--;
			}
			else if(i == s.length()-(k+(1*k-3))) {
				i = 0;
				System.out.println("~~~~~\n");
			}
			
			System.out.println("i: " + i);
			System.out.println("k: " + k);
			
			String temp1 = "";
			String temp2 = "";
			
			temp1 += s.substring(i, (i+k));
			System.out.println("temp1: " + temp1);
			i += k;
			temp2 += s.substring(i, i+k);
			System.out.println("temp2: " + temp2);
			i-=k;
			
			boolean t1all0 = temp1.replace("0", "").equals("");
			boolean t1all1 = temp1.replace("1", "").equals("");
			
			boolean t2all0 = temp2.replace("0", "").equals("");
			boolean t2all1 = temp2.replace("1", "").equals("");
			
			if( (t1all0 && t2all1) || (t1all1 && t2all0)) {
				count++;
			}
			i++;
		}
		System.out.println(count);
	}

}
