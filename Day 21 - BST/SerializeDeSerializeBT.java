import java.util.*;

public class SerializeDeSerializeBT {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static String serialize(TreeNode root) {        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0) {
            TreeNode node = q.poll();           
            sb.append(node == null ? "null": node.val);
            sb.append(",");
            if(node != null) {
                q.add(node.left);                
                q.add(node.right);
            }
        }              
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    public static TreeNode deserialize(String data) {                        
        String[] nodes = data.split(",");                
        Queue<TreeNode> roots = new LinkedList<>();
        TreeNode root = nodeOrNull(nodes[0]); 
        if(root != null) {
            roots.add(root);
        }    
        int i = 1;
        while(roots.size() > 0) {
            TreeNode next = roots.poll();            
            TreeNode left = nodeOrNull(nodes[i++]);
            TreeNode right = nodeOrNull(nodes[i++]);
            if(left != null) {
                next.left = left;
                roots.add(left);
            }
            if(right != null) {
                next.right = right;
                roots.add(right);
            }
        }
        return root;
    }

    public static TreeNode nodeOrNull(String node) {
        return node.equals("null") ? null : new TreeNode(Integer.parseInt(node));     
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        String serialized = serialize(root);
        System.out.println(serialized);
    }
}   