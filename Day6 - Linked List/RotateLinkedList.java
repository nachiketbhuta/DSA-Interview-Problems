

public class RotateLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node rotate(Node head, int k) {
		Node curr = head;

		int cnt = 1;
		while (curr != null && cnt < k) {
			curr = curr.next;
			cnt++;
		}
		if (curr == null)
			return head;

		Node kthNode = curr;

		while (curr.next != null)
			curr = curr.next;

		curr.next = head;
		head = kthNode.next;
		kthNode.next = null;
		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);

		// IP: 10 -> 20 -> 30 -> 40 -> 50, k = 3
		// OP: 40 -> 50 -> 10 -> 20 -> 30
		int k = 3;
		head = rotate(head, k);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}