

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void leftView(Node root) {
		if (root == null)
			return;

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);

		queue.add(null); // Delimiter

		while (!queue.isEmpty()) {
			Node curr = queue.peek();
			if (curr != null) {
				System.out.print(curr.data + " ");

				while (queue.peek() != null) {
					if (curr.left != null)
						queue.add(curr.left);
					if (curr.right != null)
						queue.add(curr.right);

					queue.remove();

					curr = queue.peek();
				}

				queue.add(null);
			}
			queue.remove();
		}

	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(5);
		root.right.left.right = new Node(6);
		root.right.left.right.left = new Node(18);
		root.right.left.right.right = new Node(7);

		leftView(root);
	}
}