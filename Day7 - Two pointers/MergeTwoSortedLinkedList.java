

public class MergeTwoSortedLinkedList {

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	public static Node mergeAndSort(Node ll1, Node ll2) {
		if (ll1 == null)
			return ll2;
		if (ll2 == null)
			return ll1;

		Node start = null, end = null;

		if (ll1.data <= ll2.data) {
			start = ll1;
			end = start;
			ll1 = ll1.next;
		} else {
			start = ll2;
			end = start;
			ll2 = ll2.next;
		}

		while (ll1 != null && ll2 != null) {
			if (ll1.data <= ll2.data) {
				end.next = ll1;
				end = ll1;
				ll1 = ll1.next;
			} else {
				end.next = ll2;
				end = ll2;
				ll2 = ll2.next;
			}
		}

		if (ll1 == null) {
			end.next = ll2;
		} else {
			end.next = ll1;
		}

		return start;
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