
import java.util.Arrays;

public class MatrixChainMultiplication {

	public static int solveRecursive(int[] dims, int i, int j, int[][] dp) {
		if (i >= j)
			return 0;

		if (dp[i][j] != 0)
			return dp[i][j];

		int res = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solveRecursive(dims, i, k, dp) + solveRecursive(dims, k + 1, j, dp)
					+ dims[i - 1] * dims[k] * dims[j];
			res = Math.min(res, temp);
		}
		return dp[i][j] = res;
	}

	public static int solveIterative(int[] dims, int n, int[][] dp) {
		for (int i = 0; i < n; i++)
			dp[i][i] = 0;

		for (int z = 2; z < n; z++) {
			for (int i = 1; i < n - z + 1; i++) {
				int j = i + z - 1;
				if (j == n)
					continue;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int temp = dp[i][k] + dp[k + 1][j] + dims[i - 1] * dims[k] * dims[j];
					dp[i][j] = Math.min(dp[i][j], temp);
				}
			}
		}

		return dp[1][n - 1];
	}

	public static void main(String[] args) {
		int[] dims = { 1, 2, 3, 4 };
		int n = dims.length;
		int[][] dp = new int[n + 1][n + 1];
		int ans = solveRecursive(dims, 1, n - 1, dp);
		System.out.println(ans);
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], 0);
		ans = solveIterative(dims, n, dp);
		System.out.println(ans);
	}
}
