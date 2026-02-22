package binary_search;

import java.util.Arrays;

public class FirstLastPosition {
    private static int startingIndex(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int indx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] > target) {
                high = mid - 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                indx = mid;
                high = mid - 1;
            }
        }

        return indx;
    }

    private static int lastIndex(int[] arr, int n, int target) {
        int low = 0;
        int high = n - 1;
        int indx = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                indx = mid;
                low = mid + 1;
            }
        }

        return indx;
    }

    public static int[] searchRange(int[] nums, int target) {
        int start = startingIndex(nums, nums.length, target);
        if (start == -1) {
            return new int[] { -1, -1 };
        }
        int end = lastIndex(nums, nums.length, target);
        return new int[] { start, end };
    }

    public static void main(String[] args) {
        int[] arr = { 5, 7, 7, 8, 8, 10 };
        int target = 7;

        int[] range = searchRange(arr, target);
        System.out.println(Arrays.toString(range));
    }
}
