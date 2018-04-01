package ctci;

public class ImplementBinSearch {
	
	public static void main(String[] args) {
		int[] input = {1, 4, 5, 7, 9};
		int answer = BinarySearch(input, 6, 0, input.length-1);
		System.out.println(answer);
		
	}
	
	static int mid;
	public static int BinarySearch(int[] A, int searchValue, int low, int high) {
		if(A.length < 1) {
			System.out.println("not found");
		}
		
		mid = low + ((high - low) /2);
		System.out.println("mid: " + mid);
		if(A[mid] > searchValue)
			return BinarySearch(A, searchValue, low, mid-1);
		
		else if (A[mid] < searchValue)
			return BinarySearch(A, searchValue, mid+1, high);
		
		else
			return mid;
	}

}
