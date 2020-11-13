


public class SortArraysOfZeroesOnesAndTwos {
	public static void main(String[] args) {
		int[] nums = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };

		int low = 0;
		int mid = 0;
		int high = nums.length - 1;
		int temp;
		while (mid <= high) {
			switch (nums[mid]) {
			case 0:
				temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;
				break;
			}
		}

		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}