class Solution {
        int[] parent ;
    public int makeConnected(int n, int[][] connections) {
        if( connections.length < n-1){
            return -1;
        }
         parent = new int[n];

        for( int i = 0 ; i <n ; i++){
            parent[i] = i ;
        }
        int components = n ;
        for( int[] conn : connections ){
            int u = conn[0];
            int v = conn[1];

            int pu = find(u);
            int pv = find(v);

            if(pu != pv){
                parent[pu] = pv;
                components--;
            }
        }
        return components-1;
    }
           
        private int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    
}