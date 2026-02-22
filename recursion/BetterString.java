

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BetterString {
    public static void generateSubSeq(String str, String current, int index, Set<String> set) {
        if (index == str.length()) {
            set.add(current);
            return;
        }

        // take the curr character
        generateSubSeq(str, current + str.charAt(index), index + 1, set);

        // not take the curr character
        generateSubSeq(str, current, index + 1, set);
    }

    public static int getAllSubSeq(String str) {
        Set<String> set = new HashSet<>();
        generateSubSeq(str, "", 0, set);
        return set.size();
    }

    public static String getBetterString(String str1, String str2) {
        int a = getAllSubSeq(str1);
        int b = getAllSubSeq(str2);

        if (b > a)
            return str2;

        return str1;
    }

    public static int usingDp(String str) {
        Map<Character, Integer> map = new HashMap<>();
        int n = str.length();
        int[] dp = new int[n + 1];

        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = 2 * dp[i - 1];

            if (map.containsKey(str.charAt(i - 1))) {
                dp[i] = dp[i] - dp[map.get(str.charAt(i - 1))];
            }
            map.put(str.charAt(i - 1), (i - 1));
        }

        return dp[n];
    }

    public static void main(String args[]) {

        String str1 = "gf";
        String str2 = "f";
        // List<List<Integer>> list = new ArrayList<List<Integer>>();
        // list.remove();
        System.out.println(getBetterString(str1, str2));
    }
}
