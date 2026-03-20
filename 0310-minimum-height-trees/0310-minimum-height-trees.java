import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] edgeCount = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            edgeCount[u]++;
            edgeCount[v]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (edgeCount[i] == 1) {
                leaves.offer(i);
            }
        }

        int remainingNodes = n;

        while (remainingNodes > 2) {
            int leavesCount = leaves.size();
            remainingNodes -= leavesCount;

            for (int i = 0; i < leavesCount; i++) {
                int leaf = leaves.poll();

                for (int neighbour : adj.get(leaf)) {
                    edgeCount[neighbour]--;

                    if (edgeCount[neighbour] == 1) {
                        leaves.offer(neighbour);
                    }
                }
            }
        }

        return new ArrayList<>(leaves);
    }
}