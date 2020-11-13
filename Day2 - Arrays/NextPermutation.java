

import java.util.Arrays;

public class NextPermutation {

	public static int[] swap(int[] a, int l, int r) {
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
		return a;
	}

	public static int[] reverse(int[] a, int l, int r) {

		while (l < r) {
			int temp = a[l];
			a[l++] = a[r];
			a[r--] = temp;
		}

		return a;
	}

	public static boolean nextPermutation(int[] nums) {
		if (nums.length <= 1)
			return false;

		int last = nums.length - 2;

		while (last >= 0) {
			if (nums[last] < nums[last + 1])
				break;
			last--;
		}

		if (last < 0)
			return false;

		int next = nums.length - 1;

		for (int i = nums.length - 1; i > last; i--) {
			if (nums[i] > nums[last]) {
				next = i;
				break;
			}
		}

		nums = swap(nums, next, last);
		nums = reverse(nums, last + 1, nums.length - 1);

		return true;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 2, 3 };

		if (nextPermutation(nums)) {
			System.out.println(Arrays.toString(nums));
		} else {
			System.out.println("No permutation of higher order");
		}
	}
}