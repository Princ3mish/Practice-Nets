class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] sc = new int[26];
        int[] tc = new int[26];
        for(char ch : s.toCharArray()){
            sc[ch - 'a']++;
        }
        for(char ch : target.toCharArray()){
            tc[ch - 'a']++;
        }
        int maxcopy =  Integer.MAX_VALUE;
        for(int i = 0 ; i < 26 ; i++){
            if(tc[i] > 0){
                int possible =  sc[i]/tc[i];
                maxcopy = Math.min(maxcopy , possible);
            }
        }
        return maxcopy;
    }
}