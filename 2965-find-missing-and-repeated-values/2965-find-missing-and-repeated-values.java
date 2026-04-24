class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n*n+1];

        for(int[] rows : grid){
            for(int values : rows){
                count[values]++;
            }
        }
        int repeated = -1;
        int missing = -1;
        for(int i = 0 ; i < n*n+1 ; i++){
            if(count[i] == 0) missing = i;
            if(count[i] == 2) repeated = i;

            
        }
        return new int[]{repeated,missing};
    }
}