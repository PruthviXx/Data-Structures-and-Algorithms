import java.util.*;

class SlidingWindowMaximumSolution{
    // Time: O(n^2), Space : O(n-k) 
    public int[] bruteforce(int[] arr, int k){
        int n = arr.length;
        int[] ans = new int[n-k+1];
        int max = Integer.MIN_VALUE;

        for(int i=0; i<=n-k; i++){
            int j =i;

            while( j < (i+k)){
                max =  Math.max(max, arr[j]);
                j++;
            }

            ans[i] = max;
        }

        return ans;
    }

    // Time: O(2n), Space : O(2n)
    public int[] optimal(int[] arr, int k){
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> list = new ArrayList<>(); 

        for(int i=0; i<n; i++){
            // poll index if queue length greater than k
            if(!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            // maintain decreasing order monostack
            while(!dq.isEmpty() && dq.peekFirst() < arr[i]){
                dq.pollFirst();
            }
            // push index in queue
            dq.offerLast(i);
            // add result if i >= k-1
            if(i >= k-1){
                list.add(arr[dq.peekFirst()]);
            }
        }

        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }

        return ans;
    }
}

class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k =3;
        SlidingWindowMaximumSolution slidingWindowMaximumSolution = new SlidingWindowMaximumSolution();
        int[] ans = slidingWindowMaximumSolution.bruteforce(arr,k);
        System.out.println(Arrays.toString(ans));
    }
}
