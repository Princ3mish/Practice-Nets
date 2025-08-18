class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) numSet.add(n);

        int maxLen = 0;
        for (int n : numSet) {
            
            if (!numSet.contains(n - 1)) {
                int curr = n;
                int len = 1;
                while (numSet.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
