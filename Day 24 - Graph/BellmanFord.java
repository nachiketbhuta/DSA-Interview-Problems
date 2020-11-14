public class BellmanFord {

    public static void bellmanFord(int[][] graph, int n, int m, int src) {
        int[] dist = new int[n];

        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;
    
        dist[src] = 0;
    
        // Relax all the edges
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = graph[j][0];
                int v = graph[j][1];
                int w = graph[j][2];
    
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                }
            }
        }
    
        // Check for negative edge cycles
        for (int i = 0; i < m; i++) {
            int u = graph[i][0];
            int v = graph[i][1];
            int w = graph[i][2];
    
            if (dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + w) {
                System.out.println("Negative weight cycle");
            }
        }
    
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < n; i++)
            System.out.println(i + "\t\t" + dist[i]);
    
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 1, -3 }, {0, 2, -1}, {1, 2, -2} };
        int n = graph.length;
        int m = graph[0].length;
	    bellmanFord(graph, n, m, 0);
    }
}