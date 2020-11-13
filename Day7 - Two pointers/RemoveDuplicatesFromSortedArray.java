

public class RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 2, 2, 3, 3, 4 };
		int n = nums.length;
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			if (nums[i] != nums[i + 1])
				nums[j++] = nums[i];
		}
		nums[j++] = nums[n - 1];

		n = j;
		System.out.println("After removing duplicates: ");
		for (int i = 0; i < n; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}