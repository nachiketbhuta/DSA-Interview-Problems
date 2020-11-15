
import java.util.*;

public class NumberOfIslandsGraph {

	static class Vertex {
		public int id;
		public List<Vertex> edges;

		public Vertex(int id) {
			this.id = id;
		}
	}

	public static void dfs(int node, boolean[] visited, Vertex[] graph, List<Vertex> components) {

		visited[node] = true;

		// Push current node because there exists an edge from previous node
		components.add(new Vertex(node));

		for (Vertex child : graph[node].edges) {
			if (!visited[child.id])
				dfs(child.id, visited, graph, components);
		}
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

		int connectedComponents = 0;

		// Holds the components which are connected
		List<Vertex> components = new ArrayList<Vertex>();

		for (int i = 1; i <= vertices; i++) {
			if (!visited[i]) {
				// Clears the components for next iteration
				components.clear();

				// Make a DFS call to the unvisited node
				dfs(i, visited, graph, components);

				// Increment the number of total connected components
				connectedComponents++;

				// Print the components which are connected from current node
				System.out.print("Components which are connected: ");
				for (Vertex v : components) {
					System.out.print(v.id + " ");
				}
				System.out.println();
			}
		}

		System.out.println("Total Connected Components in the graph are: " + connectedComponents);

		sc.close();
	}
}