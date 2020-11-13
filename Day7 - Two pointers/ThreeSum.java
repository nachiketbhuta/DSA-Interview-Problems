

import java.util.Arrays;

public class ThreeSum {
	public static void main(String[] args) {
		int[] nums = { 1, 4, 45, 6, 10, 8 };
		int sum = 22;

		int n = nums.length;

		Arrays.sort(nums);

		for (int i = 0; i < n - 2; i++) {
			int left = i + 1;
			int right = n - 1;

			while (left < right) {
				int temp = nums[i] + nums[left] + nums[right];
				if (temp == sum) {
					System.out.println("Triplet Found: ");
					System.out.println(nums[i] + " " + nums[left] + " " + nums[right]);
					return;
				} else if (temp < sum) {
					left++;
				} else {
					right--;
				}
			}
		}

		System.out.println("No triplets found");
	}
}