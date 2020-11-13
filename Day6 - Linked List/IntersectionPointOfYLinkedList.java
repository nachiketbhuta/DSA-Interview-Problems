

public class IntersectionPointOfYLinkedList {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static int getTotalNodes(Node head) {
		int count = 0;
		while (head != null) {
			count++;
			head = head.next;
		}
		return count;
	}

	public static int getNode(int d, Node ll1, Node ll2) {
		Node x = ll1, y = ll2;

		for (int i = 0; i < d; i++) {
			if (x == null)
				return -1;
			x = x.next;
		}

		while (x != null && y != null) {
			if (x.data == y.data) {
				return x.data;
			}

			x = x.next;
			y = y.next;
		}

		return -1;
	}

	public static int getIntersection(Node ll1, Node ll2) {
		int c1 = getTotalNodes(ll1);
		int c2 = getTotalNodes(ll2);

		if (c1 > c2) {
			int d = c1 - c2;
			return getNode(d, ll1, ll2);
		} else {
			int d = c2 - c1;
			return getNode(d, ll2, ll1);
		}
	}

	public static void main(String[] args) {
		Node head1 = new Node(3);
		head1.next = new Node(6);
		head1.next.next = new Node(9);
		head1.next.next.next = new Node(15);
		head1.next.next.next.next = new Node(30);

		Node head2 = new Node(10);
		head2.next = new Node(15);
		head2.next.next = new Node(30);

		int intersection = getIntersection(head1, head2);
		System.out.println(intersection);
	}
}