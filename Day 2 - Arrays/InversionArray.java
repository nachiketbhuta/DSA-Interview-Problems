

import java.util.Arrays;

public class InversionArray {

	public static int countInversions(int[] nums, int l, int m, int r) {
		int[] left = Arrays.copyOfRange(nums, l, m + 1);
		int[] right = Arrays.copyOfRange(nums, m + 1, r + 1);

		int i = 0, j = 0, k = l, swaps = 0;

		while (i < left.length && j < right.length) {
			if (left[i] <= right[j]) {
				nums[k++] = left[i++];
			} else {
				nums[k++] = right[j++];
				swaps += (m + 1) - (l + i);
			}
		}

		while (i < left.length)
			nums[k++] = left[i++];

		while (j < right.length)
			nums[k++] = right[j++];

		return swaps;
	}

	public static int mergeSort(int[] nums, int l, int r) {
		int ans = 0;

		if (l < r) {
			int m = (l + r) / 2;

			ans += mergeSort(nums, l, m);
			ans += mergeSort(nums, m + 1, r);
			ans += countInversions(nums, l, m, r);
		}

		return ans;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 20, 6, 4, 5 };

		System.out.println("Number of inversion: " + mergeSort(nums, 0, nums.length - 1));
	}
}