public class 被围绕的区域 {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        int[] rows = new int[]{0, row - 1};
        int[] cols = new int[]{0, col - 1};
        for (int i : rows) {
            for (int j = 0; j < col; j++) {
                dfs(board, i, j, row, col);
            }
        }
        for (int j : cols) {
            for (int i = 1; i < row - 1; i++) {
                dfs(board, i, j, row, col);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j, int row, int col) {
        if (i < 0 || i >= row || j < 0 || j >= col) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '#';
            dfs(board, i + 1, j, row, col);
            dfs(board, i - 1, j, row, col);
            dfs(board, i, j + 1, row, col);
            dfs(board, i, j - 1, row, col);
        }
    }
}
