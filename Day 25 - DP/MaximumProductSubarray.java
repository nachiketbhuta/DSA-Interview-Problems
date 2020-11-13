import java.util.Arrays;

public class MaximumProductSubarray {

	public static int solve(int[] nums, int n) {
	    int mn = nums[0], mx = nums[0];
	    int ans = nums[0];

	    for (int i = 1; i < n; i++) {
	        if (nums[i] < 0) {
	        	int temp = mx;
	        	mx = mn;
	        	mn = temp;
	        }

	        mx = Math.max(nums[i], nums[i] * mx);
	        mn = Math.min(nums[i], nums[i] * mn);

	        ans = Math.max(ans, mx);
	    }

	    return ans;
	}

	public static void main(String[] args) {
		int[] nums =  { 6, -3, -10, 0, 2 };
		int n = nums.length;
    	int ans = solve(nums, n);
		System.out.println(ans);
	}
}
