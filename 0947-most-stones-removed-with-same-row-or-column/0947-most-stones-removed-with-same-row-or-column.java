class Solution {
    public int find( int x , int[] parent){
        if(parent[x] != x){
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }
    public void union(int a , int b , int[] parent){
        int pa = find(a,parent);
        int pb = find(b,parent);
        if(pa != pb){
            parent[pa] = pb ;
        }
    }
    public int removeStones(int[][] stones) {
        int size = 20005;
        int[] parent = new int[size];

        for(int i = 0 ; i < size ; i++){
            parent[i] = i;
        }
        int offset = 10001;
        for(int[] stone : stones){
            int row = stone[0];
            int col = stone[1] + offset;
            union( row , col , parent);
        }
        Set<Integer> uniqueParents = new HashSet<>();
        for(int[] stone : stones ){
            int root = find(stone[0], parent);
            uniqueParents.add(root);
        }
        return stones.length - uniqueParents.size();
    }
}