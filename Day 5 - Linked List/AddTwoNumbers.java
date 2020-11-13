

public class AddTwoNumbers {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node addTwoNumbers(Node ll1, Node ll2) {
		Node ans = null, temp = null, prev = null;
		int carry = 0, sum;

		while (ll1 != null || ll2 != null) {
			sum = carry + (ll1 != null ? ll1.data : 0) + (ll2 != null ? ll2.data : 0);

			carry = (sum >= 10) ? 1 : 0;

			sum = sum % 10;

			temp = new Node(sum);

			if (ans == null)
				ans = temp;
			else
				prev.next = temp;
			prev = temp;

			if (ll1 != null)
				ll1 = ll1.next;
			if (ll2 != null)
				ll2 = ll2.next;
		}

		if (carry > 0)
			temp.next = new Node(carry);

		return ans;
	}

	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(5);
		head1.next.next = new Node(9);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(6);

		Node head2 = new Node(8);
		head2.next = new Node(4);

		Node newHead = addTwoNumbers(head1, head2);
		while (newHead != null) {
			System.out.print(newHead.data);
			newHead = newHead.next;
		}
		System.out.println();
	}
}