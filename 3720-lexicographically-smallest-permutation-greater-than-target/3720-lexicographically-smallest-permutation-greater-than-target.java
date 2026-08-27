class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] baseFreq = new int[26];
        for (char c : s.toCharArray()) baseFreq[c - 'a']++;

        for (int i = n - 1; i >= 0; i--) {
            int[] freq = baseFreq.clone();
            boolean okPrefix = true;

            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';
                if (freq[idx] == 0) { okPrefix = false; break; }
                freq[idx]--;
            }
            if (!okPrefix) continue;

            int start = target.charAt(i) - 'a' + 1;
            int pick = -1;
            for (int c = start; c < 26; c++) {
                if (freq[c] > 0) { pick = c; break; }
            }
            if (pick == -1) continue; 

            StringBuilder sb = new StringBuilder();
            sb.append(target.substring(0, i));
            sb.append((char) ('a' + pick));
            freq[pick]--;

            for (int c = 0; c < 26; c++) {
                while (freq[c]-- > 0) sb.append((char) ('a' + c));
            }
            return sb.toString();
        }

        
        return "";
    }
}