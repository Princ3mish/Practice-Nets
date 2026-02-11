class Solution {
    private void dfs(int city , int [][]isConnected , boolean[]visited){
        visited[city] = true ;
        for(int i = 0 ; i < isConnected.length;i++){
            if(isConnected[city][i] == 1 && !visited[i]){
                dfs(i ,isConnected , visited );
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        // yeh humlog kiye hai visited cities ko track karne ke liye 

        int provinces = 0 ;
        // aur yeh hai connected components ko ginne ke liye 

        for( int i = 0 ; i < n ; i++){//agar city visit nahi hua hai to woh naaya province hai 
            if(!visited[i]){
                provinces++;
                dfs(i , isConnected , visited);
            }
        }
        return provinces;

        
    }
}