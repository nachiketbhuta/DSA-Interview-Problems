public class RodCutting {

    public static int solve(int[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int res = Integer.MIN_VALUE;

            for (int j = 0; j < i; j++) {
                res = Math.max(res, arr[j] + dp[i - j - 1]);
            }

            dp[i] = res;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int arr[] = {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
        int ans = solve(arr, size);
        System.out.println("Maximum value is " + ans); 
    }
}