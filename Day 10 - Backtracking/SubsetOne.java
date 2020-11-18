import java.util.*;
public class SubsetOne {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, 0, nums, new ArrayList());
        return ans;
    }
    
    public static void dfs(List<List<Integer>> ans, int ind, int[] nums, List<Integer> current) {
        ans.add(new ArrayList(current));
        
        for (int i = ind; i < nums.length; i++) {
            current.add(nums[i]);
            dfs(ans, i + 1, nums, current);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1, 2, 3};

        List<List<Integer>> ans = subsets(candidates);

        for (List<Integer> curr: ans) {
            System.out.println(curr);
        }
    }
}