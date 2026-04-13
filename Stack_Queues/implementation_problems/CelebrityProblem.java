package Stack_Queues.implementation_problems;

public class CelebrityProblem {
    // Time: O(n^2), Space: O(2n)
    public static int bruteForce(int[][] arr) {
        int n = arr.length;
        int[] iKnow = new int[n];
        int[] knowsMe = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    knowsMe[j]++;
                    iKnow[i]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (knowsMe[i] == n - 1 && iKnow[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    // Time: O(2n), Space: O(1)
    public static int optimal(int[][] arr) {
        int top = 0;
        int bottom = arr.length - 1;

        while (top < bottom) {
            if (arr[top][bottom] == 1) {
                top++;
            } else if (arr[bottom][top] == 1) {
                bottom--;
            } else {
                bottom--;
                top++;
            }
        }

        if (top > bottom) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i == top) {
                continue;
            }

            if (arr[top][i] == 1 || arr[i][top] == 0) {
                return -1;
            }
        }

        return top;
    }

    public static int celebrityProblemSolution(int[][] arr) {
        return optimal(arr);
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 0 } };
        // int[][] arr = {
        // { 0, 1 },
        // { 1, 0 } };

        System.out.println(celebrityProblemSolution(arr));
    }
}
