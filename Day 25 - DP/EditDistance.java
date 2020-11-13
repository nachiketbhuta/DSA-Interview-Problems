
import java.util.Arrays;

public class EditDistance {
	public static int solveRecursive(String a, String b, int n, int m, int[][] dp) {
		if (n == 0)
			return m;

		if (m == 0)
			return n;

		if (dp[n][m] != 0)
			return dp[n][m];

		int res = Integer.MAX_VALUE;
		if (a.charAt(n - 1) == b.charAt(m - 1))
			res = solveRecursive(a, b, n - 1, m - 1, dp);
		else
			res = 1 + Math.min(Math.min(solveRecursive(a, b, n, m - 1, dp), // Remove
					solveRecursive(a, b, n - 1, m, dp)), // Insert
					solveRecursive(a, b, n - 1, m - 1, dp)); // Replace

		return dp[n][m] = res;
	}

	public static int solveIterative(String s1, String s2, int n, int m, int[][] dp) {

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0)
					dp[i][j] = j;
				else if (j == 0)
					dp[i][j] = i;
				else if (s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
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
