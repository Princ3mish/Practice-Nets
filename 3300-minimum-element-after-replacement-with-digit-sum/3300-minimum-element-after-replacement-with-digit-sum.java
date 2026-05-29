class Solution {
    public int minElement(int[] nums) {
        int minres = Integer.MAX_VALUE;
        for(int num : nums){
            int res = 0;
            while(num > 0){
                res += num%10;
                num /= 10;
            }
            if(res < minres){
                minres = res;
            }
        }
        return minres;
        
    }
}