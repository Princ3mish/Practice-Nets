class Solution {

    public boolean areSimilar(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        k = k % n;

        for(int i = 0; i < m; i++) {

            for(int j = 0; j < n; j++) {

                int newCol;

                if(i % 2 == 0) {
                    newCol = (j + k) % n;
                } else {
                    newCol = (j - k + n) % n;
                }

                
                if(grid[i][j] != grid[i][newCol]) {
                    return false;
                }
            }
        }

        return true;
    }
}