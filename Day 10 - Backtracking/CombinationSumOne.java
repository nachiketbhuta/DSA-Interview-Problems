import java.util.ArrayList;
import java.util.List;

public class CombinationSumOne {
    public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            current.add(nums[i]);
            dfs(ans, i, nums, current, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        int target = 8;

        List<List<Integer>> ans = combinationSum(candidates, target);

        for (List<Integer> curr: ans) {
            System.out.println(curr);
        }
    }
}