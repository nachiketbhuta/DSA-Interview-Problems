import java.util.*;
public class SubsetTwo {
    public static List<List<Integer>> subsetsWithDup(int[] candidates) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, 0, candidates, new ArrayList());
        return ans;
    }
    public static void dfs(List<List<Integer>> ans, int ind, int[] nums, List<Integer> current) {
        ans.add(new ArrayList(current));   
        
        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1])
                continue;
            current.add(nums[i]);
            dfs(ans, i + 1, nums, current);
            current.remove(current.size() - 1);
        }
    }
    public static void main(String[] args) {
        int[] candidates = {1, 2, 2};

        List<List<Integer>> ans = subsetsWithDup(candidates);

        for (List<Integer> curr: ans) {
            System.out.println(curr);
        }
    }
}