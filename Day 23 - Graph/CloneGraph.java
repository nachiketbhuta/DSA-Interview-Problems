import java.util.*;

public class CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Set<Node> seen = new HashSet<>();
        Stack<Node> stk = new Stack<>();
        Map<Node, Node> mapper = new HashMap<>();
        seen.add(node);
        stk.push(node);
        mapper.put(node, new Node(node.val));
        while(!stk.isEmpty()) {
            Node n = stk.peek();
            boolean isLeaf = true;
            for(Node nei: n.neighbors) {
                if(!seen.contains(nei)) {
                    seen.add(nei);
                    stk.push(nei);
                    mapper.put(nei, new Node(nei.val));
                    isLeaf = false;
                }
            }
            if(isLeaf) {
                Node poped = stk.pop();
                for(Node nei: poped.neighbors) {
                    mapper.get(poped).neighbors.add(mapper.get(nei));
                }
            }
        }
        return mapper.get(node);
    }
}