package ctci;

import java.util.Arrays;
import java.util.Stack;

import ctci.DFS_Tree_Traversals.TreeNode;

public class PleasTreeQ {
	
	public static void main(String[] args) {
		TreeNode originalRoot = new TreeNode(-10);
		originalRoot.left = new TreeNode(-3);
		originalRoot.left.left = new TreeNode(4);
		originalRoot.left.right = new TreeNode(5);
		foo(originalRoot);
	}
	
	public static void foo(TreeNode root) {
		Stack nodes = new Stack();
		nodes.push(root);
		System.out.println("nodes.size: " + nodes.size());
		
		while(nodes.size() > 0) {
			TreeNode node = (TreeNode) nodes.pop();
			System.out.println(node.text);
			for(int i = nodes.size()-1; i >= 0; i--) {
				//nodes.push(nodes[i]);
			}
		}
	}

}
