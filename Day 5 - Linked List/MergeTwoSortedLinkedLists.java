

public class MergeTwoSortedLinkedLists {
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node mergeAndSort(Node first, Node second) {
		if (first == null)
			return second;
		if (second == null)
			return first;

		if (first.data < second.data) {
			first.next = mergeAndSort(first.next, second);
			return first;
		} else {
			second.next = mergeAndSort(first, second.next);
			return second;
		}
	}

	public static void main(String[] args) {
		Node firstLinkedList = new Node(5);
		firstLinkedList.next = new Node(10);
		firstLinkedList.next.next = new Node(15);

		Node secondLinkedList = new Node(2);
		secondLinkedList.next = new Node(3);
		secondLinkedList.next.next = new Node(20);

		Node newHead = mergeAndSort(firstLinkedList, secondLinkedList);
		while (newHead != null) {
			System.out.print(newHead.data + " ");
			newHead = newHead.next;
		}
	}
}