class Solution {
    private int[] dp;

    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        dp = new int[n];
        Arrays.fill(dp, -1);

        int maxVisited = 0;
        for (int i = 0; i < n; i++) {
            maxVisited = Math.max(maxVisited, dfs(arr, d, i));
        }

        return maxVisited;
    }

    private int dfs(int[] arr, int d, int i) {
        if (dp[i] != -1) {
            return dp[i];
        }

        int n = arr.length;
        int maxJumpsFromI = 1;

        for (int x = 1; x <= d && i + x < n; x++) {
            if (arr[i + x] >= arr[i]) {
                break;
            }
            maxJumpsFromI = Math.max(maxJumpsFromI, 1 + dfs(arr, d, i + x));
        }

        for (int x = 1; x <= d && i - x >= 0; x++) {
            if (arr[i - x] >= arr[i]) {
                break;
            }
            maxJumpsFromI = Math.max(maxJumpsFromI, 1 + dfs(arr, d, i - x));
        }

        return dp[i] = maxJumpsFromI;
    }
}