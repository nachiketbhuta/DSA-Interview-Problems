public class MaximumSumPathMatrix {
    public static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    public static int maximumSumPath(int[][] mat, int i, int j, int n, int m, int[][] dp, boolean[][] visited) {
        
        if (i == n - 1 && j == m - 1) {
            return mat[i][j];
        }

        if (visited[i][j]) return dp[i][j];

        visited[i][j] = true;

        int sum = 0;
        if (i < n - 1 && j < m - 1) {
            int curr = max(
                maximumSumPath(mat, i + 1, j, n, m, dp, visited),
                maximumSumPath(mat, i, j + 1, n, m, dp, visited),
                maximumSumPath(mat, i + 1, j + 1, n, m, dp, visited)
            );

            sum = curr + mat[i][j];
        } 

        else if (i == n - 1) {
            sum = mat[i][j] + maximumSumPath(mat, i, j + 1, n, m, dp, visited);
        }

        else {
            sum = mat[i][j] + maximumSumPath(mat, i + 1, j, n, m, dp, visited);
        }

        dp[i][j] = sum;

        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = {
            {500, 100, 230},
            {1000, 300, 100},
            {200, 1000, 200}
        };

        int n = mat.length;
        int m = mat[0].length;

        int[][] dp = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int ans = maximumSumPath(mat, 0, 0, n, m, dp, visited);
        System.out.println("Maximum Sum: " + ans);
    }
}