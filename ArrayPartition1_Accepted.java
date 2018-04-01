package ctci;

import java.util.Arrays;

public class ArrayPartition1_Accepted {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		System.out.println(arrayPairSum(nums));
	}
	
	public static int arrayPairSum(int[] nums) {
		int sum = 0;
		Arrays.sort(nums);
		for(int i = 0; i <= nums.length - 2; i+=2) 
			sum += nums[i];
		return sum;
	}

}
