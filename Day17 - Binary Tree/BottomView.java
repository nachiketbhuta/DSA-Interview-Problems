
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {

	static class Node {
		int data;
		int dist;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
			this.dist = Integer.MAX_VALUE;
		}
	}

	public static void bottomView(Node root) {
		if (root == null)
			return;

		int dist = 0;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Node> queue = new LinkedList<>();

		root.dist = dist;
		queue.add(root);

		while (!queue.isEmpty()) {
			Node curr = queue.remove();

			map.put(curr.dist, curr.data);

			if (curr.left != null) {
				curr.left.dist = curr.dist - 1;
				queue.add(curr.left);
			}
			if (curr.right != null) {
				curr.right.dist = curr.dist + 1;
				queue.add(curr.right);
			}
		}

		for (Map.Entry<Integer, Integer> m : map.entrySet()) {
			System.out.print(m.getValue() + " ");
		}

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

		bottomView(root);
	}
}