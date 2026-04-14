import java.util.*;

class Solution{
    
    // TC -> (n^2), SC -> (3)
    public int bruteForce(int[] fruits){
        int n =  fruits.length;
        int maxLen = 0;
        for(int i=0; i<n; i++){
            Set<Integer> set = new HashSet<>();
            int len = 0;
            for(int j=i; j<n; j++){
                set.add(fruits[j]);
                len++;

                if(set.size()>2){
                    break;
                }
                else{
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }
    
    // TC -> (2n), SC -> (3)
    public int better(int[] fruits){
        int n =  fruits.length;
        int maxLen = 0, left = 0, right = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while(right < n){
            if(map.containsKey(fruits[right])){
                map.put(fruits[right],map.get(fruits[right])+1);
            }
            else{
                map.put(fruits[right],1);
            }

            while(map.size() > 2){
                map.put(fruits[left],map.get(fruits[left])-1);

                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }

                left++;
            }

            int len = (right - left) + 1;
            maxLen = Math.max(maxLen, len);
            right++;
        }

        return maxLen;
    }

    // TC -> (n), SC -> (3)
    public int optimal(int[] fruits){
        int n =  fruits.length;
        int maxLen = 0, left = 0, right = 0;
        Map<Integer,Integer> map = new HashMap<>();

        while(right < n){
            if(map.containsKey(fruits[right])){
                map.put(fruits[right],map.get(fruits[right])+1);
            }
            else{
                map.put(fruits[right],1);
            }

            if(map.size() > 2){
                map.put(fruits[left],map.get(fruits[left])-1);

                if(map.get(fruits[left]) == 0){
                    map.remove(fruits[left]);
                }

                left++;
            }

            int len = (right - left) + 1;
            maxLen = Math.max(maxLen, len);
            right++;
        }

        return maxLen;
    }

    public int solve(int[] fruits){
        return optimal(fruits);
    }
}

class Main {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(new Solution().solve(fruits));
    }
}
