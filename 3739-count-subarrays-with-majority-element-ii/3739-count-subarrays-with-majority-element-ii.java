import java.util.*;

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        long[] pz = new long[n + 1];
        int i = 0;
        while (i < n) {
            pz[i + 1] = pz[i] + (nums[i] == target ? 1 : -1);
            i++;
        }
        return solve(0, n, pz);
    }

    private long solve(int l, int r, long[] pz) {
        if (l >= r) return 0L;
        int m = (l + r) >>> 1;
        long res = solve(l, m, pz) + solve(m + 1, r, pz);

        int leftLen = m - l + 1;
        int rightLen = r - m;

        long[] A = new long[leftLen];
        long[] B = new long[rightLen];

        int idx = l;
        int ai = 0;
        while (idx <= m) {
            A[ai++] = pz[idx++];
        }
        idx = m + 1;
        int bi = 0;
        while (idx <= r) {
            B[bi++] = pz[idx++];
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int t0 = 0;
        int bj = 0;
        while (bj < B.length) {
            long yVal = B[bj];
            while (t0 < A.length && A[t0] <= yVal - 1) t0++;
            res += t0;
            bj++;
        }

        return res;
    }
}
