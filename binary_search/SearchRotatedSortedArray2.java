package binary_search;

public class SearchRotatedSortedArray2 {
    // tc-> O(logn) and the sc-> O(1)
    private static boolean searchElement(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            }
            // left half sorted
            else if (arr[mid] >= arr[low]) {
                if (arr[low] <= target && target <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // right half sorted
            else {
                if (arr[mid] <= target && target <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 0, 1, 1, 1 };
        int target = 0;
        System.out.println(searchElement(arr, arr.length, target));
    }
}
