class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length ;
        int ri = 0 ;
        int[] result =  new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0 ; i < n ; i++){
            if(!deque.isEmpty() && deque.peekFirst() < i - k + 1){
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i >= k - 1){
                result[ri++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}