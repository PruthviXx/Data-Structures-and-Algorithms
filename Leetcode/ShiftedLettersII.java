package Leetcode;

public class ShiftedLettersII {

    public static void replaceCharacters(StringBuilder sb, int direction, int start, int end) {
        for (int i = start; i <= end; i++) {
            char ch = sb.charAt(i);
            if (direction == 0) {
                if (ch == 'a') {
                    ch += 25;
                } else {
                    ch--;
                }
                sb.setCharAt(i, ch);
            } else {
                if (ch == 'z') {
                    ch -= 25;
                } else {
                    ch++;
                }
                sb.setCharAt(i, ch);
            }
        }
    }

    public static String solve(StringBuilder sb, int[][] shifts) {

        int n = shifts.length;

        for (int i = 0; i < n; i++) {
            int start = shifts[i][0];
            int end = shifts[i][1];
            int direction = shifts[i][2];
            replaceCharacters(sb, direction, start, end);
        }

        return sb.toString();
    }

    public static String optimal(String s, int[][] shifts) {
        char[] stringToChar = s.toCharArray();
        int[] finalShift = new int[stringToChar.length + 1];
        for (int i = 0; i < shifts.length; i++) {
            finalShift[shifts[i][0]] = shifts[i][2] == 1 ? finalShift[shifts[i][0]] + 1 : finalShift[shifts[i][0]] - 1;
            finalShift[shifts[i][1] + 1] = shifts[i][2] == 1 ? finalShift[shifts[i][1] + 1] - 1
                    : finalShift[shifts[i][1] + 1] + 1;
        }
        int prefixSum = 0;
        for (int i = 0; i < stringToChar.length; i++) {
            prefixSum += finalShift[i];
            int offset = ((stringToChar[i] - 'a') + prefixSum) % 26;
            if (offset < 0)
                stringToChar[i] = (char) (26 + offset + 'a');
            else
                stringToChar[i] = (char) (offset + 'a');
        }
        return new String(stringToChar);
    }

    public static void main(String[] args) {
        String s = "dztz";
        int[][] shifts = { { 0, 0, 0 }, { 1, 1, 1 } };
        // s=solve(new StringBuilder(s), shifts);
        s = optimal(s, shifts);
        System.out.println(s);
    }
}
