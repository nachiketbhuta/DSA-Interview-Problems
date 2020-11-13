
import java.util.*;

public class Diameter {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public static int heightOfTree(Node root) {
		if (root == null) return 0;
		return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
	}

	public static int diameter(Node root) {
		if (root == null) return 0;

		int leftHeight = heightOfTree(root.left);
		int righttHeight = heightOfTree(root.right);

		int left = diameter(root.left);
		int right = diameter(root.right);

		return Math.max(leftHeight + righttHeight + 1, Math.max(left, right));
	}

	public static void main(String[] args) {
		Node root = new Node(20); 
        root.left = new Node(8); 
        root.right = new Node(22); 
        root.left.left = new Node(5); 
        root.left.right = new Node(3); 
        root.right.left = new Node(4); 
        root.right.right = new Node(25); 
        root.left.right.left = new Node(10); 
        root.left.right.right = new Node(14); 

        System.out.println("Height: " + heightOfTree(root));
        System.out.println("Diameter: " + diameter(root));
	}
}