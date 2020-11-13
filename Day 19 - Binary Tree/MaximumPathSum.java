

public class MaximumPathSum {
	public static int ans = Integer.MIN_VALUE;

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static int maximumPathSum(Node root) {
	    if (root == null) return 0;

	    int left = maximumPathSum(root.left);
	    int right = maximumPathSum(root.right);

	    int x = Math.max(Math.max(left, right) + root.data, root.data);
	    int y = Math.max(x, left + right + root.data);

	    ans = Math.max(ans, y);

	    return x;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);

		int res = maximumPathSum(root);
		System.out.println(res);
	}
}