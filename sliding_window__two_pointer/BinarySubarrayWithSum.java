class Solution{
    // TC -> O(n^2), SC -> O(1)
    public int bruteForce(int[] arr, int goal){
        int n = arr.length, count = 0;

        for(int i=0; i<n; i++){
            int tCnt = 0;
            for(int j=i; j<n; j++){
                tCnt += arr[j];

                if(tCnt == goal){
                    count++;
                }
                else if(tCnt > goal){
                    break;
                }
            }
        }

        return count;
    }

    // TC -> O(2n), SC -> O(1)
    public int solve(int[] arr, int goal){
        int n = arr.length, count = 0, sum = 0;
        int r = 0, l = 0;
        
        while(r < n){
            if(goal <= 0){
                return 0;
            }

            sum += arr[r];

            while(sum > goal){
                sum -= arr[l];
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }

    // TC -> O(2 * 2n), SC -> O(1)
    public int optimal(int[] arr, int goal){
        // basic maths ( totalSubarrays <= goal ) - ( totalSubarrays <= goal -1 )
        return solve(arr,goal) - solve(arr,goal-1);
    }
}
class Main {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,0,1};
        int goal = 2;
        System.out.println(new Solution().optimal(arr,goal)); 
    }
}
