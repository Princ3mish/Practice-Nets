class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] mapped = new int[n];
        for(int i = 0 ; i < n; i++) mapped[i] = nums[i] == target ? 1 : -1;
        int[] pref = new int[n + 1];
        for(int i = 1 ; i <= n ; i++) pref[i] = pref[i-1] + mapped[i-1];
        return (int) countPairs(pref);
        
        
    }
    private long countPairs(int[] arr){
        int n = arr.length;
        int[] temp = new int[n];
        return mergeCount(arr , temp , 0 , n-1);
    }
    private long mergeCount(int[] arr , int[] temp , int left , int right){
        if(left >= right) return 0 ;
        int mid = (left + right)/2;
        long count = mergeCount(arr , temp , left , mid) + mergeCount(arr, temp , mid + 1 , right);
        int i = left , j = mid + 1 ,  k = left;
        for(;k <= right ; k++){
            if(i > mid){
                temp[k] =  arr[j++];
            } else if ( j > right){
                temp[k] =  arr[i++];
            } else if (arr[i] < arr[j]){
                count += (right - j + 1);
                temp[k] = arr[i++];
            } else{
                temp[k] = arr[j++];
            }
        }
        for(int t = left ; t <= right ; t++) arr[t] = temp[t];
        return count;
    }
}