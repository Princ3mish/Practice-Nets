class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 0;

        for (int i = 0; i < m; i++) {
            int j = 0;
            while (j < n) {
                for (int cost = 0; cost <= k; cost++) {
                    if (dp[i][j][cost] != -1) {
                        int score = dp[i][j][cost];

                        if (j + 1 < n) {
                            int cell = grid[i][j + 1];
                            int nextCost = cost + (cell == 0 ? 0 : 1);
                            if (nextCost <= k)
                                dp[i][j + 1][nextCost] = Math.max(dp[i][j + 1][nextCost], score + cell);
                        }

                        if (i + 1 < m) {
                            int cell = grid[i + 1][j];
                            int nextCost = cost + (cell == 0 ? 0 : 1);
                            if (nextCost <= k)
                                dp[i + 1][j][nextCost] = Math.max(dp[i + 1][j][nextCost], score + cell);
                        }
                    }
                }
                j++;
            }
        }

        int result = -1;
        for (int cost = 0; cost <= k; cost++) {
            if (dp[m - 1][n - 1][cost] != -1)
                result = Math.max(result, dp[m - 1][n - 1][cost]);
        }

        return result;
    }
}
