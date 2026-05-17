class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int currindex = queue.poll();
            if(arr[currindex]==0){
                return true;
            }
            if(arr[currindex] < 0){
                continue;
            }
            int jumpValue = arr[currindex];
            arr[currindex] = - arr[currindex];

            int right = currindex + jumpValue;
            if(right <  arr.length && arr[right] >=0){
                queue.add(right);
            }
            int left = currindex - jumpValue;
            if(left >= 0 && arr[left] >= 0){
                queue.add(left);
            }

        }
        return false;
        
    }
}