

public class TrappingWater {
	public static void main(String[] args) {
		int[] nums = { 3, 0, 2, 0, 4 };
		int n = nums.length;

		int[] pref = new int[n];
		int[] suff = new int[n];

		pref[0] = nums[0];
		for (int i = 1; i < n; i++)
			pref[i] = Math.max(pref[i - 1], nums[i]);

		suff[n - 1] = nums[n - 1];
		for (int i = n - 2; i >= 0; i--)
			suff[i] = Math.max(suff[i + 1], nums[i]);

		int ans = 0;
		for (int i = 0; i < n; i++)
			ans += Math.min(pref[i], suff[i]) - nums[i];

		System.out.println("Answer: " + ans);
	}
}