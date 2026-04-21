import java.util.*;

class NumberOfSubstringsContainingAllThreeCharacters{
    // TC -> O(n^2), SC -> O(1)
    public int bruteForce(String s){
        int n = s.length();
        int count = 0;

        for(int i=0; i<n; i++){
            Set<Character> set = new HashSet<>();
            for(int j=i; j<n; j++){
                char ch = s.charAt(j);
                set.add(ch);

                if(set.contains('a') && set.contains('b') && set.contains('c')){
                    count++;
                }
            }
        }

        return count;
    }

    // // TC -> O(n), SC -> O(1)
    public int optimal(String s){
        int n = s.length();
        int count = 0;
        int a = -1, b = -1, c = -1;

        for(int i=0; i <n; i++){
            char ch  = s.charAt(i);

            if(ch == 'a'){
                a = i;
            }
            else if(ch == 'b'){
                b = i;
            }
            else if(ch == 'c'){
                c = i;
            }

            if(a != -1 && b != -1 && c != -1){
                int minIndex = -1;
                minIndex = Math.min(a,b);
                minIndex = Math.min(minIndex,c);
                count += minIndex + 1; // combinations that can be done with previous characters 
            }
        }

        return count;
    }
}
class Main {
    public static void main(String[] args) {
        String s = "abcaabc";
        System.out.println(new NumberOfSubstringsContainingAllThreeCharacters().optimal(s)); 
    }
}
