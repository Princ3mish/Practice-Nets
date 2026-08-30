class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int minidx = 0;
        int maxidx =0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] < nums[minidx])minidx = i;
            if(nums[i] > nums[maxidx])maxidx = i;
        }
        int L = Math.min(minidx , maxidx);
        int R = Math.max(minidx , maxidx);
        int front =  R + 1;
        int back = n - L;
        int both = (L+1)+(n-R);
        return Math.min(front , Math.min(back , both));
    }
}