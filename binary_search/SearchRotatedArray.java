package binary_search;

public class SearchRotatedArray {
    // tc-> O(logn) and the sc-> O(1)
    private static int findPosition(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
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

        return -1;
    }

    public static int search(int[] nums, int target) {
        Math.sqrt(22);
        return findPosition(nums, nums.length, target);
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        System.out.println(search(arr, target));
    }
}
