package Leetcode;

import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public String bruteForce(String s, String t) { // O (n^2)
        StringBuilder originalT = new StringBuilder(t);
        StringBuilder rearrangedT = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                // find 0 in t
                String ch = "";
                for (int j = 0; j < originalT.length(); j++) {
                    if (originalT.charAt(j) == '0') {
                        ch = "0";
                        originalT.deleteCharAt(j);
                        break;
                    }
                }

                if (ch == "") {
                    originalT.deleteCharAt(0);
                    ch = "1";
                }

                rearrangedT.append(ch);
            } else {
                // find 1 in t
                String ch = "";
                for (int j = 0; j < originalT.length(); j++) {
                    if (originalT.charAt(j) == '1') {
                        ch = "1";
                        originalT.deleteCharAt(j);
                        break;
                    }
                }

                if (ch == "") {
                    originalT.deleteCharAt(0);
                    ch = "0";
                }

                rearrangedT.append(ch);
            }
        }

        // System.out.println(s);
        // System.out.println(t);
        // System.out.println(rearrangedT.toString());
        originalT.setLength(0);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1' && rearrangedT.charAt(i) == '0'
                    || s.charAt(i) == '0' && rearrangedT.charAt(i) == '1') {
                originalT.append("1");
            } else {

                originalT.append("0");
            }
        }

        return originalT.toString();
    }

    public String better(String s, String t) {
        StringBuilder rearrangedT = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            // if (map.containsKey(ch)) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            // } else {
            // map.put(ch, 1);
            // }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                // find 0 in t
                if (map.containsKey('0')) {
                    map.put('0', map.get('0') - 1);
                    rearrangedT.append("0");
                } else {
                    map.put('1', map.get('1') - 1);
                    rearrangedT.append("1");
                }
            } else {
                // find 1 in t
                if (map.containsKey('1')) {
                    map.put('1', map.get('1') - 1);
                    rearrangedT.append("1");
                } else {
                    map.put('0', map.get('0') - 1);
                    rearrangedT.append("0");
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1' && rearrangedT.charAt(i) == '0'
                    || s.charAt(i) == '0' && rearrangedT.charAt(i) == '1') {
                ans.append("1");
            } else {

                ans.append("0");
            }
        }

        return ans.toString();
    }

    public String maximumXor(String s, String t) {
        System.out.println("BruteForce : " + bruteForce(s, t));
        System.out.println("Better :     " + better(s, t));
        return better(s, t);
    }
}

public class MaximumBitwiseXORAfterRearrangement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<ArrayList<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("101", "011")));
        list.add(new ArrayList<>(Arrays.asList("0110", "1110")));
        list.add(new ArrayList<>(Arrays.asList("0101", "1001")));

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i).get(0);
            String t = list.get(i).get(1);
            // System.out.println(ans);
        }
        String s = "0110";
        String t = "1110";
        String ans = solution.maximumXor(s, t);
    }
}
