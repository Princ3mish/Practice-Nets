class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt = 0;
        for(String p : patterns){
            if(word.contains(p)){
                cnt++;
            }
        }
        return cnt;
    }
}