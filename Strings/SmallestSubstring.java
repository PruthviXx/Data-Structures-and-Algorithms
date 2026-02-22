package Strings;

public class SmallestSubstring {
    private static String subStr(String str, int k) {
        int n = str.length();
        int length = Integer.MAX_VALUE;
        StringBuilder subStr = new StringBuilder();
        int sum = 0;

        if (k >= n) {
            return str;
        }

        for (int i = 0; i < k; i++) {
            sum += (int) str.charAt(i);
        }

        length = sum;
        subStr.append(str.substring(0, k));

        int i = 0;
        int j = k;

        while (j < n) {
            sum -= (int) str.charAt(i);
            sum += (int) str.charAt(j);

            if (sum < length) {
                length = sum;
                subStr.setLength(0);
                subStr.append(str.substring(i + 1, j + 1));
            }

            j++;
            i++;
        }

        return subStr.toString();
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        StringBuilder sb=new StringBuilder();
        sb.substring(0, 0);
     sb.indexOf("g");
        System.out.println(subStr(str, 5));
        boolean res = str.contains("s");
        System.out.println(res);
    }
}
