import java.util.Collections;
import java.util.PriorityQueue;

public class MedianRunningStream {
    public static void median(int[] nums) {
        double median = nums[0];

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        maxHeap.add(nums[0]);
        System.out.println(median);

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];

            if (maxHeap.size() > minHeap.size()) {
                if (x < median) {
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(x);
                }
                else {
                    minHeap.add(x);
                }
                median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }
            else if (maxHeap.size() == minHeap.size()) {
                if (x < median) {
                    minHeap.add(x);
                    median = (double) minHeap.peek();
                }
                else {
                    maxHeap.add(x);
                    median = (double) maxHeap.peek();
                }
                median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }
            else {
                if (x > median) {
                    maxHeap.add(minHeap.remove());
                    minHeap.add(x);
                }
                else {
                    maxHeap.add(x);
                }
                median = (double) (minHeap.peek() + maxHeap.peek()) / 2;
            }

            System.out.println(median);
        }
    }
    public static void main(String[] args) {
        int[] arr = {5, 15, 10, 20, 3}; 
        median(arr); 
    }
}