public class SudokoSolver {
    public static int getStartIndex(int digit) {
        if (digit >= 0 && digit <= 2) {
            return 0;
        }

        if (digit >= 3 && digit <= 5) {
            return 3;
        }

        if (digit >= 6 && digit <= 8) {
            return 6;
        }

        return 0;
    }

    public static boolean possible(char[][] board, int row, int col, char digit, int n) {

        // check row and col
        for (int i = 0; i < n; i++) {
            if (board[row][i] == digit) {
                return false;
            }

            if (board[i][col] == digit) {
                return false;
            }

            // check sub box of grid (optimal)
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == digit) {
                return false;
            }
        }

        // brute force approach

        // check sub box of grid
        // int startRow, endRow, startCol, endCol;
        // startRow = getStartIndex(row);
        // startCol = getStartIndex(col);
        // endRow = startRow + 3;
        // endCol = startCol + 3;

        // for (int i = startRow; i < endRow; i++) {
        // for (int j = startCol; j < endCol; j++) {
        // if (board[i][j] == digit) {
        // return false;
        // }
        // }
        // }

        return true;
    }

    public static boolean solve(char[][] board, int row, int col, int n) {

        // find empty space
        for (int i = row; i < n; i++) {
            for (int j = col; j < n; j++) {
                if (board[i][j] == '.') {

                    for (char digit = '1'; digit <= '9'; digit++) {

                        if (possible(board, i, j, digit, n) == true) {
                            board[i][j] = digit;
                            boolean res = solve(board, row, col, n);
                            if (res == true) {
                                return true;
                            }
                            board[i][j] = '.';
                        }

                    }

                    return false;
                }
            }
        }

        return true;
    }

    public void solveSudoku(char[][] board) {
        int n = board.length;
        solve(board, 0, 0, n);
    }

    public static void main(String[] args) {
        char[][] board = {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        solve(board, 0, 0, board.length);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
