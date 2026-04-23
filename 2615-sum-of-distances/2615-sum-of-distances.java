import java.util.*;

class Solution {
    public long[] distance(int[] nums) {
        
        int n = nums.length;
        
        long[] result = new long[n];
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        for (List<Integer> list : map.values()) {
            
            int size = list.size();
            
            long[] prefix = new long[size];
            
            prefix[0] = list.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + list.get(i);
            }
            
            for (int k = 0; k < size; k++) {
                
                int index = list.get(k);
                
                long left = 0;
                if (k > 0) {
                    left = (long) index * k - prefix[k - 1];
                }
                
                long right = 0;
                if (k < size - 1) {
                    long rightSum = prefix[size - 1] - prefix[k];
                    
                    right = rightSum - (long) index * (size - k - 1);
                }
                
            
                result[index] = left + right;
            }
        }
        
        return result;
    }
}