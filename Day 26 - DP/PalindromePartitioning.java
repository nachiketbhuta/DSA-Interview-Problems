import java.util.Arrays;

public class PalindromePartitioning {

	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		for (int z = s.length() - 1; z >= 0; z--) {
			sb.append(s.charAt(z));
		}
		if (sb.toString().equals(s))
			return true;
		return false;
	}

	public static int solveRecursive(String s, int i, int j, int[][] dp) {
		if (i >= j || isPalindrome(s.substring(i, j)))
			return 0;

		if (dp[i][j] != 0)
			return dp[i][j];

		int res = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int temp = solveRecursive(s, i, k, dp) + solveRecursive(s, k + 1, j, dp) + 1;
			res = Math.min(res, temp);
		}
		return dp[i][j] = res;
	}

	public static int solveIterative(String s, int n) {
		int[][] dp = new int[n][n];
		boolean[][] p = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = 0;
			p[i][i] = true;
		}

		for (int z = 2; z <= n; z++) {
			for (int i = 0; i < n - z + 1; i++) {
				int j = i + z - 1;

				if (z == 2) {
					p[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					p[i][j] = (s.charAt(i) == s.charAt(j)) && p[i + 1][j - 1];
				}
				if (p[i][j])
					dp[i][j] = 0;
				else {
					dp[i][j] = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int temp = dp[i][k] + dp[k + 1][j] + 1;
						dp[i][j] = Math.min(dp[i][j], temp);
					}
				}
			}
		}

		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		String str = "ababba";
		int n = str.length();

		int[][] dp = new int[n + 1][n + 1];
		int ans = solveRecursive(str, 0, n, dp);
		System.out.println(ans);
		for (int i = 0; i < n; i++)
			Arrays.fill(dp[i], 0);
		ans = solveIterative(str, n); // Not working as expected
		System.out.println(ans);
	}

}
