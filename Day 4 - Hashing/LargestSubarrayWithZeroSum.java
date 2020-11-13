

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
	public static void main(String[] args) {
		int nums[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int sum = 0, ans = 0, n = nums.length;

		for (int i = 0; i < n; i++) {
			sum += nums[i];

			if (nums[i] == 0 && ans == 0)
				ans = 1;

			if (sum == 0)
				ans = i + 1;

			Integer prev = hashMap.get(sum);

			if (prev != null) {
				ans = Math.max(ans, i - prev);
			} else {
				hashMap.put(sum, i);
			}
		}
		System.out.println("Length: " + ans);
	}
}