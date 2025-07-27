class Solution {
    public int[][] merge(int[][] intervals) {
        if ( intervals.length <= 1)
        return intervals;
        
        Arrays.sort( intervals , Comparator.comparingInt( a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for( int i = 1 ; i<intervals.length ; i++){
            int[] lastinterval = merged.get(merged.size() - 1);
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if ( currentStart <= lastinterval[1]){
                lastinterval[1] = Math.max(lastinterval[1],currentEnd);
            } else {
                merged.add(intervals[i]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}