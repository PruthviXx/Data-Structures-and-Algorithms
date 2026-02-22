package CP;

import java.util.*;

public class SosNumber {

    private static boolean isSwissNumber(long x) {
        int divisorCount = 0;
        double n = Math.sqrt(x);
        for (long i = 1; i <= n; i++) {
            if (x % i == 0) {
                divisorCount++;
                if (i != x / i) {
                    divisorCount++;
                }
            }
        }
        return divisorCount == 3;
    }

    public static String largestOddNumber(String num) {
        int n = num.length() - 1;

        while (n >= 0) {
            if (num.charAt(n) % 2 != 0) {
                return num.substring(0, n + 1);
            }
            n--;
        }

        return "";
    }

    

    private static String better(String str) {
        str = str.trim();
        int end = str.length() - 1;
        int start = end;
        StringBuilder sb = new StringBuilder();

        while (start >= 0) {
            while (start >= 0 && str.charAt(start) == ' ') {
                start--;
            }

            end = start;
            while (start >= 0 && str.charAt(start) != ' ') {
                start--;
            }

            if (start < 0) {
                break;
            }

            sb.append(str.substring(start + 1, end + 1) + " ");
        }

        sb.append(str.substring(start + 1, end + 1) + " ");

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        long x = 169;
        TreeSet<Integer> tree = new TreeSet<>();
        String str = "5420";

        System.out.println(largestOddNumber(str));
    }
}
