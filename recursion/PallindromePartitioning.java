import java.util.ArrayList;
import java.util.List;


public class PallindromePartitioning {
    public static boolean checkPallindrome(String s, int start, int end) {

        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }

    public static void getPartition(String s, List<List<String>> list, List<String> subStrings, int index) {
        if (index == s.length()) {
            list.add(new ArrayList<>(subStrings));
        }

        // O(2^n)
        for (int i = index; i < s.length(); i++) {
            boolean result = checkPallindrome(s, index, i); // O(substring(n))

            if (result) {
                subStrings.add(s.substring(index, i + 1));
                getPartition(s, list, subStrings, i + 1);
                subStrings.remove(subStrings.size() - 1);
            }

        }
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> list = new ArrayList<>();
        getPartition(s, list, new ArrayList<>(), 0);
        System.out.println(list);
    }
}
