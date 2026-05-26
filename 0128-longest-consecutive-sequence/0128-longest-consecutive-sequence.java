class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        Set<Integer> pool = new HashSet<>();
        for(int num : nums){
            pool.add(num);
        }
        int maxl = 0;
        for(int num : pool){
            if(!pool.contains(num-1)){
                int curr = num;
                int clength = 1;
                while(pool.contains(curr+1)){
                    curr++;
                    clength++;
                }
                maxl = Math.max(maxl , clength);
            }
        }
        return maxl;
    }
}