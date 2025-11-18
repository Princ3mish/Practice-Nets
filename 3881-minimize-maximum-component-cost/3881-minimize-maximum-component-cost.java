class Solution {
    private static class DSU {
        int[] p, sz;
        int comps;
        DSU(int n) {
            p = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) { p[i] = i; sz[i] = 1; }
            comps = n;
        }
        int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }
        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (sz[a] < sz[b]) { int t = a; a = b; b = t; }
            p[b] = a;
            sz[a] += sz[b];
            comps--;
            return true;
        }
    }

    public int minCost(int n, int[][] edges, int k) {
        if (k >= n) return 0; 

        int maxW = 0;
        for (int[] e : edges) maxW = Math.max(maxW, e[2]);

        int lo = 0, hi = maxW;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            DSU dsu = new DSU(n);
            for (int[] e : edges) {
                if (e[2] <= mid) dsu.union(e[0], e[1]);
            }
            if (dsu.comps <= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
