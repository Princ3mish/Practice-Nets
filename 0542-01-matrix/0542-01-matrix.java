import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

       
        int rows = mat.length;

     
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {
            {1, 0},   
            {-1, 0},  
            {0, 1}, 
            {0, -1}   
        };


        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (mat[r][c] == 0) {
                    queue.offer(new int[]{r, c});

                } else {

                    mat[r][c] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            int r = current[0];  
            int c = current[1];  
            for (int[] dir : directions) {

                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    mat[newRow][newCol] == -1) {

                    mat[newRow][newCol] = mat[r][c] + 1;

                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
        return mat;
    }
}