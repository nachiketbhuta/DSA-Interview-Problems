public class SearchBST {
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
    
    public static void search(Node root, int data, Node parent) {
        if (root == null) {
            System.out.println("Data not found");
            // cout << "\n";
            return;
        }
    
        if (root.data == data) {
            if (parent == null) {
                System.out.println("The node with key " + data  + " is root node");
            }
            else if (data < parent.data) {
                System.out.println("Given key is left node of node with key " + parent.data);
            }
            else {
                System.out.println("Given key is right node of node with key " + parent.data);
            }
            return;
        }
    
        if (data < root.data)
            search(root.left, data, root);
        else
            search(root.right, data, root);
    }
    public static void main(String[] args) {
        int data[] = {15, 10, 20, 8, 12, 16, 25};

        Node root = null;
        for (int a: data) {
            root = construct(root, a);
        }

        search(root, 25, null);
    }
}