import java.util.Arrays;

public class LongestCommonSubsequence {

	public static int solveRecursive(String a, String b, int n, int m, int[][] dp) {

		if (n == 0 || m == 0)
			return 0;

		if (dp[n][m] != 0)
			return dp[n][m];

		int res = 0;
		if (a.charAt(n - 1) == b.charAt(m - 1))
			res = 1 + solveRecursive(a, b, n - 1, m - 1, dp);
		else
			res = Math.max(solveRecursive(a, b, n - 1, m, dp), solveRecursive(a, b, n, m - 1, dp));

		return dp[n][m] = res;
	}

	public static int solveIterative(String s1, String s2, int n, int m, int[][] dp) {

		for (int i = 0; i < n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i < m; i++) {
			dp[0][i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}

		return dp[n][m];
	}

	public static void main(String[] args) {
		String s1 = "abdcc";
		String s2 = "bd";

		int n = s1.length();
		int m = s2.length();

		int[][] dp = new int[n + 1][m + 1];

		int ans = solveRecursive(s1, s2, n, m, dp);
		System.out.println(ans);
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], 0);
		ans = solveIterative(s1, s2, n, m, dp);
		System.out.println(ans);
	}
}
