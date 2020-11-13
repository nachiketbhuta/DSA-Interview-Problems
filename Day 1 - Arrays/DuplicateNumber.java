

public class DuplicateNumber {
	public static void main(String[] args) {
		int[] nums = { 3, 1, 3, 4, 2 };

		int fast = nums[0], slow = nums[0];

		do {
			fast = nums[fast];
			slow = nums[nums[slow]];
		} while (slow != fast);

		fast = nums[0];

		while (fast != slow) {
			fast = nums[fast];
			slow = nums[nums[slow]];
		}

		System.out.println(slow);
	}
}