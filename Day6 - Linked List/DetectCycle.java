

public class DetectCycle {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static boolean isCycle(Node head) {
		Node slow = head, fast = head;
		boolean ok = false;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				ok = true;
				break;
			}
		}

		return ok;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		head.next.next.next.next.next = head;

		if (isCycle(head)) {
			System.out.println("Cycle found");
		} else {
			System.out.println("Cycle not found");
		}
	}
}