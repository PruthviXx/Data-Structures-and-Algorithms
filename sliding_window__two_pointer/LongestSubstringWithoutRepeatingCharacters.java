package sliding_window__two_pointer;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int bruteForce(String str) {
        int n = str.length();
        int max = -1;
        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (set.add(str.charAt(i))) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    break;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(bruteForce("abcabcbb"));

        char ch = ' ';
        System.out.println(ch);
    }
}
