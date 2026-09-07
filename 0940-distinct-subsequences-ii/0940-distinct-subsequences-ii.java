class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] endWith = new long[26];
        
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long currentSum = 1;
            for (int i = 0; i < 26; i++) {
                currentSum = (currentSum + endWith[i]) % MOD;
            }
            endWith[idx] = currentSum;
        }
        long total = 0;
        for (int i = 0; i < 26; i++) {
            total = (total + endWith[i]) % MOD;
        }
        return (int) total;
    }
}