package ctci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class TwoSumIVInputIsBST_Accepted {
	
	class Solution {
	    
	    ArrayList<Integer> myArray = new ArrayList<Integer>();
	    
	    
	    
	    public boolean findTarget(TreeNode root, int k) {
	    loadTree(root);
	    
	    if(myArray.size() < 2) {
	        return false;
	    }
	    
	    Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();
	        
	    for(int i = 0; i < myArray.size(); i++) {
	        ht.put(i, myArray.get(i)); //should you store the value in the key instead? since ht's are mapped on the key?
	    }
	    //System.out.println("ht: " + ht);
	        
	    for(int i = 0; i < myArray.size(); i++) {
	        int current = myArray.get(i);
	        ht.values().remove(current);
	        //System.out.println("array contains target (" + (k-current) + "): " + ht.containsValue( (k - current)));
	        if(ht.containsValue(k - current)) {
	            return true;
	        }
	    }
	    return false;
	    }
	    
	    public ArrayList<Integer> loadTree(TreeNode root) {
	        if(root != null) {
	            myArray.add(root.val);
	            loadTree(root.right);
	            loadTree(root.left);
	        }
	        //System.out.println("array: " + myArray);
	        return myArray;
	    }
	    //System.out.println("array: " + myArray);
	}
	

}

