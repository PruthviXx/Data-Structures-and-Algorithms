package Stack_Queues.monotonic_stack;

import java.util.*;

class Solution {
    

    // Next Smaller Element (strictly smaller on right)
    public int[] getNse(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : n;
            st.push(i);
        }

        return ans;
    }

    // Previous Smaller or Equal Element (on left)
    public int[] getPsee(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            ans[i] = !st.isEmpty() ? st.peek() : -1;
            st.push(i);
        }

        return ans;
    }

    // Optimal function to calculate sum of subarray minimums
    public int optimal(int[] arr) {

        int[] nse = getNse(arr);
        int[] psee = getPsee(arr);
        // 1 5 5 5 5 
        //-1-1 1 2 3

        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(psee));

        int n = arr.length;
        long sum = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {

            int left = i - psee[i];
            int right = nse[i] - i;

            long freq = (long) left * right;
            long val = (freq * arr[i]) % mod;

            sum = (sum + val) % mod;
        }

        return (int) sum;
    }
}

public class SumOfSubarraysMinimum {
    public static void main(String[] args) {
        // Input array
        int[] arr = { 3, 1, 1, 2, 5 }; 
        // 1 5 5 5 5 
        //-1-1 1 2 3

        // Create an instance of Solution
        Solution sol = new Solution();

        // Call the optimized function
        int ans = sol.optimal(arr);

        // Print the result
        System.out.println("The sum of minimum value in each subarray is: " + ans);

    }
}
