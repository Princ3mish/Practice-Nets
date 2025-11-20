import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] digs = new int[n];
        for (int i = 0; i < n; i++) digs[i] = digitSum(nums[i]);

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> {
            if (digs[a] != digs[b]) return Integer.compare(digs[a], digs[b]);
            return Integer.compare(nums[a], nums[b]);
        });

        
        int[] pos = new int[n];
        for (int sortedPos = 0; sortedPos < n; sortedPos++) {
            pos[idx[sortedPos]] = sortedPos;
        }

        boolean[] vis = new boolean[n];
        int swaps = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] || pos[i] == i) continue;
            int cur = i;
            int cycleSize = 0;
            while (!vis[cur]) {
                vis[cur] = true;
                cur = pos[cur];
                cycleSize++;
            }
            if (cycleSize > 0) swaps += cycleSize - 1;
        }
        return swaps;
    }

    private int digitSum(int x) {
        int s = 0;
        while (x > 0) {
            s += x % 10;
            x /= 10;
        }
        return s;
    }
}
