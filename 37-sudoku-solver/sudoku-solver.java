
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                // Find an empty cell
                if (board[row][col] == '.') {

                    // Try digits from 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            // Solve the remaining board
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack if the choice fails
                            board[row][col] = '.';
                        }
                    }

                    // No digit works in this cell
                    return false;
                }
            }
        }

        // All cells are filled
        return true;
    }

    private boolean isValid(char[][] board, int row,
                            int col, char num) {

        for (int i = 0; i < 9; i++) {

            // Check the row
            if (board[row][i] == num) {
                return false;
            }

            // Check the column
            if (board[i][col] == num) {
                return false;
            }

            // Check the 3 x 3 box
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;

            if (board[boxRow][boxCol] == num) {
                return false;
            }
        }

        return true;
    }
}
