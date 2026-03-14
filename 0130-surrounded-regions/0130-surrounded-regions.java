class Solution {

    public void solve(char[][] board) {

        int rows = board.length;
        int column = board[0].length;

        for(int r = 0; r < rows; r++) {

            if(board[r][0] == 'O')
                dfs(board, r, 0);

            if(board[r][column - 1] == 'O')
                dfs(board, r, column - 1);
        }

        for(int c = 0; c < column; c++) {

            if(board[0][c] == 'O')
                dfs(board, 0, c);

            if(board[rows - 1][c] == 'O')
                dfs(board, rows - 1, c);
        }

        for(int r = 0; r < rows; r++) {

            for(int c = 0; c < column; c++) {

                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

                else if(board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }
    }


    private void dfs(char[][] board, int r, int c) {

        int rows = board.length;
        int column = board[0].length;

        if(r < 0 || c < 0 || r >= rows || c >= column || board[r][c] != 'O') {
            return;
        }

        board[r][c] = '#';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}