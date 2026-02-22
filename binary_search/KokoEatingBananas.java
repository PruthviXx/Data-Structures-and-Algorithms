package binary_search;

public class KokoEatingBananas {
    // tc-> O(n) and the sc-> O(1)
    private static long findMax(int[] piles) {
        int n = piles.length;
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(piles[i], max);
        }

        return max;
    }

    // tc-> O(n) and the sc-> O(1)
    private static long findHours(int[] piles, long mid) {
        int n = piles.length;
        int hours = 0;

        for (int i = 0; i < n; i++) {
            // long hoursPerPile = piles[i] / mid;

            // if ((piles[i] % mid) > 0) {
            // hoursPerPile += 1;
            // }

            // hours += hoursPerPile;
            hours += Math.ceil((double) piles[i] / (double) mid);
        }

        return hours;
    }

    // tc-> O(n)+O(n)*O(logn) and the sc-> O(1)
    private static int findMinimumHours(int[] piles, int hours) {
        long low = 1;
        long high = findMax(piles);

        while (low <= high) {
            long mid = low + (high - low) / 2;

            long totalHours = findHours(piles, mid);

            if (totalHours <= hours) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    public static void main(String[] args) {
        int[] piles = { 805306368, 805306368, 805306368 };
        int h = 1000000000;
        System.out.println(findMinimumHours(piles, h));
    }
}
