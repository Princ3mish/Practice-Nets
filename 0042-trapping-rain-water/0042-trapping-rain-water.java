class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0 , right = n - 1;
        int totalwater = 0;
        int leftmax = 0 , rightmax = 0;
        while(left <= right){
            if(height[left] < height[right]){
                if(height[left] >= leftmax){
                    leftmax = height[left];
                }else{
                    totalwater += leftmax - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightmax){
                    rightmax = height[right];
                }else{
                    totalwater += rightmax - height[right];
                }
                right--;
            }
        }
        return totalwater;
    }
}