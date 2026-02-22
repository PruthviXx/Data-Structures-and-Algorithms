package Stack_Queues.monotonic_stack;

public class RemoveKDigit {
    public static String bruteForce(String nums, int k) {
        String minPossible = Integer.MAX_VALUE + "";
        int n = nums.length();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                // 143221954
                if (sb.length() == (nums.length() - k)) {
                    break;
                }

                if (j == i) {
                    j += k - 1;
                    continue;
                }
                sb.append(nums.charAt(j));
            }
            minPossible = Math.min(Integer.parseInt(minPossible), Integer.parseInt(sb.toString())) + "";
        }

        return minPossible;
    }

    public static String removeKdigits(String num, int k) {
        return bruteForce(num, k);
    }

    public static void main(String[] args) {
        String str = "1432219";
        System.out.println(removeKdigits(str, 3));
    }
}
