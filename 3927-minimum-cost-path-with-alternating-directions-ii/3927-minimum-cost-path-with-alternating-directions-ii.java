import java.util.*;

class Solution {
    private static final long INF = Long.MAX_VALUE / 4;

    private static class Node implements Comparable<Node> {
        int i, j, p;
        long dist;
        Node(int i, int j, int p, long dist) { this.i = i; this.j = j; this.p = p; this.dist = dist; }
        public int compareTo(Node o) { return Long.compare(this.dist, o.dist); }
    }

    public long minCost(int m, int n, int[][] waitCost) {
        int M = m, N = n;
        long[][][] dist = new long[M][N][2];
        for (int i = 0; i < M; i++) for (int j = 0; j < N; j++) {
            dist[i][j][0] = dist[i][j][1] = INF;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        long startCost = (long)(1) * (1); 
        dist[0][0][1] = startCost;
        pq.add(new Node(0,0,1,startCost));

        int[][] dirs = {{1,0},{0,1}};

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.dist != dist[cur.i][cur.j][cur.p]) continue;

            if (cur.p == 1) {
                for (int[] d : dirs) {
                    int ni = cur.i + d[0], nj = cur.j + d[1];
                    if (ni < 0 || ni >= M || nj < 0 || nj >= N) continue;
                    long entry = (long)(ni + 1) * (nj + 1);
                    long nd = cur.dist + entry;
                    if (nd < dist[ni][nj][0]) {
                        dist[ni][nj][0] = nd;
                        pq.add(new Node(ni, nj, 0, nd));
                    }
                }
            } else { 
                long nd = cur.dist + (long) waitCost[cur.i][cur.j];
                if (nd < dist[cur.i][cur.j][1]) {
                    dist[cur.i][cur.j][1] = nd;
                    pq.add(new Node(cur.i, cur.j, 1, nd));
                }
            }
        }

        long ans = Math.min(dist[M-1][N-1][0], dist[M-1][N-1][1]);
        return ans >= INF/2 ? -1L : ans;
    }
}
