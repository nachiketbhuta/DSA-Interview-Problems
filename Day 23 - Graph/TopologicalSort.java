import java.util.Stack;

public class TopologicalSort {
    public static Stack<Integer> stack = new Stack();

    static class Vertex {
		public int id;
		public List<Vertex> edges;

		public Vertex(int id) {
			this.id = id;
		}
	}

	public static void dfs(int node, boolean[] visited, Vertex[] graph) {

		visited[node] = true;

		// System.out.print(node + " ");

		for (Vertex child : graph[node].edges) {
			if (!visited[child.id])
				dfs(child.id, visited, graph);
        }
        
		stack.push(node);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int vertices = sc.nextInt();
		int edges = sc.nextInt();

		Vertex[] graph = new Vertex[vertices + 1];
		boolean[] visited = new boolean[vertices + 1];

		for (int i = 1; i <= vertices; i++) {
			graph[i] = new Vertex(i);
			graph[i].edges = new ArrayList<Vertex>();
		}

		Vertex v1, v2;

		for (int i = 1; i <= edges; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			v1 = new Vertex(a);
			v2 = new Vertex(b);

			// Since it is an undirected graph, so we will update adjacency list of both nodes
			graph[a].edges.add(v2);
			graph[b].edges.add(v1);
		}

		// We will start the traversal from 1st node since the graph is 1-based
		dfs(1, visited, graph);

		System.out.println("Topological order: ");
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();

		sc.close();
	}
}