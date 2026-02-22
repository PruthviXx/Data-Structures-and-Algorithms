package Strings;

import java.util.HashMap;
import java.util.Map;

public class IsoMorphicString {
    public static boolean isIsomorphic(String s, String t) {
        Map<String, String> map = new HashMap<>();

        int n = s.length() - 1;

        while (n >= 0) {

            String key = map.get(s.charAt(n) + "");
            if (key != null) {
                String val = t.charAt(n) + "";
                if (!(key.equals(val))) {
                    return false;
                } else {
                    n--;
                    continue;
                }
            }
            map.put(s.charAt(n) + "", t.charAt(n) + "");
            n--;
        }

        String temp = s;
        s = t;
        t = temp;
        map.clear();
        n = s.length() - 1;

        while (n >= 0) {

            String key = map.get(s.charAt(n) + "");
            if (key != null) {
                String val = t.charAt(n) + "";
                if (!(key.equals(val))) {
                    return false;
                } else {
                    n--;
                    continue;
                }
            }
            map.put(s.charAt(n) + "", t.charAt(n) + "");
            n--;
        }

        return true;
    }

    public static boolean optimal(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        int n = s.length() - 1;

        while (n >= 0) {

            char original = s.charAt(n);
            char replacement = t.charAt(n);

            if (!map.containsKey(original)) {
                if (!map.containsValue(replacement)) {
                    map.put(original, replacement);
                } else {
                    return false;
                }
            } else {
                char mapped = map.get(original);
                if (mapped != replacement) {
                    return false;
                }
            }
            n--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "bfdc";
        String t = "baba";
        System.out.println(optimal(s, t));
        System.out.println(((int) 'h'+(int)'e'));
    }
}
