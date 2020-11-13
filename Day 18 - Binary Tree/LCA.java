
public class LCA {

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

	public static Node findLCA(Node root, int n1, int n2) {
		if (root == null)
			return null;

		if (root.data == n1 || root.data == n2)
			return root;

		Node left = findLCA(root.left, n1, n2);
		Node right = findLCA(root.right, n1, n2);

		if (left != null && right != null)
			return root;

		return (left != null) ? left : right;
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

		System.out.println("LCA(5, 14) = " + findLCA(root, 5, 14).data);
		System.out.println("LCA(5, 25) = " + findLCA(root, 5, 25).data);
	}
}