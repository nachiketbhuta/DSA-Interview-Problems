public class EggDropping {
    public static int solve(int e, int f, int[][] dp) {
        if (f == 0 || f == 1) return f;
    
        if (e == 1) return f;
    
        if (dp[e][f] != 0) return dp[e][f];
    
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= f; ++i)
        {
            int first = 0, second = 0;
    
            if (dp[e - 1][i - 1] != 0)
                first = dp[e - 1][i - 1];
            else {
                first = solve(e - 1, i - 1, dp);
                dp[e - 1][i - 1] = first;
            }
    
            if (dp[e][f - i] != 0)
                second = dp[e][f - i];
            else {
                second = solve(e, f - i, dp);
                dp[e][f - i] = second;
            }
    
            int temp = Math.max(first, second);
            res = Math.min(res, temp);
        }
    
        return dp[e][f] = res + 1;
    }
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 5;

        int[][] dp = new int[eggs + 1][floors + 1];

        int ans = solve(eggs, floors, dp);
        System.out.println("Number of trials: " + ans);
    }
}