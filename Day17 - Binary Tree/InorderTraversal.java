

import java.util.Stack;

public class InorderTraversal {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void inorderTraversalRecursive(Node root) {
		if (root == null)
			return;

		inorderTraversalRecursive(root.left);
		System.out.print(root.data + " ");
		inorderTraversalRecursive(root.right);
	}

	public static void inorderTraversalIterative(Node root) {

		if (root == null)
			return;

		Stack<Node> stack = new Stack();
		Node curr = root;

		while (curr != null || !stack.isEmpty()) {
			// Explore left childrens
			while (curr != null) {
				stack.push(curr);
				curr = curr.left;
			}

			curr = stack.pop();
			System.out.print(curr.data + " ");

			curr = curr.right;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		inorderTraversalRecursive(root);
		System.out.println();

		inorderTraversalIterative(root);
		System.out.println();
	}
}