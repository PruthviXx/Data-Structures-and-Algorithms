package CP;

import java.util.HashSet;

public class YouAreTrapped {
    public static int youAreTrapped(int n, int[] a) {
        // Write your code here
        int i = 0, j = 1;
        // 3, 9, 4, 3, 9, 8, 6, 4
        while (j < n) {
            if (a[j] % a[i] == 0) {
                a[j] = -1;
                a[i] = -1;
            } else {
                j++;
            }

            while (i < n && a[i] == -1) {
                i++;
                j = i + 1;
            }

            while (j < n && a[j] == -1) {
                j++;
            }
        }

        for (int k = 0; k < n; k++) {
            if (a[k] != -1) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 9, 4, 3, 9, 8, 6, 4 };
        System.out.println(youAreTrapped(arr.length, arr));
    }
}
