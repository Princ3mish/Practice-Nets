class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        
        for (int[] c : classes) {
            double gain = getGain(c[0], c[1]);
            pq.offer(new double[]{gain, c[0], c[1]});
        }
        
        
        for (int i = 0; i < extraStudents; i++) {
            double[] top = pq.poll();
            double newPass = top[1] + 1, newTotal = top[2] + 1;
            pq.offer(new double[]{getGain(newPass, newTotal), newPass, newTotal});
        }
               
        double sum = 0;
        while (!pq.isEmpty()) {
            double[] info = pq.poll();
            sum += info[1] / info[2];
        }


        return sum / classes.length;
    }
    private double getGain(double pass, double total) {
        return (pass + 1) / (total + 1) - pass / total;
    }
}
