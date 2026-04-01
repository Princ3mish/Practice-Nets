class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][] = new int[n][n];

        for( int i = 0 ; i < n ; i++){
            Arrays.fill(dist[i],(int)1e9);
            dist[i][i] = 0;
        }

        for( int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            dist[u][v] = w;
            dist[v][u] = w;

        }
        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ;i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int minCount = Integer.MAX_VALUE;
        int resultCity = -1;

        for( int i = 0 ; i < n ; i++){
            int count = 0 ;

            for( int j = 0 ; j < n ; j++){
                if(i != j && dist[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= minCount){
                minCount = count;
                resultCity = i;
            }
        }
        return resultCity;

    }
}