/*
CONSTRUCT DOUBLE LINKED LIST DATA STRUCtURE
*/

class CustomLinkedList {
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.prev = node4;
		node4.prev = node3;
		node3.prev = node2;
		node2.prev = node1;
	}
  static class DoublyLinkedList {
    public static Node head;
    public static Node tail;

    public static void setHead(Node node) {
      if (head == null) {
				head = node;
				tail = node;
				return;
			}
			insertBefore(head, node);
    }

    public static void setTail(Node node) {
      if (tail == null) {
				setHead(node);
				return;
			}
			insertAfter(tail, node);
    }

    public static void insertBefore(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node.prev;
			nodeToInsert.next = node;
			if (node.prev == null) {
				head = nodeToInsert;
			} else {
				node.prev.next = nodeToInsert;
			}
			node.prev = nodeToInsert;
    }

    public static void insertAfter(Node node, Node nodeToInsert) {
      if (nodeToInsert == head && nodeToInsert == tail) return;
			remove(nodeToInsert);
			nodeToInsert.prev = node;
			nodeToInsert.next = node.next;
			if (node.next == null) {
				tail = nodeToInsert;
			} else {
				node.next.prev = nodeToInsert;
			}
			node.next = nodeToInsert;
    }

    public static void insertAtPosition(int position, Node nodeToInsert) {
      if (position == 1) {
				setHead(nodeToInsert);
				return;
			}
			Node node = head;
			int currentPosition = 1;
			while (node != null && currentPosition++ != position) node = node.next;
			if (node != null) {
				insertBefore(node, nodeToInsert);
			} else {
				setTail(nodeToInsert);
			}
    }

    public static void removeNodesWithValue(int value) {
      Node node = head;
			while (node != null) {
				Node nodeToRemove = node;
				node = node.next;
				if (nodeToRemove.value == value) remove(nodeToRemove);
			}
    }

    public static void remove(Node node) {
      if (node == head) head = head.next;
			if (node == tail) tail = tail.prev;
			removeNodeBindings(node);
    }

    public static boolean containsNodeWithValue(int value) {
     	Node node = head;
			while (node != null && node.value != value) node = node.next;
      return node != null;
    }
		
		public static void removeNodeBindings(Node node) {
			if (node.prev != null) node.prev.next = node.next;
			if (node.next != null) node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
		}
  }

  // Do not edit the class below.
  static class Node {
    public int value;
    public Node prev;
    public Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}

