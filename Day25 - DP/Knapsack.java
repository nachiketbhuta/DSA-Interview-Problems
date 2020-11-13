import java.util.Arrays;

public class Knapsack {

	public static int solveRecursive(int weights[], int val[], int n, int W, int[][] dp) {

		if (n == 0 || W == 0) return 0;

	    if (dp[n][W] != 0) return dp[n][W];

	    int res = Integer.MIN_VALUE;

	    if (weights[n-1] <= W) {
	        res = Math.max(val[n-1] + solveRecursive(weights, val, n - 1, W - weights[n-1], dp), solveRecursive(weights, val, n - 1, W, dp));
	    }
	    else if (weights[n-1] > W) {
	        res = solveRecursive(weights, val, n - 1, W, dp);
	    }

	    return dp[n][W] = res;
	}

	// public static int solveIterative(String s1, String s2, int n, int m, int[][] dp) {

	// }

	public static void main(String[] args) {
		int weights[] = {10, 20, 30};
	    int values[] = {60, 100, 120};
	    int n = 3;
	    int W = 50;

		int[][] dp = new int[n + 1][W + 1];

		int ans = solveRecursive(weights, values, n, W, dp); // 220
		System.out.println(ans);
	}
}
