class Solution {

    public int minimumDistance(String word) {
        int n = word.length();
        
        // dp[j] = min cost where free finger is at j
        int[] dp = new int[26];
        for (int i = 0; i < 26; i++) dp[i] = 0;

        int res = 0;

        for (int i = 1; i < n; i++) {
            int cur = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';

            int[] newDp = new int[26];
            for (int j = 0; j < 26; j++) {
                newDp[j] = dp[j] + dist(prev, cur);
            }

            for (int j = 0; j < 26; j++) {
                int cost = dp[j] + dist(j, cur);
                newDp[prev] = Math.min(newDp[prev], cost);
            }

            dp = newDp;
        }

        int ans = Integer.MAX_VALUE;
        for (int val : dp) {
            ans = Math.min(ans, val);
        }

        return ans;
    }

    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}