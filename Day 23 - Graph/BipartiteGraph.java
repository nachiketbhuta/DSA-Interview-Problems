import java.util.*;

public class BipartiteGraph {

	static class Vertex {
		public int id;
		public List<Vertex> edges;

		public Vertex(int id) {
			this.id = id;
		}
	}

	public static boolean dfs(int node, int[] color, Vertex[] graph) {

		// Exploring the adjacents of current node
		for (Vertex child : graph[node].edges) {
			// Checking if the adjacent node is colored or not
			if (color[child.id] == 0) {

				// Mark the adjacent node as inverted color of current node
				color[child.id] = color[node] ^ 1;

				// Apply DFS for adjacent nodes
				if (!dfs(child.id, color, graph))
					return false;

			} else if (color[node] == color[child.id]) {
				// If the color of current node and adjacent node is same
				// Then they belong to same set, hence the graph is not bipartite
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int vertices = sc.nextInt();
		int edges = sc.nextInt();

		Vertex[] graph = new Vertex[vertices + 1];

		// Stores the color of a node
		int[] color = new int[vertices + 1];

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

		// Start making DFS call from 1st node in the graph
		// A flag to store whether the graph is bipartite
		boolean isBipartite = dfs(1, color, graph);

		// Print the components which are connected from current node
		System.out.print("The vertices of set 1: ");
		for (int i = 1; i <= vertices; i++) {
			if (color[i] == 0)
				System.out.print(i + " ");
		}
		System.out.println();

		System.out.print("The vertices of set 2: ");
		for (int i = 1; i <= vertices; i++) {
			if (color[i] == 1)
				System.out.print(i + " ");
		}
		System.out.println();

		if (isBipartite) {
			System.out.println("The graph is bipartite");
		} else {
			System.out.println("The graph is not bipartite");
		}

		sc.close();
	}
}