class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int rightsum = 0;
        for(int num : nums){
            rightsum += num;
        }
        int leftsum = 0;
        for(int i = 0 ; i < n ; i++){
            rightsum -= nums[i];
            answer[i] = Math.abs(leftsum - rightsum);
            leftsum += nums[i];
        }
        return answer;
    }
}