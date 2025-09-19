class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (search(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int row, int col, int idx) {
        if (idx == word.length()) return true;
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(idx))
            return false;
        char temp = board[row][col]; 
        board[row][col] = '#'; 
        boolean found = search(board, word, row+1, col, idx+1) ||
                        search(board, word, row-1, col, idx+1) ||
                        search(board, word, row, col+1, idx+1) ||
                        search(board, word, row, col-1, idx+1);
        board[row][col] = temp; 
        return found;
    }
}
