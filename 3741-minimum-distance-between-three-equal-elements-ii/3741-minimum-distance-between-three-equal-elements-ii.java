class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer>[] indices = new ArrayDeque[n+1];
        int ans = Integer.MAX_VALUE;
        int i = 0 ;

        while(i<n){
            int val = nums[i];
            if(indices[val] == null) indices[val] = new ArrayDeque<>();
            ArrayDeque<Integer> list = indices[val];
            if(list.size() ==  2){
                int first = list.peekFirst();
                ans = Math.min(ans,2*(i-first));
            }
            list.addLast(i);
            if(list.size() > 2) list.removeFirst();
            i++;
        }
        return ans == Integer.MAX_VALUE ? -1:ans;
    }
}