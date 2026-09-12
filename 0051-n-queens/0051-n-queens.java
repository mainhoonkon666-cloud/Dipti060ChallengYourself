import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        boolean[] col = new boolean[n];
        boolean[] leftDiagonal = new boolean[2 * n - 1];
        boolean[] rightDiagonal = new boolean[2 * n - 1];

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, n, board, result,
              col, leftDiagonal, rightDiagonal);

        return result;
    }

    private void solve(int row, int n,
                       char[][] board,
                       List<List<String>> result,
                       boolean[] col,
                       boolean[] leftDiagonal,
                       boolean[] rightDiagonal) {

        if (row == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            result.add(current);

            return;
        }

        for (int c = 0; c < n; c++) {

            if (col[c] ||
                leftDiagonal[row - c + n - 1] ||
                rightDiagonal[row + c]) {

                continue;
            }

            board[row][c] = 'Q';

            col[c] = true;
            leftDiagonal[row - c + n - 1] = true;
            rightDiagonal[row + c] = true;

            solve(row + 1, n, board, result,
                  col, leftDiagonal, rightDiagonal);

            board[row][c] = '.';

            col[c] = false;
            leftDiagonal[row - c + n - 1] = false;
            rightDiagonal[row + c] = false;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna