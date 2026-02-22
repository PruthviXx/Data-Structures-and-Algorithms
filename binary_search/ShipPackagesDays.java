package binary_search;

public class ShipPackagesDays {
    private static int findMinMax(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
        }

        return max;
    }

    private static boolean shipWeight(int[] arr, int days, int weight) {
        int n = arr.length;
        int cntDays = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if ((sum + arr[i]) <= weight) {
                sum += arr[i];
            } else {

                cntDays++;
                sum = 0;
                sum += arr[i];
                if (sum > weight) {
                    return false;
                }
            }
        }

        if (sum != 0) {
            cntDays++;
        }

        return cntDays <= days;
    }

    private static int getWeight(int[] arr, int days) {
        // start from min
        // end till max * days
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            max += arr[i];
        }

        int low = findMinMax(arr);
        int high = max;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (shipWeight(arr, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 1;
        System.out.println(getWeight(arr, days));
    }
}
