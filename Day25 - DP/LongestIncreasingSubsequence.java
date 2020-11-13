import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public static int solve(int arr[], int ind, int dp[]) {

		if (dp[ind] != -1) return dp[ind];

		int res = 0;
		for (int i = ind; i >= 0; i--)
		{
			if (arr[i] < arr[ind])
				res = Math.max(res, 1 + solve(arr, i, dp));
		}

		return dp[ind] = res;
	}

	public static void main(String[] args) {
		int n = 5;
		int[] arr = {4, 1, 5, 6, 9};
		int[] dp = new int[n + 1];

		Arrays.fill(dp, -1);

		int ans = 1;
		for (int i = 1; i < n; i++) {
			int temp = 1 + solve(arr, i, dp);
			ans = Math.max(ans, temp);
		}

		System.out.println(ans);
	}
}
