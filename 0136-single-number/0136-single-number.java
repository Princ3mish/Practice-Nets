class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer , Integer> count = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
        }
        for(int num : nums){
            if(count.get(num) == 1){
                return num;
            }
        }
        return -1;
    }
}