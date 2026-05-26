class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] lowerSeen = new boolean[26];
        boolean[] upperSeen = new boolean[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                lowerSeen[ch - 'a'] = true;
            } else if (ch >= 'A' && ch <= 'Z') {
                upperSeen[ch - 'A'] = true;
            }
        }
        
        int specialCount = 0;
        for (int i = 0; i < 26; i++) {
            if (lowerSeen[i] && upperSeen[i]) {
                specialCount++;
            }
        }
        
        return specialCount;
    }
}