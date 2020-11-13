public class MedianArray {

    public static int getMedian(int[] arr1, int[] arr2, int l1, int l2, int n1, int n2) {
        if (n1 - l1 == 1) {
            int a = Math.max(arr1[l1], arr2[l1]);
            int b = Math.min(arr1[n1], arr2[n2]);
            return (a + b) / 2;
        }

        int m1 = median(arr1, l1, n1);
        int m2 = median(arr2, l2, n2);

        if (m1 == m2) return m1;

        else if (m1 < m2)  { 
            if (n1 % 2 == 1) 
                return getMedian(arr1, arr2, (n1 + l1) / 2, l2, n1, (n2 + l2) / 2); 
            else
                return getMedian(arr1, arr2, (n1 + l1 + 1) / 2, l2, n1, (n2 + l2 + 1) / 2); 
        } 
        
        else { 
            if (n1 % 2 == 1) 
                return getMedian(arr1, arr2, l1, (n2 + l2) / 2, (n1 + l1) / 2, n2); 
            else 
                return getMedian(arr1, arr2, l1, (n2 + l2 + 1) / 2, (n1 + l1 + 1) / 2, n2); 
        } 
    }

    public static int median(int[] arr, int s, int e) {
        int n = e - s + 1;
        if (n % 2 == 1) 
            return arr[s + (n/2)];
        else
            return (arr[s + (n/2)] + arr[s + (n/2 - 1)]) / 2;
    }

    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 6}; 
        int arr2[] = {4, 6, 8, 10}; 
        int n1 = arr1.length;
        int n2 = arr2.length;
        
        int ans = 0;

        if (n1 != n2) {
            System.out.println("Doesn't work for arrays of unequal size");
           
        }
        else {
            if (n1 == 1) ans = (arr1[0] + arr2[0]) / 2;
            else if (n1 == 2)  {
                int a = Math.max(arr1[0], arr2[0]);
                int b = Math.min(arr1[1], arr2[1]);
                ans = (a + b) / 2;
            }
            else {
                ans = getMedian(arr1, arr2, 0, 0, n1 - 1, n2 - 1);
                System.out.println(ans);
            }
        }
    } 
}