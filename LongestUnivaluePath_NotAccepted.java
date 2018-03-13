package ctci;

import java.util.ArrayList;
import java.util.Stack;

import javax.swing.plaf.synth.SynthSeparatorUI;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    Boolean visited;
    TreeNode(int x) { val = x; }
}
//STUCK: https://leetcode.com/problems/longest-univalue-path/description/
public class LongestUnivaluePath_NotAccepted {
	
	public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        s.push(root);
        
        while(!s.empty()) {
            TreeNode current = s.peek(); 
            s.pop();
            
            if(current != null) {
            	// if want to do preorder traversal(root, right left) instead of (root, left, right), push left first, then right
                s.push(current.right);
                s.push(current.left);
                
                result.add(current.val);
                //System.out.println("added: " + current.val);
            }
            if(current == null) {
//            	result.add(result.get(result.size()-1));
//            	System.out.println("added: " + result.get(result.size()-1));
            }
        }
        
        System.out.println("result: " + result);
        return result;
    }
	
	static ArrayList<Integer> result = new ArrayList<Integer>();
	static int count = 0;
	public static ArrayList<Integer> addNode(TreeNode root, TreeNode previous) {
		count++;
		while(count < 25) {
		System.out.println("result.size:" + result.size());
		result.add(root.val);
		if(root.left != null && root.left.visited == null) {
			System.out.println("root.left.visited: " + root.left.visited);
			root.left.visited = true;
			System.out.println("root.left.visited: " + root.left.visited);
			addNode(root.left, root);
		}
		else if(root.right != null && root.right.visited == null) {
			System.out.println("root.right.visited: " + root.right.visited);
			root.right.visited = true;
			System.out.println("root.right.visited: " + root.right.visited);
			addNode(root.right, root);
		}
		else {
			addNode(previous, root);
		}
		
		}
		return result;
	}
	
	
	
	
	
	
	
	//given answer:
	static int ans;
    public static int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public static int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        System.out.println("left = arrowLength(node.left): " + arrowLength(node.left));
        int right = arrowLength(node.right);
        System.out.println("right =  arrowLength(node.right): " + arrowLength(node.right));
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
	
	public static void main(String[] args) {
		//setting root value:
		TreeNode originalRoot = new TreeNode(5);
		
		TreeNode previousNode;
		
		//setting up left side of root:
		originalRoot.left = new TreeNode(4);
		originalRoot.left.left = new TreeNode(1);
		originalRoot.left.right = new TreeNode(1);
		
		//setting up right side of root:
		originalRoot.right = new TreeNode(5);
		originalRoot.right.right = new TreeNode(5);
		
		//given solution:
		int newResult = longestUnivaluePath(originalRoot);
		System.out.println("Final Answer: " + newResult);
		
		//addNode(originalRoot, null);
		//System.out.println("Fully traversed tree: " + result);
		
		
//		System.out.println("tree:\n" + preorderTraversal(originalRoot));
//		ArrayList<Integer> result = preorderTraversal(originalRoot);
//		
//		if(result.size()-1 == 1) {
//			System.out.println(1);
//		}
//		
//		int maxLength = 0;
//		int currentLength = 1;
//		for(int i = 0; i < result.size()-1; i++) {
//			if(result.indexOf(i) == result.indexOf(i-1)) {
//				currentLength++;
//			}
//			else {
//				if(currentLength > maxLength) {
//					maxLength = currentLength;
//					System.out.println("New maxLength: " + maxLength);
//					currentLength = 0;
//				}
//			}
//		}
		
	}
	
	public static void updateMaxLength(int length) {
		
	}

}
