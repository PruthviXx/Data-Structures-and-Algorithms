package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimefactorsDsa {
    public static int[] getPrimeFactors(int n) {
        List<Integer> list = new ArrayList<>();
        n = (int) Math.sqrt(n);

        for (int i = 2; i <= n; i++) { // O(sqrtn)
            if (n % i == 0) {
                list.add(i);

                while (n % i == 0) { // O(sqrtn)
                    n = n / i;
                }
            }
        }

        int[] arr = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(Arrays.toString(getPrimeFactors(n)));
    }
}
