class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int n = landStartTime.length;
        int m = waterStartTime.length;
        int minFinishTime = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                int landFinishA = landStartTime[i] + landDuration[i];
                int waterStartA = Math.max(landFinishA, waterStartTime[j]);
                int finalFinishA = waterStartA + waterDuration[j];
                
                int waterFinishB = waterStartTime[j] + waterDuration[j];
                int landStartB = Math.max(waterFinishB, landStartTime[i]);
                int finalFinishB = landStartB + landDuration[i];
                minFinishTime = Math.min(minFinishTime, Math.min(finalFinishA, finalFinishB));
            }
        }

        return minFinishTime;
    }
}