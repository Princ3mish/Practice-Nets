class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        backtrack(s,wordDict,"",result);
        return result;
    }
    private void backtrack(String s , List<String>wordDict , String path , List<String>result){
        if(s.length() == 0){
            result.add(path.trim());
            return;
        }
        for (String word : wordDict){
            if(s.startsWith(word)){
                String next = s.substring(word.length());
                backtrack(next,wordDict,path + word+" ",result);
            }
        }
    }

}