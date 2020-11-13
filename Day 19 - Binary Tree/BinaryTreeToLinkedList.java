
import java.util.Stack;

public class BinaryTreeToLinkedList {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		Stack<Node> stack = new Stack();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node curr = stack.pop();

			if (curr.right != null) {
				stack.push(curr.right);
			}
			if (curr.left != null) {
				stack.push(curr.left);
			}

			if (!stack.isEmpty()) {
				curr.right = stack.peek();
			}
			curr.left = null;
		}

		Node curr = root;
		while(curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
		System.out.println();
	}
}