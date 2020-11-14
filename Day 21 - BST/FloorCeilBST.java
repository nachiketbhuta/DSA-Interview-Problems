public class FloorCeilBST {
    static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
    }

    public static int ceil(Node root, int key) {
        if (root == null) 
            return -1;
    
        if (root.data == key) 
            return root.data;
    
        if (root.data < key)
            return ceil(root.right, key);
    
        int ans = ceil(root.left, key);
    
        return (ans >= key) ? ans : root.data;
    }
    
    public static int floor(Node root, int key) {
        if (root == null) 
            return Integer.MAX_VALUE;
    
        if (root.data == key) return root.data;
    
        if (root.data > key)
            return floor(root.left, key);
    
        int ans = floor(root.right, key);
    
        return (ans <= key) ? ans : root.data;
    }
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);
    
        root.left.left = new Node(2);
        root.left.right = new Node(6);
    
        root.right.left = new Node(10);
        root.right.right = new Node(14);
    
        System.out.println("Ceil: " + ceil(root, 5));
        System.out.println("Floor: " + floor(root, 5));
    }
}