class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int i = -1;
        for(int k = 0 ; k < n ; k++){
            if(nums[k] == 0){
                i = k;
                break;
            }
        }
        if(i == -1)return ;
        for(int j = i+1; j < n ; j++){
            if(nums[j]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }

        }
    }
}