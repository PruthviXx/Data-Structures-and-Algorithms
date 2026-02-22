package maths;

public class CountPrimes {
    private static int optimal(int n) {
        // O(n)
        int[] primes = new int[n];

        for (int i = 2; i < n; i++) {
            primes[i] = 1;
        }

        // logic
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (primes[i] == 1) {
                for (int j = i * i; j < n; j += i) {
                    primes[j] = 0;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i] == 1) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(optimal(10));
    }
}
