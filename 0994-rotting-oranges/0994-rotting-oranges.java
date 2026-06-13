class Solution {
    public int orangesRotting(int[][] grid) {
        int totalrows = grid.length;
        int totalcols = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;
        for(int r = 0 ; r < totalrows ; r++){
            for(int c = 0 ; c < totalcols ; c++){
                if(grid[r][c] ==2){
                    queue.add(new int[]{r,c});
                }else if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }
        if(fresh == 0)return 0;
        int minutes = 0;
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,-1,1};
        while(!queue.isEmpty()){
            int curr = queue.size();
            for(int i = 0 ; i < curr ; i++){
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for(int d = 0 ; d < 4 ; d++){
                    int nrow = r + drow[d];
                    int ncol = c + dcol[d];
                    if(nrow >= 0 && nrow < totalrows && ncol >= 0 && ncol < totalcols && grid[nrow][ncol] == 1){
                        grid[nrow][ncol] = 2;
                        fresh--;
                        queue.add(new int[]{nrow,ncol});
                    }
                }
            }
            minutes++;
        }
        return fresh == 0 ? minutes - 1 : -1;
    }
}