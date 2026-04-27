class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0 ,candidates ,target , new ArrayList<>() , result);
        return result;
    }
    private void findCombination(int index , int[] candidates , int target , List<Integer> current , List<List<Integer>>result){
        if(target == 0 ){
            result.add(new ArrayList<>(current));
            return ;
        }
        if(target < 0) return;
        for(int i = index ; i < candidates.length ; i++){
            if(i > index && candidates[i] == candidates[i-1])continue;
            if(candidates[i] > target) break;
            current.add(candidates[i]);                     
            findCombination(i + 1 , candidates, target - candidates[i], current, result); 
            current.remove(current.size() - 1);  

        }
    }
}