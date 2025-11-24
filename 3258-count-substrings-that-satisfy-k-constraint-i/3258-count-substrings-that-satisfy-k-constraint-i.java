class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int[] pref0 = new int[n + 1];
        int[] pref1 = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            pref0[i + 1] = pref0[i] + (s.charAt(i) == '0' ? 1 : 0);
            pref1[i + 1] = pref1[i] + (s.charAt(i) == '1' ? 1 : 0);
        }
        
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int zeros = pref0[j + 1] - pref0[i];
                int ones = pref1[j + 1] - pref1[i];
                if (zeros <= k || ones <= k) {
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
