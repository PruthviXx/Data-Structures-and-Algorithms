package binary_search;

public class LowerBound {

    private static int binarySearch(int[] arr, int n, int x) {
        int low = 0;
        int high = n - 1;
        int k = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= x) {
                k = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 3, 5 };
        int x = 2;
        int n = arr.length;

        System.out.println(binarySearch(arr, n, x));
    }

}
