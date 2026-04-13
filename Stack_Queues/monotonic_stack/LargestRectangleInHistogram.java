package Stack_Queues.monotonic_stack;

import java.util.Stack;

class Solution{
     // Time : O(n^2), Space : O(1)
    public int bruteForce(int[] arr){
        int maxValue = -1;
        int n = arr.length;

        for(int i=0; i<n; i++){
            int maxLength = 1;

            // forward direction
            int j = i+1;
            while(j < n && arr[i] < arr[j]){
                maxLength++;
                j++;
            }
            // backward direction
            j=i-1;
            while(j >= 0 && arr[i] < arr[j]){
                maxLength++;
                j--;
            }

            maxValue = Math.max(maxValue, (arr[i] * maxLength));
        }

        return maxValue;
    }

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

    // Time : O(5n), Space : O(4n)
    public int better(int[] arr){
        int[] nse = getNse(arr); // O(2n)
        int[] psse = getPsee(arr); // O(2n)
        int maxValue = -1;
        int n = arr.length;

        for(int i=0; i<n; i++){
            maxValue = Math.max(maxValue, (arr[i] * (nse[i] - psse[i] - 1)));
        }

        return maxValue;
    }

    // Time : O(2n), Space : O(n)
    public int optimal(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxValue = -1;
        int n = arr.length;

        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                int element = arr[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();
                maxValue = Math.max(maxValue, (element * (nse - pse -1)));
            }
            st.push(i);
        }

        // for reamining elements in stack
        while(!st.isEmpty()){
            int nse = n;
            int element = arr[st.pop()];
            int pse = st.isEmpty() ? -1 : st.peek();
            maxValue = Math.max(maxValue, (element * (nse - pse -1)));
        }

        return maxValue;
    }
}
class Main {
    public static void main(String[] args) {
        // int[] arr = {2,1,5,6,2,3};
        int[] arr = {3,2,10,11,5,10,6,3};
        Solution solution = new Solution();
        int ans = solution.better(arr);
        System.out.println("Max area: "+ans);
    }
}
