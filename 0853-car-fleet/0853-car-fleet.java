class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new double[]{position[i], (double) (target - position[i]) / speed[i]};
        }
        
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        
        int fleets = 0;
        double maxTime = 0.0;
        for (double[] car : cars) {
            if (car[1] > maxTime) {
                fleets++;
                maxTime = car[1];
            }
        }
        return fleets;
    }
}