

import java.util.Scanner;

public class GridUniquePaths {

	public static int paths(int n, int m, int[][] dp) {
		if (n == 1 || m == 1)
			return 1;

		if (dp[n][m] != 0)
			return dp[n][m];

		int res = paths(n - 1, m, dp) + paths(n, m - 1, dp);
		return dp[n][m] = res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] dp = new int[n + 1][m + 1];

		int ans = paths(n, m, dp);
		System.out.println("Paths: " + ans);
	}
}