public class BTDLL {
    static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
    }
    static Node prev = null, head = null;
    public static void convert(Node root) {
        if (root == null) return;

        convert(root.left);

        if (prev == null) {
            head = root;
        }
        else {
            root.left = prev;
            prev.right = root;
        }

        prev = root;

        convert(root.right);
    }
    public static void main(String[] args) {
        Node root = new Node(10); 
        root.left = new Node(12); 
        root.right = new Node(15); 
        root.left.left = new Node(25); 
        root.left.right = new Node(30); 
        root.right.left = new Node(36); 

        convert(root);
        Node node = head;

        while (node != null)  
        { 
            System.out.print(node.data + " "); 
            node = node.right; 
        } 
    }
}