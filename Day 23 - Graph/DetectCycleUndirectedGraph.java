
import java.util.*;

public class DetectCycleUndirectedGraph {

	static class Vertex {
		public int id;
		public List<Vertex> edges;

		public Vertex(int id) {
			this.id = id;
		}
	}

	public static boolean dfs(int node, boolean[] visited, Vertex[] graph, int parent) {

		// Mark the current node as visited
		visited[node] = true;

		// Explore all the vertices adjacent to this vertex
		for (Vertex child : graph[node].edges) {

			// If an adjacent is not visited, then recur for that adjacent
			if (!visited[child.id]) {

				// Check if there is cycle by calling adjacent node as current node
				// And current node as the parent node
				if (dfs(child.id, visited, graph, node))
					return true;

			} else if (child.id != parent) {
				// If an adjacent is visited and not parent of current vertex,
				// then there is a cycle.
				return true;
			}
		}

		return false;
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


		int parent = -1;

		// Start making DFS call from 1st node in the graph
		boolean isCyclic = dfs(1, visited, graph, parent);

		if (isCyclic) {
			System.out.println("Cycle is present in the graph");
		} else {
			System.out.println("No cycle is present in the graph");
		}

		sc.close();
	}
}