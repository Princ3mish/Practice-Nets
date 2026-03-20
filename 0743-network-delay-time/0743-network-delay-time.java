import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0]; 
            int v = time[1];
            int w = time[2];

            adj.get(u).add(new int[]{v, w});
        }
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[]{0, k});
        Set<Integer> visit = new HashSet<>();
        int t = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int w1 = curr[0]; 
            int n1 = curr[1]; 
            if (visit.contains(n1)) continue;
            visit.add(n1);
            t = Math.max(t, w1);
            for (int[] neighbor : adj.get(n1)) {
                int n2 = neighbor[0]; 
                int w2 = neighbor[1];
                if (!visit.contains(n2)) {
                    minHeap.offer(new int[]{w1 + w2, n2});
                }
            }
        }
        return visit.size() == n ? t : -1;
    }
}