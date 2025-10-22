class Solution {
    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);  
            right += num;               
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, m, mid)) {
                right = mid;  
            } else {
                left = mid + 1;  
            }
        }
        return left;
    }

    private boolean canSplit(int[] nums, int m, int maxSumAllowed) {
        int currentSum = 0, splits = 1;
        for (int num : nums) {
            if (currentSum + num <= maxSumAllowed) {
                currentSum += num;
            } else {
                splits++;
                currentSum = num;
                if (splits > m) return false;
            }
        }
        return true;
    }
}
