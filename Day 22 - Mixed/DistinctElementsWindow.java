import java.util.*;

public class DistinctElementsWindow {
    public static List<Integer> countDistinctElements(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < k; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        ans.add(hashMap.size());

        for (int i = k; i < nums.length; i++) {
            if (hashMap.get(nums[i - k]) == 1) {
                hashMap.remove(nums[i - k]);
            }
            else {
                hashMap.put(nums[i - k], hashMap.get(nums[i - k]) - 1);
            }

            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
            ans.add(hashMap.size());
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 }; 
        int k = 3; 

        List<Integer> ans = countDistinctElements(arr, k);
        System.out.println(ans);
    }
}