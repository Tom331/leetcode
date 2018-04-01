package ctci;

import ctci.DFS_Tree_Traversals.Solution;
import ctci.DFS_Tree_Traversals.TreeNode;

public class Scrap {
	
	public static void main(String[] args) {
		TreeNode originalRoot = new TreeNode(-10);
		
		//setting up left side of root:
		originalRoot.left = new TreeNode(-3);
		originalRoot.left.left = new TreeNode(4);
		originalRoot.left.right = new TreeNode(5);
		
		//setting up right side of root:
		originalRoot.right = new TreeNode(3);
		
		Solution solution = new Solution();
		Foo(originalRoot);
	}
	
	static void Foo(TreeNode root) {
        if (root == null)
            return;
        Foo(root.left);
        System.out.print(root.val + " ");
        Foo(root.right);
    }

}
