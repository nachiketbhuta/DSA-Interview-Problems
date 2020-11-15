import java.util.Arrays;

public class Dijkstra {

    public static int minDistance(int[] dist, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static void dijkstra(int[][] graph, int src) {
        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        // visited[src] = true;

        for (int i = 0; i < graph.length - 1; i++) {
            int u = minDistance(dist, visited);

            visited[u] = true;

            for (int v = 0; v < dist.length; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[v] > dist[u] + graph[u][v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("Vertex \t\t Distance from Source"); 
        for (int i = 0; i < dist.length; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
        { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
        { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
        { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
        { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
        { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
        { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
        { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
        { 0, 0, 2, 0, 0, 0, 6, 7, 0 } }; 

        dijkstra(graph, 0);
    }
}