public class SearchInRotatedArray {

    public static int search(int[] arr, int low, int high, int key) {
        if (low > high) return -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            else if (arr[mid] <= arr[high]) {
                if (key > arr[mid] && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            else {
                if (arr[low] <= key && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 }; 
        int n = arr.length; 
        int key = 1; 
        int i = search(arr, 0, n - 1, key); 
        if (i != -1) 
            System.out.println("Index: " + i); 
        else
            System.out.println("Key not found"); 
    }
}