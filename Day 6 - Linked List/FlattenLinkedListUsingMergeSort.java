

public class FlattenLinkedListUsingMergeSort {

	static class Node {
		int data;
		Node next, down;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.down = null;
		}
	}

	public static Node merge(Node a, Node b) {
		if (a == null)
			return b;
		if (b == null)
			return a;

		Node res;
		if (a.data < b.data) {
			res = a;
			res.down = merge(a.down, b);
		} else {
			res = b;
			res.down = merge(a, b.down);
		}

		res.next = null;
		return res;
	}

	public static Node flatten(Node head) {
		if (head == null || head.next == null)
			return head;

		head.next = flatten(head.next);
		head = merge(head, head.next);

		return head;
	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.down = new Node(7);
		head.down.down = new Node(8);
		head.down.down.down = new Node(30);

		head.next = new Node(10);
		head.next.down = new Node(20);

		head.next.next = new Node(19);
		head.next.next.down = new Node(22);
		head.next.next.down.down = new Node(50);

		head.next.next.next = new Node(28);
		head.next.next.next.down = new Node(35);
		head.next.next.next.down.down = new Node(40);
		head.next.next.next.down.down.down = new Node(45);

		head = flatten(head);
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.down;
		}
		System.out.println();

	}
}