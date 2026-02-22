package binary_search;

public class MakeMBouquets {

    // tc-> O(m)*O(n) and the sc-> O(1)
    private static int[] findMinMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = bloomDay.length;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }

        return new int[] { min, max };
    }

    private static int bouquetsPerDay(int[] bloomDay, int day, int k, int bouquets) {
        int n = bloomDay.length;
        int cnt = 0;
        int m = 0;

        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
            } else {
                m += cnt / k;
                cnt = 0;
            }

        }

        m += cnt / k;

        return m;
    }

    private static int bruteForce(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int[] minMax = findMinMax(bloomDay);

        if ((m * k) > n) {
            return -1;
        }

        for (int i = minMax[0]; i <= minMax[1]; i++) {
            if (bouquetsPerDay(bloomDay, i, k, m) == m) {
                return i;
            }
        }

        return -1;
    }

    private static int optimal(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int[] minMax = findMinMax(bloomDay);

        if ((m * k) > n) {
            return -1;
        }

        int low = minMax[0];
        int high = minMax[1];

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int bouquets = bouquetsPerDay(bloomDay, mid, k, m);

            if (bouquets >= m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        System.out.println(optimal(arr, m, k));
    }
}
