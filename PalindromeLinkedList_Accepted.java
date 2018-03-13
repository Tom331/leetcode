package ctci;

import java.util.ArrayList;
import java.util.Collections;

public class PalindromeLinkedList_Accepted {
	
	public static void main(String[] args) {
		ListNode node = new ListNode(0);
		node.next = new ListNode(0);
		//node.next.next = new ListNode(1);
		//node.next.next.next = new ListNode(1);
		
		ArrayList firstHalf = new ArrayList();
		ArrayList secondHalf = new ArrayList();
		
		int count = 0;
		
		ListNode counterNode = node;
		while(counterNode != null) {
			count++;
			counterNode = counterNode.next;
		}
		
		int middle = count/2;
		boolean middleIgnored = count%2 != 0;
		for(int i = 0; i < middle; i++) {
			firstHalf.add(node.val);
			node = node.next;
		}
		
		if(middleIgnored) {
			node = node.next;
			System.out.println("middle ignored");
		}
		
		for(int i = middle + 1; node != null; i++) {
			secondHalf.add(node.val);
			node = node.next;
		}
		
		Collections.reverse(secondHalf);
		boolean isPalindrome = firstHalf.equals(secondHalf);
		
		System.out.println("first half: " + firstHalf);
		System.out.println("\nsecond half: " + secondHalf);
		System.out.println("\npalindrome? " + isPalindrome);
		
	}
	
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}