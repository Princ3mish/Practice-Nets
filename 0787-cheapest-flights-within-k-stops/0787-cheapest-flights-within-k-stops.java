class Solution {


class Tuple {
    int stops, node, cost;
    Tuple(int stops, int node, int cost) {
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

    ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }

    for (int[] flight : flights) {
        adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
    }

    Queue<Tuple> q = new LinkedList<>();
    q.add(new Tuple(0, src, 0));

    int[] dist = new int[n];
    Arrays.fill(dist, (int)1e9);
    dist[src] = 0;

    while (!q.isEmpty()) {
        Tuple it = q.poll();

        int stops = it.stops;
        int node = it.node;
        int cost = it.cost;

        if (stops > k) continue;

        for (int[] iter : adj.get(node)) {
            int adjNode = iter[0];
            int edw = iter[1];

            if (cost + edw < dist[adjNode] && stops <= k) {
                dist[adjNode] = cost + edw;
                q.add(new Tuple(stops + 1, adjNode, cost + edw));
            }
        }
    }

    return dist[dst] == (int)1e9 ? -1 : dist[dst];
}

}