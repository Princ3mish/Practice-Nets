class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];
        for (int[] edge : prerequisites) {
            int u = edge[1]; 
            int v = edge[0]; 
            adj.get(u).add(v);
            in[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                q.add(i);
            }
        }
        int[] topo = new int[numCourses];
        int index = 0;
        
        while (!q.isEmpty()) {
            int node = q.poll();
            topo[index++] = node;
            
            for (int neighbor : adj.get(node)) {
                in[neighbor]--;
                if (in[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        if (index == numCourses) return topo;
        return new int[0];
    }
}