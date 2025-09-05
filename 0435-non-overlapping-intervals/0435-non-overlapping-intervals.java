class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1]; // Use the end time of the first interval (index 0, second element)

        for (int i = 1; i < intervals.length; i++) {
            // Compare the start time of current interval with prevEnd
            if (intervals[i][0] < prevEnd) {
                count++; // Overlapping, remove this interval
            } else {
                prevEnd = intervals[i][1]; // Update prevEnd with current interval's end
            }
        }
        return count;
    }
}
