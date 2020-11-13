import java.util.HashMap;

public class BinaryTreeFromInorderPreorder {

    static int preIndex = 0;

    static class Node {
		char data;
		Node left, right;

		Node(char data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
    }
    
    public static void main(String[] args) {
        char[] inorder = { 'D', 'B', 'E', 'A', 'F', 'C' };
        char[] preorder = { 'A', 'B', 'D', 'E', 'C', 'F' };

        int n = inorder.length;

        Node root = constructTree(inorder, preorder, n);
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

    public static Node constructTree(char[] inorder, char[] preorder, int n) {
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();

        for (int i = 0; i < n; i++) {
            mpp.put(inorder[i], i);
        }

        Node root = buildTree(inorder, preorder, 0, n - 1, mpp);
        return root;
    }

    public static Node buildTree(char[] inorder, char[] preorder, int start, int end, HashMap<Character, Integer> mpp) {
        
        if (start > end) return null;

        char current = preorder[preIndex++];
        Node node = new Node(current);

        if (start == end) return node;

        int inIndex = mpp.get(current);

        node.left = buildTree(inorder, preorder, start, inIndex - 1, mpp);
        node.right = buildTree(inorder, preorder, inIndex + 1, end, mpp);

        return node;
    }
}