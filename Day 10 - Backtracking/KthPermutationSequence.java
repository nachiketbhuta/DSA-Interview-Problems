import java.util.*;

public class KthPermutationSequence {
    static public void findPermutation(int[] numbers, int k)
{
    int n = numbers.length;
    int[] indices = new int[n];

    int divisor = 1;
    for (int place = 1; place <= n; place++)
    {
        if((k / divisor) == 0)
            break; 

        indices[n-place] = (k / divisor) % place;
        divisor *= place;
    }
    for (int i = 0; i < n; i++)
    {
        int index = indices[i] + i;

        if(index != i)
        {
            int temp = numbers[index];
            for(int j = index; j > i; j--)
               numbers[j] = numbers[j-1];
            numbers[i] = temp;
        }
    }
    System.out.println(Arrays.toString(numbers));
}
    public static void main(String[] args) {
        int k = 10000000;
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++)
            nums[i] = i + 1;
        // List<Integer> ans = toFactoradic(k);
        // System.out.println(ans);
        findPermutation(nums, k);
    }
}