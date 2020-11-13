public class BTisBST {
    static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
    }
    
    public static boolean isBST(Node root, int min, int max) {
        if (root == null) return true;

        if (root.data < min || root.data > max)
            return false;

        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right = new Node(6);

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            System.out.println("This is a BST");
        }
        else {
            System.out.println("This is not a BST");
        }
    }
}