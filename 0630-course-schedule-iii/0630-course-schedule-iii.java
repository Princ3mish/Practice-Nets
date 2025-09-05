class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort( courses , (a,b) -> a[1]-b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int totalDuration = 0 ;
        for( int[] course : courses){
            int duration = course[0];
            int lastDay = course[1];
            totalDuration += duration;
            maxHeap.offer(duration);

            if( totalDuration > lastDay){
                int longest = maxHeap.poll();
                totalDuration -= longest;
            }
        }
        return maxHeap.size();
    }
}