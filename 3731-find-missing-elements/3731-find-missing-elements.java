class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res =  new ArrayList<>();
        int i  = 1;
        while (i < nums.length){
            int current = nums[i-1]+1;
            while(current < nums[i]){
                res.add(current);
                current++;
            }
            i++;
        }
        return res;
    }
}