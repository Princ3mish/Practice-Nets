class Solution {
    static final int MOD = (int) 1e9 + 7;
    int maxHeight = 0;

    long powerMod(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) != 0) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
    void dfs(int node, int parent, int depth, List<List<Integer>> adj) {
        maxHeight = Math.max(maxHeight, depth);
        for (int neighbor : adj.get(node)) {
            if (neighbor != parent) {
                dfs(neighbor, node, depth + 1, adj);
            }
        }
    }
    int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        maxHeight = 0;
        dfs(1, -1, 0, adj); 
        if (maxHeight == 0) return 1; 
        return (int) powerMod(2, maxHeight - 1); 
    }
}