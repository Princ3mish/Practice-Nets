class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] count = new int[n*n+1];

        for( int[] row:grid){
            for( int value:row){
                count[value]++;
            }
        }
        int repeated= -1;
        int missing = -1;
        for( int i=1;i<=n*n;i++){
            if( count[i] == 0) missing = i;
            if (count[i] == 2) repeated = i;
        }
        return new int[] { repeated , missing};
    }
}