class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }
        }
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] > pivot) {
                ans[right--] = nums[j];
            }
        }
        while (left <= right) {
            ans[left++] = pivot;
        }
        
        return ans;
    }
}