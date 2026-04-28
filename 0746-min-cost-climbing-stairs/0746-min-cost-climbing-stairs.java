class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int a = 0 ;
        int b = 0 ;
        for(int i = 2 ; i <= cost.length ; i++){
            int c = Math.min(a+cost[i-2],b+cost[i-1]);
            a=b;
            b=c;
        }
        return b;

        
    }
}