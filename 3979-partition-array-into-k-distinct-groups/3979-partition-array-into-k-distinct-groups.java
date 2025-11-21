class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;
        int groups = n / k;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);

        for (int count : freq.values()) {
            if (count > groups) return false;
        }
        return true;
    }
}
