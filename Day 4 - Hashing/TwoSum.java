

import java.util.HashSet;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 1, 4, 45, 6, 10, -8 };

		int sum = 49;

		HashSet<Integer> ans = new HashSet<>();

		for (int i : nums) {
			int temp = sum - i;

			if (ans.contains(temp)) {
				System.out.println("Pair: (" + i + ", " + temp + ")");
			}
			ans.add(i);
		}
	}
}