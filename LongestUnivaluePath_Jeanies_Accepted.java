package ctci;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.plaf.synth.SynthSeparatorUI;


//STUCK: https://leetcode.com/problems/longest-univalue-path/description/
public class LongestUnivaluePath_Jeanies_Accepted {
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public int longestUnivaluePath(TreeNode root) {
	        int longest = 0;
	        if (root == null) return 0;
	        
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        while (!stack.isEmpty()) {
	            TreeNode currentNode = stack.pop();
	            int currentLongest = getLongest(currentNode.left, currentNode.val) + getLongest(currentNode.right, currentNode.val);
	            if (currentNode.left != null) stack.push(currentNode.left);
	            if (currentNode.right != null) stack.push(currentNode.right);
	            if (longest < currentLongest) longest = currentLongest;
	        }
	        return longest;
	        
	    }
	    
	    public int getLongest(TreeNode root, int value) {
	        if (root == null || root.val != value) return 0;
	        return Math.max(getLongest(root.left, value) + 1, getLongest(root.right, value)+1);
	        
	    }
	}
	
	public void main(String[] args) {
		Solution solution = new Solution();
	}
}
