public class ConstructBST {
    static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
    }

    public static Node construct(Node root, int data) {
        if (root == null) return new Node(data);

        if (data < root.data) {
            root.left = construct(root.left, data);
        }
        else {
            root.right = construct(root.right, data);
        }
    
        return root;
    }

    public static void inorderTraversalRecursive(Node root) {
		if (root == null)
			return;

		inorderTraversalRecursive(root.left);
		System.out.print(root.data + " ");
		inorderTraversalRecursive(root.right);
	}

    public static void main(String[] args) {
        int data[] = {15, 10, 20, 8, 12, 16, 25};

        Node root = null;
        for (int a: data) {
            root = construct(root, a);
        }

        inorderTraversalRecursive(root);
    }
}