package ctci;

import java.util.ArrayList;
import java.util.Stack;

import ctci.DFS_Tree_Traversals.TreeNode;

//reference: https://stackoverflow.com/questions/26891747/convert-integer-array-into-a-binary-tree

public class ArrayToBinaryTree {
	
	static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	
public TreeNode sortedArrayToBST(int[] num) {
    if (num.length == 0) {
        return null;
    }
    TreeNode head = helper(num, 0, num.length - 1);
    return head;
}

public TreeNode helper(int[] num, int low, int high) {
    if (low > high) { // Done
        return null;
    }
    int mid = (low + high) / 2;
    TreeNode node = new TreeNode(num[mid]);
    node.left = helper(num, low, mid - 1);
    node.right = helper(num, mid + 1, high);
    return node;
}



public static ArrayList<Integer> inorderTraversal(TreeNode root) {
	
	//accepted submission to https://leetcode.com/problems/binary-tree-inorder-traversal/description/
	Stack<TreeNode> nodes = new Stack<TreeNode>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    
    if(root == null) return result;
    
    while(root != null || !nodes.empty()) {
    	//push left children if available
    	while(root != null) {
    		nodes.push(root);
    		root = root.left;
    		//result.add(root.val);
    	}
    	
    	//retrieve top node and store its right child if exists
    	root = nodes.peek();
    	nodes.pop();
    	
    	//add value of root to result array
    	result.add(root.val);
    	root = root.right;
    }
    return result;
}
	
	public static void main(String[] args) {
		int[] myArray = {1,2,3,4,5,6,7,8,9,10};
		ArrayToBinaryTree instance = new ArrayToBinaryTree();
		
		TreeNode finalAnswer = instance.sortedArrayToBST(myArray);
		ArrayList<Integer> tree = inorderTraversal(finalAnswer);
		System.out.println(tree);
	}

}
