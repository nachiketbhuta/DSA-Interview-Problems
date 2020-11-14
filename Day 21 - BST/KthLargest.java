public class KthLargest {
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

    static int k;

    public static int solve(Node root) {
        if (root == null) return 0;
    
        int right = solve(root.right);
        if (right != 0) return right;
        
        if (--k == 0) return root.data;
    
        int left = solve(root.left);
        return left;
    }
    public static void main(String[] args) {
        int nums[] = {8, 4, 12, 2, 6, 10, 14};
        Node root = null;

        for (int i: nums)
            root = construct(root, i);

        k = 3;
        System.out.println("Kth Smallest: " + solve(root));
    }
}