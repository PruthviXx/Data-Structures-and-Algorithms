package binary_search.two_d_arrays;

import java.util.*;

public class RowWithMax1 {
    private static int lowerBound(ArrayList<Integer> arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int k = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) >= x) {
                k = mid;
                high = mid - 1;
            } else if (arr.get(mid) < x) {
                low = mid + 1;
            }
        }

        return k;
    }

    private static int optimal(ArrayList<ArrayList<Integer>> arr, int n, int m) {
        int max = 0;
        int index = -1;

        for (int i = 0; i < n; i++) {
            int cnt_ones = m - lowerBound(arr.get(i), m, 1);
            if (cnt_ones > max) {
                max = cnt_ones;
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        // int mat[][] = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        arr.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        arr.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        arr.add(new ArrayList<>(Arrays.asList(0, 0, 0)));
        int n = 3, m = 3;
        System.out.println(optimal(arr, n, m));
    }
}