
import java.util.Stack;

public class LevelOrderTraversalSpiralForm {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void levelOrder(Node root) {
		if (root == null)
			return;

		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();

		stack1.push(root);

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				Node curr = stack1.peek();
				stack1.pop();
				System.out.print(curr.data + " ");

				if (curr.right != null) {
					stack2.push(curr.right);
				}

				if (curr.left != null) {
					stack2.push(curr.left);
				}
			}

			while (!stack2.isEmpty()) {
				Node curr = stack2.peek();
				stack2.pop();
				System.out.print(curr.data + " ");

				if (curr.left != null) {
					stack1.push(curr.left);
				}
				if (curr.right != null) {
					stack1.push(curr.right);
				}
			}
		}
	}

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(25);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		levelOrder(root);
	}
}