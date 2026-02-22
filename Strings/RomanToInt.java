package Strings;

public class RomanToInt {
    public static int getNumber(String s) {
        int n = s.length() - 1;
        int cnt = 0;
        int i = 0;

        while (i <= n) {
            if (i < n && s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                cnt += 4;
                i += 2;
            } else if (i < n && s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                cnt += 9;
                i += 2;
            } else if (i < n && s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                cnt += 40;
                i += 2;
            } else if (i < n && s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                cnt += 90;
                i += 2;
            } else if (i < n && s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                cnt += 400;
                i += 2;
            } else if (i < n && s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                cnt += 900;
                i += 2;
            } else if (s.charAt(i) == 'I') {
                cnt += 1;
                i += 1;
            } else if (s.charAt(i) == 'V') {
                cnt += 5;
                i += 1;
            } else if (s.charAt(i) == 'X') {
                cnt += 10;
                i += 1;
            } else if (s.charAt(i) == 'L') {
                cnt += 50;
                i += 1;
            } else if (s.charAt(i) == 'C') {
                cnt += 100;
                i += 1;
            } else if (s.charAt(i) == 'D') {
                cnt += 500;
                i += 1;
            } else if (s.charAt(i) == 'M') {
                cnt += 1000;
                i += 1;
            }
        }
        return cnt;
    }

    public static int usingSwitch(String s) {
        int n = s.length() - 1;
        int cnt = 0;
        int i = 0;
    
        while (i <= n) {
            switch (s.charAt(i)) {
                case 'I':
                    if (i < n && s.charAt(i + 1) == 'V') {
                        cnt += 4;
                        i += 2;
                    } else if (i < n && s.charAt(i + 1) == 'X') {
                        cnt += 9;
                        i += 2;
                    } else {
                        cnt += 1;
                        i += 1;
                    }
                    break;
                case 'V':
                    cnt += 5;
                    i += 1;
                    break;
                case 'X':
                    if (i < n && s.charAt(i + 1) == 'L') {
                        cnt += 40;
                        i += 2;
                    } else if (i < n && s.charAt(i + 1) == 'C') {
                        cnt += 90;
                        i += 2;
                    } else {
                        cnt += 10;
                        i += 1;
                    }
                    break;
                case 'L':
                    cnt += 50;
                    i += 1;
                    break;
                case 'C':
                    if (i < n && s.charAt(i + 1) == 'D') {
                        cnt += 400;
                        i += 2;
                    } else if (i < n && s.charAt(i + 1) == 'M') {
                        cnt += 900;
                        i += 2;
                    } else {
                        cnt += 100;
                        i += 1;
                    }
                    break;
                case 'D':
                    cnt += 500;
                    i += 1;
                    break;
                case 'M':
                    cnt += 1000;
                    i += 1;
                    break;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(usingSwitch(s));
    }
}
