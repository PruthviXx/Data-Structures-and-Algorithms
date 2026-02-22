import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NQueens {

    // O(n)
    private static List<String> construct(char[][] ch) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            String s = new String(ch[i]);
            board.add(s);
        }

        return board;
    }

    // O(3n) -> we can optimize this to O(1) by using 3 hash tables
    private static boolean possible(int row, int col, char[][] board, int n) {
        int tempRow = row;
        int tempCol = col;

        // first check for the left backward direction
        while (col >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
        }

        // now check for the upper diagonal backward direction
        col = tempCol;
        while (col >= 0 && row >= 0) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
            row--;
        }

        // now check for the bottom diagonal backward direction
        col = tempCol;
        row = tempRow;
        while (col >= 0 && row < n) {
            if (board[row][col] == 'Q') {
                return false;
            }
            col--;
            row++;
        }

        return true;
    }

    // // O(n^n)
    // private static void solve(int col, char[][] board, List<List<String>> res,
    // int n) {
    // if (col == n) {
    // res.add(construct(board));
    // return;
    // }

    // for (int row = 0; row < n; row++) {
    // if (possible(row, col, board, n)) {
    // board[row][col] = 'Q';
    // solve(col + 1, board, res, n);
    // board[row][col] = '.';
    // }
    // }
    // }

    // O(n^n)
    private static void solve(int col, char[][] board, List<List<String>> res, int n, int[] rowHash,
            int[] lowerDiagonalHash, int[] upperDiagoalHash) {
        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (rowHash[row] == 0 && lowerDiagonalHash[row + col] == 0 && upperDiagoalHash[n - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                rowHash[row] = 1;
                lowerDiagonalHash[row + col] = 1;
                upperDiagoalHash[n - 1 + col - row] = 1;
                solve(col + 1, board, res, n, rowHash, lowerDiagonalHash, upperDiagoalHash);
                board[row][col] = '.';
                rowHash[row] = 0;
                lowerDiagonalHash[row + col] = 0;
                upperDiagoalHash[n - 1 + col - row] = 0;
            }
        }
    }

    // O(n^2)
    private static List<List<String>> getQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> res = new ArrayList<>();
        int[] rowHash = new int[n];
        int[] lowerDiagonalHash = new int[(2 * n) - 1];
        int[] upperDiagoalHash = new int[(2 * n) - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        solve(0, board, res, n, rowHash, lowerDiagonalHash, upperDiagoalHash);
        
        return res;
    }

    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = getQueens(n);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }

}
