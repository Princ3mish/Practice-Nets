class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        int thres =  n / 3;
        for(int v : nums){
            map.put(v,map.getOrDefault(v,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > thres){
                res.add(entry.getKey());
            }
        }
        return res;
    }
}