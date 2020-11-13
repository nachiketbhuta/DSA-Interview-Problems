public class ElementOccuringOnlyOnce {
    public static int search(int[] arr) {
        int low = 0, high = arr.length - 1;
        
        while (low <= high) {

            if (low == high) return arr[low];

            int mid = (low + high) / 2;

            if (mid % 2 == 0) {
                if (arr[mid] == arr[mid + 1]) {
                    low = mid + 2; 
                } else {
                    high = mid;
                }
            }
            else if(mid % 2 == 1) {
                if (arr[mid] == arr[mid - 1]) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4, 5, 5, 6, 6}; 
        int ans = search(arr); 
        System.out.println(ans);
    }
}