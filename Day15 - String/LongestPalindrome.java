

import java.util.Scanner;

public class LongestPalindrome {
	public static String longestPalindrome(String s) {
		int n = s.length();
		if (n == 0)
			return "";
		int[][] dp = new int[n + 1][n + 1];
		int ans = 1, start = 0;

		for (int i = 0; i < n; i++)
			dp[i][i] = 1;

		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				start = i;
				ans = 2;
			}
		}

		for (int k = 3; k <= n; k++) {
			for (int i = 0; i < n - k + 1; i++) {
				int j = i + k - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					if (k > ans) {
						start = i;
						ans = k;
					}
				}
			}
		}

		return s.substring(start, start + ans);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String s = sc.next();
		System.out.println(longestPalindrome(s));

	}

}
