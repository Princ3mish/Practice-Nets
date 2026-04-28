class Solution {
    public int rob(int[] nums) {
        if(nums.length ==  1) return nums[0];
        int n = nums.length;
        int[] array1 =  new int[n-1];
        int[] array2 = new int[n-1];
        for(int i = 0 ; i < nums.length ; i++){
            if(i != 0 ){
                array2[i-1] = nums[i];
            }
            if(i!=n-1){
                array1[i] = nums[i];
            }
        }
         int ans1  =  rob2(array1);
         int ans2  =  rob2(array2);
         return Math.max(ans1,ans2);

    }
    public int rob2(int[] nums) {
        int a = 0 , b = 0 ;
        for(int i = 0 ; i < nums.length;i++){
            int c = Math.max(a,b+nums[i]);
            b = a;
            a = c;
            
        }
        return a;
    }
}