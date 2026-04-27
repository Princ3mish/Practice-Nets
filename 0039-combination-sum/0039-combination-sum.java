class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0,candidates,target,new ArrayList<>(),result);
        return result;
        
    }
    private void findCombination(int index , int[] candidates , int target , List<Integer> current, List<List<Integer>> result){
        if(index == candidates.length){
            if(target == 0 ){
                result.add(new ArrayList<>(current));
            }
            return ;
        }
        if(candidates[index] <= target){
            current.add(candidates[index]);
            findCombination(index , candidates , target-candidates[index],current, result);
        current.remove(current.size()-1);

        }
            findCombination(index + 1 , candidates , target ,current, result);

    }
}