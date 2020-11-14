import java.util.LinkedList;
import java.util.Queue;


public class PopulateNextRightPointers {
    static class Node {
		int data;
		Node left, right, next;

		Node(int data) {
			this.data = data;
			this.left = null;
            this.right = null;
            this.next = null;
		}
    }

    public static Node populate(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while(queue.peek() != null) {
            int size = queue.size() - 1;

            while (size-- > 0) {
                Node node = queue.poll();
                node.next = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            queue.remove();
            queue.add(null);
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8); 
        root.right = new Node(2); 
        root.left.left = new Node(3); 
        root.right.right = new Node(90); 

        root = populate(root);
        int a = root.next != null ?  
                                     root.next.data : -1; 
        int b = root.left.next != null ?  
                                 root.left.next.data : -1; 
        int c = root.right.next != null ?  
                                root.right.next.data : -1; 
        int d = root.left.left.next != null ?  
                                  root.left.left.next.data : -1; 
        int e = root.right.right.next != null ?  
                                   root.right.right.next.data : -1; 
           
        // Now lets print the values 
        System.out.println("Following are populated next pointers in "
                + " the tree(-1 is printed if there is no next)"); 
        System.out.println("next of " + root.data + " is " + a); 
        System.out.println("next of " + root.left.data  
                                                       + " is " + b); 
        System.out.println("next of " + root.right.data +  
                                                           " is " + c); 
        System.out.println("next of " + root.left.left.data +  
                                                            " is " + d); 
        System.out.println("next of " + root.right.right.data +  
                                                             " is " + e); 
    }
}