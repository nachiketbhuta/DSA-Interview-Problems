
import java.util.Arrays;

public class MaximumSumIncreasingSubsequence {

	public static int solve(int[] nums, int n) {
	    int[] sum = new int[n];
	    Arrays.fill(sum, 0);
	    sum[0] = nums[0];

	    for (int i = 1; i < n; i++) {
	        for (int j = 0; j < i; j++) {
	            if (sum[i] < sum[j] && nums[i] > nums[j]) {
	                sum[i] = sum[j];
	            }
	        }

	        sum[i] += nums[i];
	    }

	    int res = Integer.MIN_VALUE;
	    for (int i = 0; i < n; i++) {
	    	res = Math.max(res, sum[i]);
	    }
	    return res;
	}

	public static void main(String[] args) {
		int[] nums =  { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
		int n = nums.length;
    	int ans = solve(nums, n);
		System.out.println(ans);
	}
}
