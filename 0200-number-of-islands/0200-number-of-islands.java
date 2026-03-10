class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length ;
        int columns = grid[0].length;

        int islandcount = 0 ;

        for( int r = 0 ; r < rows ; r++){
            for( int c = 0 ; c < columns ; c++){
                if(grid[r][c]=='1'){
                    islandcount++;
                    dfs(grid , r , c);
                }
            }
        }
        return islandcount;

        
    }
    private void dfs(char[][] grid , int r , int c){
        int rows = grid.length;
        int columns = grid[0].length;

        if( r < 0 || c  < 0 || r >= rows || c >= columns || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';

        dfs(grid , r+1 , c);
        dfs(grid , r-1 , c);
        dfs(grid , r , c+1);
        dfs(grid , r , c-1);
    }
}