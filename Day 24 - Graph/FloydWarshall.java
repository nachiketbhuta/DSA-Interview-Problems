public class FloydWarshall {
    public static final int INF = 9999;
    public static void floydWarshall(int[][] graph, int n) {
        int[][] dist = new int[n][n];
    
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
            }
        }
    
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (dist[i][j] == INF)
                    System.out.print("INF\t");
                else
                    System.out.print(dist[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 5, 9999, 10},
            {9999, 0, 3, 9999},
            {9999, 9999, 0, 1},
            {9999, 9999, 9999, 0}
        };
        int n = graph.length;
        floydWarshall(graph, n);
    }
}