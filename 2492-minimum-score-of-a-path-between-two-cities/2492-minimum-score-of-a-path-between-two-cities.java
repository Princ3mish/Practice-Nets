class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads ){
            int u = road[0];
            int v = road[1];
            int distance = road[2];
            graph[u].add(new int[]{v,distance});
            graph[v].add(new int[]{u,distance});
        }
        int minscore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue =new LinkedList<>();
        queue.offer(1);
        visited[1] =  true;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int[] neighbourInfo : graph[current]){
                int neighbour = neighbourInfo[0];
                int distance = neighbourInfo[1];
                minscore = Math.min(minscore , distance);
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return minscore;

        
    }
}