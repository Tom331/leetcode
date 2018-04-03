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
		
//public Solution() {
//			
//		}

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
	    
	    
	    
	    //RECURSIVE METHODS
	    
	    int level = -1; // -1 denotes null node
	    ArrayList<Integer> inorderResult = new ArrayList<Integer>();
	    
	    class Frame {
	    	private int value;
	    	private int recursionLevel;
	    	
	    	public Frame(int value, int recursionLevel) {
	    		this.value = value;
	    		this.recursionLevel = recursionLevel;
	    	}
	    	
	    	public String toString() {
	    		String result = "\n\nvalue: " + value + "\nrecursion level: " + recursionLevel;
	    		return result;
	    	}
	    }
	    ArrayList<Frame> stackFrame = new ArrayList<Frame>();
	    public void printInorderRecursive(TreeNode node)
	    {	
	        if (node == null) {
	        	//System.out.print("\n~~~\nNode: NULL" + "\nRecursion Level: " + recursionLevel);
	        	System.out.println("null node");
	        	stackFrame.add(new Frame(-1, level));
	            return;
	        }
	 
	        /* first recur on left child */
	        printInorderRecursive(node.left);
	 
	        /* then print the data of node */
	        //System.out.print("\n~~~\nNode:" + node.val + "\nRecursion Level: " + recursionLevel);
	        inorderResult.add(node.val);
	 
	        /* now recur on right child */
	        printInorderRecursive(node.right);
	        System.out.println("\ninorderResult: " + inorderResult);
	        System.out.println("\nstackFrame: " + stackFrame.toString());
	        //return implied here
	    }
	    
	    
	    
	} //end class Solution
	
	public static void main(String[] args) {
		
		int[] myArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		//setting root value:
		TreeNode originalRoot = new TreeNode(1);
		
		//setting up left side of root:
		originalRoot.left = new TreeNode(2);
		originalRoot.left.left = new TreeNode(4);
		originalRoot.left.right = new TreeNode(5);
		
		//setting up right side of root:
		originalRoot.right = new TreeNode(3);
		
		Solution solution = new Solution();
		solution.printInorderRecursive(originalRoot);
	}
}

