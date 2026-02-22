package CP;

public class MakeItBinary {
    public static int bruteForce(int n, String s) {
        // Write your code here

        int i = 0, j = 1;

        while (j < n) {
            if (s.charAt(i) == '0' && s.charAt(j) == '#') {
                i = j + 1;
                j = i + 1;
            } else if (s.charAt(i) == '#' && s.charAt(j) == '1') {
                i = j + 1;
                j = i + 1;
            } else if (!(s.charAt(i) == '#') && !(s.charAt(j) == '#')) {
                i++;
                j++;
            } else {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        String s = "###01###";
        int n = s.length();
        System.out.println(bruteForce(n, s));
    }
}
