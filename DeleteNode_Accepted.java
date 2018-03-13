package ctci;

import java.util.LinkedList;
import java.util.List;

public class DeleteNode_Accepted {

/*	Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
	Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.*/
	
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		
		deleteNode(node.next.next);
		while(node != null) {
			System.out.println(node.val);
			node = node.next;
		}
		System.out.println(3/2);
	}
	
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	 
	
	public static void deleteNode(ListNode node) {
	    node.val = node.next.val;
	    node.next = node.next.next;
	}
	
	//my solution:
	static LinkedList<Integer> deleteNode(LinkedList<Integer> list, int val) {
		
		
			for(int i = 0; list.get(list.indexOf(i) + 1) != null; i++) {
					if(list.get(i) == val) {
						list.remove(i);
						System.out.println(list);
					}
					else {
						System.out.println("Item not found or is last item");
					}
		}
		return list;
	}
}
