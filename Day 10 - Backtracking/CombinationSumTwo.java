import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumTwo {
    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, 0, candidates, new ArrayList(), target);
        return ans;
    }
    
    public static void dfs(List<List<Integer>> ans, int ind, int[] nums, List<Integer> current, int target) {
        
        if (target < 0) return;
        else if (target == 0) {
            ans.add(new ArrayList(current));
            return;
        }
        
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1])
                continue;
            current.add(nums[i]);
            dfs(ans, i + 1, nums, current, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        List<List<Integer>> ans = combinationSum(candidates, target);

        for (List<Integer> curr: ans) {
            System.out.println(curr);
        }
    }
}