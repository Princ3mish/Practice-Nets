class Solution {
    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        void union(int x, int y) {
            int xPar = find(x);
            int yPar = find(y);

            if (size[xPar] > size[yPar]) {
                parent[yPar] = xPar;
                size[xPar] += size[yPar];
            } else {
                parent[xPar] = yPar;
                size[yPar] += size[xPar];
            }
        }
    }

    public int minTime(int n, int[][] edges, int k) {

        if (edges.length == 0) {
            return 0;
        }

        Arrays.sort(edges, (a, b) -> b[2] - a[2]);

        if (n == k) {
            return edges[0][2];
        }

        DSU dsu = new DSU(n);

        int components = n;

        for (int[] edge : edges) {

            if (dsu.find(edge[0]) != dsu.find(edge[1])) {

                if (components == k) {
                    return edge[2];
                }

                dsu.union(edge[0], edge[1]);
                components--;
            }
        }

        return 0;
    }
}