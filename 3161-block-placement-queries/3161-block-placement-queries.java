class Solution {
    private int[] tree;
    private int n;

    private void update(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (idx <= mid) {
            update(2 * node, start, mid, idx, val);
        } else {
            update(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.max(tree[2 * node], tree[2 * node + 1]);
    }

    private int query(int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 0;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        return Math.max(query(2 * node, start, mid, l, r), query(2 * node + 1, mid + 1, end, l, r));
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxCoord = 0;
        for (int[] q : queries) {
            maxCoord = Math.max(maxCoord, q[1]);
        }
        
        n = maxCoord + 1;
        tree = new int[4 * n];
        
        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0);
        obstacles.add(n);
        update(1, 0, n, n, n);
        
        List<Boolean> results = new ArrayList<>();
        
        for (int[] q : queries) {
            if (q[0] == 1) {
                int x = q[1];
                int prev = obstacles.floor(x);
                int next = obstacles.ceiling(x);
                
                update(1, 0, n, x, x - prev);
                update(1, 0, n, next, next - x);
                obstacles.add(x);
            } else {
                int x = q[1];
                int sz = q[2];
                
                int maxGap = query(1, 0, n, 0, x);
                int prev = obstacles.floor(x);
                maxGap = Math.max(maxGap, x - prev);
                
                results.add(maxGap >= sz);
            }
        }
        
        return results;
    }
}