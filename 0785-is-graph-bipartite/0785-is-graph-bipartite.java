class Solution {
    public boolean isBipartite(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        Arrays.fill(color , -1);
        for(int i = 0 ; i < N ; i++){
            if(color[i] == -1){
                if(!bfs(i,graph,color)){
                    return false;
                }
            }
        }
        return true;
        
    }
    private boolean bfs(int start ,int[][] graph , int[] color){
        Queue<Integer> queue = new LinkedList<>();
        color[start] = 0;
        queue.add(start);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int n : graph[node]){
                if(color[n] == -1){
                    color[n] = 1 - color[node];
                    queue.add(n);
                }
                else if (color[n] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}