
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

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

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);

		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			System.out.print(curr.data + " ");
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
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