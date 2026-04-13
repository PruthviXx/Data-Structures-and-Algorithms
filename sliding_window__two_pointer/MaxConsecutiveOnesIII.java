package sliding_window__two_pointer;

public class MaxConsecutiveOnesIII {
    public static int bruteForce(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int cntK = 0, cntLen = 0;
            for (int j = i; j < n; j++) {
                if (cntK > k) {
                    break;
                }

                if (nums[j] == 0) {
                    cntK++;
                }
                cntLen++;
            }

            maxLen = Math.max(maxLen, cntLen);
        }

        return maxLen;
    }

    public static int better(int[] nums, int k) {
        int maxLen = 0;
        int n = nums.length;
        int left = 0, right = 0;

        while (right < n) {

        }
        return maxLen;
    }

    public static int longestOnes(int[] nums, int k) {
        return bruteForce(nums, k);
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
        int k = 3;
        System.out.println(longestOnes(nums, k));
    }
}
