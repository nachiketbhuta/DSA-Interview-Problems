import java.util.*;

public class NumberOfIslandsGrid {
    public static boolean isValid(int i, int j, int n, int m) {
        if (i >= 0 && i < n && j >= 0 && j < m)
            return true;
        return false;
    }

    public static void dfs(int[][] grid, int i, int j, int n, int m) {
        if (!isValid(i, j, n, m))
            return;
        if (grid[i][j] != 1)
            return;

        // Mark as visited
        grid[i][j] = 2;

        dfs(grid, i, j - 1, n, m); // Left
        dfs(grid, i - 1, j, n, m); // Up
        dfs(grid, i, j + 1, n, m); // Right
        dfs(grid, i + 1, j, n, m); // Down
    }

    public static int solve(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, n, m);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid =  {
            {1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 1, 0, 0, 1},
            {1, 1, 0, 0, 1}
        };
        
        int ans = solve(grid);
        System.out.println("Number of islands: " + ans);
    }
}