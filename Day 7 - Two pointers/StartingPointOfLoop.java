

public class StartingPointOfLoop {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node startingPoint(Node head) {
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

		if (slow != fast)
			return null;

		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		head.next.next.next.next.next = head.next;

		Node start = startingPoint(head);
		System.out.println("Starting point of loop: " + start.data);
	}
}