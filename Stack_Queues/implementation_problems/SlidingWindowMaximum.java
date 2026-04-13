package Stack_Queues.implementation_problems;

import java.lang.reflect.Array;
import java.util.Arrays;

class SlidingWindowMaximumSolution {
    public int[] solve(int[] nums, int k) {
        int n = nums.length;

        int[] arr = new int[n - k + 1];
        int maxW = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            maxW = Math.max(maxW, nums[i]);
        }

        int indx = 0;
        arr[indx] = maxW;
        indx++;
        for (int i = k; i < n; i++) {
            maxW = Math.max(maxW, nums[i]);
            arr[indx] = maxW;
            indx++;
        }

        return arr;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        return solve(nums, k);
    }
}

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = { 1, -1 };
        int k = 1;
        SlidingWindowMaximumSolution slidingWindowMaximumSolution = new SlidingWindowMaximumSolution();
        int[] ans = slidingWindowMaximumSolution.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
