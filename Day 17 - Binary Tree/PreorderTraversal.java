


import java.util.Stack;

public class PreorderTraversal {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void preorderTraversalRecursive(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preorderTraversalRecursive(root.left);
		preorderTraversalRecursive(root.right);
	}

	public static void preorderTraversalIterative(Node root) {

		if (root == null)
			return;

		Stack<Node> stack = new Stack();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			System.out.print(curr.data + " ");

			// The left child must always be processed before the right child.
			// So put right child on the stack before left child.
			// Then process the top stack element.
			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		preorderTraversalRecursive(root);
		System.out.println();

		preorderTraversalIterative(root);
		System.out.println();
	}
}