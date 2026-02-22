import java.util.*;

public class RatInMaze {
    public static void getPaths(ArrayList<ArrayList<Integer>> mat, StringBuilder sb, ArrayList<String> list, int n,
            int col,
            int row, int[][] hashMat) {
        // code here
        if (col == n - 1 && row == n - 1) {
            list.add(sb.toString());
            return;
        }

        // check left
        if (col > 0 && mat.get(row).get(col - 1) == 1 && hashMat[row][col - 1] != 1) {
            hashMat[row][col - 1] = 1;
            sb.append("L");
            getPaths(mat, sb, list, n, col - 1, row, hashMat);
            sb.deleteCharAt(sb.length() - 1);
            hashMat[row][col - 1] = 0;
        }

        // check right
        if (col < n - 1 && mat.get(row).get(col + 1) == 1 && hashMat[row][col + 1] != 1) {
            hashMat[row][col + 1] = 1;
            sb.append("R");
            getPaths(mat, sb, list, n, col + 1, row, hashMat);
            sb.deleteCharAt(sb.length() - 1);
            hashMat[row][col + 1] = 0;
        }

        // check up
        if (row > 0 && mat.get(row - 1).get(col) == 1 && hashMat[row - 1][col] != 1) {
            hashMat[row - 1][col] = 1;
            sb.append("U");
            getPaths(mat, sb, list, n, col, row - 1, hashMat);
            sb.deleteCharAt(sb.length() - 1);
            hashMat[row - 1][col] = 0;
        }

        // check Down
        if (row < n - 1 && mat.get(row + 1).get(col) == 1 && hashMat[row + 1][col] != 1) {
            hashMat[row + 1][col] = 1;
            sb.append("D");
            getPaths(mat, sb, list, n, col, row + 1, hashMat);
            sb.deleteCharAt(sb.length() - 1);
            hashMat[row + 1][col] = 0;
        }
    }

    public static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        // code here
        ArrayList<String> list = new ArrayList<String>();
        int n = mat.size();
        int[][] hashMat = new int[n][n];
        hashMat[0][0] = 1;
        if (mat.get(0).get(0) != 1) {
            return list;
        }

        // O(4^(m*n))
        getPaths(mat, new StringBuilder(), list, n, 0, 0, hashMat);

        // O(nlogn)
        Collections.sort(list);

        return list;
    }

    public static void main(String[] args) {
        // int[][] mat = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1
        // } };
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();

        mat.add(new ArrayList<>(Arrays.asList(1, 1, 1, 0, 1)));
        mat.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1, 1)));
        mat.add(new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1)));
        mat.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1)));
        mat.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0, 1)));

        ArrayList<String> list = findPath(mat);

        System.out.println(list);

        StringBuilder sb = new StringBuilder();
        sb.append("applepenapple");
        String s = "applepenapple";
        s.contains("apple");
        s.getBytes();
        System.out.println(sb);
    }
}
