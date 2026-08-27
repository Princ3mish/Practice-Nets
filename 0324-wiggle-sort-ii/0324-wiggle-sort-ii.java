class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = (n-1)/2;
        int right = n-1;
        for(int i = 0  ; i < n ; i++){
            if((i & 1) == 1){
                nums[i] = sorted[right--];
            }else{
                nums[i] = sorted[left--];
            }
        }
        
    }
}