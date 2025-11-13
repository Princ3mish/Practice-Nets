class Solution {
    public boolean scoreBalance(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) total += s.charAt(i) - 'a' + 1;
        int pref = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            pref += s.charAt(i) - 'a' + 1;
            if (pref == total - pref) return true;
        }
        return false;
    }
}
