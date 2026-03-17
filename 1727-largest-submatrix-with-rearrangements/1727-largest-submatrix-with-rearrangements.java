import java.util.*;

class Solution {

    public int largestSubmatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int r = 1; r < rows; r++) {

            for(int c = 0; c < cols; c++) {

                if(matrix[r][c] == 1) {
                    matrix[r][c] += matrix[r - 1][c];
                }
            }
        }

        int maxArea = 0;

        for(int r = 0; r < rows; r++) {

            int[] heights = matrix[r].clone();

            Arrays.sort(heights);

            for(int i = cols - 1; i >= 0; i--) {

                int height = heights[i];

                int width = cols - i;

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}