
import java.util.*;

public class BFS {

	static class Vertex {
		public int id;
		public List<Vertex> edges;

		public Vertex(int id) {
			this.id = id;
		}
	}

	public static void bfs(int node, boolean[] visited, Vertex[] graph) {
        Queue<Integer> queue = new LinkedList<>();
        visited[node] = true;
        queue.add(node);

        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            System.out.print(current + " ");

            for (Vertex child : graph[current].edges) {
                if (!visited[child.id]) {
                    visited[child.id] = true;
                    queue.add(child.id);
                }
            }
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

		System.out.println();
		System.out.print("BFS Traversal: ");

		// We will start the traversal from 1st node since the graph is 1-based
		bfs(1, visited, graph);

		System.out.println();

		sc.close();
	}
}