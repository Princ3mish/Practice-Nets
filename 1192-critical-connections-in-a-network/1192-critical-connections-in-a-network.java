class Solution {
        int time = 0 ;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> edge : connections ){
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] disc = new int[n];
        int[] low = new int[n];

        Arrays.fill(disc,-1);
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0 ; i < n; i++){
            if(disc[i] == -1){
                dfs(i,-1,graph , disc , low , result);
            }
        }
        return result;
        
    }
    private void dfs(int u , int parent , List<List<Integer>> graph , int[] disc , int[] low , List<List<Integer>> result){
        disc[u] = low[u] = time++;
        for( int v : graph.get(u)){
            if( v == parent ) continue;

            if(disc[v]== -1){
                dfs(v,u,graph,disc,low, result);
                low[u] = Math.min(low[u], low[v]);

                if(low[v] > disc[u]){
                    result.add(Arrays.asList(u,v));
                }
            }else{
                low[u] = Math.min(low[u],disc[v]);
            }
        }
    }
}