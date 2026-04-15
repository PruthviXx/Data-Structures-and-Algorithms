import java.util.*;

class Solution{   
    // TC -> (n^2), SC -> (k) 
    public int bruteForce(String str,int k){
        int n = str.length();
        int maxLen = 0;

        for(int i=0; i<n; i++){
            Map<Character,Integer> map = new HashMap<>();
            int maxFreq = 0;
            for(int j=i; j<n; j++){
                char ch = str.charAt(j);
                if(map.containsKey(ch)){
                    map.put(ch,map.get(ch)+1);
                }
                else{
                    map.put(ch,1);
                }

                maxFreq = Math.max(maxFreq,map.get(ch));
                int changes = (j-i+1) - maxFreq;

                if(changes <= k){
                    maxLen =  Math.max(maxLen,(j-i)+1);
                    // System.out.println(maxLen);
                }

                if(changes > k){
                    break;
                }
            }
        }

        return maxLen;
    }

    // TC -> (n^k), SC -> (k) 
    public int better(String str,int k){
        int n = str.length();
        int maxLen = 0;
        int right = 0, left = 0, maxFreq = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(right < n){ //  O(N)
            char ch = str.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }

            maxFreq = Math.max(maxFreq, map.get(ch));
            int len = right - left + 1;
            int changes = len - maxFreq;

            if(changes > k){
                char ch2 = str.charAt(left);
                if(map.get(ch2) == 0){
                    map.remove(ch2);
                }
                else{
                    map.put(ch2, map.get(ch2)-1);
                }

                // update maxfreq again
                for(Map.Entry<Character,Integer> entry : map.entrySet()){ // O(K)
                    maxFreq = Math.max(maxFreq, entry.getValue());
                }

                left++;
            }

            maxLen = Math.max(maxLen,  right - left + 1);

            right++;
        }

        return maxLen;
    }

    // TC -> (n), SC -> (k) 
    public int optimal(String str,int k){
        int n = str.length();
        int maxLen = 0;
        int right = 0, left = 0, maxFreq = 0;
        Map<Character,Integer> map = new HashMap<>();

        while(right < n){
            char ch = str.charAt(right);
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }
            else{
                map.put(ch,1);
            }

            maxFreq = Math.max(maxFreq, map.get(ch));
            int len = right - left + 1;
            int changes = len - maxFreq;

            if(changes > k){
                char ch2 = str.charAt(left);
                if(map.get(ch2) == 0){
                    map.remove(ch2);
                }
                else{
                    map.put(ch2, map.get(ch2)-1);
                }

                left++;
            }

            maxLen = Math.max(maxLen,  right - left + 1);

            right++;
        }

        return maxLen;
    }

    public int solve(String str,int k){
        return optimal(str,k);
    }
}

class Main {
    public static void main(String[] args) {
        String str = "ABCVDEHADDDFFDDDDD";
        int k = 2;
        System.out.println(new Solution().solve(str,k));
    }
}
