class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqmap = new HashMap<>();
        for(int num : nums){
            freqmap.put(num , freqmap.getOrDefault(num,0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for(int key : freqmap.keySet()){
            int freq = freqmap.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }
        int[] result = new int[k];
        int index = 0;
        for(int i = buckets.length - 1 ; i>=0 ; i--){
            if(buckets[i] != null){
                for(int num : buckets[i]){
                    result[index++] = num;
                    if(index == k){
                        return result;
                    }
                }
            }
        }  
        return result;
        
    }
}