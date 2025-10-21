class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

       
        int[] color = new int[n + 1];

        
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) { 
                if (!bfsColor(graph, color, i)) {
                    return false; 
                }
            }
        }
        return true; 
    }

    private boolean bfsColor(List<Integer>[] graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 1; 

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {
                    
                    color[neighbor] = -color[node];
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    
                    return false;
                }
            }
        }
        return true;
    }
}
