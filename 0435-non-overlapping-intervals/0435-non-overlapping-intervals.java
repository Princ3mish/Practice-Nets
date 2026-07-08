class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length <= 1 ){
            return 0;
        }
        Arrays.sort(intervals , (a,b)->Integer.compare(a[1],b[1]));
        int total = intervals.length;
        int count = 1;
        int lasttime = intervals[0][1];
        for(int i = 0 ; i < total ; i++){
            int curr = intervals[i][0];
            int end = intervals[i][1];
            if(curr >= lasttime){
                count++;
                lasttime = end;
            }
        }
        return total - count;
    }
}