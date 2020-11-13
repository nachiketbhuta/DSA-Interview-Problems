

import java.util.Scanner;

public class ReverseLinkedListInGroups {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node reverse(Node head, int k) {
		Node curr = head, next = null, prev = null;

		int cnt = 0;

		while (cnt < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			cnt++;
		}

		if (next != null) {
			head.next = reverse(next, k);
		}

		return prev;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head.next.next.next.next.next.next.next.next = new Node(9);

		int k = sc.nextInt();
		Node temp = reverse(head, k);
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}