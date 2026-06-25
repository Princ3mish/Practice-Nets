class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        int[] in = new int[numCourses];
        for(int[] edge : prerequisites){
            int v =  edge[1];
            int u = edge[0];
            adj.get(v).add(u);
            in[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < numCourses ; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int n : adj.get(node)){
                in[n]--;
                if(in[n] == 0){
                    q.add(n);
                }
            }
        }
        return cnt == numCourses;
    }
}
