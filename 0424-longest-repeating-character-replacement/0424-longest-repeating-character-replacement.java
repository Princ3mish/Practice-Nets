class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int maxlen =  0 ;
        int maxfreq = 0 ;
        int left = 0 , right = 0 ;
        while(right < s.length()){
            hash[s.charAt(right) - 'A']++;
            maxfreq = Math.max(maxfreq , hash[s.charAt(right)-'A']);
            if(right-left+1 - maxfreq > k ){
                hash[s.charAt(left)-'A']--;
                left++;
            }
            maxlen = Math.max(maxlen , right - left + 1);
            right++;

        }
        return maxlen;
    }
}