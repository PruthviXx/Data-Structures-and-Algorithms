
package Strings;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Map;

/**
 * ValidQueriesI
 */
public class ValidQueriesI {
    public static int bruteForce(String text, String pattern, int q,
            int[][] queries) {
        int cnt = 0;
        int n = text.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int indx1 = queries[i][0];
            int indx2 = queries[i][1];

            sb.setLength(0);
            sb.append(text.substring(0, indx1));
            sb.append(text.substring(indx2 + 1, n));

            int m = pattern.length();
            int flag = 0;
            for (int j = 0; j < m; j++) {
                if (sb.indexOf(pattern.charAt(j) + "") == -1) {
                    flag = 1;
                    break;
                }
            }

            if (flag == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    

    public static void main(String[] args) {
        String text = "abacaba";
        String pattern = "abc";
        int q = 3;
        int[][] queries = {
                { 1, 4 },
                { 1, 2 },
                { 0, 6 },
        };

        System.out.println(bruteForce(text, pattern, q, queries));
    }

}