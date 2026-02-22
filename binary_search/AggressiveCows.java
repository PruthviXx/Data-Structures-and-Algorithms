package binary_search;

import java.util.Arrays;

public class AggressiveCows {
    private static boolean assignStalls(int[] arr, int dist, int k) {
        int n = arr.length;
        int cnt = 1;
        int last = 0;
        for (int i = 1; i < n; i++) {
            int stallDist = arr[i] - arr[last];

            if (stallDist > dist) {
                cnt++;
                last = i;
            }

            if (cnt >= k) {
                return true;
            }
        }

        return false;
    }

    private static int bruteForce(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int start = 1;
        int end = arr[n - 1] - arr[0];

        for (int i = start; i <= end; i++) {
            if (assignStalls(arr, i, k)) {
                return i;
            } else {
                break;
            }
        }

        return 0;
    }

    private static int optimal(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int low = 1;
        int high = arr[n - 1] - arr[0];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (assignStalls(arr, mid, k)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 3, 4, 7, 10, 9 };
        int k = 4;
        System.out.println(bruteForce(arr, k));
    }
}
