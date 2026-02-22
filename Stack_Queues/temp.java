package Stack_Queues;

import java.util.*;
import java.util.Map.Entry;

class temp {

    public static int findFactorial(int n) {
        // if(n == 0){
        // return 1;
        // }
        int product = 1;
        while (n > 0) {
            product *= n;
            n--;
        }
        return product;
    }

    public static boolean solve(int n) {
        int sum = 0;
        int tempN = n;

        while (n > 0) {
            int digit = n % 10;
            sum += findFactorial(digit);
            n = n / 10;
        }

        System.out.println(tempN);
        System.out.println(sum);

        HashMap<Integer, Integer> map1 = new HashMap<>();
        n = tempN;
        // storing keys
        while (n > 0) {
            int digit = n % 10;
            if (map1.containsKey(digit)) {
                map1.put(digit, map1.get(digit) + 1);
            } else {
                map1.put(digit, 1);
            }
            n = n / 10;
        }

        // validating keys
        n = sum;
        while (n > 0) {
            int digit = n % 10;
            if (map1.containsKey(digit)) {
                if (map1.get(digit) == 1) {
                    map1.remove(digit);
                } else {
                    map1.put(digit, map1.get(digit) - 1);
                }
            } else {
                return false;
            }
            n = n / 10;
        }

        if (!map1.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "-1";
        String b = "12";
        StringBuilder sb = new StringBuilder();

        System.out.println(solve(133));
    }
}
