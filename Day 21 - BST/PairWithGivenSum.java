import java.util.HashSet;

public class PairWithGivenSum {
    static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
    }

    public static boolean findPair(Node root, HashSet<Integer> set, int sum) {
        if (root == null) 
            return false;

        if (findPair(root.left, set, sum))
            return true;

        if (set.contains(sum - root.data)) {
            System.out.println("Pair: (" + (sum - root.data) + ", " + root.data + ")");
            return true;
        }
        else {
            set.add(root.data);
        }

        return findPair(root.right, set, sum);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(4);
        root.right = new Node(12);

        root.left.left = new Node(2);
        root.left.right = new Node(6);

        root.right.left = new Node(10);
        root.right.right = new Node(14);

        HashSet<Integer> set = new HashSet<>();
        int sum = 24;
        findPair(root, set, sum);
    }
}