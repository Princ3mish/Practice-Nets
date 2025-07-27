class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i-1]) continue;
            int left = i-1;
            while (left >= 0 && nums[left] == nums[i]) left--;
            if (left < 0) continue; // No different value on the left
            
            // Find the nearest different value to the right
            int right = i+1;
            while (right < nums.length && nums[right] == nums[i]) right++;
            if (right == nums.length) continue; // No different value on the right
            
            // Now check for hill/valley
            if ((nums[i] > nums[left] && nums[i] > nums[right]) ||
                (nums[i] < nums[left] && nums[i] < nums[right])) {
                count++;
            }
        }
        return count;
    }
}
