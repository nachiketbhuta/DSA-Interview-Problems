public class LCATwoNodes {
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

    public static Node LCA(Node root, int x, int y) {
        if (root == null) return null;
    
        if (root.data > x && root.data > y)
            return LCA(root.left, x, y);
        if (root.data < x && root.data < y)
            return LCA(root.right, x, y);
    
        return root;
    }
    public static void main(String[] args) {
        int data[] = {15, 10, 20, 8, 12, 16, 25};

        Node root= null;
        for (int a: data) {
            root = construct(root, a);
        }

        Node lca = LCA(root, 10, 25);
        System.out.println("LCA: " + lca.data);  
        // cout << "LCA of 10 and 25: " << lca->val << endl;
    }
}