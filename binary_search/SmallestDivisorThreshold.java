package binary_search;

public class SmallestDivisorThreshold {
    public static boolean divisorSum(int[] arr, int divisor, int threshold) {
        int n = arr.length; // Size of the array
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int division = arr[i] / divisor;

            if (arr[i] % divisor != 0) {
                division++;
            }

            sum += division;
        }
        return sum <= threshold;
    }

    // tc-> O(logn)*O(n) and the sc-> O(1)
    public static int findSmallestDivisor(int[] arr, int threshold) {
        int n = arr.length; // Size of the array
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }

        // Apply binary search:
        int low = 1, high = maxi;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (divisorSum(arr, mid, threshold)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 21212, 10101, 12121 };
        int threshold = 1000000;
        System.out.println(findSmallestDivisor(arr, threshold));
    }
}
