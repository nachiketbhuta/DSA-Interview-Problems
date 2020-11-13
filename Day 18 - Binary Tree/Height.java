
import java.util.LinkedList;
import java.util.Queue;

public class Height {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static int heightOfTree(Node root) {
		if (root == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		Node front = null;
		int height = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				front = queue.poll();
				if (front.left != null) {
					queue.add(front.left);
				}
				if (front.right != null) {
					queue.add(front.right);
				}
			}
			height++;
		}

		return height;
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

		System.out.println("Height: " + heightOfTree(root));
	}
}