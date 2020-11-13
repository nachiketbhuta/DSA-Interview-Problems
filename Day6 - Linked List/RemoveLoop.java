

public class RemoveLoop {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node removeLoop(Node head) {
		Node slow = head, fast = head;

		slow = slow.next;
		fast = fast.next.next;

		while (fast != null && fast.next != null) {
			if (slow == fast) {
				break;
			}

			slow = slow.next;
			fast = fast.next.next;
		}

		if (slow == fast) {
			slow = head;

			while (slow.next != fast.next) {
				slow = slow.next;
				fast = fast.next;
			}

			fast.next = null;
		}

		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		head.next.next.next.next.next = head.next;

		head = removeLoop(head);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}