package binary_search;

public class SearchInsertPosition {
    // tc-> O(logn) and the sc-> O(1)
    private static int binarySearch(int[] arr, int n, int m) {
        int low = 0;
        int high = n - 1;
        int pos = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= m) {
                pos = mid;
                high = mid - 1;
            } else if (arr[mid] < m) {
                low = mid + 1;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 7 };
        int m = 6;
        System.out.println(binarySearch(arr, arr.length, m));
    }
}
