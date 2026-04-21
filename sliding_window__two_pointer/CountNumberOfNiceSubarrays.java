class CountNumberOfNiceSubarrays{
    // TC -> O(n^2), SC -> O(1)
    public int bruteForce(int[] arr, int k){
        int n = arr.length, count = 0;

        for(int i=0; i<n; i++){
            int tCnt = 0;
            for(int j=i; j<n; j++){
                if(arr[j] % 2 != 0){
                    tCnt++;
                }

                if(tCnt == k){
                    count++;
                    break;
                }
            }
        }

        return count;
    }

    public int solve(int[] arr, int k){
        int n = arr.length, count = 0, countOdd = 0;
        int r = 0, l = 0;
        
        while(r < n){
            if(k <= 0){
                return 0;
            }
            
            if(arr[r] % 2 !=0){
                countOdd++;
            }

            while(countOdd > k){
                if(arr[l] %2 !=0){
                    countOdd--;
                }
                l++;
            }

            count += (r - l + 1);
            r++;
        }
        
        return count;
    }

    // TC -> O(n^2), SC -> O(1)
    public int optimal(int[] arr, int k){
        return solve(arr,k) - solve(arr,k-1);
    }
}
class Main {
    public static void main(String[] args) {
        int[] arr = {1,1,2,1,1,1,1};
        int k = 3;
        System.out.println(new CountNumberOfNiceSubarrays().optimal(arr,k)); 
    }
}
