package Stack_Queues.monotonic_stack;

import java.util.Stack;

class MaximalRectangleSolution {
    public int maxRectangle(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxA = -1;
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int element = arr[st.pop()];
                int pse = st.isEmpty() ? -1 : st.peek();
                int nse = i;
                maxA = Math.max(maxA, (element * (nse - pse - 1)));
            }
            st.push(i);
        }

        // for reamining elements in stack
        while (!st.isEmpty()) {
            int nse = n;
            int element = arr[st.pop()];
            int pse = st.isEmpty() ? -1 : st.peek();
            maxA = Math.max(maxA, (element * (nse - pse - 1)));
        }

        return maxA;
    }

    public int solve(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return -1;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        int maxValue = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    arr[j] = arr[j] + 1;
                } else {
                    arr[j] = 0;
                }
            }

            int maxA = maxRectangle(arr);
            maxValue = Math.max(maxValue, maxA);
        }

        return maxValue;
    }

    public int getMaximalRectangle(char[][] matrix) {
        return solve(matrix);
    }
}

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' }
        };
        MaximalRectangleSolution solution = new MaximalRectangleSolution();
        int ans = solution.getMaximalRectangle(matrix);
        System.out.println(ans);
    }
}
