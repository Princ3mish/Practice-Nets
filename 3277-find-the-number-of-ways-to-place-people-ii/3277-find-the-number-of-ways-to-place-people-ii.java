class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, ans = 0;
        for (int i = 0; i < n; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < n; ++j) {
                if (i == j) continue; // Can't pick same point for Alice and Bob
                int x2 = points[j][0], y2 = points[j][1];
                // Alice should be upper left of Bob
                if (x1 <= x2 && y1 >= y2) {
                    boolean valid = true;
                    for (int k = 0; k < n; ++k) {
                        if (k == i || k == j) continue;
                        int x = points[k][0], y = points[k][1];
                        // If there's anyone else inside/on the border of the rectangle, skip
                        if (x1 <= x && x <= x2 && y2 <= y && y <= y1) {
                            valid = false;
                            break;
                        }
                    }
                    if (valid) ans++;
                }
            }
        }
        return ans;
    }
}
