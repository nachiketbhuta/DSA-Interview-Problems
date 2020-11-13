
public class HeightBalancedTree {

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
		return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
	}

	public static boolean isBalanced(Node root) {
		if (root == null)
			return true;

		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);

		if (Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right))
			return true;

		return false;
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

		// Node root = new Node(1);
		// root.left = new Node(2);
		// root.right = new Node(3);
		// root.left.left = new Node(4);
		// root.left.right = new Node(5);
		// root.left.left.left = new Node(8);

		if (isBalanced(root)) {
			System.out.println("Tree is height balanced");
		} else {
			System.out.println("Tree is not height balanced");
		}
	}
}