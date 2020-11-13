

public class KadanesAlgorithm {
	public static void main(String[] args) {
		int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };

		int max = nums[0], currMax = nums[0];

		for (int i = 1; i < nums.length; i++) {
			currMax = Math.max(nums[i], currMax + nums[i]);
			max = Math.max(max, currMax);
		}

		System.out.println("Maximum Contiguous Sum: " + max);
	}
}