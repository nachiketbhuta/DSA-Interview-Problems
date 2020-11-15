import java.util.*;
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        // int k = 4;
        dfs(ans, nums, new ArrayList(), used);
        return ans;
    }
    
    public static void dfs(List<List<Integer>> ans, int[] nums, List<Integer> current, boolean[] used) {
        
        if (current.size() == nums.length) {
            ans.add(new ArrayList(current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) 
                continue;
            current.add(nums[i]);
            used[i] = true;
            dfs(ans, nums, current, used);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 8;

        List<List<Integer>> ans = permute(nums);

        for (List<Integer> curr: ans) {
            System.out.println(curr);
        }
    }
}