package binary_search;

import java.util.Arrays;

public class KthElementOfArays {
    public static long optimal(int k, int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;

        if (n > m) {
            return optimal(k, arr2, arr1);
        }

        int low = Math.max(0, k - m), high = Math.min(k, n);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if (mid1 < n)
                r1 = arr1[mid1];
            if (mid2 < m)
                r2 = arr2[mid2];
            if (mid1 > 0)
                l1 = arr1[mid1 - 1];
            if (mid2 > 0)
                l2 = arr2[mid2 - 1];

            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return -1; // dummy
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 6, 7, 9 };
        int[] arr2 = { 1, 4, 8, 10 };
        int k = 1;
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr1));
        System.out.println(optimal(k, arr1, arr2));
    }
}
