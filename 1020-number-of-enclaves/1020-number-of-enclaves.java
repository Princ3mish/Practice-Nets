class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid == null || grid.length == 0)return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int r = 0 ; r < rows ; r++){
            if(grid[r][0] == 1){
                dfs(grid , r , 0 , rows , cols);
            }
            if(grid[r][cols - 1] == 1){
                dfs(grid , r , cols - 1 , rows , cols );
            }
        }
        for(int c = 0 ; c < cols ; c++){
            if(grid[0][c] == 1){
                dfs(grid , 0 , c , rows , cols);
            }
            if(grid[rows - 1][c] == 1){
                dfs(grid , rows - 1 , c , rows , cols);
            }
        }
        int enc = 0;
        for(int r = 0 ; r < rows ; r++){
            for(int c = 0 ; c < cols ; c++){
                if(grid[r][c] == 1){
                    enc++;
                }
            }
        }
        return enc;
    }
    private void  dfs(int[][] grid , int r , int c , int rows , int cols){
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 1){
            return;
        }
        grid[r][c] = 0;
        dfs(grid , r+1 , c , rows, cols);
        dfs(grid , r-1 , c , rows, cols);
        dfs(grid , r , c+1 , rows, cols);
        dfs(grid , r , c-1 , rows, cols);
    }
}