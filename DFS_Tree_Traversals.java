package ctci;

import java.util.ArrayList;
import java.util.Stack;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class DFS_Tree_Traversals {		
	
	 //Leetcode's definition for a binary tree node
	 static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
		 String text;
	     TreeNode(int x) { val = x; }
	 }
	 	 
	public static class Solution {
		
public Solution() {
			
		}

//		public Solution(ctci.ConvertSortedArrayToBST_NotAccepted.TreeNode answer) {
//			//this.inorderTraversal = inorderTraversal;
//		}
		
	    public ArrayList<Integer> preorderTraversal(TreeNode root) {
	    	//accepted submission to: https://leetcode.com/problems/binary-tree-preorder-traversal/description/
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        s.push(root);
	        
	        while(!s.empty()) {
	            TreeNode current = s.peek(); 
	            s.pop();
	            
	            if(current != null) {
	                s.push(current.right);
	                s.push(current.left);
	                result.add(current.val);
	            }
	        }
	        
	        System.out.println("result: " + result);
	        return result;
	    }
	    
	    public ArrayList<Integer> inorderTraversal(TreeNode root) {
	    	
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
	}
	
	public static void main(String[] args) {
		
		int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//setting root value:
		TreeNode originalRoot = new TreeNode(-10);
		
		//setting up left side of root:
		originalRoot.left = new TreeNode(-3);
		originalRoot.left.left = new TreeNode(4);
		originalRoot.left.right = new TreeNode(5);
		
		//setting up right side of root:
		originalRoot.right = new TreeNode(3);
		
		Solution solution = new Solution();
		System.out.println("tree:\n" + solution.inorderTraversal(originalRoot));
	}
}

