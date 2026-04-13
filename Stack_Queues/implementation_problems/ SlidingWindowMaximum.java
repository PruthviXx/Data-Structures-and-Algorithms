package Stack_Queues.implementation_problems;

class SlidingWindowMaximumSolution {
    public int[] solve(int[] nums, int k) {
        int n = nums.length;

        int[] arr = new int[n - k + 1];
        int maxW = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            maxW = Math.max(maxW, arr[i]);
        }

        int indx = 0;
        arr[indx] = maxW;
        indx++;
        for (int i = k; i < n; i++) {
            arr[indx] = Math.max(maxW, arr[i]);
            indx++;
        }

        return arr;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        return solve(nums, k);
    }
}

public class  SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        SlidingWindowMaximumSolution slidingWindowMaximumSolution = new SlidingWindowMaximumSolution();
        int[] ans = slidingWindowMaximumSolution.maxSlidingWindow(nums, k);
    }
}
