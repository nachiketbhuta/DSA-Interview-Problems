import java.util.Arrays;

public class MColoring {
    public static boolean isSafe(int graph[][], int v, int n, int[] color, int c) { 
        for (int i = 0; i < n; i++) {
            if (graph[v][i] == 1 && color[i] == c)
                return false; 
        }
        return true;
    } 
    public static int[] colorGraph(int[][] graph, int m) {
        int[] color = new int[graph.length];
        int n = graph.length;
        Arrays.fill(color, 0);
        dfs(graph, m, n, color, 0);
        return color;
    }

    public static boolean dfs(int[][] graph, int m, int n, int[] color, int u) {
        if (u == n) return true;

        for (int i = 1; i <= m; i++) {
            if (isSafe(graph, u, n, color, i)) {
                color[u] = i;

                if (dfs(graph, m, n, color, u + 1))
                    return true;

                color[u] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int graph[][] = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 },
        };
        int m = 3;
        int[] ans = colorGraph(graph, m);
        for (int a: ans) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}