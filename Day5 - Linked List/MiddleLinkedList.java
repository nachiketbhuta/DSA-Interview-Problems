

public class MiddleLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		// Reverse
		Node slow = head, fast = head;

		while (fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		System.out.println("Middle:" + slow.data);
	}
}