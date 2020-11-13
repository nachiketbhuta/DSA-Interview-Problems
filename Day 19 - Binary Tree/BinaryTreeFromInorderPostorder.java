import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeFromInorderPostorder {

    static int preIndex = 0;

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
        int[] inorder = { 4, 2, 1, 7, 5, 8, 3, 6 };
		int[] postorder = { 4, 2, 7, 8, 5, 6, 3, 1 };

        int n = inorder.length;

        Node root = constructTree(inorder, postorder, n);
        System.out.println("Inorder: ");
        inorderTraversal(root);
        System.out.println();
    }
    
    public static void inorderTraversal(Node root) {
		if (root == null)
			return;

        inorderTraversal(root.left);
		System.out.print(root.data + " ");
		inorderTraversal(root.right);
	}

    public static Node constructTree(int[] inorder, int[] postorder, int n) {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            mpp.put(inorder[i], i);
        }

        AtomicInteger pIndex = new AtomicInteger(n - 1);
        Node root = buildTree(inorder, postorder, 0, n - 1, pIndex, mpp);
        return root;
    }

    public static Node buildTree(int[] inorder, int[] postorder, int start, int end, AtomicInteger pIndex, HashMap<Integer, Integer> mpp) {
        
        if (start > end) return null;

        int current = postorder[pIndex.getAndDecrement()];
        Node node = new Node(current);

        // if (start == end) return node;

        int inIndex = mpp.get(current);

        node.right = buildTree(inorder, postorder, inIndex + 1, end, pIndex, mpp);
        node.left = buildTree(inorder, postorder, start, inIndex - 1, pIndex, mpp);
        

        return node;
    }
}