import java.util.*;

public class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] result = new int[n - k + 1][m - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                
                Set<Integer> current = new HashSet<>();
                
                for (int ii = i; ii < i + k; ii++) {
                    for (int jj = j; jj < j + k; jj++) {
                        current.add(grid[ii][jj]);
                    }
                }
                
                if (current.size() == 1) {
                    result[i][j] = 0;
                } else {
                    List<Integer> sortedList = new ArrayList<>(current);
                    Collections.sort(sortedList);
                    
                    int minDiff = Integer.MAX_VALUE;
                    
                    for (int idx = 1; idx < sortedList.size(); idx++) {
                        int diff = sortedList.get(idx) - sortedList.get(idx - 1);
                        minDiff = Math.min(minDiff, diff);
                    }
                    
                    result[i][j] = minDiff;
                }
            }
        }
        
        return result;
    }
}