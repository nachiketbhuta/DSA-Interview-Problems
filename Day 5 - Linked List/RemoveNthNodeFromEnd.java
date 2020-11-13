

import java.util.Scanner;

public class RemoveNthNodeFromEnd {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static void removeNthNode(Node head, int n) {
		Node first = head, second = head;

		for (int i = 1; i <= n; i++) {
			if (second.next == null) {
				if (i == n) {
					head = head.next;
				}
				return;
			}
			second = second.next;
		}

		while (second.next != null) {
			first = first.next;
			second = second.next;
		}

		first.next = first.next.next;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);

		int n = sc.nextInt();

		removeNthNode(head, n);

		// Print
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}