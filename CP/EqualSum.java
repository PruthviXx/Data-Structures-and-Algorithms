package CP;

public class EqualSum {
    private static int bruteForce(int n) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i = 0; i < n; i++) {
            sum1 += 1;
            for (int j = i + 1; j < n; j++) {
                sum2 += 2;
                for (int j2 = j + 1; j2 < n; j2++) {
                    sum3 += 3;

                }
                if (sum1 == sum2 && sum2 == sum3) {
                    return 1;
                }
                sum3 = 0;
            }
            sum2 = 0;
        }

        return 0;
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(bruteForce(n));
    }
}
