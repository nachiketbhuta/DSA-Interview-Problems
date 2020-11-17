import java.util.PriorityQueue;

public class KthLargestElement {
    public PriorityQueue<Integer> heap;
    public int k;
    public KthLargestElement(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();
        
        for (int a: nums) {
            add(a);
        }
    }
    
    public int add(int val) {
        heap.add(val);
        if (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
    public static void main(String[] args) {
        int nums[] = {4, 5, 8, 2};
        int k = 3;
        KthLargestElement kthLargest = new KthLargestElement(k, nums);
        System.out.println(kthLargest.add(3));  
        System.out.println(kthLargest.add(5));  
        System.out.println(kthLargest.add(10)); 
        System.out.println(kthLargest.add(9));  
        System.out.println(kthLargest.add(4));  
        
    }
}