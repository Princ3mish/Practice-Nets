import java.util.*;

class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        for(int start = 0; start < n; start++) {
            if(color[start] != 0)
                continue;

            Queue<Integer> queue = new LinkedList<>();


            color[start] = 1;

            queue.offer(start);


            while(!queue.isEmpty()) {

                int node = queue.poll();

                for(int neighbor : graph[node]) {
                    if(color[neighbor] == 0) {

                        color[neighbor] = -color[node];

                        queue.offer(neighbor);
                    }
                    else if(color[neighbor] == color[node]) {

                        return false;
                    }
                }
            }
        }
        return true;
    }
}