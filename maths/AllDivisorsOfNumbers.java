package maths;

import java.util.ArrayList;
import java.util.List;

public class AllDivisorsOfNumbers {

    public static void solve(int n) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; (i * i) <= n; i++) {
            if (n % i == 0) {
                list1.add(i);
                // System.out.print(i + " ");
                if (n / i != i) {

                    // System.out.print((n / i) + " ");
                }
            }
        }

        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }

        for (Integer integer : list2) {
            System.out.print(integer + " ");
        }
    }

    public static void main(String[] args) {
        int n = 20;
        solve(n);
    }
}
