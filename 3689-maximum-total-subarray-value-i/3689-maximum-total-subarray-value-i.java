class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int minval = Integer.MAX_VALUE;
        int maxval = Integer.MIN_VALUE;
        for(int num : nums){
            if(num > maxval)maxval = num;
            if(num < minval)minval = num;
        }
        long maxsubarray = (long)maxval - minval;
        return maxsubarray*k;
        
    }
}