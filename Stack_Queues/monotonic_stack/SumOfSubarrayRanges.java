package Stack_Queues.monotonic_stack;

public class SumOfSubarrayRanges {
    public static long bruteForce(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                }
                if (nums[j] > max) {
                    max = nums[j];
                }
                sum = sum + (max - min);
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(bruteForce(arr));
    }
}