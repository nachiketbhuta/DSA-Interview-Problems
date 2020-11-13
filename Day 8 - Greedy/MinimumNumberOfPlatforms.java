

import java.util.Arrays;

public class MinimumNumberOfPlatforms {
	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		int n = arr.length;

		Arrays.sort(arr);
		Arrays.sort(dep);

		int platformNeeded = 1, ans = 1;

		int i = 1, j = 0;

		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				platformNeeded++;
				ans = Math.min(ans, platformNeeded);
				i++;
			} else {
				platformNeeded--;
				j++;
			}
		}

		System.out.println(ans);
	}
}