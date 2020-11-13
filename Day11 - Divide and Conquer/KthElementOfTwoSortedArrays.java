import java.util.*;
public class KthElementOfTwoSortedArrays {

    public static int kthElement(int[] arr1, int[] arr2, int n1, int n2, int k) {

        if (k > (n1 + n2) || k < 1) return -1;

        if (n1 > n2) 
            return kthElement(arr2, arr1, n2, n1, k);

        if (n1 == 0) return arr2[k - 1];
        if (n2 == 0) return arr1[k - 1];

        if (k == 1) return Math.min(arr1[0], arr2[0]);


        int mid1 = Math.min(n1, k / 2);
        int mid2 = Math.min(n2, k / 2);

        if (arr1[mid1 - 1] > arr2[mid2 - 1]) {
            int[] temp = Arrays.copyOfRange(arr2, mid2, n2);
            return kthElement(arr1, temp, n1, n2 - mid2, k - mid2);
        }
        
        int[] temp = Arrays.copyOfRange(arr1, mid1, n1);
        return kthElement(temp, arr2, n1 - mid1, n2, k - mid1);
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9}; 
        int[] arr2 = {1, 4, 5, 8, 10}; 
        
        int n1 = arr1.length;
        int n2 = arr2.length;

        int k = 5; 
        int ans = kthElement(arr1, arr2, n1, n2, k);
        System.out.println(ans);
    }
}