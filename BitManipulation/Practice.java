package BitManipulation;

import java.util.ArrayList;

public class Practice {
    private static int clearBit(int no, int i) {
        if ((no ^ (1 << i)) < no) {
            return (no ^ (1 << i));
        }
        return no;
    }

    private static int setBit(int no, int i) {
        if ((no ^ (1 << i)) > no) {
            return (no ^ (1 << i));
        }
        return no;
    }

    private static int toggleBit(int no, int i) {
        return (no ^ (1 << i));
    }

    private static int extractBit(int no, int i) {
        if ((no ^ (1 << i)) < no) {
            return 1;
        }

        return 0;
    }

    private static boolean checkBit(int no, int i) {
        System.out.println((1 << i));
        System.out.println((no ^ (1 << i)));
        return ((no ^ (1 << i)) < no);
    }

    private static int nearestPowOfTwo(int n) {

        int x = 0;

        while ((1 << x) <= n)
            x++;

        return x - 1;
    }

    public static int countSetBits(int n) {

        // Your code here

        if (n == 0)
            return 0;

        int x = nearestPowOfTwo(n); // finding the nearest power of 2 in O(log n) time

        int nc = (1 << x);

        return (nc >> 1) * x + n - nc + 1 + countSetBits(n - nc);

    }

    static int setBit(int n) {
        // code here
        // 1111
        int y = ~n;
        ArrayList<Integer> ds = new ArrayList<>();
        ds.clear();
        // 0000
        y = y & y - 1;
        // 1001 (9)
        // 1000
        // 1000
        // 0111
        return ~y;
    }

    public static void main(String[] args) {
        int no = 70; // 1010
        int i = 3; // . 0010
        System.out.println(setBit(15));
    }
}
