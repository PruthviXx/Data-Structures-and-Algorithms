package Leetcode;

public class KthCharStringGame {
    public static void generateWords(StringBuilder sb) {
        int n = sb.length();

        StringBuilder newWord = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char ch = sb.charAt(i);
            if (ch == 'z') {
                ch -= 25;
            } else {
                ch++;
            }
            newWord.append(ch);
        }

        sb.append(newWord.toString());
    }

    public static char solve(int k) {
        StringBuilder sb = new StringBuilder("a");

        while (sb.length() < k) {
            generateWords(sb);
        }

        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        int k = 5;
        System.out.println(solve(k));

        char ch = (char) ('a' + Integer.bitCount(k - 1));
        System.out.println(ch);
    }
}
