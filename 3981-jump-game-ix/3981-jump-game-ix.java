class Solution {
    private int helper(int val, int[] arr, ArrayList<Integer> list){
        int lo = 0;
        int hi = list.size()-1;
        int result = -1;

        while(lo <= hi){
            int mid = lo-(lo-hi)/2;

            if(arr[list.get(mid)] < val){
                result = list.get(mid);
                hi = mid-1;
            }
            else lo = mid+1;
        }
        return result;
    }
    private int[] findMin(int[] arr){
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        list.add(n-1);

        for(int i = n-2; i >= 0; i--){
            int idx = helper(arr[i], arr, list);

            if(idx == -1) list.add(i);
            else result[i] = idx;
        }
        return result;
    }
    
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int min = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            if(nums[b]-nums[a] == 0) return a-b;
            return nums[b]-nums[a];
        });

        int[] result = new int[n];
        int[] rightMin = findMin(nums);

        for(int i = 0; i < n; i++){
            pq.add(i);
            result[i] = -1;
        }

        while(!pq.isEmpty()){
            int idx = pq.remove();
            if(idx > min) continue;

            int rightPossible = rightMin[idx];
            if(rightPossible != -1 && result[rightPossible] != -1){
                int val = result[rightPossible];
                if(rightPossible >= min){
                    for(int i = idx; i < min; i++) result[i] = val;
                    min = idx;
                }
            }
            else{
                for(int i = idx; i < min; i++) result[i] = nums[idx];
                min = idx;
            }
        }
        return result;
    }
}
