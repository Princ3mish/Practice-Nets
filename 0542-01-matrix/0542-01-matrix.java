class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int totalrows = mat.length;
        int totalcols = mat[0].length;
        int[][]dist = new int[totalrows][totalcols];
        Queue<int[]> queue = new ArrayDeque<>();
        for(int r = 0 ; r < totalrows ; r++){
            for(int c = 0 ; c < totalcols ; c++){
                if(mat[r][c] == 0){
                    dist[r][c] = 0;
                    queue.add(new int[]{r,c});
                }else{
                    dist[r][c] = -1;
                }
            }
        }
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,-1,1};
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            for(int d = 0 ; d < 4 ;d++){
                int nrow = r + drow[d];
                int ncol = c + dcol[d];
                if(nrow >= 0 && nrow < totalrows && ncol >= 0 && ncol < totalcols && dist[nrow][ncol] == -1){
                    dist[nrow][ncol] = dist[r][c] + 1;
                    queue.add(new int[]{nrow,ncol});

                }
            }
        }
        return dist;


        
    }
}