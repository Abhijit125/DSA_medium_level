/*
REMOVE KTH INDEX FROM LAST IN LINKEDLIST
*/

import java.util.*;
class RemoveNodeFromEnd
{
	public static void main(String[] args) 
	{
		LinkedList ls = new LinkedList(0);
		ls.next = new LinkedList(1);
		ls.next.next = new LinkedList(1);
		ls.next.next.next = new LinkedList(2);
		ls.next.next.next.next = new LinkedList(3);
		ls.next.next.next.next.next = new LinkedList(4);
		ls.next.next.next.next.next.next = new LinkedList(5);

		removeKthEle(ls, 3);
		printList(ls);
	}

	public static void removeKthEle(LinkedList head, int k) {
		
		int counter = 1;
		LinkedList first = head;
		LinkedList second = head;
		while (counter <= k) {
			second = second.next;
			counter++;
		}
		if (second == null) {
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while (second.next != null) {
			second = second.next;
			first = first.next;
		}
		first.next = first.next.next;
  }

  public static void printList(LinkedList ls) {
	  while(ls.next != null) {
		  System.out.print(ls.value+" ");
		  ls = ls.next;
	  }
  }
	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}
}
