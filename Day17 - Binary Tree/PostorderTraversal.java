

import java.util.Stack;

public class PostorderTraversal {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void postorderTraversalRecursive(Node root) {
		if (root == null)
			return;

		postorderTraversalRecursive(root.left);
		postorderTraversalRecursive(root.right);
		System.out.print(root.data + " ");
	}

	public static void postorderTraversalIterative(Node root) {

		if (root == null)
			return;

		Stack<Node> stack1 = new Stack();
		Stack<Node> stack2 = new Stack();

		stack1.push(root);

		while (!stack1.isEmpty()) {
			Node curr = stack1.pop();
			// System.out.println("Popped element: " + curr.data);
			stack2.push(curr);

			if (curr.left != null) {
				// System.out.println("Push L: " + curr.left.data);
				stack1.push(curr.left);
			}
			if (curr.right != null) {
				// System.out.println("Push R: " + curr.right.data);
				stack1.push(curr.right);
			}

		}

		while (!stack2.isEmpty()) {
			Node temp = stack2.pop();
			System.out.print(temp.data + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		postorderTraversalRecursive(root);
		System.out.println();

		postorderTraversalIterative(root);
		System.out.println();
	}
}