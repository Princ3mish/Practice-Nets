import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        
        Map<Integer , Integer> lastIndexByReversed = new HashMap<>();
        int minDist = Integer.MAX_VALUE;
        for ( int j = 0 ; j < nums.length ; j++){
            int val = nums[j];

            Integer i = lastIndexByReversed.get(val);
            if(i!=null){
                int dist = j - i;
                if(dist < minDist){
                    minDist = dist;
                }
            }
            int rev = reverse(val);
            lastIndexByReversed.put(rev,j);
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
    private int reverse(int x){
        int r = 0 ;
        while(x>0){
            r = r * 10 + (x %10);
            x /= 10;
        }
        return r;
    }
}