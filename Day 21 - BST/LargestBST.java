public class LargestBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
    
	public static int size(Node root) {
		if (root == null) {
			return 0;
		}
		return size(root.left) + 1 + size(root.right);
	}

	public static boolean isBST(Node node, int min, int max) {
		if (node == null)
			return true;

		if (node.data < min || node.data > max) {
			return false;
		}

        return isBST(node.left, min, node.data) 
            && isBST(node.right, node.data, max);
	}

	public static int findLargestBST(Node root) {
		if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
			return size(root);
		}
		return Math.max(findLargestBST(root.left), findLargestBST(root.right));
    }
    
    public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(15);
		root.right = new Node(8);

		root.left.left = new Node(12);
		root.left.right = new Node(20);

		root.right.left = new Node(5);
		root.right.right = new Node(2);

		System.out.println("The size of the largest BST is " + findLargestBST(root));
	}
}