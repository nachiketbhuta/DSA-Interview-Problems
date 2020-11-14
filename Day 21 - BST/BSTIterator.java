import java.util.Stack;

public class BSTIterator {
    static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
    }

    Stack<Node> stack = new Stack();

    BSTIterator(Node root) {
        pushLeft(root);
    }

    public void pushLeft(Node node) {
        if (node != null) {
            stack.push(node);
            pushLeft(node.left);
        }
    }

    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        return true;
    }

    public int next() {
        Node node = stack.pop();
        pushLeft(node.right);
        return node.data;
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

    public static void main(String[] args) {
        int nums[] = {8, 4, 12, 2, 6, 10, 14};
        Node root = null;

        for (int i: nums)
            root = construct(root, i);

        BSTIterator iterator = new BSTIterator(root);
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}