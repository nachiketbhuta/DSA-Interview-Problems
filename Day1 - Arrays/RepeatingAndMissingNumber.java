

public class RepeatingAndMissingNumber {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 2, 6 };

		for (int i = 0; i < nums.length; i++) {
			int temp = Math.abs(nums[i]) - 1;

			if (nums[temp] > 0) {
				nums[temp] = -nums[temp];
			} else {
				System.out.println("Repeating number: " + Math.abs(nums[temp]));
				break;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				System.out.println("Missing number: " + (i + 1));
				break;
			}
		}
	}
}