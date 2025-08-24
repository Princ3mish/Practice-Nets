class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0 ; 
        int zerocount = 0 ;
        int maxLen = 0 ;
        for ( int right = 0 ; right < nums.length ; right++){
            if( nums[right] == 0 ){
                zerocount++;
            }
            while( zerocount >  1 ){
                if( nums[left] == 0) zerocount--;
                left++;
            }
            maxLen = Math.max( maxLen , right - left);
        }
        return maxLen;
    }
}