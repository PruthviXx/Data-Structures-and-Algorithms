package BitManipulation;

public class DivideTwoIntegers {
    public static int optimal(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        boolean sign = true;
        if (dividend < 0 && divisor > 0) {
            sign = false;
        }
        if (dividend > 0 && divisor < 0) {
            sign = false;
        }

        long n = (Math.abs((long) dividend));
        long d = (Math.abs((long) divisor));
        long quotient = 0;

        while (n >= d) {
            int cnt = 0;

            while (n >= (d << (cnt + 1))) {
                cnt++;
            }

            quotient += 1 << cnt;
            n -= (d << cnt);
        }

        if (quotient == (1 << 31) && sign)
            return Integer.MAX_VALUE;

        if (quotient == (1 << 31) && !sign)
            return Integer.MIN_VALUE;

        return (int) (sign ? quotient : (quotient * -1));
    }

    public static void main(String[] args) {

        System.out.println(optimal(22,3));
    }
}
