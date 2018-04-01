package ctci;

public class RotateStringVirtualQuiz {
	
	public static void main(String[] args) {
		
		String A = "abcde";
		String B = "abced";
		
		System.out.println("a: " + A);
		if(A == B)
			System.out.println("True");
		
		if(A.length() != B.length())
			System.out.println("False");
		
		StringBuilder sb = new StringBuilder(A);
		for(int i = 0; i < A.length(); i++) {
			sb.append(sb.charAt(0));
			System.out.println("new a: " + sb);
			sb.delete(0, 1);
			System.out.println("new a: " + sb);
			if(sb.toString().equals(B))
				System.out.println("true");
		}
		
		System.out.println("FALSE");
		
	}

}
