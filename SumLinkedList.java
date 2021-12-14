/*

SUM OF LINKEDLIST ELEMENTS

*/
class SumLinkedList
{
	public static void main(String[] args) 
	{
		LinkedList ls = new LinkedList(1);
		ls.next = new LinkedList(2);
		ls.next.next = new LinkedList(3);
		ls.next.next.next = new LinkedList(4);
		ls.next.next.next.next = new LinkedList(5);
		ls.next.next.next.next.next = new LinkedList(6);
		System.out.println(sumLinkedList(ls));
	}
	public static int sumLinkedList(LinkedList ls) {
		int sum = 0;
		while(ls != null) {
			sum += ls.value;
			ls = ls.next;
		}
		return sum;
	}

	public static class LinkedList {
		public int value;
		public LinkedList next;
		public LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

}
