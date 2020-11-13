

import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nums[] = { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 };
		int n = nums.length;

		HashSet<Integer> hashSet = new HashSet<>();

		for (int a : nums) {
			hashSet.add(a);
		}

		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (!hashSet.contains(nums[i] - 1)) {
				int j = nums[i];
				while (hashSet.contains(j))
					j++;
				ans = Math.max(ans, j - nums[i]);
			}
		}
		System.out.println("Length: " + ans);
	}
}