public class CoinChange {
    public static int ways(int coins[], int size, int sum, int[][] dp) {

        if (sum == 0) return 1;
        if (sum < 0) return 0;
    
        if (size <= 0 && sum >= 1)
            return 0;
    
        if (dp[size][sum] != 0) return dp[size][sum];
    
        int res = ways(coins, size - 1, sum, dp)
                  + ways(coins, size, sum - coins[size - 1], dp);
    
        return dp[size][sum] = res;
    }
    
    public static void main(String[] args) {
        int coins[] = {2, 3, 5, 6};
        int size = coins.length;
        int sum = 10;

        int[][] dp = new int[size + 1][sum + 1];

        int ans = ways(coins, size, sum, dp);
        System.out.println("Ways: " + ans);
    }
}   