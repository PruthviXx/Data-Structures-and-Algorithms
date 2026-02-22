package Strings;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            int start = 0;
            int n = strs[i].length();
            if (prefix.isEmpty() || strs[i].isEmpty()) {
                return "";
            }
            while (start < n && start < prefix.length() && strs[i].charAt(start) == prefix.charAt(start)) {
                start++;
            }
            prefix = prefix.substring(0, start);
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = { "aaa", "aa", "aaa" };
        System.out.println(longestCommonPrefix(strs));
    }
}
