

public class CloneLinkedList {

	static class Node {
		int data;
		Node next, random;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.random = null;
		}
	}

	public static Node clone(Node head) {
		Node curr = head, temp = null;

		while (curr != null) {
			temp = curr.next;
			curr.next = new Node(curr.data);
			curr.next.next = temp;
			curr = temp;
		}

		curr = head;

		while (curr != null) {
			if (curr.next != null) {
				curr.next.random = (curr.random != null) ? curr.random.next : curr.random;
				curr = (curr.next != null) ? curr.next.next : curr.next;
			}
		}

		Node original = head, copy = head.next;
		temp = copy;

		while (original != null && copy != null) {
			original.next = (original.next != null) ? original.next.next : original.next;
			copy.next = (copy.next != null) ? copy.next.next : copy.next;

			original = original.next;
			copy = copy.next;
		}

		return temp;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);

		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next.next.next;
		head.next.next.next.random = head.next.next.next.next;
		head.next.next.next.next.random = head.next;

		Node clonedList = clone(head);

		System.out.println("Original List: ");
		while (head != null) {
			System.out.println("Data = " + head.data + " , Random = " + head.random.data);
			head = head.next;
		}

		System.out.println("Cloned List: ");
		while (clonedList != null) {
			System.out.println("Data = " + clonedList.data + " , Random = " + clonedList.random.data);
			clonedList = clonedList.next;
		}
	}
}