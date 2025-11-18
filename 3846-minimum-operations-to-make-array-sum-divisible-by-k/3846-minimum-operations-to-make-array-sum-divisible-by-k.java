class Solution {
    public int minOperations(int[] nums, int k) {
        long sum = 0;
        for (int x : nums) sum += x;
        int r = (int)(sum % k);
        return r;
    }
}
