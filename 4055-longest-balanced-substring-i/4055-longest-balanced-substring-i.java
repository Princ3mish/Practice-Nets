class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        for(int start = 0 ; start < n ; start++){
            int[] freq = new int[26];
            int distinctCount = 0;
            for(int end = start; end < n; end++){
                int idx = s.charAt(end) - 'a';
                if (freq[idx] == 0){
                    distinctCount++;
                }
                freq[idx]++;
                if(isBalanced(freq, distinctCount)){
                    maxLength = Math.max(maxLength, end - start + 1);
                }
            }
        }
        return maxLength;
    }

    private boolean isBalanced(int[] freq, int distinctCount){
        int targetFrequency = 0;
        int countChecked = 0;
        for(int f : freq){
            if(f > 0){
                if(targetFrequency == 0){
                    targetFrequency = f;
                } else if(f != targetFrequency){
                    return false;
                }
                countChecked++;
            }
        }
        return countChecked == distinctCount;
    }
}
