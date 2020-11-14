public class SubsetSum {
    public static boolean partition(int[] a, int n, int sum, boolean[][] dp) {
        if (sum == 0) return true;
        if (n == 0 && sum != 0) return false;
    
        if (dp[n][sum]) return dp[n][sum];
    
        boolean res = false;
        if (a[n - 1] > sum)
            res = partition(a, n - 1, sum, dp);
        else
            res = partition(a, n - 1, sum, dp) || partition(a, n - 1, sum - a[n - 1], dp);
        
        return dp[n][sum] = res;
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 7, 14};
        int n = a.length;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        if (sum % 2 == 1) {
            System.out.println("Cannot be partitioned coz sum is odd");
        } 
        else {
            boolean[][] dp = new boolean[n + 1][sum + 1];
            
            boolean ans = partition(a, n, sum / 2, dp);
            if (ans)
                System.out.println("Can be partitioned");
            else
                System.out.println("Cannot be partitioned");
        }
    }
}
