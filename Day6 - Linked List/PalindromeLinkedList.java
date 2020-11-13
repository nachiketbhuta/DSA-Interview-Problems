

import java.util.Stack;

public class PalindromeLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static boolean isPalindrome(Node head) {
		Stack<Integer> stack = new Stack<>();

		Node curr = head;

		while (curr != null) {
			stack.push(curr.data);
			curr = curr.next;
		}

		boolean ok = true;
		while (head != null) {
			int temp = stack.pop();

			if (temp == head.data) {
				ok = true;
			} else {
				ok = false;
				break;
			}

			head = head.next;
		}

		return ok;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);

		System.out.println("isPalindrome: " + isPalindrome(head));
	}
}