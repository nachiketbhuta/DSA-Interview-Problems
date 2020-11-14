import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class InorderPredecessorSuccessor {
    static class Node {
		int data;
        Node left, right;
        
        Node() {
            this.left = this.right = null;
        }

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

    static Node predecessor = new Node();
    static Node successor = new Node();

    public static void inorderPredecessorSuccessor(Node root, int data) {
        if (root == null) return;

        if (root.data == data) {
            if (root.left != null) {
                Node temp = root.left;

                while (temp.right != null) {
                    temp = temp.right;
                }

                predecessor = temp;
            }

            if (root.right != null) {
                Node temp = root.right;

                while (temp.left != null) {
                    temp = temp.left;
                }

                successor = temp;
            }
        }

        if (root.data > data) {
            successor = root;
            inorderPredecessorSuccessor(root.left, data);
        }

        if (root.data < data) {
            predecessor = root;
            inorderPredecessorSuccessor(root.right, data);
        }
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
        inorderPredecessorSuccessor(root, 20);

        System.out.println("\nInorder Predecessor of 12: " + predecessor.data);
        System.out.println("Inorder Successor of 12: " + successor.data);
    }
}