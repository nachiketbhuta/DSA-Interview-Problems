public class RatMaze {
    public static boolean isSafe(int maze[][], int x, int y, int n) { 
        return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1); 
    } 

    public static int[][] solveMaze(int[][] maze) {
        int[][] ans = new int[maze.length][maze[0].length];
        int n = maze.length;
        dfs(maze, 0, 0, n, ans);
        return ans;
    }

    public static boolean dfs(int[][] maze, int i, int j, int n, int[][] ans) {
        if (i == n - 1 && j == n - 1 && maze[i][j] == 1) {
            ans[i][j] = 1;
            return true;
        }

        if (isSafe(maze, i, j, n)) {
            ans[i][j] = 1;
            if (dfs(maze, i + 1, j, n, ans)) return true;
            if (dfs(maze, i, j + 1, n, ans)) return true;
            ans[i][j] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        int maze[][] = { { 1, 0, 0, 0 }, 
                         { 1, 1, 0, 1 }, 
                         { 0, 1, 0, 0 }, 
                         { 1, 1, 1, 1 } }; 
        int[][] ans = solveMaze(maze);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}