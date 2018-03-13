package ctci;

import java.util.ArrayList;

import ctci.DFS_Tree_Traversals.Solution;

public class ConvertSortedArrayToBST_NotAccepted {
	
	//see png in this folder for info
	
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public static TreeNode sortedArrayToBST(int[] num) {
	    if (num.length == 0) {
	        return null;
	    }
	    TreeNode head = helper(num, 0, num.length - 1);
	    return head;
	}

	public static TreeNode helper(int[] num, int low, int high) {
	    if (low > high) { // Done
	        return null;
	    }
	    int mid = (low + high) / 2;
	    TreeNode node = new TreeNode(num[mid]);
	    node.left = helper(num, low, mid - 1);
	    node.right = helper(num, mid + 1, high);
	    return node;
	}
	
	public static void main(String[] args) {
		int[] tree = {-10,-3,0,5,9};
		TreeNode answer = sortedArrayToBST(tree);
		//Solution solution = new Solution(answer);
		
		//ArrayList<Integer> inorder = solution.inorderTraversal(answer);
		
		//System.out.println(inorder);
	}

}
