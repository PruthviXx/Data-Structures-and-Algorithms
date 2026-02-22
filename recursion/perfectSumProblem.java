import java.util.ArrayList;

public class perfectSumProblem {
    public static int findCountSubsets(int arr[], int index, int sum, int n, int k) {
        // Your code goes here
        if (index == n) {
            if (sum == k) {
                return 1;
            }
            return 0;
        }

        sum += arr[index];
        int l = findCountSubsets(arr, index + 1, sum, n, k);
        sum -= arr[index];
        int r = findCountSubsets(arr, index + 1, sum, n, k);
        return l + r;

        
    }

    public static void main(String[] args) {
        int[] arr = { 5, 5, 5 };
        int n = arr.length;
        int sum = 10;

        System.out.println(findCountSubsets(arr, 0, 0, n, sum));
    }
}
