package maths;

import java.util.Stack;

public class Pow {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                if (st.isEmpty()) {
                    return false;
                } else {
                    char ch = st.pop();
                    if (!(s.charAt(i) == ')' && ch == '(' || s.charAt(i) == '}' && ch == '{'
                            || s.charAt(i) == ']' && ch == '[')) {
                        return false;
                    }
                }
            }

            return true;
        }

        return false;
    }

    public static double optimal(double x, int n) {
        double ans = 1.0;
        long nn = n;

        if (nn < 0) {
            nn = nn * -1;
        }

        // tc -> logn
        while (nn > 0) {
            if (nn % 2 == 1) {
                ans *= x;
                nn -= 1;
            } else {
                x *= x;
                nn /= 2;
            }
        }

        if (n < 0) {
            ans = (double) (1.0) / (double) (ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int x = 2, p = 10;
        System.out.println(optimal(x, p));
    }
}
