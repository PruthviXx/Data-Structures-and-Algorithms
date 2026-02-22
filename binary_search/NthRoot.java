package binary_search;

public class NthRoot {
    // tc-> O(m)*O(n) and the sc-> O(1)
    private static int bruteForce(int n, int m) {
        int nth = -1;

        for (int i = 1; i <= m; i++) {
            long temp = (long) i;
            for (int j = 2; j <= n; j++) {
                temp *= (long) i;
            }
            if (temp == m) {
                nth = i;
            }
            if (temp > m) {
                break;
            }
        }

        return nth;
    }

    // tc-> O(logn)*O(n) and the sc-> O(1)
    private static int optimal(int n, int m) {

        int low = 1, high = m;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long mul = calculateN(n, m, mid);

            if (mul == m) {
                return mid;
            } else if (mul > m) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static long calculateN(int n, int m, int mid) {
        long mul = (long) mid;

        for (int i = 2; i <= n; i++) {
            mul *= (long) mid;

            if (mul > m) {
                return mul;
            }
        }

        return mul;
    }

    public static void main(String[] args) {
        int n = 7, m = 78125;
        System.out.println(optimal(n, m));

    }
}
