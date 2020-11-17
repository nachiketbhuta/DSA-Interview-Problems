import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementUnsortedArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int a: nums) pq.add(a);
        
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        int ans = findKthLargest(nums, k);
        System.out.println(ans);
    }
}