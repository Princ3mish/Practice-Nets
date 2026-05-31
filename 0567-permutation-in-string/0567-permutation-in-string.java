class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 > len2){
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for(int i = 0 ; i < len1 ; i++){
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }
        for(int i = len1 ; i < len2 ;i++){
            if(matches(s1count , s2count)){
                return true;
            }
            s2count[s2.charAt(i)-'a']++;
            s2count[s2.charAt(i-len1) - 'a']--;
        }
        return matches(s1count,s2count);
        }
        private boolean matches(int[] s1count , int[] s2count){
            for(int i = 0 ; i < 26 ; i++){
                if(s1count[i] != s2count[i]){
                    return false;
                }
            }
        return true;
    }
}