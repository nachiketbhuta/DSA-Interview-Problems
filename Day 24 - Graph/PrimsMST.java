import java.util.Arrays;

public class PrimsMST {
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

    public static void primsMST(int[][] graph) {
        int[] parent = new int[graph.length];
        int[] dist = new int[graph.length];
        boolean[] mst = new boolean[graph.length];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        parent[0] = -1;
        

        for (int i = 0; i < graph.length - 1; i++) {
            int u = minDistance(dist, mst);

            mst[u] = true;

            for (int v = 0; v < dist.length; v++) {
                if (!mst[v] && graph[u][v] != 0 && dist[v] > graph[u][v]) {
                    dist[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        System.out.println("Edge \tWeight"); 
        for (int i = 1; i < dist.length; i++) 
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
        { 2, 0, 3, 8, 5 }, 
        { 0, 3, 0, 0, 7 }, 
        { 6, 8, 0, 0, 9 }, 
        { 0, 5, 7, 9, 0 } }; 

        primsMST(graph);
    }
}