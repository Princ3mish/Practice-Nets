class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        java.util.Map<Integer, java.util.List<Integer>> pos = new java.util.HashMap<>();
        for (int i = 0; i < n; ++i) {
            pos.computeIfAbsent(nums[i], k -> new java.util.ArrayList<>()).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for (java.util.List<Integer> list : pos.values()) {
            if (list.size() < 3) continue;
            for (int i = 0; i + 2 < list.size(); ++i) {
                int span = list.get(i + 2) - list.get(i);
                int dist = 2 * span;
                if (dist < ans) ans = dist;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
