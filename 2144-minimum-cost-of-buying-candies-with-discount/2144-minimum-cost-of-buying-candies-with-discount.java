class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        int n = cost.length;
        int counter = 1;
        for(int i = n-1 ; i>=0 ;i--){
            if(counter % 3 == 0){
                counter++;
                continue;
            }
            total += cost[i];
            counter++;
        }
        return total;
    }
}