class Solution {
    private Integer[][] memo;
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        memo = new Integer[n][n];
        return maxDiff(nums , 0  , n-1) >= 0;
        
    }
    private int maxDiff(int[] nums, int i , int j){
        if(i == j){
            return nums[j];
        }
        if(memo[i][j] !=  null){
            return memo[i][j];
        }
        int pickleft = nums[i] - maxDiff(nums , i+1  , j);
        int pickRight = nums[j]  - maxDiff(nums , i , j - 1);
        return memo[i][j] = Math.max(pickleft , pickRight);
    }
}