

public class MaxContinuousOnes {
	public static void main(String[] args) {
		int nums[] = { 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1 };
		int n = nums.length;
		int ans = 0, cnt = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0)
				cnt = 0;
			else {
				cnt++;
				ans = Math.max(ans, cnt);
			}
		}
		System.out.println("Max Continuous ones: " + ans);
	}
}