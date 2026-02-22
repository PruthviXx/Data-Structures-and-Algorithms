import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidAnagram {
    public static boolean better(String s, String t) {
        int n = s.length();
        int m = t.length();

        if (n != m)
            return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char toPut = s.charAt(i);
            if (map1.containsKey(toPut)) {
                map1.put(toPut, map1.get(toPut) + 1);
            } else {
                map1.put(toPut, 1);
            }
        }

        for (int i = 0; i < n; i++) {
            char toPut = t.charAt(i);
            if (map2.containsKey(toPut)) {
                map2.put(toPut, map2.get(toPut) + 1);
            } else {
                map2.put(toPut, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
            Integer val1 = entry.getValue();
            Integer val2 = map2.get(entry.getKey());

            if (val1 != val2) {
                return false;
            }
        }

        return true;
    }

    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int cntMax = 1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c) + 1;
                cntMax = Math.max(cnt, cntMax);
                map.put(c, cnt);
            } else {
                map.put(c, 1);
            }
        }

        List<Map.Entry<Character, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        // Iterate over the sorted entries
        for (Map.Entry<Character, Integer> entry : entries) {
            int val = entry.getValue();
            char key = entry.getKey();

            for (int i = 0; i < val; i++) {
                sb.append(key);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String t = "Aabb";
        System.out.println(frequencySort(t));
    }
}
