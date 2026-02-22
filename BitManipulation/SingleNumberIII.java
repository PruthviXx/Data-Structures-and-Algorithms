package BitManipulation;

import java.util.Arrays;

public class SingleNumberIII {
    static int[] optimal(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }

        int rightMost = xor & -xor;
        int b1 = 0, b2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightMost) != 0) {
                b1 ^= arr[i];
            } else {
                b2 ^= arr[i];
            }
        }
        return new int[] { b1, b2 };
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2, 4, 5, 2, 3, 3, 1 };
        int n = arr.length;

        System.out.println(Arrays.toString(optimal(arr, n)));
    }
}
